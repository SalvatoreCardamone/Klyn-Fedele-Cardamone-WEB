package model;

public class Prenotazione 
{
	private Integer idPrenotazione;
	private String utente;
	private String data;
	private Trattamento trattamento;
	
	public Prenotazione()
	{
		
	}
	
	public Prenotazione(Integer idPrenotazione, String utente, String data, Trattamento trattamento)
	{
		this.idPrenotazione=idPrenotazione;
		this.utente=utente;
		this.data=data;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Trattamento getTrattamento() {
		return trattamento;
	}

	public void setTrattamento(Trattamento trattamento) {
		this.trattamento = trattamento;
	}
	
	public String toString()
	{
		String stampa="";
		
		stampa="idPrenotazione: "+idPrenotazione+"\nUtente: "+utente+"\nData: "+data+"\nTrattamento: "+trattamento.toString();
		
		return stampa;
	}
	
}
