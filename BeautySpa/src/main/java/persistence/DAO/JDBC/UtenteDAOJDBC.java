package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Utente;
import persistence.DBSource;
import persistence.DAO.UtenteDAO;

public class UtenteDAOJDBC implements UtenteDAO
{
	
	DBSource dbSource;
	
	public UtenteDAOJDBC(DBSource dbSource)
	{
		this.dbSource=dbSource;
	}

	@Override
	public void save(Utente utente) {
		Connection conn;
		try
		{
		conn= dbSource.getConnection();
		String quety= "INSERT INTO utente values(?,?,?,?,?,?)";
		PreparedStatement st= conn.prepareStatement(quety);
		
		st.setString(1, utente.getEmail());
		st.setString(2, utente.getPassword());
		st.setString(3, utente.getNome());
		st.setString(4, utente.getCognome());
		st.setBoolean(5, utente.isConvalidato());
		st.setString(6, utente.getNumero());
		
		st.executeUpdate();
		System.out.println("Utente e stato aggiunto con sucesso");
		}
		catch(Exception e)
		{
			System.out.println("Non riesco a fare la query di save");
		}
	}

	@Override
	public Utente findByPrimaryKey(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Utente> findAll() {
		ArrayList<Utente> lista= new ArrayList<Utente>();
		Connection conn;
		try
		{
			conn=dbSource.getConnection();
			String query="select * fron utente";
			PreparedStatement st= conn.prepareStatement(query);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				String email= rs.getString("email");
				String password= rs.getString("password");
				String nome= rs.getString("nome");
				String cognome= rs.getString("cognome");
				boolean convalidato= rs.getBoolean("convalidato");
				String telefono= rs.getString("numero");
				Utente ut= new Utente(email,password,nome,cognome,convalidato,telefono);
				lista.add(ut);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void update(Utente studente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utente studente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente login(String email, String password) {
		Utente utente= new Utente();
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
		    String query = "select * from utente where utente.email=? and utente.password=?";
		    PreparedStatement st= conn.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
		    ResultSet rs = st.executeQuery();
		      while (rs.next()) 
		      {
		    	
		        String nome = rs.getString("Nome");
		        String cognome = rs.getString("Cognome");
		        utente.setNome(nome);
		        utente.setCognome(cognome);
		      }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println("Non riesco a fare la query di login!");
		}
		//Rimane di passare i parametri al HTML per cambiarli
		//Utente utente;
		//return null;
		return utente;
	}

}
