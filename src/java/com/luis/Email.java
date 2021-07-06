package com.luis;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.*;
import java.util.logging.Level;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import javax.net.ssl.*;
import javax.swing.JOptionPane;

public class Email {

   String toAddress;
   String userName;
   String password;
   String subject;
   String message;
   String host;
   String port;
    
   public Email(String host_, String port_,
                final String userName_, final String password_, String toAddress_,
                String subject_, String message_){
       
       port = port_;
       host = host_;
       toAddress = toAddress_;
       userName =  userName_;
       password = password_;
       subject = subject_;        
       message = message_;
   }
public void test(){
 
         System.out.println(toAddress);
         System.out.println(userName);
         System.out.println(host);
         System.out.println(port);
         System.out.println(password);
         System.out.println(subject);
         System.out.println(message);
}
    //Métodos de la clase
    public void enviar()
    {
              try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(props);
            
            String correoRemitente = "pruebaluisrm@gmail.com";
            String passwordRemitente = "Kreatormetal123";
            String correoReceptor = "luisrm5142@gmail.com";
            String asunto = "Prueba Correo";
            String mensaje = "Esto es una prueba desde Web desde java";
            
            // creates a new e-mail message
            Message msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress(correoRemitente));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress (correoReceptor));
            msg.setSubject(asunto);
            // set plain text message
            msg.setText(mensaje);
            
// *** BEGIN CHANGE
// sends the e-mail
            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
            t.close();
// *** END CHANGE
        //JOptionPane.showMessageDialog(null, "Correo Enviado");
        } catch (AddressException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    }  
}
