package web.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Utente;
import persistence.DBManager;

@RestController
public class AdminRestController {
	
	@PostMapping("adminListaUtenti")
	public ArrayList<Utente> dammiUtenti()
	{
		ArrayList<Utente>listaUtenti=DBManager.getInstance().UtenteDAO().findAll();
		return listaUtenti;
	}
}
