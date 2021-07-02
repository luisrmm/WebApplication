package com.luis;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import org.apache.log4j.Logger;


public class Email {

   String to;
   String from;
   String host;
    
   public Email(String to_, String from_, String host_){
       to = to_;
       from =  from_;
       host = host_;
   }
public void test(){
     Logger log = Logger.getLogger("Logger de Ejemplo");
         log.trace("un melnsaje");
         log.debug("un meknsaje");
         log.info("un mensuuaje");
}
    //Métodos de la clase
    public void enviar()
    {
        //Email e = new Email("jcnv21@gmail.com","luisrm5142@gmail.com", "localhost")
        // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         Logger log = Logger.getLogger("Logger de Ejemplo");
         log.trace("un melnsaje");
         log.debug("un meknsaje");
         log.info("un mensuuaje");
         log.warn("un men99saje");
         log.error("un men00saje");
         log.fatal("un mensaje");
         
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }
    
}
