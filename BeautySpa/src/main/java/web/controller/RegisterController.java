package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import model.Utente;
import persistence.DBManager;


@Controller
public class RegisterController {

	String regex = "\"^\\\\d{10}$\"";
	
	@PostMapping("/registrazione")
	public String registraUtente(@RequestParam String email,@RequestParam String password,
			@RequestParam String nome,@RequestParam String cognome, @RequestParam String telefono, HttpSession session, Model model)
	{
		System.out.println("Email: "+email);
		Utente vedi= DBManager.getInstance().UtenteDAO().trovaUtente(email);
		String messagio="";
		if(vedi.getEmail()!=null)
		{
			messagio="Email esiste gia";
			session.setAttribute("nonRegistrato", false);
			session.setAttribute("messagio", messagio);
			return "redirect:/";
		}
		else
		{
			Utente utente= new Utente(email,password, nome,cognome,false,telefono);
			DBManager.getInstance().UtenteDAO().save(utente);
			System.out.println("Ok registo nuovo utente!");
			messagio="Utente "+nome+" "+cognome+" e stato registrato";
			session.setAttribute("registrato", true);
			session.setAttribute("messagio", messagio);
			return "redirect:/";
		}
	}
	
	@GetMapping("/registrazione")
	public String fineRegistrazione()
	{
		System.out.println("Fine dela registrazione");
		//return "/HTML/RegistrazioneCompletata.html";
		return "Home";
	}
	
	/*
	@PostMapping("onSignIn")
	public Utente registraUtente(@RequestParam String email,@RequestParam String password,
			@RequestParam String nome,@RequestParam String cognome, @RequestParam String telefono)
	{
		Utente utente= new Utente(email,password, nome,cognome,false,telefono);
		DBManager.getInstance().utenteDAO().save(utente);
		System.out.println("Ok registo nuovo utente!");
		
		return utente;
	}
	*/
	
}
