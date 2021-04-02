/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mailer;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author USUARIO
 */
public class Mailer {
     public static void content(String nombre, String correo, String descripcion) throws UnsupportedEncodingException, MessagingException{
        
        final String user = "jssgtitan*****@gmail.com";
        final String pass = "Asw******";
        
        Properties propertie = new Properties();
        propertie.setProperty("mail.smtp.host", "smtp.gmail.com");
        propertie.setProperty("mail.smtp.starttls.enable", "true");
        propertie.setProperty("mail.smtp.port", "587");
        propertie.setProperty("mail.smtp.starttls.required", "flase");
        propertie.setProperty("mail.smtp.auth", "true");
        propertie.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session;
        session = Session.getInstance(propertie, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pass);
            }
        });
        
        try{
        BodyPart texto = new MimeBodyPart();
            texto.setContent(descripcion, "text/html");
        MimeMultipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
        MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user, "Casa Banquetes y Eventos SION"));
            
            InternetAddress destinatario = new InternetAddress(correo);//casadebanquetesyeventossion@gmail.com
            
       message.setRecipient(Message.RecipientType.TO,destinatario);
       message.setSubject("Información detallada");
       message.setContent(multiparte, "text/html; charset = utf-8");
       
       
            Transport.send(message);
       
        System.out.println("Done");
            
    }   catch (MessagingException me) {
            throw new RuntimeException(me);
        }
    } 
}
