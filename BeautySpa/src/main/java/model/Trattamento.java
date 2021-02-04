package model;

public class Trattamento 
{
	private String nomeTrattamento;
	private Integer durata;
	
	public Trattamento()
	{
		
	}
	
	public Trattamento(String nomeTrattamento, Integer durata)
	{
		this.nomeTrattamento=nomeTrattamento;
		this.durata=durata;
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
