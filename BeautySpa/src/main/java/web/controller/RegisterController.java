package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import model.Utente;
import persistence.DBManager;


@Controller
public class RegisterController {

	@PostMapping("/index.html")
	public String registraUtente(@RequestParam String email,@RequestParam String password,
			@RequestParam String nome,@RequestParam String cognome)
	{
		/*
		Utente utente= new Utente();
		utente.setEmail(email);
		utente.setPassword(password);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setConvalidato(false);
		*/
		
		
		//System.out.println(email);
		//System.out.println(nome);
		//System.out.println(cognome);
		//System.out.println(date);
		//System.out.println(scuolaId);
		Utente utente= new Utente(email,password, nome,cognome,false);
		DBManager.getInstance().utenteDAO().save(utente);
		System.out.println("Ok registo nuovo utente!");
		
		//{matricola:matr, cognome:cogn, nome:nome, date:date}
		return "/HTML/index";
		//DBManager.getInstance().utenteDAO().save(utente);
		//DBManager.getInstance().UtenteDAO().save(utente);
		//return utente;
	}
	
	@PostMapping("../web.controller/registraUtenteObj")
	public Utente registraUtenteObj(@RequestBody Utente utente)
	{
		/*
		Studente stud= new Studente();
		stud.setMatricola(matricola);
		stud.setNome(nome);
		stud.setCognome(cognome);
		stud.setDataNascita(date);
		*/
		//Scuola sc= DBManager.getInstance().scuolaDAO().findByPrimaryKey(scuolaId);
		//stud.setScuola(sc);
		
		
		System.out.println("Sono qui");
		DBManager.getInstance().utenteDAO().save(utente);
		
		return utente;
	}
}
