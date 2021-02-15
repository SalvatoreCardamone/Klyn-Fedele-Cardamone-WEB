package model;

import java.sql.Date;
import java.sql.Time;

public class Prenotazione 
{
	private Integer idPrenotazione;
	private String utente;
	private Date date;
	private Time time;
	private String trattamento;
	
	public Prenotazione()
	{
		
	}
	
	public Prenotazione(Integer idPrenotazione, String utente, String trattamento, Date date,Time time)
	{
		this.idPrenotazione=idPrenotazione;
		this.utente=utente;
		this.date=date;
		this.trattamento=trattamento;
		this.time=time;
	}

	public Integer getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(Integer idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date data) {
		this.date = data;
	}

	public String getTrattamento() {
		return trattamento;
	}

	public void setTrattamento(String trattamento) {
		this.trattamento = trattamento;
	}
	
	
	public String toString()
	{
		String stampa="";
		
		stampa="idPrenotazione: "+idPrenotazione+"\nUtente: "+utente+"\nDate: "+date+"\nTrattamento: "+trattamento+"\n Time: "+time;
		
		return stampa;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
