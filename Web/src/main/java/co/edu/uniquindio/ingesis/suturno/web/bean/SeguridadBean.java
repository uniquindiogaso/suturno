package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJB;

/**
 * Bean de sesion para el control de autenticacion  de la aplicacion suturno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 06/05/2017
 * @version 1.0
 *
 */

@ManagedBean(name = "seguridadBean")
@SessionScoped
public class SeguridadBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9117475224173807416L;
	
	/**
	 * Atributo de control de nombre de usuario
	 */
	private String usuario;
	/**
	 * Atributoi de control de contraseña de acceso
	 */
	private String clave;
	/**
	 * Flag de verificacion de autenticado
	 */
	private boolean autenticado = false;
	/**
	 * Usuario del Sistema Autenticado ( Empleado)
	 */
	private Empleado empleado;	
	/**
	 * Puente para verificacion de datos en BD
	 */
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
	
	/**
	 * Metodo para la actualizacion de informacion en base de datos
	 * del Usuario autenticado permitiendo cambiar sus datos principales
	 */
	public void actualizarInformacion(){
		System.out.println("Seguridad Actualizar Informacion ..." + empleado.getClave());	
		System.out.println(empleado.getTercero().getNombre1());
		System.out.println(empleado.getTercero().getNombre2());
		empleadoEJB.actualizarEmpleado(empleado);
		FacesMessage mensaje = new FacesMessage("Informacion Actualizada Correctamente");
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the autenticado
	 */
	public boolean isAutenticado() {
		return autenticado;
	}

	/**
	 * @param autenticado the autenticado to set
	 */
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
