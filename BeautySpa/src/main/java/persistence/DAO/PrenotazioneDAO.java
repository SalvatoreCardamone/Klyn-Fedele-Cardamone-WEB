package persistence.DAO;

import java.sql.Date;
import java.util.ArrayList;

import model.Prenotazione;
import model.Utente;

public interface PrenotazioneDAO 
{
	public void save(Prenotazione prenotazione);
	public void delete(Integer idPrenotazione);
	public ArrayList<Prenotazione> prenotazioniData(Date date);
}
