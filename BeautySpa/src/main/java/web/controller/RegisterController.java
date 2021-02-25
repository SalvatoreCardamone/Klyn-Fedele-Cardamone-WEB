package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Utente;
import persistence.DBManager;


@Controller
public class RegisterController {
	
	@PostMapping("/registrazione")
	public String registraUtente(@RequestParam String email,@RequestParam String password,
			@RequestParam String nome,@RequestParam String cognome, @RequestParam String telefono, HttpSession session, Model model)
	{
		
		Utente vedi= DBManager.getInstance().UtenteDAO().trovaUtente(email);
		String messagio="";
		if(vedi.getEmail()!=null)
		{
			messagio="Email esiste gia";
			session.setAttribute("messagio", messagio);
			return "redirect:/";
		}
		else
		{
			Utente utente= new Utente(email,password, nome,cognome,false,telefono);
			DBManager.getInstance().UtenteDAO().save(utente);
			messagio="Utente "+nome+" "+cognome+" e stato registrato";
			session.setAttribute("messagio", messagio);
			return "redirect:/";
		}
	}
}
