package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Utente;
import persistence.DBManager;

@Controller
public class LoginController 
{
	@PostMapping("/loginGoogle")
	public String loginUtenteGoogle(@RequestParam String id,@RequestParam String nome, @RequestParam String email)
	{
		String []lista=nome.split(" ");
		Utente utente= new Utente(email, id, lista[0],lista[1],true,"");
		System.out.println("Nome: "+utente.getNome()+" Cognome: "+utente.getCognome());
		//DBManager.getInstance().utenteDAO().save(utente);
		return "";
	}
	
	@PostMapping("/login")
	public String loginUtente(@RequestParam String email,@RequestParam String password)
	{
		Utente ut=new Utente();
		ut= DBManager.getInstance().utenteDAO().trovaUtente(email, password);
		if(ut.getEmail().equals(""))
			return "NO";
		else
			return "";
		//Utente utente= new Utente(email, id, lista[0],lista[1],true,"");
		//System.out.println("Nome: "+utente.getNome()+" Cognome: "+utente.getCognome());
		//DBManager.getInstance().utenteDAO().save(utente);
	}
	
}
