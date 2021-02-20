package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import model.Prenotazione;
import model.Trattamento;
import persistence.DBManager;
import persistence.DBSource;
import persistence.DAO.PrenotazioneDAO;

public class PrenotazioneDAOJDBC implements PrenotazioneDAO
{
	DBSource dbSource;
	
	public PrenotazioneDAOJDBC(DBSource db)
	{
		this.dbSource=db;
	}

	@Override
	public void save(Prenotazione prenotazione) {
		Connection conn;
		//for(int i=0; i<prenotazione.numeroTrattamenti(); i++)
		//{
		try
		{
			conn= dbSource.getConnection();
			String query= "INSERT INTO prenotazione(utente , time , date , persone , trattamento) values(?,?,?,?,?)";
			PreparedStatement st= conn.prepareStatement(query);
			st.setString(1,prenotazione.getUtente());
			st.setTime(2, prenotazione.getTime());
			st.setDate(3, prenotazione.getDate());
			st.setInt(4, prenotazione.getPersone());
			st.setInt(5, prenotazione.getTrattamento());
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer idPrenotazione) {
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query="DELETE FROM prenotazione WHERE id=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, idPrenotazione);
			st.executeUpdate();
			
			System.out.println("Prenotazione eliminata");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Prenotazione> prenotazioniData(Date date) {
		ArrayList<Prenotazione> lista = new ArrayList<Prenotazione>();
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query="SELECT * FROM prenotazione WHERE date=?";
			PreparedStatement st= conn.prepareStatement(query);
			st.setDate(1, date);
			ResultSet rs= st.executeQuery();
			 while (rs.next()) {
			    	Integer id=rs.getInt("id");
			        String nome = rs.getString("utente");
			        Time time= rs.getTime("time");
			        Date dateP= rs.getDate("date");
			        Integer persone= rs.getInt("persone");
			        Integer trattamento= rs.getInt("trattamento");
			        Prenotazione prenotazione= new Prenotazione(id,nome,time,dateP,persone,trattamento);
			        lista.add(prenotazione);
			      }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public ArrayList<String> dammiDescrizioneTrattamenti(ArrayList<Prenotazione> lista) {
		Connection conn;
		ArrayList<String> descrizioni= new ArrayList<String>();
		for(int i=0; i<lista.size(); i++)
		{
			try
			{
				conn= dbSource.getConnection();
				String query="SELECT * FROM trattamento WHERE id=?";
				PreparedStatement st= conn.prepareStatement(query);
				st.setInt(1, lista.get(i).getTrattamento());
				ResultSet rs= st.executeQuery();
				while (rs.next()) 
				{
					String descrizione=rs.getString("descrizione");
					descrizioni.add(descrizione);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return descrizioni;
	}
}
