package web.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Properties;

@Controller
public class EmailSender {

	@PostMapping("/sendEmail")
    public String sendEmail(HttpSession webSession, @RequestParam String name, @RequestParam String email, @RequestParam String inquiry,
    		@RequestParam String message) {

        final String username = "beautyspaserver@gmail.com";
        final String password = "B34UTY5P4";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message m = new MimeMessage(session);
            m.setFrom(new InternetAddress("beautyspaserver@gmail.com"));
            m.setRecipients(Message.RecipientType.TO, InternetAddress.parse("beautyspaserver@gmail.com"));
            m.setSubject("Nuova domanda da " + email);
            m.setText("Nome mittente: " + name
                    + "\nE-mail mittente: " + email
                    + "\nTipo di domanda: " + inquiry
                    + "\nMessaggio: " + message);

            Transport.send(m);
            
            webSession.setAttribute("messaggio", "E-mail inviata con successo!");	
            
        } catch (MessagingException e) {
            e.printStackTrace();
            webSession.setAttribute("messaggio", "Errore invio e-mail");
        }
        
        return "redirect:/Info";
    }

}
