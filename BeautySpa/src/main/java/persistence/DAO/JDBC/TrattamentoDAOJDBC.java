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
	public ArrayList<Trattamento> listaTrattamenti() {
		Connection conn;
		ArrayList<Trattamento> lista= new ArrayList<Trattamento>();
		try {
		    conn= dbSource.getConnection();
		    String query = "SELECT * FROM trattamento";
		    PreparedStatement st= conn.prepareStatement(query);
		    ResultSet rs = st.executeQuery();
		      while (rs.next()) {
		    	Integer id=rs.getInt("id");
		        String nome = rs.getString("nome");
		        String descrizione= rs.getString("descrizione");
		        
		        Trattamento passa= new Trattamento(id,nome,descrizione);
		        lista.add(passa);
		      }
		    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Trattamento trovaTrattamento(Integer id) {
		Connection conn;
		Trattamento trattamento= new Trattamento();
		try
		{
			conn= dbSource.getConnection();
			String query= "SELECT * FROM trattamento WHERE id=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idP= rs.getInt("id");
				String nome=rs.getString("nome");
				
				String desc= rs.getString("descrizione");
				
				trattamento.setId(idP);
				trattamento.setNome(nome);
				trattamento.setDescrizione(desc);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return trattamento;
	}

	@Override
	public void save(Trattamento trattamento) 
	{
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query="INSERT INTO trattamento(nome , descrizione) values(?,?)";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setString(1, trattamento.getNome());
			st.setString(2, trattamento.getDescrizione());
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateTrattamento(Trattamento trattamento) 
	{
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			Trattamento tr= trovaTrattamento(trattamento.getId());
			if(tr.getId() == null)
			{
				//trattamento non trovato
			}
			else
			{
				String query="UPDATE trattamento SET nome=? , descrizione=? WHERE id=?";
				PreparedStatement st= conn.prepareStatement(query);
				
				st.setString(1, trattamento.getNome());
				st.setString(2, trattamento.getDescrizione());
				st.setInt(3, trattamento.getId());				
				st.executeUpdate();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer idTrattamento) {
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query="DELETE FROM trattamento WHERE id=?";
			PreparedStatement st= conn.prepareStatement(query);
			st.setInt(1, idTrattamento);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
