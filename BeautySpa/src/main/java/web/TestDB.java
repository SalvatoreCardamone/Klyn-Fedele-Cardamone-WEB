package web;

import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFileChooser;

import model.Prenotazione;
import model.Recensione;
import model.Trattamento;
import model.Utente;
import persistence.DBManager;
import persistence.DAO.PrenotazioneDAO;
import persistence.DAO.TrattamentoDAO;
import persistence.DAO.UtenteDAO;

public class TestDB {
	
	public static void main(String[] args) 
	{
		DBManager.getInstance().verificaConnesione();
		
		//Trattamenti
		//provaSaveTrattamento();
		//provaListaTratamenti();
		//provaTrovaTrattamenti(1);
		
		//Utenti
		//provaSaveUtente();
		//provaLoginUtente("email","password");
		//provaTrovaUtente("email");
		//provaVediTuttiUtenti();
		//provaUpdateUtente();
		
		//Recensioni
		//provaSaveRecensione();
		//provaMieRecensioni("email");
		//provaEliminaRecensione(2, "email");
		
		//Prenotazione
		//provaSavePrenotazione();
		//provaEliminaPrenotazione(11);
		//provaPrenotazioneData();
		System.out.println("OK");
	}
	
	

	public static void provaSaveTrattamento()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		String filename = f.getAbsolutePath();
		Trattamento tr= new Trattamento(0,"Bagnio turco",filename,true,"E come un bagnio normale solo che con le sigarette");
		DBManager.getInstance().TrattamentoDAO().save(tr);
	}
	public static void provaListaTratamenti()
	{
		ArrayList<Trattamento>lista;
		lista=DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		for(int i=0; i<lista.size(); i++)
		{
			System.out.println("Trattamento"+i+":"+lista.get(i));
		}
	}
	public static void provaTrovaTrattamenti(Integer id)
	{
		Trattamento trattamento= DBManager.getInstance().TrattamentoDAO().trovaTrattamento(id);
		System.out.println(trattamento);
	}
	
	public static void provaSaveUtente()
	{
		Utente utente= new Utente("email","password","nome","cognome",true,"12345");
		DBManager.getInstance().UtenteDAO().save(utente);
		System.out.println("Utente salvato");
	}
	public static void provaLoginUtente(String email, String password)
	{
		Utente utente=DBManager.getInstance().UtenteDAO().login(email, password);
		System.out.println(utente);
	}
	public static void provaTrovaUtente(String email)
	{
		Utente utente= DBManager.getInstance().UtenteDAO().trovaUtente(email);
		System.out.println(utente);
	}
	public static void provaVediTuttiUtenti()
	{
		ArrayList<Utente>lista= new ArrayList<Utente>();
		lista=DBManager.getInstance().UtenteDAO().findAll();
		for(int i=0; i<lista.size(); i++)
		{
			System.out.println(lista.get(i));
		}
	}
	public static void provaUpdateUtente()
	{
		Utente utente= new Utente("email","pass","nome","cognome",false,"1111");
		DBManager.getInstance().UtenteDAO().update(utente);
		utente=DBManager.getInstance().UtenteDAO().trovaUtente(utente.getEmail());
		System.out.println("Utente aggiornato\n"+utente);
	}
	
	
	public static void provaSaveRecensione()
	{
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);  
		Recensione recensione= new Recensione(0,"Buono",date,"email",5);
		DBManager.getInstance().RecensioneDAO().save(recensione);
		System.out.println("Recensione salvata");
	}
	public static void provaMieRecensioni(String email)
	{
		ArrayList<Recensione>lista= new ArrayList<Recensione>();
		lista=DBManager.getInstance().RecensioneDAO().mieRecensioni(email);
		for(int i=0; i<lista.size(); i++)
		{
			System.out.println(lista.get(i));
		}
	}
	public static void provaEliminaRecensione(Integer id, String scritto)
	{
		DBManager.getInstance().RecensioneDAO().delete(id,scritto);
	}
	
	public static void provaSavePrenotazione()
	{
	 
		Time time =null; 
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(calendar.getTime().getTime());
        Trattamento tr= new Trattamento(1,"Bagnio turco","a",true,"E come un bagnio normale solo che con le sigarette");
        ArrayList<Trattamento> lista= new ArrayList<Trattamento>();
        lista.add(tr);
        lista.add(tr);
		Prenotazione prenotazione= new Prenotazione(1,"email",time,date,2,lista);
		DBManager.getInstance().PrenotazioneDAO().save(prenotazione);
		System.out.println("Prenotazione e stata salvata");
	}
	public static void provaEliminaPrenotazione(Integer num)
	{
		DBManager.getInstance().PrenotazioneDAO().delete(num);
		
	}
	private static void provaPrenotazioneData() {
		
		ArrayList<Prenotazione> lista= new ArrayList<Prenotazione>();
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(calendar.getTime().getTime());
		lista= DBManager.getInstance().PrenotazioneDAO().prenotazioniData(date);
		
		for(int i=0; i<lista.size(); i++)
		{
			System.out.println(lista.get(i));
		}
		
	}
}
