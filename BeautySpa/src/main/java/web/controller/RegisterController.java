package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import model.Utente;
import persistence.DBManager;


@Controller
public class RegisterController {

	@PostMapping("/registrazione")
	public String registraUtente(@RequestParam String email,@RequestParam String password,
			@RequestParam String nome,@RequestParam String cognome, @RequestParam String telefono)
	{
		Utente utente= new Utente(email,password, nome,cognome,false,telefono);
		DBManager.getInstance().utenteDAO().save(utente);
		System.out.println("Ok registo nuovo utente!");
		
		return "Prova01";
	}
	
	@GetMapping("/registrazione")
	public String fineRegistrazione()
	{
		System.out.println("Fine dela registrazione");
		//return "/HTML/RegistrazioneCompletata.html";
		return "fReg.html";
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
