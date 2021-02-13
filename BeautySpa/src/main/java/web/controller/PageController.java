package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController 
{
	@GetMapping("/Gallery")
	public String gallery()
	{
		return "Gallery";
	}
	
	@GetMapping("/Booking")
	public String booking()
	{
		return "Booking";
	}
	
	@GetMapping("/Info")
	public String info()
	{
		return "Info";
	}
	
	@GetMapping("/")
	public String home()
	{
		return "Home";
	}
}
