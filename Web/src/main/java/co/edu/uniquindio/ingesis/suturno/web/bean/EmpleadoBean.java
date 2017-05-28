package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJB;
import co.edu.uniquindio.ingesis.suturno.web.utils.ControladorEmail;

@ManagedBean
public class EmpleadoBean {
	
	@EJB
	private EmpleadoEJB empleadoEJB;
	
	private String nombreUsuario;
	private String clave;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String email;
	private String tel1;
	private String tel2;


	public EmpleadoBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void recuperarClave(ActionEvent actionEvent){
		Empleado e = empleadoEJB.buscarEmpleadoPorNombreUsuario(nombreUsuario);
		if ( null != e){
			ControladorEmail.enviarRecordatorioClave(e);
			FacesMessage mensaje = new FacesMessage("Contraseña Enviada al Correo Electronico");
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
			nombreUsuario = null;
		}else{
			FacesMessage mensaje = new FacesMessage("Usuario no encontrado");
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
			nombreUsuario = null;
		}		
	}
	
	
	public void actualizarInformacion(ActionEvent actionEvent){
		System.out.println("Actualizar Informacion ...");
	}

     
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	 * @return the nombre1
	 */
	public String getNombre1() {
		return nombre1;
	}


	/**
	 * @param nombre1 the nombre1 to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}


	/**
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}


	/**
	 * @param nombre2 the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}


	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}


	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}


	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the tel1
	 */
	public String getTel1() {
		return tel1;
	}


	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}


	/**
	 * @return the tel2
	 */
	public String getTel2() {
		return tel2;
	}


	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	
	

	

	
	

}
