package web;

import model.Utente;
import persistence.DBManager;
import persistence.DAO.UtenteDAO;

public class TestDB {
	
	public static void main(String[] args) 
	{
		DBManager.getInstance().verificaConnesione();
		
		UtenteDAO ut= DBManager.getInstance().utenteDAO();
		//Inserimento Utente
		Utente utente= new Utente();
		ut.save(utente);
		
	}
	
}
