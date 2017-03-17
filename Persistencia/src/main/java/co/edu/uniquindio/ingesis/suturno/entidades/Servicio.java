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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entidad Servicio
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
@Table(name = "suturno_servicio")
@NamedQueries({ @NamedQuery(name = Servicio.GET_ALL, query = "SELECT s FROM Servicio s"),
		@NamedQuery(name = Servicio.GET_SERVICIO_ACTIVOS, query = "SELECT s FROM Servicio s WHERE s.activo=true") })
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constante que identifica la consulta que obtener todos los registros del
	 * servicio {@link Servicio} <br />
	 */
	public static final String GET_ALL = "Servicio_findAll";

	/**
	 * Constante que identifica la consulta que obtener todos los servicios
	 * activos {@link Servicio} <br />
	 */
	public static final String GET_SERVICIO_ACTIVOS = "Servicio_findByActivo";

	/**
	 * Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * Variable que representa el atributo codigo del servicio
	 */
	@NotNull(message = "El Codigo del Servicio debe de ser obligatorio")
	@Size(max = 10, message = "El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false, length = 10)
	private String codigo;

	/**
	 * Variable que representa el atributo nombre del servicio
	 */
	@Column(nullable = false, length = 50)
	@NotNull(message = "El nombre del Servicio debe de ser obligatorio")
	private String nombre;

	/**
	 * Variable que representa el atributo descripcion del servicio
	 */
	@Column(nullable = false)
	private String descripcion;

	/**
	 * Variable que representa el atributo activo del servicio
	 */
	@Column()
	private boolean activo;

	/**
	 * Variable que representa el atributo empleados que pertenecen al servicio
	 */
	@ManyToMany(mappedBy = "servicios")
	private List<Empleado> empleados;

	/**
	 * Variable que representa el atributo turnos que pertenecen al servicio
	 */
	@OneToMany(mappedBy = "servicio")
	private List<Turno> turnos;

	/**
	 * Metodo constructor de la entidad Servicio
	 */
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor de la entidad Servicio
	 * 
	 * @param codigo
	 *            el codigo del servicio
	 * @param nombre
	 *            el nombre del servicio
	 * @param descripcion
	 *            la descripción del servicio
	 * @param activo
	 *            true si el servicio está activo o false si el servicio está
	 *            inactivo
	 */
	public Servicio(String codigo, String nombre, String descripcion, boolean activo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad Servicio
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que permite asignar un valor al atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad Servicio
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo codigo
	 * 
	 * @return codigo el codigo del servicio
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo codigo
	 * 
	 * @param codigo
	 *            el codigo del servicio
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre
	 * 
	 * @return nombre el nombre del servicio
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            el nombre del servicio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo descripcion
	 * 
	 * @return descripcion la descripción del servicio
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo que permite asignar un valor al atributo descripcion
	 * 
	 * @param descripcion
	 *            la descripción del servicio
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo que permite obtener el valor del atributo activo
	 * 
	 * @return activo true si el servicio está activo o false si el servicio
	 *         está inactivo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo activo
	 * 
	 * @param activo
	 *            true si el servicio está activo o false si el servicio está
	 *            inactivo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo empleados
	 * 
	 * @return empleados lista de empleados que pertenece al servicio
	 */
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	/**
	 * Metodo que permite asignar un valor al atributo empleados
	 * 
	 * @param empleados
	 *            lista de empleados que pertenece al servicio
	 */
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	/**
	 * Metodo que permite obtener el valor del atributo turnos
	 * 
	 * @return turnos lista de turnos que pertenece el servicio
	 */
	public List<Turno> getTurnos() {
		return turnos;
	}

	/**
	 * Metodo que permite asignar un valor al atributo turnos
	 * 
	 * @param turnos
	 *            lista de turnos que pertenece el servicio
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
		Servicio other = (Servicio) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
