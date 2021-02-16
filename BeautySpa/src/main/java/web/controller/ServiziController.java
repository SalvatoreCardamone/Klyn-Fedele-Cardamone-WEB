package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Utente;
import persistence.DBManager;

@RestController
public class ServiziController {

	@RequestMapping(value = "/loginGoogle", method = RequestMethod.POST)
	public void loginGoogle(@RequestParam String ID,@RequestParam String nome, @RequestParam String email ) {
		
		/*
		String []lista=nome.split(" ");
		Utente utente= new Utente(email, id, lista[0],lista[1],true,"");
		System.out.println("Nome: "+utente.getNome()+" Cognome: "+utente.getCognome());
		DBManager.getInstance().utenteDAO().save(utente);
		return "";
		*/
	}
	
	@PostMapping("verificaLogin")
	public String verirficaLogin(String email, String password)
	{
		String verifica;
		if(email!=null)
			verifica="SUCCSESS";
		else
			verifica="NO";
		
		return verifica;
	}
	
	@PostMapping("/registrazioneGoogle")
	public String registrazioneGoogle(String id, String nome, String email, HttpSession session)
	{
		String ritorna="";
		String []lista=nome.split(" ");
		Utente utente= new Utente(email, id, lista[0],lista[1],true,"");
		System.out.println("Nome: "+utente.getNome()+" Cognome: "+utente.getCognome());
		//DBManager.getInstance().UtenteDAO().save(utente);
		Utente ut= DBManager.getInstance().UtenteDAO().trovaUtente(email);
		if(ut.getEmail()==null)
			ritorna="Utente e gia registrato";
		else
		{
			DBManager.getInstance().UtenteDAO().save(utente);
			ritorna="Utente e stato registrato";
		}
		return ritorna;
	}
	/*
	@PostMapping("/registrazione")
	public String registrazione(String email, String nome, String cognome, String numero)
	{
		String ritorna="null";
		Utente ut= DBManager.getInstance().UtenteDAO().trovaUtente(email);
		//Riempio Utente
		if(ut.getEmail()!= null)
			ritorna="Esiste";
		else
		{
			DBManager.getInstance().UtenteDAO().save(ut);
		}
		return ritorna;
	}
	*/
	
	
	
	
}
