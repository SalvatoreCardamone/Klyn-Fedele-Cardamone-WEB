package web.controller;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Prenotazione;
import model.Recensione;
import model.Trattamento;
import model.Utente;
import persistence.DBManager;

@RestController
public class AdminRestController {
	
	@PostMapping("adminListaUtenti")
	public ArrayList<Utente> dammiUtenti()
	{
		ArrayList<Utente>listaUtenti=DBManager.getInstance().UtenteDAO().findAll();
		return listaUtenti;
	}
	
	@PostMapping("adminListaRecensioni")
	public ArrayList<Recensione> dammiRecensione()
	{
		
		ArrayList<Recensione>listaRecensione=DBManager.getInstance().RecensioneDAO().findAll();
		return listaRecensione;
	}
	
	@PostMapping("adminEliminaRecensione")
	public ArrayList<Recensione>adminEliminaRecensione(Integer idRecensione,HttpSession session, Model model)
	{
		DBManager.getInstance().RecensioneDAO().delete(idRecensione);
		ArrayList<Recensione>listaRecensioni=DBManager.getInstance().RecensioneDAO().findAll();
		session.setAttribute("listaRecensioni", listaRecensioni);
		return listaRecensioni;
	}
	
	@PostMapping("adminEliminaPrenotazione")
	public ArrayList<Prenotazione>  adminEliminaPrenotazione(Integer idRecensione,HttpSession session, Model model)
	{
		ArrayList<Prenotazione>listaPrenotazioni;
		DBManager.getInstance().PrenotazioneDAO().delete(idRecensione);
		listaPrenotazioni=DBManager.getInstance().PrenotazioneDAO().findAll();
		session.setAttribute("listaPrenotazioni", listaPrenotazioni);
		return listaPrenotazioni;
	}
	
	@PostMapping("adminUpdateTrattamento")
	public ArrayList<Trattamento> adminUpdateTrattamento(Integer idTrattamento,String nomeTrattamento ,String descrizioneTrattamento, HttpSession session, Model model)
	{
		Trattamento tr= new Trattamento(idTrattamento,nomeTrattamento,descrizioneTrattamento);
		DBManager.getInstance().TrattamentoDAO().updateTrattamento(tr);
		ArrayList<Trattamento> lista= DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		session.setAttribute("adminListaTrattamenti", lista);
		return lista;
	}
	
	
	@PostMapping("adminUpdateRecensione")
	public ArrayList<Recensione> adminUpdateRecensione(Integer idRecensione,
			String descrizioneRecensione,
			Date dateRecensione, 
			String scrittoRecensione,
			Integer votoRecensione,
			HttpSession session, Model model)
	{
		
		Recensione rc= new Recensione(idRecensione,descrizioneRecensione,dateRecensione,scrittoRecensione,votoRecensione);
		DBManager.getInstance().RecensioneDAO().update(rc);
		ArrayList<Recensione>listaRecensioni = DBManager.getInstance().RecensioneDAO().findAll();
		session.setAttribute("listaRecensioni", listaRecensioni);
		return null;
	}
	
	   

	@PostMapping("adminUpdatePrenotazione")
	public ArrayList<Prenotazione> adminUpdatePrenotazione(Integer idPrenotazione,
			String utentePrenotazione,
			Time timePrenotazione,
			Date datePrenotazione, 
			Integer personePrenotazione,
			Integer trattamentoPrenotazione,
			HttpSession session, Model model)
	{
		
		Prenotazione pr=new Prenotazione(idPrenotazione,utentePrenotazione,timePrenotazione,datePrenotazione,personePrenotazione,trattamentoPrenotazione);
		DBManager.getInstance().PrenotazioneDAO().update(pr);
		ArrayList<Prenotazione>listaPrenotazioni=DBManager.getInstance().PrenotazioneDAO().findAll();
		session.setAttribute("listaPrenotazioni", listaPrenotazioni);
		return null;
	}
	
}
