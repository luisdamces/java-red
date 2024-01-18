package org.sfsoft.clientesmtp;

import java.util.Date;
import java.util.Properties;
import java.util.Properties;


import javax.mail.*;
import javax.mail.internet.*;



/**
 * Ejemplo Java que envía un mensaje de correo a un servidor SMTP
 * Se ha empleado la librería JavaMail
 *
 */
public class ClienteSMTP {

	public static void main(String args[]) {
		try
	        {
	            // Propiedades de la conexión
	            Properties props = new Properties();
	            props.setProperty("mail.smtp.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.user", "xxxxxxx@gmail.com");
	            props.setProperty("mail.smtp.auth", "true");
	
	            // Preparamos la sesion
	            Session session = Session.getDefaultInstance(props);
	
	            // Construimos el mensaje
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("yo@yo.com"));
	            message.addRecipient(
	                Message.RecipientType.TO,
	                new InternetAddress("xxxxxxx@gmail.com"));
	            message.setSubject("Hola");
	            message.setText(
	                "Mensajito con Java Mail" + "de los buenos." + "poque si");
	
	            // Lo enviamos.
	            Transport t = session.getTransport("smtp");
	            t.connect("xxxxxx@gmail.com", "");
	            t.sendMessage(message, message.getAllRecipients());
	
	            // Cierre.
	            t.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}
}
