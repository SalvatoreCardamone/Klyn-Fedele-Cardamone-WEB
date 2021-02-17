package web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Recensione;
import persistence.DBManager;

@Controller
public class PageController 
{
	@GetMapping("/Gallery")
	public String gallery(HttpSession session, Model model)
	{
		
		ArrayList<Recensione> rec = DBManager.getInstance().RecensioneDAO().getLastRecensioni();
		session.setAttribute("reviewList", rec);
		
		return "Gallery";
	}
	
	@GetMapping("/Booking")
	public String booking(HttpSession session, Model model)
	{
		return "Booking";
	}
	
	@GetMapping("/Info")
	public String info(HttpSession session, Model model)
	{
		return "Info";
	}
	
	@GetMapping("/")
	public String home(HttpSession session, Model model)
	{
		return "Home";
	}
	
	@GetMapping("/getRecensioni")
	public String getRecensioni(HttpSession session, Model model){
		
		
		
		return "Gallery";
	}
}
