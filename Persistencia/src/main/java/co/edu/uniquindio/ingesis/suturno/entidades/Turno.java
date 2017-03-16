package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno;

/**
 * Entidad Turno
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
@NamedQueries({ @NamedQuery(name = Turno.GET_ALL, query = "SELECT entidad FROM Turno entidad") })
@Table(name = "suturno_turno")
public class Turno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constante que identifica la consulta que obtener todos los registros de
	 * {@link Depto} <br />
	 */
	public static final String GET_ALL = "Turno_findAll";
	
	
	/**
	 * Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * Variable que representa el atributo id de la entidad
	 */
	@NotNull(message = "La fecha debe de ser obligatoria")
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
	private Timestamp fecha;

	/**
	 * Variable que representa el atributo empleado del turno
	 */
	@ManyToOne(optional = true)
	private Empleado empleado;

	/**
	 * Variable que representa el atributo cliente del turno
	 */
	@NotNull(message = "El cliente debe de ser obligatorio")
	@ManyToOne(optional = false)
	private Persona cliente;

	/**
	 * Variable que representa el atributo servicio del turno
	 */
	@NotNull(message = "El servicio debe de ser obligatorio")
	@ManyToOne(optional = false)
	private Servicio servicio;

	/**
	 * Variable que representa el atributo nota del turno
	 */
	private String nota;

	/**
	 * Variable que representa el atributo estado del turno
	 */
	@NotNull(message = "El estado debe de ser obligatorio")
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EstadoTurno estado;

	/**
	 * Metodo constructor de la entidad Turno
	 */
	public Turno() {
		super();
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad Turno
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que permite asignar un valor al atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad Turno
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo fecha
	 * 
	 * @return fecha la fecha en la que se realizo el servicio
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * Metodo que permite asignar un valor al atributo fecha
	 * 
	 * @param fecha
	 *            la fecha en la que se realizo el servicio
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo que permite obtener el valor del atributo empleado
	 * 
	 * @return empleado el empleado al que se le asigna el turno
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * Metodo que permite asignar un valor al atributo empleado
	 * 
	 * @param empleado
	 *            el empleado al que se le asigna el turno
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	/**
	 * Metodo que permite obtener el valor del atributo cliente
	 * 
	 * @return cliente el cliente que solicito el servicio
	 */
	public Persona getCliente() {
		return cliente;
	}

	/**
	 * Metodo que permite asignar un valor al atributo cliente
	 * 
	 * @param cliente
	 *            el cliente que solicito el servicio
	 */
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	/**
	 * Metodo que permite obtener el valor del atributo servicio
	 * 
	 * @return servicio el servicio que se solicito para el turno
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * Metodo que permite asignar un valor al atributo servicio
	 * 
	 * @param servicio
	 *            el servicio que se solicito para el turno
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nota
	 * 
	 * @return nota si al atender el turno se necesita una nota
	 */
	public String getNota() {
		return nota;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nota
	 * 
	 * @param nota
	 *            si al momento de atender el turno se necesita una nota
	 */
	public void setNota(String nota) {
		this.nota = nota;
	}

	/**
	 * Metodo que permite obtener el valor del atributo estado
	 * 
	 * @return estado el estado del turno
	 */
	public EstadoTurno getEstado() {
		return estado;
	}

	/**
	 * Metodo que permite asignar un valor al atributo estado
	 * 
	 * @param estado
	 *            el estado del turno
	 */
	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
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
		Turno other = (Turno) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
