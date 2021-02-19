package web.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Orario;
import model.Prenotazione;
import model.Recensione;
import model.Trattamento;
import model.Utente;
import persistence.DBManager;

@Controller
public class PageController 
{
	@GetMapping("/Gallery")
	public String gallery(HttpSession session, Model model)
	{
		
		ArrayList<Recensione> rec = DBManager.getInstance().RecensioneDAO().getLastRecensioni();
		session.setAttribute("reviewList", rec);
		
		return "Gallery";
	}
	
	@GetMapping("/Booking")
	public String booking(HttpSession session, Model model)
	{
		return "Booking";
	}
	
	@GetMapping("/Info")
	public String info(HttpSession session, Model model)
	{
		return "Info";
	}
	
	@GetMapping("/")
	public String home(HttpSession session, Model model)
	{
		return "Home";
	}
	
	
	 @GetMapping("/Treatments")
	 public String getRecensioni(HttpSession session, Model model,@RequestParam String nome,@RequestParam Date data,@RequestParam Integer numeroPersone )
	 {
		ArrayList<Trattamento>listaTrattamenti= new ArrayList<Trattamento>();
		listaTrattamenti=DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		
		ArrayList<Prenotazione>listaPrenotazioni= new ArrayList<Prenotazione>();
		listaPrenotazioni= DBManager.getInstance().PrenotazioneDAO().prenotazioniData(data);
		
		Orario r = new Orario();
		session.setAttribute("listaTrattamenti", listaTrattamenti);
		session.setAttribute("listaPrenotazioni", listaPrenotazioni);
		session.setAttribute("orariDisponibili", r.orari);
		
		return "Treatments";
	 }
	 
	 @PostMapping("/LetReview")
	 public String aggiungiRecensione(@RequestParam Integer id,@RequestParam String descrizione,@RequestParam Date data,@RequestParam String autore, @RequestParam Integer voto )
	 {
		 	System.out.println("Ok reewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwo utente!");
			Recensione tmp= new Recensione(id, descrizione, data, autore, voto);
			System.out.println("Ok registo aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanuovo utente!");
			DBManager.getInstance().RecensioneDAO().save(tmp);
			return "Gallery";
	 }
}
