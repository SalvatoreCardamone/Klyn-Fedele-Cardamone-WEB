package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Prenotazione 
{
	private Integer id;
	private String utente;
	private Time time;
	private Date date;
	private Integer persone;
	private ArrayList<Trattamento>lista;
	
	public Prenotazione()
	{
		lista= new ArrayList<Trattamento>();
	}
	
	public Prenotazione(Integer id, String utente,Time time, Date date, Integer persone, ArrayList<Trattamento>l)
	{
		this.id=id;
		this.utente=utente;
		this.time=time;
		this.date=date;
		this.persone=persone;
		lista= new ArrayList<Trattamento>();
		for(int i=0; i<l.size(); i++)
		{
			lista.add(l.get(i));
		}
		
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

	public ArrayList<Trattamento> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Trattamento> lista) {
		this.lista = lista;
	}

	public String toString()
	{
		String stampa="";
		
		stampa="idPrenotazione: "+id+"\nUtente: "+utente+"\nDate: "+date+"\n Time: "+time+"\nPersone: "+persone;
		StampaLista();
		return stampa;
	}

	public void StampaLista()
	{
		for(int i=0; i<lista.size(); i++)
		{
			System.out.println(lista.get(i));
		}
	}
	
	public int numeroTrattamenti()
	{
		return lista.size();
	}
	
	public Trattamento trattamentoNumero(int numero)
	{
		if(numero < lista.size())
		{
			Trattamento tr= lista.get(numero);
			return tr;
		}
		else
		{
			return null;
		}
	}
	
}
