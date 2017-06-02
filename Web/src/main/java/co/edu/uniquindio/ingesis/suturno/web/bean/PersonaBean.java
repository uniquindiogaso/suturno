package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;
import co.edu.uniquindio.ingesis.suturno.negocio.ClienteEJB;
import co.edu.uniquindio.ingesis.suturno.negocio.GeografiaEJB;
import co.edu.uniquindio.ingesis.suturno.negocio.TurnoEJB;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

/**
 * Bean de la persona de la aplicacion suturno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 06/05/2017
 * @version 1.0
 *
 */
@ManagedBean
@SessionScoped
public class PersonaBean implements Serializable {
	/**
	 * Variable que representa el atributo identificacion de la persona
	 */
	private String identificacion;
	/**
	 * Variable que representa el atributo tipo de documento de la persona
	 */
	private TipoDocumento tDoc;
	/**
	 * Variable que representa el atributo genero de la persona
	 */
	private Genero genero;
	/**
	 * Variable que representa el primer nombre de la persona
	 */
	private String nombre1;
	/**
	 * Variable que representa el atributo del segundo nombre de la persona
	 */
	private String nombre2;
	/**
	 * Varible que representa el atributo del primer apellido de la persona
	 */
	private String apellido1;
	/**
	 * Variable que representa el atributo del segundo apellido de la persona
	 */
	private String apellido2;
	/**
	 * Variable que representa el atributo email de la Persona
	 */
	private String email;
	/**
	 * Variable que representa el atributo del primer telefono de la persona
	 */
	private String tel1;
	/**
	 * Variable que representa el atributo del segundo telefono de la persona
	 */
	private String tel2;

	/**
	 * Variable que represent el atributo de la fecha de nacimiento de la
	 * persona
	 */
	private Date fecha;

	/**
	 * Variable que representa el atributo de la direccion de la persona
	 */
	private String dir;
	/**
	 * Variable que representa el atributo departamento de la persona
	 */
	private Depto dpto;
	/**
	 * Variable que representa el atributo ciudad de la persona
	 */
	private Ciudad ciudad;
	/**
	 * Variable que representa el atributo activo de la persona
	 */
	private boolean activo;

	private Persona cliente;

	private Servicio servicio;

	/**
	 * Permite identificar si el usuario ya tiene un servicio y mostrarle
	 * informacion al respecto
	 */
	private Turno ultimoTurno;

	/**
	 * Puente para acceder a funcionalidades persistencia de Cliente
	 */
	@EJB
	private ClienteEJB clienteEJB;
	/**
	 * Puente para acceder a funcionalidades persistencia de geografia
	 */
	@EJB
	private GeografiaEJB geografiaEJB;

	/**
	 * Puente para acceder a funcionalidades persistencia de Turno
	 */
	@EJB
	private TurnoEJB turnoEJB;

	/**
	 * Lista de Departamentos disponibles
	 */
	private List<Depto> departamentos;
	/**
	 * Lista de Ciudades en funcion del departametno seleccionado
	 */
	private List<Ciudad> ciudades;
	/**
	 * Listado de Turnos
	 */
	private List<Turno> turnos;

	@PostConstruct
	public void inicializar() {
		departamentos = geografiaEJB.listarDepartamentos();
		// turnos = turnoEJB.turnosDeCliente(cliente);
	}

	/**
	 * Metodo constructor del bean de persona
	 */
	public PersonaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permite buscar el cliente por la identificacion
	 * 
	 * @return nulo sin no encuentra el cliente o la direccion del solicitar
	 *         turno si el cliente tiene turnos en espera o la direccion del
	 *         registrar cliente si el cliente no existe
	 */
	public String buscarCliente() {
		String retorno = null;
		FacesMessage mensaje;
		try {
			cliente = clienteEJB.buscarClientePorIdentificacion(identificacion);
			if (cliente != null) {
				mensaje = new FacesMessage("Se encontro cliente");

				// buscar turnos existentes
				ultimoTurno = turnoEJB.turnosPendientesCliente(cliente);

				retorno = "/cliente/solicitarTurno";
			} else {
				mensaje = new FacesMessage("No encontro cliente");
				retorno = "/cliente/registrar";
			}
		} catch (Throwable e) {
			mensaje = new FacesMessage(e.getCause().getMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return retorno;
	}

	/**
	 * Permite registrar el cliente si este no existe
	 * 
	 * @return nulo si no es posible registrarlo o la direccion del solicitar
	 *         turno
	 */
	public String registrarCliente() {
		String retorno = null;
		FacesMessage mensaje;
		cliente = new Persona();
		cliente.setIdentificacion(identificacion);
		cliente.setNombre1(nombre1);
		cliente.setNombre2(nombre2);
		cliente.setApellido1(apellido1);
		cliente.setApellido2(apellido2);
		cliente.setTel1(tel1);
		cliente.setTel2(tel2);
		cliente.setCiudad(ciudad);
		cliente.setDir(dir);
		cliente.setEmail(email);
		cliente.setGenero(genero);
		cliente.settDoc(tDoc);

		try {
			clienteEJB.registrarCliente(cliente);
			mensaje = new FacesMessage("Se registro cliente");
			System.out.println("Se registro");
			retorno = "/cliente/solicitarTurno";

		} catch (Throwable e) {
			e.printStackTrace();
			mensaje = new FacesMessage(e.getCause().getMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return retorno;
	}

	/**
	 * Permite solicitar el turno al cliente
	 * 
	 * @return nulo si no es posible solicitar el turno y la direccion del index
	 *         del cliente
	 */
	public String solicitarTurno() {
		Turno turno = new Turno();
		turno.setCliente(cliente);
		turno.setServicio(servicio);
		String retorno = null;
		FacesMessage mensaje;
		try {
			clienteEJB.solicitarTurno(turno);
			mensaje = new FacesMessage("Se registro turno");
			retorno = "/cliente/index";
		} catch (Throwable e) {
			mensaje = new FacesMessage(e.getCause().getMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return retorno;
	}

	/**
	 * public String verTurnoCliente() { List<Turno> turno = turnos;
	 * FacesMessage mensaje; String retorno = null; if (turnos == null) {
	 * mensaje = new FacesMessage("No posee ningún turno."); } else { retorno =
	 * "/cliente/verTurno"; } return retorno;
	 * 
	 * }
	 */

	/**
	 * Metodo get del atributo identificacion
	 * 
	 * @return identificacion la identificacion de la persona
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Metodo set del atributo identificacion
	 * 
	 * @param identificacion
	 *            la identificacion de la persona
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * Metodo get del array de tipos de documentos
	 * 
	 * @return array con los tipos de documentos
	 */
	public TipoDocumento[] gettdocs() {
		return TipoDocumento.values();
	}

	/**
	 * Metodo get del atributo tipo de documento
	 * 
	 * @return tDoc la enumeracion tipo de documento de la persona
	 */
	public TipoDocumento gettDoc() {
		return tDoc;
	}

	/**
	 * Metodo set del atributo del tipo de documento
	 * 
	 * @param tDoc
	 *            la enumeracion del tipo de cliente de la persona
	 */
	public void settDoc(TipoDocumento tDoc) {
		this.tDoc = tDoc;
	}

	/**
	 * Metodo get del atributo genero
	 * 
	 * @return genero la enumeracion genero de la persona
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Metodo get del array de tipos de generos
	 * 
	 * @return array con los tipos de documentos
	 */
	public Genero[] getGeneros() {
		return Genero.values();
	}

	/**
	 * Metodo set del atributo genero
	 * 
	 * @param genero
	 *            la enumeracion genero de la persona
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Metodo get del atributo primer nombre
	 * 
	 * @return nombre1 el primer nombre de la persona
	 */
	public String getNombre1() {
		return nombre1;
	}

	/**
	 * Metodo set del atributo primer nombre
	 * 
	 * @param nombre1
	 *            el primer nombre de la persona
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	/**
	 * Metodo get del atributo segundo nombre
	 * 
	 * @return nombre2 el segundo nombre de la persona
	 */
	public String getNombre2() {
		return nombre2;
	}

	/**
	 * Metodo set del atributo segundo nombre
	 * 
	 * @param nombre2
	 *            el segundo nombre de la persona
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	/**
	 * Metodo get del atributo del primer apellido
	 * 
	 * @return apellido1 el primer apellido de la persona
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Metodo set del atributo del primer apellido
	 * 
	 * @param apellido1
	 *            el primer apellido de la persona
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Metodo get del atributo segundo apellido
	 * 
	 * @return apellido2 el segundo apellido de la persona
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Metodo set del atributo segundo apellido
	 * 
	 * @param apellido2
	 *            el segundo apellido de la persona
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Metodo get del atributo primer telefono
	 * 
	 * @return tel1 el primer telefono de la persona
	 */
	public String getTel1() {
		return tel1;
	}

	/**
	 * Metodo set del atributo primer telefono
	 * 
	 * @param tel1
	 *            el primer telefono de la persona
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	/**
	 * Metodo get del atributo segundo telefono
	 * 
	 * @return tel2 el segundo telefono de la persona
	 */
	public String getTel2() {
		return tel2;
	}

	/**
	 * Metodo set del atributo segundo telefono
	 * 
	 * @param tel2
	 *            el segundo telefono de la persona
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	/**
	 * Metodo get del atributo direccion
	 * 
	 * @return dir la direccion de la persona
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * Metodo set del atributo direccion
	 * 
	 * @param dir
	 *            la direccion de la persona
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * Metodo get del atributo departamento
	 * 
	 * @return dpto el departamento de la persona
	 */
	public Depto getDpto() {
		return dpto;
	}

	/**
	 * Metodo set del atributo departamento
	 * 
	 * @param dpto
	 *            el departamento de la persona
	 */
	public void setDpto(Depto dpto) {
		this.dpto = dpto;
	}

	/**
	 * Metodo get del atributo ciudad
	 * 
	 * @return ciudad la ciudad de la persona
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * Metodo set del atributo ciudad
	 * 
	 * @param ciudad
	 *            la ciudad de la persona
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Metodo get del atributo activo
	 * 
	 * @return activo true o false si la persona esta activa
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Metodo set del atributo activo
	 * 
	 * @param activo
	 *            true o false si la persona esta activa
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Metodo get de la fecha de nacimiento
	 * 
	 * @return fecha la fecha de nacimiento de la persona
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo set de la fecha de nacimiento
	 * 
	 * @param fecha
	 *            la fecha de nacimiento de la persona
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * @return the cliente
	 */
	public Persona getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	/**
	 * @return the departamentos
	 */
	public List<Depto> getDepartamentos() {
		return departamentos;
	}

	/**
	 * @param departamentos the departamentos to set
	 */
	public void setDepartamentos(List<Depto> departamentos) {
		this.departamentos = departamentos;
	}

	/**
	 * @return the ciudades
	 */
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	/**
	 * @param ciudades the ciudades to set
	 */
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	/**
	 * @return the turnos
	 */
	public List<Turno> getTurnos() {
		return turnos;
	}

	/**
	 * @param turnos the turnos to set
	 */
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	/**
	 * @return the ultimoTurno
	 */
	public Turno getUltimoTurno() {
		return ultimoTurno;
	}

	/**
	 * @param ultimoTurno
	 *            the ultimoTurno to set
	 */
	public void setUltimoTurno(Turno ultimoTurno) {
		this.ultimoTurno = ultimoTurno;
	}

}