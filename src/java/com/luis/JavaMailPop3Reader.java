/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

public class JavaMailPop3Reader {
    
//    
//   String host;    
//   String userName;
//   String password;
//    
//   public JavaMailPop3Reader(String host_, final String userName_, final String password_){
//       
//       host = host_;
//       userName =  userName_;
//       password = password_;
//   }

  public void getInbox() 
  {
      

         try {

         String host = "pop.gmail.com";
         String port = "995";
         String user = "o.cempresa12@gmail.com";
         String password = "empresa123";
         
             
             
      //create properties field
      Properties properties = new Properties();

      properties.put("mail.pop.host", host);
      properties.put("mail.pop.port", "995");
      properties.put("mail.pop.starttls.enable", "true");
      Session emailSession = Session.getDefaultInstance(properties);
  
      //create the POP3 store object and connect with the pop server
      Store store = emailSession.getStore("pop3s");

      store.connect(host, user, password);

      //create the folder object and open it
      Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_ONLY);

      // retrieve the messages from the folder in an array and print it
      Message[] messages = emailFolder.getMessages();
      System.out.println("messages.length---" + messages.length);

      for (int i = 0, n = messages.length; i < n; i++) {
         Message message = messages[i];
         System.out.println("---------------------------------");
         System.out.println("Email Number " + (i + 1));
         System.out.println("Subject: " + message.getSubject());
         System.out.println("From: " + message.getFrom()[0]);
         System.out.println("Text: " + message.getContent().toString());

      }

      //close the store and folder objects
      emailFolder.close(false);
      store.close();

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
  }
}