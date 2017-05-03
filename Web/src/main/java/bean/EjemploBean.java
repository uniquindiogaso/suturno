package bean;

import javax.faces.bean.ManagedBean;

/**
 * Bean de ejemplo
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @since 26/04/2017
 * @version 1.0
 *
 */
@ManagedBean
public class EjemploBean {

	/**
	 * Variable que representa el atributo1
	 */
	private String atributo1;
	/**
	 * Variable que representa el atributo2
	 */
	private String atributo2;

	/**
	 * Metodo constructor de Ejemplo Bean
	 */
	public EjemploBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permite cambiar el atributo 1 por el atributo 2
	 */
	public void cambiar() {
		String aux = atributo1;
		atributo1 = atributo2;
		atributo2 = aux;
	}

	/**
	 * Metodo get del atributo1
	 * 
	 * @return atributo1 de tipo String
	 */
	public String getAtributo1() {
		return atributo1;
	}

	/**
	 * Metodo set del atributo1
	 * 
	 * @param atributo1
	 *            el atributo 1 de tipo String
	 */
	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	/**
	 * Metodo get del atributo2
	 * 
	 * @return atributo2 de tipo String
	 */
	public String getAtributo2() {
		return atributo2;
	}

	/**
	 * Metodo set del atributo2
	 * 
	 * @param atributo2
	 *            el atributo 2 de tipo String
	 */
	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

}
