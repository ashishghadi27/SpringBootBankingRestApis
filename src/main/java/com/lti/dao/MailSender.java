package com.lti.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	public static boolean sendMail(String message, String email){
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("your mail id","Your password");  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message1 = new MimeMessage(session);    
         message1.addRecipient(Message.RecipientType.TO,new InternetAddress(email)); 
         message1.setFrom(new InternetAddress("rootdevs27"));
         message1.setSubject("Important Mail From your bank ");    
         message1.setText(message);    
         //send message  
         Transport.send(message1);    
         return true;
        } catch (MessagingException e) {
        	return false;
        }
	}
	
}
