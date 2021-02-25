package model;

import java.sql.Date;
import java.sql.Time;

public class Prenotazione 
{
	private Integer id;
	private String utente;
	private Time time;
	private Date date;
	private Integer persone;
	private Integer trattamento;
	
	public Prenotazione(){}
	
	public Prenotazione(Integer id, String utente,Time time, Date date, Integer persone,Integer trattamento)
	{
		this.id=id;
		this.utente=utente;
		this.time=time;
		this.date=date;
		this.persone=persone;
		this.trattamento=trattamento;
	}

	public Integer getId() {
		return id;
	}

	public void setIdPrenotazione(Integer idPrenotazione) {
		this.id = idPrenotazione;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date data) {
		this.date = data;
	}
	
	public Integer getPersone() {
		return persone;
	}

	public void setPersone(Integer persone) {
		this.persone = persone;
	}

	public Integer getTrattamento() {
		return trattamento;
	}

	public void setTrattamento(Integer trattamento) {
		this.trattamento = trattamento;
	}
	
	public String toString()
	{
		String stampa="";
		stampa="idPrenotazione: "+id+"\nUtente: "+utente+"\nDate: "+date+"\n Time: "+time+"\nPersone: "+persone+"\nTrattamento: "+trattamento;
		return stampa;
	}
	
}
