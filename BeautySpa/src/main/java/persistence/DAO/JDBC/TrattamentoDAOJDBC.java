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
	

	
	//Da finire
	@Override
	public ArrayList<Trattamento> listaTrattamenti() {
		Connection conn;
		ArrayList<Trattamento> lista;
		try {
		    conn= dbSource.getConnection();
		    String query = "select * from trattamento";
		    PreparedStatement st= conn.prepareStatement(query);
		    ResultSet rs = st.executeQuery(query);
		      while (rs.next()) {
		        String nomeTrattamento = rs.getString("NomeTrattamento");
		        Integer durata = rs.getInt("Durata");
		        System.out.println(nomeTrattamento+": "+durata);
		      }
		    } 
		catch (Exception e) 
		{
			System.out.println("Non riesco a ristituire trattamenti");
		}
		return null;
	}

	@Override
	public Trattamento trovaNomeTrattamento(String nomeTrattamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiornaTrattamento(Trattamento trattamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminaTrattamento(Trattamento trattamento) {
		// TODO Auto-generated method stub
		
	}

}