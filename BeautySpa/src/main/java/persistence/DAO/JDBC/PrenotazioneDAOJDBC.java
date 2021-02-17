package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import model.Prenotazione;
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
		for(int i=0; i<prenotazione.numeroTrattamenti(); i++)
		{
		try
		{
			conn= dbSource.getConnection();
			String query= "INSERT INTO prenotazione(utente , time , date , persone , trattamento) values(?,?,?,?,?)";
			PreparedStatement st= conn.prepareStatement(query);
			st.setString(1,prenotazione.getUtente());
			//Volendo si puo caricare il tempo direttamente qui facendo
			/*
			 	LocalTime localTime = LocalTime.now();
			 	Time time = Time.valueOf(localTime)
			 	st.setDate(2, time);
			 */
			st.setTime(2, prenotazione.getTime());
			//Volendo qui si puo occuopare del tempo facendo
			/*
			 	Calendar calendar = Calendar.getInstance();
				Date date = new Date(calendar.getTime().getTime());
			 	st.setTime(3, date);
			 */
			st.setDate(3, prenotazione.getDate());
			st.setInt(4, prenotazione.getPersone());
			st.setInt(5, prenotazione.trattamentoNumero(i).getId());
			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
}
