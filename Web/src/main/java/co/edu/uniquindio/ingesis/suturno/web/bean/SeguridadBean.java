package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJB;

@ManagedBean
@SessionScoped
public class SeguridadBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9117475224173807416L;
	
	private String usuario;
	private String clave;
	private boolean autenticado = false;
	private Empleado empleado;	
	@EJB
	private EmpleadoEJB empleadoEJB;
	
	
	/**
	 * Comprobar el Acceso a la Aplicacion Administradora
	 * @return ruta de navegacion
	 */
	public String comprobarAcceso(){
		System.out.println("Comprobar para " + usuario + " | " + clave);
		empleado = empleadoEJB.verificarAcceso(usuario, clave);
		if( null != empleado){
			autenticado = true;
			
			FacesMessage mensaje = new FacesMessage("Bienvenido "+empleado.getTercero().getNombre1() );
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
			
			return "index";
		}else{
			FacesMessage mensaje = new FacesMessage("ERROR: Usuario o Clave incorrectos " );
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}
		
		return null;
	
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


	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}


	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
		

}
