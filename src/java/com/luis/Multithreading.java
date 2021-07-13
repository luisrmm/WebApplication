/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luis;

import java.io.File;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

class Multithreading extends Thread {

    public void cancel() { 
        System.out.println(" ------------------------------------------------------------------------- Cierre de Thread ");
        interrupt(); 
    }
    
    public void run() {
        try {
            // Displaying the thread that is running
            String host = "pop.gmail.com";
            String port = "995";
            String user = "o.cempresa12@gmail.com";
            String password = "empresa123";
            String saveDirectory = "C:/Users\\luisr\\Documents\\NetBeansProjects\\WebApplication2\\Documentos\\XML recibido";

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop.host", host);
            properties.put("mail.pop.port", "995");
            properties.put("mail.pop.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                    + " is running");

            store.connect(host, user, password);
            
            while (true) {
                

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
                    String subject = message.getSubject();
                    System.out.println("Subject: " + subject);
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Text: " + message.getContent().toString());
                    String contentType = message.getContentType();
                    String messageContent = "";

                    // store attachment file name, separated by comma
                    String attachFiles = "";

                    if (contentType.contains("multipart")) {
                        // content may contain attachments
                        Multipart multiPart = (Multipart) message.getContent();
                        int numberOfParts = multiPart.getCount();
                        for (int partCount = 0; partCount < numberOfParts; partCount++) {
                            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                                // this part is attachment
                                String fileName = part.getFileName();
                                attachFiles += fileName + ", ";
                                part.saveFile(saveDirectory + File.separator + "ordencompra.xml");
                            } else {
                                // this part may be the message content
                                messageContent = part.getContent().toString();
                            }
                        }

                        if (attachFiles.length() > 1) {
                            attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                        }
                    } else if (contentType.contains("text/plain")
                            || contentType.contains("text/html")) {
                        Object content = message.getContent();
                        if (content != null) {
                            messageContent = content.toString();
                        }
                    }

                    message.setFlag(Flags.Flag.DELETED, true);
                    System.out.println("Marked DELETE for message: " + subject);

                    // print out details of each message
                    System.out.println("Message #" + (i + 1) + ":");
                    System.out.println("\t Message: " + messageContent);
                    System.out.println("\t Attachments: " + attachFiles);

                }
                emailFolder.close(false);
                store.close();
            }

        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
            System.out.println(e);

        }
    }
}
