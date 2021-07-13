package com.luis;

import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.*;
import java.util.logging.Level;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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
    String directorio;
    String archivo;

    public Email(String host_, String port_,
            final String userName_, final String password_, String toAddress_,
            String subject_, String message_, String directorio_, String archivo_) {

        port = port_;
        host = host_;
        toAddress = toAddress_;
        userName = userName_;
        password = password_;
        subject = subject_;
        message = message_;
        directorio = directorio_;
        archivo = archivo_;
    }

    //Métodos de la clase
    public void enviar() {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            BodyPart texto = new MimeBodyPart();
            texto.setText(message);

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(directorio)));
            adjunto.setFileName(archivo);

            MimeMultipart multiParte = new MimeMultipart();

            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            // creates a new e-mail message
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(userName));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            msg.setSubject(subject);
            msg.setContent(multiParte);

// *** BEGIN CHANGE
// sends the e-mail
            Transport t = session.getTransport("smtp");
            t.connect(userName, password);
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
