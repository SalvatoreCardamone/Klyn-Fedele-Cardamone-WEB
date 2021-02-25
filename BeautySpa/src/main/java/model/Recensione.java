package model;

import java.sql.Date;

public class Recensione {
	private Integer idRecensione;
	private String descrizione;
	private Date date;
	private String scrittoDa;//Email utente
	private Integer voto;
	
	public Recensione(){}
	
	public Recensione(Integer idRecensione, String descrizione, Date data, String scrittoDa, Integer voto)
	{
		this.idRecensione=idRecensione;
		this.descrizione=descrizione;
		this.date=data;
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

	public Date getData() {
		return date;
	}

	public void setData(Date data) {
		this.date = data;
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
		stampa="idRecensione: "+idRecensione+"\ndescrizione: "+descrizione+"\nData: "+date+"\nScrittoDa: "+scrittoDa+"\nVoto: "+voto.toString();
		return stampa;
	}
	
}
