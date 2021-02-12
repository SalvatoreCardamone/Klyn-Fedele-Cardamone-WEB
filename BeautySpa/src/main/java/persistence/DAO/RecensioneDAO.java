package persistence.DAO;

import java.util.ArrayList;

import model.Recensione;
import model.Utente;

public interface RecensioneDAO 
{
	public void save(Recensione recensione);
	public ArrayList<Recensione> findAll(String emailUtente);
}
