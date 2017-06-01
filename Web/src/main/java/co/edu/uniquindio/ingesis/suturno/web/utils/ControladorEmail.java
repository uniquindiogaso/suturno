package co.edu.uniquindio.ingesis.suturno.web.utils;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedProperty;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import jsf.template.bean.UserSettings;

public class ControladorEmail {

	private static Properties mailServerProperties;
	private static Session getMailSession;
	private static MimeMessage generateMailMessage;
	
	@ManagedProperty(value="#{userSettings.locate}")
	private static Locale localizacion;

	/**
	 * Enviar una notificacion via correo electronico
	 * 
	 * @param e Usuario al que se le enviara la notificacion
	 */
	public static void enviarRecordatorioClave(Empleado e) {	
		ResourceBundle rb = ResourceBundle.getBundle("messages");
		
		System.out.println("Saludo " + rb.getString("emailclave.titulo"));
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(e.getTercero().getEmail()));
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("gustavo2840@gmail.com"));
			generateMailMessage.setSubject(rb.getString("emailclave.titulo"));
			String emailBody = rb.getString("emailclave.saludo") + e.getTercero().getNombreCompleto() + rb.getString("emailclave.msj1") + e.getClave() + rb.getString("emailclave.msj2") 
					+ rb.getString("emailclave.adios");
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

	/**
	 * @return the localizacion
	 */
	public static Locale getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public static void setLocalizacion(Locale localizacion) {
		ControladorEmail.localizacion = localizacion;
	}
	
	

}
