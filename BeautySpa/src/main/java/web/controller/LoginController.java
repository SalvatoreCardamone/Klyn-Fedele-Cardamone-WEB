package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Utente;
import persistence.DBManager;

@Controller
public class LoginController 
{

	
	@PostMapping("/login")
	public String loginUtente(@RequestParam String email,@RequestParam String password, HttpSession session)
	{
		
		//Utente ut;
		//ut = DBManager.getInstance().utenteDAO().trovaUtente(email, password);
		//if(ut.getEmail() != null)
			session.setAttribute("utente", "banana");
		
		return "nav";
		
		//Utente utente= new Utente(email, id, lista[0],lista[1],true,"");
		//System.out.println("Nome: "+utente.getNome()+" Cognome: "+utente.getCognome());
		//DBManager.getInstance().utenteDAO().save(utente);
	}
	
}
