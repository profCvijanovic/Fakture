package bussinesService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Validacija {
	
	
public String konvertujPasswordUSifru(String password) {
		
		try {
			//Kreiraj MessageDigest objekat koji implementira MD5 algoritam
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//Prosledi password kao niz bajtova u MessageDigest objekat
			md.update(password.getBytes());
			
			//Od passworda kreiramo sifrovani password, ali je vracen kao niz bajtova
			byte[] digest = md.digest();
			
			StringBuffer sb = new StringBuffer();
			//Prolazimo kroz niz bajtova i pretvaramo ga u heksadekadni zapis
			for(int i = 0; i<digest.length; i++) {
				sb.append(Integer.toHexString(digest[i] & 0xff));
			}
			return sb.toString();		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

public void sendRegistrationEmail(String fromEmail,String password, String toEmail, String subject, String message) {
	
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "587");
	props.put("mail.smtp.starttls.enable", "true");

	
	Session session = Session.getInstance(props,new MyPasswordAuthenticator(fromEmail, password));
	
	Message mailMessage = new MimeMessage(session);
	
	try {
		mailMessage.setFrom(new InternetAddress(fromEmail));
		mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		mailMessage.setText(message);
		mailMessage.setSubject(subject);
		
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com",fromEmail, password);
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
	}  catch (AddressException e) {
        
        e.printStackTrace();
   } catch (MessagingException e) {
        
        e.printStackTrace();
   }	
}





}
