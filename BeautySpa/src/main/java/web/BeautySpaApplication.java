package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import persistence.DBManager;
import persistence.DAO.UtenteDAO;


@SpringBootApplication
public class BeautySpaApplication {

	public static void main(String[] args) 
	{
		
		SpringApplication.run(BeautySpaApplication.class, args);
		
		
	}

}
