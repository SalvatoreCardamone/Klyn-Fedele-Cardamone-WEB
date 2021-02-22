package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Utente;
import persistence.DBManager;

@Controller
public class LoginController 
{

	
	@PostMapping("/login")
	public String loginUtente(@RequestParam String email,@RequestParam String password, HttpSession session, Model model)
	{
		
		Utente ut = DBManager.getInstance().UtenteDAO().login(email, password);
		if(ut.getEmail() != null)
			session.setAttribute("utente", ut);
		else
			session.setAttribute("messaggio", "Attenzione: E-mail e/o password inserite non corrette!");
		
		//model.addAttribute();// prenod con $
		return "redirect:/"; 
		
	}
	
	@PostMapping("/logout")
	public String logoutUtente(HttpSession session)
	{
		session.setAttribute("utente", null);
		return "redirect:/";
		
	}
	
	@PostMapping("/loginGoogle")
	public String loginGoogle(String email,String password, String nomeCognome, HttpSession session, Model model) 
	{
		
		Utente ut = DBManager.getInstance().UtenteDAO().trovaUtente(email);
		
		String []lista=nomeCognome.split(" ");
		Utente utente= new Utente(email, password, lista[0],lista[1],true,"---");
		
		if(ut.getEmail()==null)
		{
			DBManager.getInstance().UtenteDAO().save(utente);
		}
		
		loginUtente(email, password, session, model);
		return "redirect:/";
	}
	
}
