package vn.iostar.utils;

//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import vn.iostar.models.UserModels;

public class Email {

	public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999); // Random number up to 6 digits
        return String.format("%06d", number); // Format number as 6 digits
    }
	
	public boolean sendEmail(UserModels user) {
	    boolean test = false;

	    String toEmail = user.getEmail(); // User's email
	    String fromEmail = "mitieutram@gmail.com"; // Sender's email
	    String password = "123456"; // Sender's email password

	    try {
	        // Configure SMTP server details
	        Properties pr = configEmail(new Properties());

	        // Get session to authenticate the host email address and password
	        Session session = Session.getInstance(pr, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	            
	        	});
	        // set email mess detail
	        Message mess = new MimeMessage(session);
	        mess.setHeader("Context-Type", "text/plain; charset=UTF-8");
	        // set from email add
	        mess.setFrom(new InternetAddress(fromEmail));
	        mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
	        
	        // set email subjet
	        mess.setSubject("Confirm code");
	        //email text
	        mess.setText("Password: " + user.getCode());
	        // send the mess
	        Transport.send(mess);
	        
	        test = true;
	    	}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		return test;
	    
	}
	
	//cuoi
	public Properties configEmail(Properties pr)
	{
		//ur host email server detail
		
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.port", "587");
		pr.setProperty("mail.smtp.auth", "true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.socketFactoty.port", "587");
		pr.put("mail.smtp.socketFactoty.class", "javax.net.ssl.SSLSocketFactory");
		
		return pr;
	}
}
