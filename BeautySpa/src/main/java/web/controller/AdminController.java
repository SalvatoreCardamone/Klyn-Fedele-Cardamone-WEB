package web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
			//Stampo tutti gli utenti
			ArrayList<Utente>listaUtenti=DBManager.getInstance().UtenteDAO().findAll();
			session.setAttribute("listaUtenti", listaUtenti);
			
			//Stampo tutte le recensioni
			ArrayList<Recensione>listaRecensioni = DBManager.getInstance().RecensioneDAO().findAll();
			session.setAttribute("listaRecensioni", listaRecensioni);
			
			return "PageAdmin";
		}
			
		
		session.setAttribute("messaggio", "ACCESSO NEGATO");
			return "redirect:/";
	}
	/*
	@PostMapping("/adminListaUtenti")
	public ArrayList<Utente> dammiUtentiController()
	{
		ArrayList<Utente>listaUtenti=DBManager.getInstance().UtenteDAO().findAll();
		return listaUtenti;
	}
	*/
	@PostMapping("/adminListaPrenotazioni")
	public ArrayList<Recensione> dammiPrenotazioni(HttpSession session, Model model)
	{
		ArrayList<Recensione>listaRecensioni = DBManager.getInstance().RecensioneDAO().findAll();
		return listaRecensioni;
	}
	
	
	@PostMapping("/adminTuttiPrenotazioni")
	public ArrayList<Prenotazione> adminTuttiPrenotazioni(HttpSession session, Model model)
	{
		ArrayList<Prenotazione>lista= DBManager.getInstance().PrenotazioneDAO().findAll();
		//session.setAttribute("adminListaPrenotazione", lista);
		return lista;
	}
	
	@PostMapping("/adminPrenotazioniUtente")
	public ArrayList<Prenotazione> adminPrenotazioniUtente(@RequestParam String emailUtente,HttpSession session, Model model)
	{
		ArrayList<Prenotazione>listaPrenotazioni=DBManager.getInstance().UtenteDAO().dammiPrenotazioni(emailUtente);
		//session.setAttribute("adminPrenotaioniUtente", listaPrenotazioni);
		return listaPrenotazioni;
	}
	
	@PostMapping("/adminEliminaPrenotazione")
	public void adminEliminaPrenotazione(@RequestParam Integer idPrenotazione,HttpSession session, Model model)
	{
		DBManager.getInstance().PrenotazioneDAO().delete(idPrenotazione);
		adminTuttiPrenotazioni(session,model);
		
	}
	/*
	@PostMapping("/adminEliminaTrattamento")
	public String adminEliminaTrattamento(@RequestParam Integer idTrattamento,HttpSession session, Model model)
	{
		DBManager.getInstance().TrattamentoDAO().delete(idTrattamento);
		session.setAttribute("messageAdmin", "Trattamento e stato eliminato");
		return "PageAdmin";
	}
	
	@PostMapping("/adminNuovoTrattamento")
	public String adminNuovoTrattamento(@RequestParam String nomeTrattamento ,@RequestParam String descrizioneTrattamento, HttpSession session, Model model)
	{
		Trattamento tr= new Trattamento(0,nomeTrattamento,descrizioneTrattamento);
		DBManager.getInstance().TrattamentoDAO().save(tr);
		session.setAttribute("messageAdmin", "Trattamento e stato aggiunto");
		return "PageAdmin";
	}
	*/
	@PostMapping("/adminUpdateTrattamento")
	public ArrayList<Trattamento> adminUpdateTrattamento(@RequestParam Integer idTrattamento,@RequestParam String nomeTrattamento ,@RequestParam String descrizioneTrattamento, HttpSession session, Model model)
	{
		Trattamento tr= new Trattamento(idTrattamento,nomeTrattamento,descrizioneTrattamento);
		DBManager.getInstance().TrattamentoDAO().updateTrattamento(tr);
		ArrayList<Trattamento> lista= DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		session.setAttribute("adminListaTrattamenti", lista);
		return lista;
	}
}
