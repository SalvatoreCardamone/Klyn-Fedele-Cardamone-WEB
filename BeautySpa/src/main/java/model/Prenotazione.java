package model;

import java.sql.Date;

public class Prenotazione 
{
	private Integer idPrenotazione;
	private String utente;
	private Date date;
	private Trattamento trattamento;
	
	public Prenotazione()
	{
		
	}
	
	public Prenotazione(Integer idPrenotazione, String utente, Date date, Trattamento trattamento)
	{
		this.idPrenotazione=idPrenotazione;
		this.utente=utente;
		this.date=date;
		this.trattamento=trattamento;
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

	public Trattamento getTrattamento() {
		return trattamento;
	}

	public void setTrattamento(Trattamento trattamento) {
		this.trattamento = trattamento;
	}
	
	public String getNomeTrattamento()
	{
		String nome="";
		nome=trattamento.getNomeTrattamento();
		return nome;
	}
	
	public String toString()
	{
		String stampa="";
		
		stampa="idPrenotazione: "+idPrenotazione+"\nUtente: "+utente+"\nDate: "+date+"\nTrattamento: "+trattamento.toString();
		
		return stampa;
	}
	
}
