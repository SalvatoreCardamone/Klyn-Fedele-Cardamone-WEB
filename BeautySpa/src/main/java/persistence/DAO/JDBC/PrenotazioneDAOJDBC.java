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
import java.util.HashMap;

import model.Criptazione;
import model.Prenotazione;
import model.Recensione;
import model.Trattamento;
import model.Utente;
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

	@Override
	public HashMap<Date, Integer> countDate(String mail) {
		Connection conn;
		HashMap<Date, Integer> lista= new HashMap<Date, Integer>();
		try {
		conn= dbSource.getConnection();
		String query="SELECT date, COUNT(*) as Counter FROM prenotazione WHERE utente = ? GROUP BY date ORDER BY date DESC";
		PreparedStatement st=conn.prepareStatement(query);
		st.setString(1, mail);
		ResultSet rs= st.executeQuery();
		Integer n=0;
			while(rs.next()) {
				n=n+rs.getInt("Counter");
				lista.put(rs.getDate("date"), n);
			}
		
		}
		catch(Exception e) {e.printStackTrace();}
		
		return lista;
	}

	@Override
	public ArrayList<Prenotazione> findAll() {
		ArrayList<Prenotazione> lista= new ArrayList<Prenotazione>();
		Connection conn;
		try
		{
			conn=dbSource.getConnection();
			String query="SELECT * FROM prenotazione";
			PreparedStatement st= conn.prepareStatement(query);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idPrenotazione= rs.getInt("id");
				String utente= rs.getString("utente");
				Time time= rs.getTime("time");
				Date date= rs.getDate("date");
				Integer persone= rs.getInt("persone");
				Integer trattamento= rs.getInt("trattamento");
				Prenotazione pren= new Prenotazione(idPrenotazione,utente, time,date,persone,trattamento);
				lista.add(pren);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Prenotazione trovaPrenotazione(Integer id) {
		Connection conn;
		Prenotazione prenotazione= new Prenotazione();
		try
		{
			conn= dbSource.getConnection();
			String query= "SELECT * FROM prenotazione WHERE id=?";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1, id);
			ResultSet rs= st.executeQuery();
			while(rs.next())
			{
				Integer idP= rs.getInt("id");
				String utente= rs.getString("utente");
				Time time= rs.getTime("time");
				Date date= rs.getDate("date");
				Integer persone= rs.getInt("persone");
				Integer trattamento= rs.getInt("trattamento");
				
				prenotazione.setIdPrenotazione(idP);
				prenotazione.setUtente(utente);
				prenotazione.setTime(time);
				prenotazione.setDate(date);
				prenotazione.setPersone(persone);
				prenotazione.setTrattamento(trattamento);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return prenotazione;
	}

	@Override
	public void update(Prenotazione prenotazione) {
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			Prenotazione pr= trovaPrenotazione(prenotazione.getId());
			if(pr.getId() == null)
			{
				//trattamento non trovato
			}
			else
			{
				
				String query="UPDATE prenotazione SET time=? , date=? , persone=? , trattamento=? WHERE id=?";
				PreparedStatement st= conn.prepareStatement(query);
				
				System.out.println(pr);
				st.setTime(1, prenotazione.getTime());
				st.setDate(2, prenotazione.getDate());
				st.setInt(3, prenotazione.getPersone());
				st.setInt(4, prenotazione.getTrattamento());
				
				st.setInt(5, prenotazione.getId());
				
				st.executeUpdate();
				System.out.println("Cambiamenti aggiornati!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
