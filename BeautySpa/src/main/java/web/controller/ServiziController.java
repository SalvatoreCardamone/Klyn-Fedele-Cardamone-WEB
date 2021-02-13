package web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Utente;
import persistence.DBManager;

@RestController
public class ServiziController {

	@RequestMapping(value = "/loginGoogle", method = RequestMethod.POST)
	public void loginGoogle(@RequestParam String ID,@RequestParam String nome, @RequestParam String email ) {
		
		/*
		String []lista=nome.split(" ");
		Utente utente= new Utente(email, id, lista[0],lista[1],true,"");
		System.out.println("Nome: "+utente.getNome()+" Cognome: "+utente.getCognome());
		DBManager.getInstance().utenteDAO().save(utente);
		return "";
		*/
	}
}
