/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mailApp;

/*
import java.util.Properties; 
import javax.mail.Session ; 
import javax.mail.Authenticator; 
import javax.mail.PasswordAuthentication; 
import javax.mail.Message;
import javax.mail.internet.MimeMessage; 
//import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
import javax.mail.Transport; 
import javax.mail.MessagingException; 
import javax.mail.internet.InternetAddress;
import java.util.List; 



public class MailApp {

   
    public static void SendMail(String[] args) {
        // TODO code application logic here
        Properties props=new Properties(); 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        String emailCentre="xxxxx@gmail.com";
        String  mdpCentre="xxxxxxxxxxxx";
        List<String> recepient;
        
         Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailCentre, mdpCentre);
            }
        });
         Message emailMessage=prepareMessage(session,emailCentre ,recepient); }
         
         private static Message prepareMessage( Session session , String emailCentre , List<String> recepient){
             
             try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(emailCentre));
        
           emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
            emailMessage.setSubject("fisrt java mail");
            emailMessage.setText("Hello  there , look my email ");

            Transport.send(emailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
         
         
         
         
    
}
*/


/*

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import java.util.List;

public class MailApp {

    public static void SendMail(String[] args) {
        // Configuration du serveur SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        String emailCentre = "xxxxx@gmail.com";
        String mdpCentre = "xxxxxxxxxxxx";

        // Liste des destinataires (remplacez ceci par une vraie liste d'adresses email)
        List<String> recepient = List.of("recipient1@example.com", "recipient2@example.com");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailCentre, mdpCentre);
            }
        });

        prepareAndSendEmail(session, emailCentre, recepient);
    }

    private static void prepareAndSendEmail(Session session, String emailCentre, List<String> recipients) {
        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(emailCentre));

            for (String recipient : recipients) {
                emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }

            emailMessage.setSubject("First Java Mail");
            emailMessage.setText("Hello there, look at my email.");

            Transport.send(emailMessage);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
*/

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

public class MailApp {

    public static void sendMail(List<String> recipients) {
        // SMTP server configuration
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        String emailCentre = "centredonsang@gmail.com";
        String mdpCentre = "14400998";

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("centredonsang@gmail.com", "vtyo edsh ezkc xgjj");
            }
        });

        Message emailMessage = prepareAndSendEmail(session, emailCentre, recipients);
        try {
            Transport.send(emailMessage);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            Logger.getLogger(MailApp.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Prepare and send email
    private static Message prepareAndSendEmail(Session session, String emailCentre, List<String> recipients) {
        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(emailCentre));

            for (String recipient : recipients) {
                emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }

            emailMessage.setSubject("Your Blood Donation Can Save Lives!");
            emailMessage.setText("""
                                 We hope this message finds you well. At [Your Blood Donation Center], we are reaching out to you with an important request that could make a significant impact on the lives of those in need.
                                 
                                 Our blood bank is currently facing a shortage, and we are in desperate need of donors like you to come forward and donate blood. Your generous contribution can be a lifeline for patients undergoing surgeries, trauma victims, and individuals with chronic illnesses.
                                 """);

            return emailMessage;
        } catch (MessagingException e) {
            Logger.getLogger(MailApp.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}

