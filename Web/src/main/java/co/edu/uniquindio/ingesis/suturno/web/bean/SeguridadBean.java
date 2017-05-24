package co.edu.uniquindio.ingesis.suturno.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SeguridadBean {
	
	private String usuario;
	private String clave;
	private boolean autenticado = false;
	
	
	public String comprobarAcceso(){
		autenticado = true;
		return "index";
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
		

}
