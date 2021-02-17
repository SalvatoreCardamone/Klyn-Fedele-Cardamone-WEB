package model;

import java.sql.Date;
import java.sql.Time;

public class Trattamento 
{
	private Integer id;
	private String nome;
	private String image;
	private boolean disponibile;
	private String descrizione;
	
	
	public Trattamento()
	{
		
	}
	
	public Trattamento(Integer id, String nome, String image, boolean disponibile, String descrizione)
	{
		this.id=id;
		this.nome=nome;
		this.image=image;
		this.disponibile=disponibile;
		this.descrizione=descrizione;
	}
	
	
	
	
	public String toString()
	{
		String stampa="";
		
		stampa="\nid: "+id+"\nnome: "+nome+"\nimage: "+image+"\ndescrizione: "+descrizione;
		if(disponibile)
		{
			stampa+="\nDisponibile";
		}
		else
		{
			stampa+="\nNon disponibbile";
		}

		return stampa;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isDisponobile() {
		return disponibile;
	}

	public void setDisponobile(boolean disponobile) {
		this.disponibile = disponobile;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
