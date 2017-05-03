
package bean;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;

/**
 * Hola mundo Bean
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @since 26/04/2017
 * @version 1.0
 *
 */
@ManagedBean
public class HolaMundoBean {

	/**
	 * Metodo constructor del HolaMundoBean
	 */
	public HolaMundoBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo get del mensaje
	 * 
	 * @return mensaje tipo String a mostrar
	 */
	public String getMensaje() {
		return "a las 11:51 PM!";
	}
	
	public String getMensaje1(){		
		ResourceBundle rb = ResourceBundle.getBundle("resources/mensajes");		
		return rb.getString("saludouq");
	}

}
