package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.negocio.ServiciosEJB;

/**
 * Bean del servicio de la aplicacion suturno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 26/04/2017
 * @version 1.0
 *
 */
@ManagedBean
public class ServicioBean {

	/**
	 * Variable que representa el atributo codigo del servicio
	 */
	private String codigo;
	/**
	 * Variable que representa el atributo nombre del servicio
	 */
	private String nombre;
	/**
	 * Variable que representa el atributo descripcion del servicio
	 */
	private String descripcion;
	/**
	 * Variable que representa el atributo soloLectura para el boton del
	 * servicio
	 */
	private boolean soloLectura = false;
	/**
	 * Variable que representa el atributo de lista de servicios del servicio
	 */
	private List<Servicio> servicios;
	/**
	 * Variable que representa la instancia del EJB del servicio
	 */
	@EJB
	private ServiciosEJB servicioEJB;

	/**
	 * Metodo que inicializa el listado de servicios
	 */
	@PostConstruct
	public void inicializar() {
		// servicios=servicioEJB.listarServicios();
	}

	/**
	 * Registra el servicio utilizando el EJB
	 * 
	 * @return una url de una vista web
	 */
	public String registrar() {
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

			return "listar?faces-redirect=true";

		} catch (Throwable e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getCause().getMessage(),
					e.getCause().getMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);

		return null;
	}

	/**
	 * Busca el servicio por el nombre
	 * 
	 * @return url de la vista web donde aparece los datos del servicio
	 */
	public String buscarXNombre() {
		Servicio existe = servicioEJB.buscarServicioPorNombre(nombre);

		System.out.println("NOMBRE A BUSCAR ?" + nombre);
		System.out.println("Existe Servicio?" + existe);

		if (existe != null) {
			codigo = existe.getCodigo();
			nombre = existe.getNombre();
			descripcion = existe.getDescripcion();
			soloLectura = true;
			return "index";
		} else {
			FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Servicio No encontrado",
					"No se encontro el servicio");
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}

		return null;
	}

	/**
	 * Metodo get del atributo codigo
	 * 
	 * @return codigo el codigo del servicio
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo set del atributo codigo
	 * 
	 * @param codigo
	 *            el codigo del servicio
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo get del atributo nombre
	 * 
	 * @return nombre el nombre del servicio
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set del atributo nombre
	 * 
	 * @param nombre
	 *            el nombre del servicio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get del atributo descripcion
	 * 
	 * @return descripcion la descripcion del servicio
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo set del atributo descripcion
	 * 
	 * @param descripcion
	 *            la descripcion del servicio
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo get del atributo lista de servicios
	 * 
	 * @return servicios la lista de servicios
	 */
	public List<Servicio> getServicios() {
		return servicioEJB.listarServicios();
	}

	/**
	 * Metodo set del atributo lista de servicios
	 * 
	 * @param servicios
	 *            la lista de servicios
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/**
	 * Metodo get del atributo soloLectura
	 * 
	 * @return soloLectura true o false, si permite o no la lectura
	 */
	public boolean isSoloLectura() {
		return soloLectura;
	}

	/**
	 * Metodo set del atributo soloLectura
	 * 
	 * @param soloLectura
	 *            true o false, si permite o no la lectura
	 */
	public void setSoloLectura(boolean soloLectura) {
		this.soloLectura = soloLectura;
	}

}
