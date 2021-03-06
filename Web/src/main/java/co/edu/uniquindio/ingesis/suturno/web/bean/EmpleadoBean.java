package co.edu.uniquindio.ingesis.suturno.web.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJB;
import co.edu.uniquindio.ingesis.suturno.web.utils.ControladorEmail;

/**
 * Bean Manager de Empleado - Usando para la comunicacion entre la Vista y el Backend
 * 
 * @author gusta - laura
 *
 */
@ManagedBean
public class EmpleadoBean {
	
	//Puente para la conexion con la Base de datos
	@EJB
	private EmpleadoEJB empleadoEJB;
	
	private String nombreUsuario;

	public EmpleadoBean() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Dispara recurso que verifica si el empleado existe para enviar un 
	 * mail con los datos de acceso.
	 * @param actionEvent
	 */
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



	
	
     
	
	

	
	

}
