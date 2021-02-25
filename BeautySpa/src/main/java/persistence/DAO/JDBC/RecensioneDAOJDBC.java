package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import model.Recensione;
import persistence.DBSource;
import persistence.DAO.RecensioneDAO;

public class RecensioneDAOJDBC implements RecensioneDAO
{
	
	DBSource dbSource;
	
	public RecensioneDAOJDBC(DBSource dbSource)
	{
		this.dbSource=dbSource;
	}
	 
	@Override
	public void save(Recensione recensione) 
	{
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query="INSERT INTO recensione(descrizione , date , scritto , voto) values(?,?,?,?)";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setString(1,recensione.getDescrizione());
			Calendar calendar = Calendar.getInstance();
			Date date = new Date(calendar.getTime().getTime());
			st.setObject(2, date);
			st.setString(3, recensione.getScrittoDa());
			st.setInt(4, recensione.getVoto());
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Recensione> mieRecensioni(String emailUtente) {
		Connection conn;
		ArrayList<Recensione> lista= new ArrayList<Recensione>();
		try
		{
			conn= dbSource.getConnection();
			String query="SELECT * FROM recensione WHERE scritto=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setString(1, emailUtente);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idRecensione=rs.getInt("id");
				String descrizione=rs.getString("descrizione");
				Date date=rs.getDate("date");
				String scrittoDa=rs.getString("scritto");
				Integer voto= rs.getInt("voto");
				
				Recensione passa= new Recensione(idRecensione, descrizione,date, scrittoDa, voto);
				lista.add(passa);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void delete(Integer idRecensione) {
		Connection conn;
		try
		{
			conn=dbSource.getConnection();
			String query= "DELETE FROM recensione WHERE id=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, idRecensione);
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Recensione> getLastRecensioni() {
		Connection conn;
		ArrayList<Recensione> lista= new ArrayList<Recensione>();
		try
		{
			conn= dbSource.getConnection();
			String query="SELECT * FROM recensione ORDER BY date DESC LIMIT 6";
			PreparedStatement st= conn.prepareStatement(query);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idRecensione=rs.getInt("id");
				String descrizione=rs.getString("descrizione");
				Date date=rs.getDate("date");
				String scrittoDa=rs.getString("scritto");
				Integer voto= rs.getInt("voto");
				
				Recensione passa= new Recensione(idRecensione, descrizione,date, scrittoDa, voto);
				lista.add(passa);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ArrayList<Recensione> findAll() {
		ArrayList<Recensione> lista= new ArrayList<Recensione>();
		Connection conn;
		try
		{
			conn=dbSource.getConnection();
			String query="SELECT * FROM recensione";
			PreparedStatement st= conn.prepareStatement(query);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idRecensione=rs.getInt("id");
				String descrizione=rs.getString("descrizione");
				Date date=rs.getDate("date");
				String scrittoDa=rs.getString("scritto");
				Integer voto= rs.getInt("voto");
				
				Recensione passa= new Recensione(idRecensione, descrizione,date, scrittoDa, voto);
				lista.add(passa);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void update(Recensione recensione) {
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			Recensione rc= trovaRecensione(recensione.getIdRecensione());
			if(rc.getIdRecensione() == null)
			{
				//trattamento non trovato
			}
			else
			{
				String query="UPDATE recensione SET descrizione=? , scritto=?, voto=?, date=? WHERE id=?";
				PreparedStatement st= conn.prepareStatement(query);
				
				st.setString(1, recensione.getDescrizione());
				st.setString(2, recensione.getScrittoDa());
				st.setInt(3, recensione.getVoto());
				st.setDate(4, recensione.getData());
				
				st.setInt(5, recensione.getIdRecensione());
				st.executeUpdate();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	@Override
	public Recensione trovaRecensione(Integer id) {
		Connection conn;
		Recensione recensione= new Recensione();
		try
		{
			conn= dbSource.getConnection();
			String query= "SELECT * FROM recensione WHERE id=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idR= rs.getInt("id");
				String desc= rs.getString("descrizione");
				String scritto= rs.getString("scritto");
				Integer voto= rs.getInt("voto");
				Date date= rs.getDate("date");
				
				recensione.setIdRecensione(idR);
				recensione.setDescrizione(desc);
				recensione.setScrittoDa(scritto);
				recensione.setVoto(voto);
				recensione.setData(date);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return recensione;
	}
}
