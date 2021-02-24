package web.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import model.Criptazione;
import model.Orario;
import model.Prenotazione;
import model.Recensione;
import model.Trattamento;
import model.Utente;
import persistence.DBManager;

@Controller
public class PageController 
{
	
	private Date ricordaData;
	private Integer ricordaPersone;
	
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
	
	@GetMapping("/Profile")
	public String profile(HttpSession session, Model model)
	{
		Utente ut=(Utente) session.getAttribute("utente");
		String tmp=(String) ut.getEmail();
		ArrayList<Prenotazione> prenotazione = DBManager.getInstance().UtenteDAO().dammiPrenotazioni(tmp);
		session.setAttribute("bookingList", prenotazione);
		ArrayList<Trattamento> trattamento = DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		session.setAttribute("serviceList", trattamento);
		
		HashMap<Date,Integer> listaCount = new HashMap<Date, Integer>();
		listaCount=DBManager.getInstance().PrenotazioneDAO().countDate(tmp);
		session.setAttribute("listaCount", listaCount);
		
		return "Profile";
	}
	
	@GetMapping("/DeleteBooking")
	public String deleteBooking(HttpSession session, Model model,@RequestParam Integer id)
	{
		DBManager.getInstance().PrenotazioneDAO().delete(id);
		Utente ut=(Utente) session.getAttribute("utente");
		String tmp=(String) ut.getEmail();
		ArrayList<Prenotazione> prenotazione = DBManager.getInstance().UtenteDAO().dammiPrenotazioni(tmp);
		session.setAttribute("bookingList", prenotazione);
		ArrayList<Trattamento> trattamento = DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		session.setAttribute("serviceList", trattamento);
		
		HashMap<Date,Integer> listaCount = new HashMap<Date, Integer>();
		listaCount=DBManager.getInstance().PrenotazioneDAO().countDate(tmp);
		session.setAttribute("listaCount", listaCount);
		return "Profile";
	}
	
	@GetMapping("/PrintBooking")
	public String printBooking(HttpSession session, Model model,@RequestParam Date idDataDaStampare, HttpServletResponse response) throws DocumentException, IOException
	{
		
		Utente ut=(Utente) session.getAttribute("utente");
		String tmp=(String) ut.getEmail();
		Document document = new Document();
		String nomeFile= new String (idDataDaStampare+tmp+".pdf");
		
		File targetDir=new File("PdfPrenotazioni");
		File targetFile=new File(targetDir, nomeFile);
		FileOutputStream fos = new FileOutputStream(targetFile);
		
		PdfWriter.getInstance(document, fos);

		document.open();
		
		PdfPTable table = new PdfPTable(3);
		ArrayList<Prenotazione> prenotazione = DBManager.getInstance().UtenteDAO().dammiPrenotazioni(tmp);
		ArrayList<Trattamento> trattamento = DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		
		Font font = FontFactory.getFont(FontFactory.COURIER, 16);
		Paragraph testa = new Paragraph(ut.getNome() + " " +ut.getCognome() + " ha effettuato una prenotazione per il giorno " + idDataDaStampare.toString() + " per i seguenti trattamenti:" , font);
		document.add(testa);
		DottedLineSeparator separator = new DottedLineSeparator();
        separator.setPercentage(59500f / 523f);
        Chunk linebreak = new Chunk(separator);
		document.add(linebreak);
		
		for (int i = 0 ; i<prenotazione.size(); i++) {
				
				if(prenotazione.get(i).getDate().equals(idDataDaStampare))  {
				table.addCell(prenotazione.get(i).getTime().toString());
				table.addCell(prenotazione.get(i).getPersone().toString());
					for(int j=0; j<trattamento.size(); j++){
						if(trattamento.get(j).getId()==prenotazione.get(i).getTrattamento())
						table.addCell(trattamento.get(j).getNome());
				}
			}
		}

		document.add(table);
		document.close();
		
		String name = new String("../" + targetDir.getName() + "/" + targetFile.getName());
		session.setAttribute("pdfprint", name);
		
		
		return "redirect:/Profile";
	}
	
	 @GetMapping("/Treatments")
	 public String getRecensioni(HttpSession session, Model model,@RequestParam String nome,@RequestParam Date data,@RequestParam Integer numeroPersone )
	 {
		ArrayList<Trattamento>listaTrattamenti= new ArrayList<Trattamento>();
		listaTrattamenti=DBManager.getInstance().TrattamentoDAO().listaTrattamenti();
		
		ArrayList<Prenotazione>listaPrenotazioni= new ArrayList<Prenotazione>();
		listaPrenotazioni= DBManager.getInstance().PrenotazioneDAO().prenotazioniData(data);
		
		ricordaData=data;
		ricordaPersone=numeroPersone;
		
		Orario r = new Orario();
		session.setAttribute("listaTrattamenti", listaTrattamenti);
		session.setAttribute("listaPrenotazioni", listaPrenotazioni);
		session.setAttribute("orariDisponibili", r.orari);
		
		return "Treatments";
	 }
	 
	 @PostMapping("/LetReview")
	 public String aggiungiRecensione(@RequestParam Integer id,@RequestParam String descrizione,@RequestParam Date data,@RequestParam String autore, @RequestParam Integer voto )
	 {
			Recensione tmp= new Recensione(id, descrizione, data, autore, voto);
			DBManager.getInstance().RecensioneDAO().save(tmp);
			return "redirect:/Gallery";
	 }
	 
	 
	 
	 //@SuppressWarnings("deprecation")
	 //Temporaneo
	@PostMapping("/confermaPrenotazione")
	 public String confermaprenotazione(HttpSession session, Model model,
			 @RequestParam String trattamento1,
			 @RequestParam String trattamento2,
			 @RequestParam String trattamento3,
			 @RequestParam String trattamento4,
			 @RequestParam String trattamento5,
			 @RequestParam String trattamento6,
			 @RequestParam String trattamento7,
			 @RequestParam String trattamento8,
			 HttpServletRequest richiesta,
			 HttpServletResponse risposta)
	 {		
			ArrayList<Trattamento>list= new ArrayList<Trattamento>();
			
			ArrayList<String>listaTratt=new ArrayList();
			listaTratt.add(trattamento1);
			listaTratt.add(trattamento2);
			listaTratt.add(trattamento3);
			listaTratt.add(trattamento4);
			listaTratt.add(trattamento5);
			listaTratt.add(trattamento6);
			listaTratt.add(trattamento7);
			listaTratt.add(trattamento8);
			
			aggiungiTrattamento(list,listaTratt);
			
			//System.out.println(list);
			String ricordaUtente=(String) session.getAttribute("emailUtente");
			Utente ut=(Utente) session.getAttribute("utente");
			
			//Time time=java.sql.Time.valueOf("String");
			for(int i=0; i<listaTratt.size(); i++)
			{
				if(!listaTratt.get(i).equals("no"))
				{
					Time time=java.sql.Time.valueOf(listaTratt.get(i));
					Integer passa=i+1;
					Prenotazione pr= new Prenotazione(0,ut.getEmail(),time,ricordaData,ricordaPersone,passa);
					DBManager.getInstance().PrenotazioneDAO().save(pr);
				}
			}
			
		 	ricordaData=null;
		 	ricordaPersone=null;
			return "Home";
	 }
	
	public void aggiungiTrattamento(ArrayList<Trattamento>list,ArrayList<String>listaTratt)
	{
		for(int i=1; i<9; i++)
		{
			if(!listaTratt.get(i-1).equals("no"))
			{
				Trattamento tr= new Trattamento();
				tr.setId(i);
				list.add(tr);
			}
		}
	}
	
	
	 @PostMapping("/modificaUtente")
	 public String aggiungiRecensione(@RequestParam String Email,
			 @RequestParam String Password,
			 @RequestParam String Nome,
			 @RequestParam String Cognome,
			 @RequestParam String Telefono,
			 @RequestParam String oldPassword,
			 HttpSession session, Model model)
	 {
		 
		/* Utente daCambiare= DBManager.getInstance().UtenteDAO().login(Email);
		 if(daCambiare.getEmail()!=null)
		 {
			 String pass=Criptazione.getInstance().encrypt(Password);
		 }
		 */
		 Utente ut=(Utente) session.getAttribute("utente");
		 Utente verifica=DBManager.getInstance().UtenteDAO().trovaUtente(ut.getEmail());
		 String pass;
		 if(Password.equals("") || oldPassword.equals(""))
		 {
			 System.out.println("Password nulla");
			 pass=verifica.getPassword();
		 }
		 else
		 {
			Utente daVerificare=DBManager.getInstance().UtenteDAO().login(Email, oldPassword);
			if(daVerificare.getEmail().equals(""))
			{
				 pass=verifica.getPassword();
			}
			else
			{
				pass=Criptazione.getInstance().encrypt(Password);
			}
		 }
		 
		 if(Nome.equals(""))
		 {
			Nome=verifica.getNome();
		 }
		 if(Cognome.equals(""))
		 {
			Cognome=verifica.getCognome();
		 }
		 if(Telefono.equals(""))
		 {
			Telefono=verifica.getNumero();
		 }
		 
		 //System.out.println(pass);
		 Utente daCambiare = new Utente(Email,pass,Nome,Cognome,true,Telefono);
		 //System.out.println("Utente da Cambiare \n"+daCambiare);
		 //session.setAttribute("ut.nome", Nome);
		 //session.setAttribute("ut.cognome", Cognome);
		 session.setAttribute("utente", daCambiare);
		 //session.setAttribute("utente.cognome", Cognome);
		 DBManager.getInstance().UtenteDAO().update(daCambiare);
		 //System.out.println("Utente cambiato");
		 //Allert che non si e cambiato
		 return "Profile";
	 }
	 
	 
}
