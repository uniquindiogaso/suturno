package bean;

import javax.faces.bean.ManagedBean;
/**
 * Bean de ejemplo
 * @author Gustavo Salgado, Laura Rua
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

	public EjemploBean() {
		// TODO Auto-generated constructor stub
	}

	public void cambiar() {
		String aux = atributo1;
		atributo1 = atributo2;
		atributo2 = aux;
	}

	/**
	 * @return the atributo1
	 */
	public String getAtributo1() {
		return atributo1;
	}

	/**
	 * @param atributo1
	 *            the atributo1 to set
	 */
	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}

	/**
	 * @return the atributo2
	 */
	public String getAtributo2() {
		return atributo2;
	}

	/**
	 * @param atributo2
	 *            the atributo2 to set
	 */
	public void setAtributo2(String atributo2) {
		this.atributo2 = atributo2;
	}

}
