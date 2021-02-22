package persistence.DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import model.Prenotazione;

public interface PrenotazioneDAO 
{
	public void save(Prenotazione prenotazione);
	public void delete(Integer idPrenotazione);
	public ArrayList<Prenotazione> prenotazioniData(Date date);
	public ArrayList<String> dammiDescrizioneTrattamenti(ArrayList<Prenotazione> lista);
	public HashMap<Date, Integer> countDate(String mail);
	public ArrayList<Prenotazione> findAll();
}
