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

	@PostMapping("/registraUtente")
	public void registraUtente(String email, String password, String nome, String cognome)
	{
		/*
		Utente utente= new Utente();
		utente.setEmail(email);
		utente.setPassword(password);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setConvalidato(false);
		*/
		System.out.println("Ok registo nuovo utente!");
		
		//System.out.println(matricola);
		//System.out.println(nome);
		//System.out.println(cognome);
		//System.out.println(date);
		//System.out.println(scuolaId);
		//{matricola:matr, cognome:cogn, nome:nome, date:date}
		
		//DBManager.getInstance().utenteDAO().save(utente);
		//DBManager.getInstance().UtenteDAO().save(utente);
		
		//return utente;
	}
	
	@PostMapping("/registraUtenteObj")
	public Utente iscriviStudenteObj(@RequestBody Utente utente)
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
		
		
		
		DBManager.getInstance().utenteDAO().save(utente);
		
		return utente;
	}
}
