package persistence.DAO;

import java.util.ArrayList;
import java.util.List;

import model.Utente;

public interface UtenteDAO 
{
	public void save(Utente utente); // Create
	public Utente login(String email, String password);
	public Utente findByPrimaryKey(String email); // Retrieve
	public ArrayList<Utente> findAll();
	public void update(Utente studente); //Update
	public void delete(Utente studente); //Delete
}
