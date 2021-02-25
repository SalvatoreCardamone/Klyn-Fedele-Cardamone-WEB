package web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Prenotazione;
import model.Recensione;
import model.Trattamento;
import model.Utente;
import persistence.DBManager;

@Controller
public class AdminController 
{
	private final String nome="admin";
	private final String password="admin";
	
	@PostMapping("/PageAdmin")
	public String pageAdmin(HttpSession session, Model model, @RequestParam String nomeAdmin, @RequestParam String passwordAdmin)
	{
		if(nomeAdmin.equals(nome) && passwordAdmin.equals(password))
		{
			ArrayList<Utente>listaUtenti=DBManager.getInstance().UtenteDAO().findAll();
			session.setAttribute("listaUtenti", listaUtenti);
			
			ArrayList<Recensione>listaRecensioni = DBManager.getInstance().RecensioneDAO().findAll();
			session.setAttribute("listaRecensioni", listaRecensioni);
			
			ArrayList<Prenotazione>listaPrenotazioni=DBManager.getInstance().PrenotazioneDAO().findAll();
			session.setAttribute("listaPrenotazioni", listaPrenotazioni);
			
			ArrayList<Trattamento>listaTrattamenti=DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
			session.setAttribute("listaTrattamenti", listaTrattamenti);
			return "PageAdmin";
		}
		session.setAttribute("messaggio", "ACCESSO NEGATO");
		return "redirect:/";
	}
}
