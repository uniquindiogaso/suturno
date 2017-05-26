package co.edu.uniquindio.ingesis.suturno.web.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;

public class ControladorEmail {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	public static void enviarRecordatorioClave(Empleado e) {

		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("gustavo2840@gmail.com"));
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("laurajrua@gmail.com"));
			generateMailMessage.setSubject("[SUTURNO] - Recordatorio de Contraseña");
			String emailBody = "Test email by Crunchify.com JavaMail API example. "
					+ "<br><br> Regards, <br>Crunchify Admin";
			generateMailMessage.setContent(emailBody, "text/html");

			Transport transport = getMailSession.getTransport("smtp");

			transport.connect("smtp.gmail.com", "suturnouniquindio@gmail.com", "tarea2017");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();

		} catch (MessagingException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		}

	}

}
