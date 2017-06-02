package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Bean Manager de Sesion para controlar la internacionalizacion de la aplicacion
 * @author gusta - laura
 * @see https://stackoverflow.com/questions/4830588/localization-in-jsf-how-to-remember-selected-locale-per-session-instead-of-per
 */
@ManagedBean
@SessionScoped
public class IdiomaBean implements Serializable {

	//Variable para el control del idioma
	private Locale localizacion;

	@PostConstruct
	protected void initialize() {
		localizacion = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();

	}

	/**
	 * Metodo que sirve como swith de intercambio entre idioma ingles y espaniol
	 * @return pagina inicio con idioma cambiado
	 */
	public String cambiarIdioma() {

		String idiomaActual = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
		System.out.println("Idioma Actual: " + FacesContext.getCurrentInstance().getViewRoot().getLocale().toString());

		if ("es".equals(idiomaActual)) {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
			FacesContext.getCurrentInstance().getApplication().setDefaultLocale(Locale.ENGLISH);
		} else {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
			FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale("es"));
		}

		localizacion = FacesContext.getCurrentInstance().getViewRoot().getLocale();

		System.out.println(
				"Idioma Cambiado a " + FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage());

		return "inicio";
	}

	/**
	 * @return the localizacion
	 */
	public Locale getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion
	 *            the localizacion to set
	 */
	public void setLocalizacion(Locale localizacion) {
		this.localizacion = localizacion;
	}

}
