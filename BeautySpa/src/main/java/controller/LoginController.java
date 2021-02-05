package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{
	@PostMapping("doLogin")
	public String login(HttpSession session,@RequestParam String email,@RequestParam String password)
	{
		System.out.println(email);
		System.out.println(password);
		
		
		if(loginOk(email,password))
		{
			session.setAttribute("usernameLogged", email);//In questo modo ricordo in sessione che username e loggato
			//return "loginSuccess";
			return "index";
		}
		else
		{
			return "loginError";
		}
	}
	
	
	@GetMapping("doLogout")
	public String logout(HttpSession session)
	{
		session.invalidate();//svoto la sessione
		return "index";
		//return "logoutSuccess";
	}
	
	private boolean loginOk(String email, String password)
	{
		if(email.equals("admin") && password.equals("admin"))
		{
			return true;
		}
		return false;
	}
}
