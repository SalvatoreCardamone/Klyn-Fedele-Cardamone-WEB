package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Utente;
import persistence.DBManager;

@Controller
public class LoginController 
{
	@PostMapping("/login")
	public String loginUtente(@RequestParam String email,@RequestParam String password)
	{
		System.out.println("Qui");
		//Utente utente= new Utente(email,password, nome,cognome,false,telefono);
		//DBManager.getInstance().utenteDAO().save(utente);
		System.out.println("Email da HTML : "+email+":"+password);
		
		Utente utente=DBManager.getInstance().utenteDAO().login(email, password);
		System.out.println("Nome: "+utente.getNome()+" Cognome: "+utente.getCognome());
		
		return "";
	}
}
