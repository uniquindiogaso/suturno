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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entidad TipoCliente
 * 
 * @author Gustavo Salgado y Laura Julieth R�a
 * 
 * @author Ingenier�a de Sistemas y Computaci�n
 * 
 * @author Universidad del Quind�o
 * 
 * @version 1.0
 * 
 * @since 1/03/2017
 */
@Entity
@NamedQueries({ @NamedQuery(name = TipoCliente.GET_ALL, query = "SELECT tCli FROM TipoCliente tCli"),
		@NamedQuery(name = TipoCliente.GET_X_NOMBRE, query = "SELECT tp FROM TipoCliente tp WHERE tp.nombre= :tipoCliente"),
		@NamedQuery(name = TipoCliente.GET_PRIORIDAD, query = "SELECT tCli FROM TipoCliente tCli WHERE tCli.prioridad = True") })
@Table(name = "suturno_tipocliente")
public class TipoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constante que identifica la consulta que obtiene todos los registros del
	 * tipo de cliente {@link TipoCliente} <br />
	 */
	public static final String GET_ALL = "TipoCliente_findAll";


	/**
	 * Constante que identifica la consulta que obtener todos los registros que
	 * tengan establecidad una prioridad {@link TipoCliente} <br />
	 */
	public static final String GET_PRIORIDAD = "TipoCliente_findByPrioridad";
	
	
	/**
	 * Constante que identifica la consulta que obtener todos los registros que
	 * tengan el nombre consultado {@link TipoCliente} <br />
	 */
	public static final String GET_X_NOMBRE = "TipoCliente_findByNombre";

	/**
	 * Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Variable que representa el atributo codigo del tipo de cliente
	 */
	@NotNull(message = "El Codigo de Tipo Cliente debe ser Obligatorio")
	@Size(max = 5, message = "El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false, length = 5)
	private String codigo;

	/**
	 * Variable que representa el atributo nombre del tipo de cliente
	 */
	@NotNull(message = "El nombre del tipo cliente debe de ser obligatorio")
	@Column(nullable = false, length = 50)
	private String nombre;

	/**
	 * Variable que representa el atributo prioridad del tipo de cliente
	 */
	@Column()
	private boolean prioridad;

	/**
	 * Variable que representa el atributo personas lista de personas que
	 * pertenecen al tipo de cliente
	 */
	@ManyToMany(mappedBy = "tiposCliente")
	private List<Persona> personas;

	/**
	 * Metodo constructor de entidad TipoCliente
	 */
	public TipoCliente() {
		super();
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad TipoCliente
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo que permite asignar un valor al atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad TipoCliente
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo codigo
	 * 
	 * @return codigo el codigo del tipo de cliente
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo codigo
	 * 
	 * @param codigo
	 *            el codigo del tipo de cliente
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre
	 * 
	 * @return nombre el nombre del tipo de cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            el nombre del tipo de cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo prioridad
	 * 
	 * @return prioridad true si el cliente tiene prioridad o false si el
	 *         cliente no tiene prioridad
	 */
	public boolean isPrioridad() {
		return prioridad;
	}

	/**
	 * Metodo que permite asignar un valor al atributo prioridad
	 * 
	 * @param prioridad
	 *            true si el cliente tiene prioridad o false si el cliente no
	 *            tiene prioridad
	 */
	public void setPrioridad(boolean prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * Metodo que permite obtener el valor del atributo personas
	 * 
	 * @return personas lista de personas que tienen el tipo de cliente
	 */
	public List<Persona> getPersonas() {
		return personas;
	}

	/**
	 * Metodo que permite asignar un valor al atributo personas
	 * 
	 * @param personas
	 *            lista de personas que tienen el tipo de cliente
	 */
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	/*
	 * Metodo sobreescrito de hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCliente other = (TipoCliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
