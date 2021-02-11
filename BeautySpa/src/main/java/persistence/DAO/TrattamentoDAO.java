package persistence.DAO;

import java.util.ArrayList;

import model.Trattamento;

public interface TrattamentoDAO 
{
	public void newTrattamento(Trattamento trattamento);
	public ArrayList<Trattamento> listaTrattamenti();
	public Trattamento trovaNomeTrattamento(String nomeTrattamento);
	public void aggiornaTrattamento(Trattamento trattamento);
	public void eliminaTrattamento(Trattamento trattamento);
	/*
	 public void save(Utente utente); // Create
	public Utente findByPrimaryKey(String email); // Retrieve
	public List<Utente> findAll();
	public void update(Utente studente); //Update
	public void delete(Utente studente); //Delete
	 */
}
