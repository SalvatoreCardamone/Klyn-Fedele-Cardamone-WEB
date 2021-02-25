package persistence.DAO;

import java.util.ArrayList;

import model.Prenotazione;
import model.Utente;

public interface UtenteDAO 
{
	public void save(Utente utente); 
	public Utente login(String email, String password);
	public Utente trovaUtente(String email); 
	public ArrayList<Utente> findAll();
	public void update(Utente studente); 
	public ArrayList<Prenotazione> dammiPrenotazioni(String email);
}
