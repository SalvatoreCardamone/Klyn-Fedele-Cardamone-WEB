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
			
			//st.setInt(1, recensione.getIdRecensione());
			st.setString(1,recensione.getDescrizione());
			Calendar calendar = Calendar.getInstance();
			Date date = new Date(calendar.getTime().getTime());
			st.setObject(2, date);
			st.setString(3, recensione.getScrittoDa());
			st.setInt(4, recensione.getVoto());
			
			st.executeUpdate();
			System.out.println("Recensione e stata aggiunta");
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
	public void delete(Integer idRecensione, String scrittoDa) {
		Connection conn;
		try
		{
			conn=dbSource.getConnection();
			String query= "DELETE FROM recensione WHERE id=? and scritto=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, idRecensione);
			st.setString(2,scrittoDa);
			
			st.executeUpdate();
			System.out.println("Recensione eliminata");
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

}
