package model;

public class Recensione {
	private Integer idRecensione;
	private String descrizione;
	private String data;
	private String scrittoDa;//Utente
	private Integer voto;
	
	public Recensione()
	{
		
	}
	
	public Recensione(Integer idRecensione, String descrizione, String data, String scrittoDa, Integer voto)
	{
		this.idRecensione=idRecensione;
		this.descrizione=descrizione;
		this.data=data;
		this.scrittoDa=scrittoDa;
		this.voto=voto;
	}

	public Integer getIdRecensione() {
		return idRecensione;
	}

	public void setIdRecensione(Integer idRecensione) {
		this.idRecensione = idRecensione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getScrittoDa() {
		return scrittoDa;
	}

	public void setScrittoDa(String scrittoDa) {
		this.scrittoDa = scrittoDa;
	}

	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}
	
	public String toString()
	{
		String stampa="";
		
		stampa="idRecensione: "+idRecensione+"\ndescrizione: "+descrizione+"\nData: "+data+"\nScrittoDa: "+scrittoDa+"\nVoto: "+voto.toString();

		return stampa;
	}
	
}
