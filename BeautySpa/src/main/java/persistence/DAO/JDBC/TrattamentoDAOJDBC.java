package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Trattamento;
import persistence.DBSource;
import persistence.DAO.TrattamentoDAO;

public class TrattamentoDAOJDBC implements TrattamentoDAO{

	DBSource dbSource;
	
	public TrattamentoDAOJDBC(DBSource dbSource)
	{
		this.dbSource=dbSource;
	}

	/*
	@Override
	public void newTrattamento(Trattamento trattamento) {
		Connection conn;
		try
		{
		conn= dbSource.getConnection();
		String quetyUpdate= "INSERT INTO trattamento values(?,?)";
		PreparedStatement st= conn.prepareStatement(quetyUpdate);
		
		st.setString(1, trattamento.getNomeTrattamento());
		st.setInt(2, trattamento.getDurata());
		
		st.executeUpdate();
		System.out.println("Trattamento e stato aggiunto con sucesso");
		}
		catch(Exception e)
		{
			System.out.println("Non riesco a fare la query di save nel trattamento");
		}
	}
	*/
	

	
	//Da finire
	@Override
	public ArrayList<Trattamento> listaTrattamenti() {
		Connection conn;
		ArrayList<Trattamento> lista= new ArrayList<Trattamento>();
		try {
		    conn= dbSource.getConnection();
		    String query = "SELECT * FROM trattamento";
		    PreparedStatement st= conn.prepareStatement(query);
		    ResultSet rs = st.executeQuery();
		      while (rs.next()) {
		        String nomeTrattamento = rs.getString("nome");
		        Integer durata = rs.getInt("durata");
		        Trattamento passa= new Trattamento(nomeTrattamento,durata);
		        lista.add(passa);
		        //System.out.println(nomeTrattamento+": "+durata);
		      }
		    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Trattamento trovaNomeTrattamento(String nomeTrattamento) {
		Connection conn;
		Trattamento trattamento= new Trattamento();
		try
		{
			conn= dbSource.getConnection();
			String query= "SELECT * FROM trattamento WHERE nome=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setString(1, nomeTrattamento);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				String nome=rs.getString("nome");
				Integer durata=rs.getInt("durata");
				trattamento.setNomeTrattamento(nome);
				trattamento.setDurata(durata);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return trattamento;
	}
}
