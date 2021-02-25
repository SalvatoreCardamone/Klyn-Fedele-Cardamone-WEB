package persistence.DAO;

import java.util.ArrayList;

import model.Recensione;
import model.Utente;

public interface RecensioneDAO 
{
	public void save(Recensione recensione);
	public ArrayList<Recensione> mieRecensioni(String emailUtente);
	public void delete(Integer idRecensione);
	public ArrayList<Recensione> getLastRecensioni();
	public ArrayList<Recensione> findAll();
	public void update(Recensione recensione);
	public Recensione trovaRecensione(Integer id);
}
