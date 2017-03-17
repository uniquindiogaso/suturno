package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entidad Empleado
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 1/03/2017
 */
@Entity
@NamedQueries({ @NamedQuery(name = Empleado.GET_ALL, query = "SELECT e FROM Empleado e"),
		@NamedQuery(name = Empleado.AUTENTICAR, query = "SELECT e FROM Empleado e WHERE	e.usuario=:usuario AND e.clave=:clave"),
		@NamedQuery(name = Empleado.GET_EMPLEADO_PUESTO, query = "SELECT e.puesto FROM Empleado e WHERE e.id=:empleadoId") })

@Table(name = "suturno_empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constante que identifica la consulta que permite comprobrar credenciales
	 * de acceso de {@link Empleado} <br />
	 */
	public static final String AUTENTICAR = "Empleado_findbyUsuarioAndClave";

	/**
	 * Constante que identifica la consulta que obtener todos los registros del
	 * empleado {@link Empleado} <br />
	 */
	public static final String GET_ALL = "Empleado_findAll";

	/**
	 * Constante que identifica la consulta que obtiene el puesto al que
	 * pertenece el empleado {@link Empleado} <br />
	 */
	public static final String GET_EMPLEADO_PUESTO = "Empleado_findByPuesto";

	/**
	 * /** Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * Variable que representa el atributo persona de la entidad Empleado
	 */
	@NotNull(message = "El tercero debe de ser obligatorio")
	@OneToOne(mappedBy = "empleado")
	private Persona tercero;

	/**
	 * Variable que representa el atributo usuario de la entidad Empleado
	 */
	@NotNull(message = "El usuario debe de ser obligatorio")
	@Column(nullable = false, length = 50, unique = true)
	private String usuario;

	/**
	 * Variable que representa el atributo clave de la entidad Empleado
	 */
	@NotNull(message = "La clave debe de ser obligatoria")
	@Column(nullable = false, length = 50)
	private String clave;

	/**
	 * Variable que representa el atributo administrador de la entidad Empleado
	 */
	@Column
	private boolean admin;

	/**
	 * Variable que representa el atributo puesto de trabajo de la entidad
	 * Empleado
	 */
	@OneToOne
	private PuestoTrabajo puesto;

	/**
	 * Variable que representa el atributo lista de servicios de la entidad
	 * Empleado
	 */
	@ManyToMany
	private List<Servicio> servicios;

	/**
	 * Variable que representa el atributo lista de turnos de la entidad
	 * Empleado
	 */
	@OneToMany(mappedBy = "empleado")
	private List<Turno> turnos;

	/**
	 * Metodo constructor de la entidad Empleado
	 */
	public Empleado() {
		super();
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad Empleado
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que permite asignar un valor al atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad Empleado
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo tercero
	 * 
	 * @return tercero la persona la cual es un Empleado
	 */
	public Persona getTercero() {
		return tercero;
	}

	/**
	 * Metodo que permite asignar un valor al atributo tercero
	 * 
	 * @param tercero
	 *            la persona la cual es un Empleado
	 */
	public void setTercero(Persona tercero) {
		this.tercero = tercero;
	}

	/**
	 * Metodo que permite obtener el valor del atributo usuario
	 * 
	 * @return usuario el usuario para ingresar al sistema como Empleado
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Metodo que permite asignar un valor al atributo usuario
	 * 
	 * @param usuario
	 *            el usuario para ingresar al sistema como Empleado
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que permite obtener el valor del atributo clave
	 * 
	 * @return clave la contraseña para ingresar como Empleado
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Metodo que permite asignar un valor al atributo clave
	 * 
	 * @param clave
	 *            la contraseña para ingresar como Empleado
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Metodo que permite obtener el valor del atributo admin
	 * 
	 * @return admin true si el empleado en adminitrador o falso si el empleado
	 *         no es administrador
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Metodo que permite asignar un valor al atributo admin
	 * 
	 * @param admin
	 *            true si el empleado en adminitrador o falso si el empleado no
	 *            es administrador
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * Metodo que permite obtener el valor del atributo servicios
	 * 
	 * @return servicios la lista de los servicios que tiene el empleado
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * Metodo que permite asignar un valor al atributo servicios
	 * 
	 * @param servicios
	 *            la lista de los servicios que tiene el empleado
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	/**
	 * Metodo que permite obtener el valor del atributo puesto
	 * 
	 * @return puesto el puesto de trabajo que tiene el empleado
	 */
	public PuestoTrabajo getPuesto() {
		return puesto;
	}

	/**
	 * Metodo que permite asignar un valor al atributo puesto
	 * 
	 * @param puesto
	 *            el puesto de trabajo que tiene el empleado
	 */
	public void setPuesto(PuestoTrabajo puesto) {
		this.puesto = puesto;
	}

	/**
	 * Metodo que permite obtener el valor del atributo turnos
	 * 
	 * @return turnos los turnos que tiene que atender el empleado
	 */
	public List<Turno> getTurnos() {
		return turnos;
	}

	/**
	 * Metodo que permite asignar un valor al atributo turnos
	 * 
	 * @param turnos
	 *            los turnos que tiene que atender el empleado
	 */
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	/*
	 * Metodo sobreescrito de hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * Metodo sobreescrito de equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
