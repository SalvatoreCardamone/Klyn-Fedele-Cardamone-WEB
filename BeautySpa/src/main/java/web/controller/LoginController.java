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
			session.setAttribute("utente", ut.getNome() + " " + ut.getCognome());
		else
			session.setAttribute("erroreLogin", true);
		
		//model.addAttribute();// prenod con $
		//return "Home";
		return "redirect:/"; 
		
	}
	
	@PostMapping("/logout")
	public String logoutUtente(HttpSession session)
	{
		session.setAttribute("utente", null);
		return "redirect:/";
		
	}
	
	@PostMapping("/loginGoogle")
	public String loginGoogle(@RequestParam String email,@RequestParam String password, @RequestParam String nomeCognome, HttpSession session) 
	{
		
		Utente ut = DBManager.getInstance().UtenteDAO().trovaUtente(email);
		
		if (ut.getEmail() == null) //non esiste
		{
			//devo crearlo..
		}
		
		//faccio login e setto attributo utente
		
		
		return "redirect:/";
	}
	
}
