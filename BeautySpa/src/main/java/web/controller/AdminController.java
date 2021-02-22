package web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Prenotazione;
import model.Trattamento;
import model.Utente;
import persistence.DBManager;

@Controller
public class AdminController 
{
	private final String nomeAdmin="admin";
	private final String passwordAdmin="admin";
	
	@PostMapping("/verificaAdmin")
	public String admin(@RequestParam String email,@RequestParam String password, HttpSession session, Model model)
	{
		ArrayList<Utente>listaUtenti=DBManager.getInstance().UtenteDAO().findAll();
		session.setAttribute("adminTuttiUtenti", listaUtenti);
		return "PageAdmin";
	}
	
	@PostMapping("/adminTuttiUtenti")
	public String adminTuttiUtenti(@RequestParam String email,@RequestParam String password, HttpSession session, Model model)
	{
		ArrayList<Utente>listaUtenti=DBManager.getInstance().UtenteDAO().findAll();
		session.setAttribute("adminTuttiUtenti", listaUtenti);
		return "PageAdmin";
	}
	
	@PostMapping("/adminTuttiPrenotazioni")
	public String adminTuttiPrenotazioni(@RequestParam String email,@RequestParam String password, HttpSession session, Model model)
	{
		ArrayList<Prenotazione>lista= DBManager.getInstance().PrenotazioneDAO().findAll();
		session.setAttribute("adminListaPrenotazione", lista);
		return "PageAdmin";
	}
	
	@PostMapping("/adminPrenotazioniUtente")
	public String adminPrenotazioniUtente(@RequestParam String emailUtente,HttpSession session, Model model)
	{
		ArrayList<Prenotazione>listaPrenotazioni=DBManager.getInstance().UtenteDAO().dammiPrenotazioni(emailUtente);
		session.setAttribute("adminPrenotaioniUtente", listaPrenotazioni);
		return "PageAdmin";
	}
	
	@PostMapping("/adminEliminaPrenotazione")
	public String adminEliminaPrenotazione(@RequestParam Integer idPrenotazione,HttpSession session, Model model)
	{
		DBManager.getInstance().PrenotazioneDAO().delete(idPrenotazione);
		session.setAttribute("messageAdmin", "Trattamento e stato eliminato");
		return "PageAdmin";
	}
	
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
	
	@PostMapping("/adminUpdateTrattamento")
	public String adminUpdateTrattamento(@RequestParam Integer idTrattamento,@RequestParam String nomeTrattamento ,@RequestParam String descrizioneTrattamento, HttpSession session, Model model)
	{
		Trattamento tr= new Trattamento(idTrattamento,nomeTrattamento,descrizioneTrattamento);
		DBManager.getInstance().TrattamentoDAO().updateTrattamento(tr);
		ArrayList<Trattamento> lista= DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		session.setAttribute("adminListaTrattamenti", lista);
		return "PageAdmin";
	}
}
