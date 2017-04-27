package co.edu.uniquindio.ingesis.suturno.web.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.negocio.ServiciosEJB;

@ManagedBean
public class ServicioBean {

	private String codigo;
	private String nombre;
	private String descripcion;

	@EJB
	private ServiciosEJB servicioEJB;

	public void registrar() {
		FacesMessage mensaje;
		Servicio servicio = new Servicio();
		servicio.setCodigo(codigo);
		servicio.setNombre(nombre);
		servicio.setDescripcion(descripcion);

		try {
			servicioEJB.registrarServicio(servicio);
			mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Registro exitoso Servicio");
			codigo = "";
			nombre = "";
			descripcion = "";

		} catch (Throwable e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getCause().getMessage(),
					e.getCause().getMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
