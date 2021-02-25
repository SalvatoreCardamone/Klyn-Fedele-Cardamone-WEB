package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import model.Criptazione;
import model.Prenotazione;
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
		String pass;
		try
		{
		conn= dbSource.getConnection();
		String quety= "INSERT INTO utente values(?,?,?,?,?,?)";
		PreparedStatement st= conn.prepareStatement(quety);
		
		st.setString(1, utente.getEmail());
		pass=Criptazione.getInstance().encrypt(utente.getPassword());
		st.setString(2, pass);
		st.setString(3, utente.getNome());
		st.setString(4, utente.getCognome());
		st.setBoolean(5, utente.isConvalidato());
		st.setString(6, utente.getNumero());
		
		st.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Utente trovaUtente(String email) {
		Connection conn;
		Utente ut= new Utente();
		try
		{
			conn=dbSource.getConnection();
			String query="SELECT * FROM utente WHERE email=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setString(1, email);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				String Email=rs.getString("email");
				String Password=rs.getString("password");
				String Nome=rs.getString("nome");
				String Cognome=rs.getString("cognome");
				String Numero=rs.getString("numero");
				boolean Convalidato=rs.getBoolean("convalidato");
				
				ut.setEmail(Email);
				ut.setPassword(Password);
				ut.setNome(Nome);
				ut.setCognome(Cognome);
				ut.setConvalidato(Convalidato);
				ut.setNumero(Numero);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ut;
	}

	@Override
	public ArrayList<Utente> findAll() {
		ArrayList<Utente> lista= new ArrayList<Utente>();
		Connection conn;
		try
		{
			conn=dbSource.getConnection();
			String query="SELECT * FROM utente";
			PreparedStatement st= conn.prepareStatement(query);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				String email= rs.getString("email");
				String nome= rs.getString("nome");
				String cognome= rs.getString("cognome");
				boolean convalidato= rs.getBoolean("convalidato");
				String telefono= rs.getString("numero");
				Utente ut= new Utente(email,"Criptata",nome,cognome,convalidato,telefono);
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
	public void update(Utente utente) 
	{
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			Utente ut= trovaUtente(utente.getEmail());
			if(ut.getEmail() == null)
			{
				//utente non trovato
			}
			else
			{
				String query="UPDATE utente SET password=? , convalidato=? , numero=?, nome=? , cognome=? WHERE email=?";
				PreparedStatement st= conn.prepareStatement(query);
				
				st.setString(1, utente.getPassword());
				st.setBoolean(2, utente.isConvalidato());
				st.setString(3,utente.getNumero());
				st.setString(4, utente.getNome());
				st.setString(5,utente.getCognome());
				
				st.setString(6,utente.getEmail());
				
				st.executeUpdate();
				System.out.println("Cambiamenti aggiornati!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
			String pass=Criptazione.getInstance().encrypt(password);
			st.setString(2, pass);
		    ResultSet rs = st.executeQuery();
		      while (rs.next()) 
		      {
		    	String Email= rs.getString("email");
		        String Nome = rs.getString("nome");
		        String Cognome = rs.getString("cognome");
		        String Telefono= rs.getString("numero");
		        utente.setEmail(Email);
		        utente.setNome(Nome);
		        utente.setCognome(Cognome);
		        utente.setNumero(Telefono);
		      }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return utente;
	}

	@Override
	public ArrayList<Prenotazione> dammiPrenotazioni(String email) 
	{
		Connection conn;
		ArrayList<Prenotazione>lista= new ArrayList<Prenotazione>();
		try
		{
			conn= dbSource.getConnection();
		    String query = "SELECT * FROM prenotazione WHERE utente=? ORDER BY date DESC, time";
		    PreparedStatement st= conn.prepareStatement(query);
			st.setString(1,email);
		    ResultSet rs = st.executeQuery();
		      while (rs.next()) 
		      {
		    	  Integer id= rs.getInt("id");
		    	  String utent=rs.getString("utente");
		    	  Time time= rs.getTime("time");
		    	  Date date= rs.getDate("date");
		    	  Integer persone= rs.getInt("persone");
		    	  Integer trattamento= rs.getInt("trattamento");
		    	  Prenotazione pr= new Prenotazione(id,utent,time,date,persone,trattamento);
		    	  lista.add(pr);
		      }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

}
