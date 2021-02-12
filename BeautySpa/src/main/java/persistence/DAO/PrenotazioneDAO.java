package persistence.DAO;

import model.Prenotazione;
import model.Utente;

public interface PrenotazioneDAO 
{
	public void save(Prenotazione prenotazione);
	public void delete(Integer idPrenotazione);
	public void updatePrenotazione(Prenotazione prenotazione);
}
