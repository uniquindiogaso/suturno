package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class IdiomaBean {

	public String cambiarIdioma(){
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);

		FacesContext.getCurrentInstance().getApplication().setDefaultLocale(Locale.ENGLISH);
		return null;
	}
}
