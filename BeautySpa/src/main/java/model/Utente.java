package model;

import java.util.ArrayList;

public class Utente {

	private String email;
	private String password;
	private ArrayList<Recensione> recensioni;
	private String nome;
	private String cognome;
	private boolean convalidato;
	
	public Utente()
	{
		recensioni= new ArrayList<Recensione>();
	}
	
	
	public Utente(String email, String password, ArrayList<Recensione> recensione, String nome, String cognome, boolean convalidato)
	{
		this.email=email;
		this.password=password;
		this.recensioni=recensione;
		this.nome=nome;
		this.cognome=cognome;
		this.convalidato=convalidato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public boolean isConvalidato() {
		return convalidato;
	}

	public void setConvalidato(boolean convalidato) {
		this.convalidato = convalidato;
	}
	
	public void stampaRecensioni()
	{
		System.out.println("Lista Recensioni: ");
		for(int i=0; i<recensioni.size(); i++)
		{
			System.out.println(i+":"+recensioni.get(i).toString()+"\n");
		}
		System.out.println(";");
	}
	
	public String toString()
	{
		String stampa="";
		
		stampa="Email: "+email+"\nPassword: "+password+"\nNome: "+nome+"\nCognome: "+cognome;
		if(convalidato)
			stampa+="Convalidato!";
		else
			stampa+="Non Convalidato!";
		
		stampaRecensioni();
		
		return stampa;
	}
}