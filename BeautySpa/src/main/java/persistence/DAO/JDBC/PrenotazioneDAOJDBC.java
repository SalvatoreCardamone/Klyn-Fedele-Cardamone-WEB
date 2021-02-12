package persistence.DAO.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Prenotazione;
import persistence.DBSource;
import persistence.DAO.PrenotazioneDAO;

public class PrenotazioneDAOJDBC implements PrenotazioneDAO
{
	DBSource dbSource;
	public PrenotazioneDAOJDBC(DBSource dbSourse)
	{
		this.dbSource=dbSource;
	}

	@Override
	public void save(Prenotazione prenotazione) {
		Connection conn;
		try
		{
			conn= dbSource.getConnection();
			String query= "INSERT INTO prenotazione values(?,?,?,?)";
			PreparedStatement st= conn.prepareStatement(query);
			
			st.setInt(1,prenotazione.getIdPrenotazione());
			st.setString(2,prenotazione.getUtente());
			st.setDate(3, prenotazione.getDate());
			st.setString(4, prenotazione.getNomeTrattamento());
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
			String query="DELETE FROM prenotazione WHERE idPrenotazione=?";
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
