package model;

public class Trattamento 
{
	private String nomeTrattamento;
	private Integer durata;
	private String descrizione;
	private String percorso;
	
	
	public Trattamento()
	{
		
	}
	
	public Trattamento(String nomeTrattamento, Integer durata, String descrizione , String percorso)
	{
		this.nomeTrattamento=nomeTrattamento;
		this.durata=durata;
		this.descrizione=descrizione;
		this.percorso=percorso;
	}
	
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPercorso() {
		return percorso;
	}

	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}

	
	public String getNomeTrattamento() {
		return nomeTrattamento;
	}
	public void setNomeTrattamento(String nomeTrattamento) {
		this.nomeTrattamento = nomeTrattamento;
	}
	public Integer getDurata() {
		return durata;
	}
	public void setDurata(Integer durata) {
		this.durata = durata;
	}
	
	public String toString()
	{
		String stampa="";
		
		stampa="NomeTrattamento: "+nomeTrattamento+"\ndurata: "+durata.toString();

		return stampa;
	}
	
}
