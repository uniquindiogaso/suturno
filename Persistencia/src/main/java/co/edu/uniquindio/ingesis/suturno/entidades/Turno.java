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
 * @author Ingenieria de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 1/03/2017
 */
@Entity
@NamedQueries({ @NamedQuery(name = Turno.GET_ALL, query = "SELECT t FROM Turno t"),
		@NamedQuery(name = Turno.GET_TURNOS_CLIENTE, query = "SELECT t FROM Turno t WHERE t.cliente.id=:clienteId"),
		@NamedQuery(name = Turno.GET_TURNOS_EMPLEADO, query = "SELECT t FROM Turno t WHERE t.empleado.id=:empleadoId"),
		@NamedQuery(name = Turno.GET_TURNO_FECHA, query = "SELECT new co.edu.uniquindio.ingesis.suturno.dto.InformacionTurnoPorFechaDTO(t.id, t.servicio.nombre , t.cliente.identificacion ,  t.cliente.nombre1 , t.cliente.email) FROM Turno t WHERE CAST(t.fecha DATE )= :fecha"),
		@NamedQuery(name = Turno.GET_CLIENTES_X_FECHA, query = "SELECT DISTINCT t.cliente FROM Turno t WHERE CAST(t.fecha DATE ) = :fecha"),
		@NamedQuery(name = Turno.GET_COUNT_CLIENTES_X_TURNO, query = "SELECT COUNT( DISTINCT t.cliente.id) FROM Turno t WHERE CAST(t.fecha DATE )= :fecha"),
		@NamedQuery(name = Turno.TURNO_X_EN_ESPERA_CLIENTE, query = "SELECT t FROM Turno t WHERE t.cliente.id=:clienteId AND t.estado=co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.EN_ESPERA"),

		@NamedQuery(name = Turno.GET_CANT_TURNO_CLIENTE_SIN_ATENDER, query = "SELECT new co.edu.uniquindio.ingesis.suturno.dto.CantTurnosXClienteDTO(COUNT(1) , t.cliente ) FROM Turno t WHERE t.estado = co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.EN_ESPERA GROUP BY t.cliente"),
		@NamedQuery(name = Turno.NUM_CLIENT_ATENDIDOS_POR_EMPLEADO, query = "SELECT COUNT( DISTINCT t.cliente.id) FROM Turno t WHERE t.estado = co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.FINALIZADO AND t.empleado= :empleado"),
		@NamedQuery(name = Turno.NUM_CLIENT_ATENDIDOS_POR_EMPLEADOS, query = "SELECT t.empleado , COUNT( DISTINCT t.cliente.id) FROM Turno t WHERE t.estado = co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.FINALIZADO GROUP BY t.empleado"),
		@NamedQuery(name = Turno.GET_EMPLEADO_GOLD, query = "SELECT t.empleado  FROM Turno t WHERE t.estado = co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.FINALIZADO "),
		@NamedQuery(name = Turno.TURNOS_SIN_ATENDER_POR_USUARIO, query = "SELECT t  FROM Turno t WHERE t.estado = co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.EN_ESPERA AND t.servicio IN (SELECT s FROM Empleado e LEFT JOIN(e.servicios) s WHERE e= :empleado )"),

		@NamedQuery(name = Turno.TURNOS_ATENDIDOS_EMPLEADO_ENTRE_FECHAS, query = "SELECT COUNT( DISTINCT t.cliente.id) FROM Turno t WHERE t.empleado.id= :empleado AND CAST(t.fecha DATE ) BETWEEN :fechaInicio AND :fechaFin AND t.estado = co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.FINALIZADO"),
		@NamedQuery(name = Turno.TURNOS_ATENDIDOS_EMPLEADO_ENTRE_FECHAS_AGRUPADA, query = "SELECT new co.edu.uniquindio.ingesis.suturno.dto.EmpleandoXClientesDTO( t.empleado , COUNT( DISTINCT t.cliente.id) ) FROM Turno t WHERE t.estado = co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno.FINALIZADO AND CAST(t.fecha DATE ) BETWEEN :fechaInicio AND :fechaFin GROUP BY t.empleado"),
		@NamedQuery(name = Turno.GET_COUNT_CLIENTES_X_SERVICIO, query = "SELECT COUNT( DISTINCT t.cliente.id) FROM Turno t WHERE t.servicio.id= :servicio"),		
		@NamedQuery(name = Turno.GET_CLIENTES_SERVICIO_AGRUPADOS, query = "SELECT new co.edu.uniquindio.ingesis.suturno.dto.ConteoClientesXServicioDTO(COUNT( DISTINCT t.cliente.id) , t.servicio ) FROM Turno t GROUP BY t.servicio"), })
@Table(name = "suturno_turno")
public class Turno implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constante que identifica la consulta que obtener todos los registros de
	 * Turno {@link Turno} <br />
	 */
	public static final String GET_ALL = "Turno_findAll";

	/**
	 * Constante que identifica la consulta que obtiene la cantidad de turnos
	 * que tiene el cliente {@link Turno} <br />
	 */
	public static final String GET_TURNOS_CLIENTE = "Turno_findByCliente";

	/**
	 * Constante que identifica la consulta que obtiene la cantidad de turnos
	 * que tiene el empleado {@link Turno} <br />
	 */
	public static final String GET_TURNOS_EMPLEADO = "Turno_findByEmpleado";

	/**
	 * Constante que identifica la consulta que obtiene datos de turno de
	 * acuerdo a la fecha que tiene el turno {@link Turno} <br />
	 */
	public static final String GET_TURNO_FECHA = "Turno_findByFecha";

	/**
	 * Constante que identifica la consulta que obtiene datos de los clientes
	 * que solicitan turno en fecha especifica {@link Turno} <br />
	 */
	public static final String GET_CLIENTES_X_FECHA = "Turno_findByClientesAndFecha";

	/**
	 * Constante que identifica la consulta que permite obtener el n�mero de
	 * clientes que tienen turno para una fecha dada. . {@link Turno} <br />
	 */
	public static final String GET_COUNT_CLIENTES_X_SERVICIO = "Turno_CountByClienteAndServicio";

	/**
	 * Constante que identifica la consulta que permite obtener el n�mero de
	 * clientes que han solicitado un determinado servicio. {@link Turno} <br />
	 */
	public static final String GET_COUNT_CLIENTES_X_TURNO = "Turno_CountByClienteByFecha";

	/**
	 * Constante que identifica la consulta que permite determinar el n�mero de
	 * clientes que han solicitado cada servicio {@link Turno} <br />
	 */
	public static final String GET_CLIENTES_SERVICIO_AGRUPADOS = "Turno_CountClientesGroupByServicio";

	/**
	 * Constante que identifica la consulta que permite determinar que clientes
	 * tienen turnos que a�n no han sido atendidos {@link Turno} <br />
	 */
	public static final String GET_CANT_TURNO_CLIENTE_SIN_ATENDER = "Turno_CountTurnoSinAtender";

	/**
	 * Constante que identifica la consulta que permite determinar cual es el
	 * empleado que m�s clientes ha atendido {@link Turno} <br />
	 */
	public static final String GET_EMPLEADO_GOLD = "Turno_MaxEmpleado";

	/**
	 * Constante que identifica la consulta que permite determinar cantidad de
	 * Clientes que han sido atendidos por un Empleado en particular
	 * {@link Turno} <br />
	 */
	public static final String NUM_CLIENT_ATENDIDOS_POR_EMPLEADO = "Turno_findByEmpleadoWhereEstadoAtendido";

	/**
	 * Constante que identifica la consulta que permite determinar Empleado y
	 * Cantidad de Clientes que ha atendido {@link Turno} <br />
	 */
	public static final String NUM_CLIENT_ATENDIDOS_POR_EMPLEADOS = "Turno_findEstadoAtendidoGroupByEmpleado";

	/**
	 * Constante que identifica la consulta que permite obtener un listado con
	 * los clientes y turnos que aun no han sido atendidos y que pueden ser
	 * atendidos por un determinado empleado {@link Turno} <br />
	 */
	public static final String TURNOS_SIN_ATENDER_POR_USUARIO = "Turno_findEstadoByUSuario";

	/**
	 * Constante que identifica la Consulta para determinar el n�mero de
	 * clientes atendidos por un empleado en un intervalo de tiempo dado
	 * {@link Turno} <br />
	 */
	public static final String TURNOS_ATENDIDOS_EMPLEADO_ENTRE_FECHAS = "Turno_findAtendidosByUsuarioEntreFechas";

	/**
	 * Constante que identifica la Consulta para determinar el n�mero de
	 * clientes atendidos por cada empleado en un intervalo de tiempo dado
	 * 
	 * {@link Turno} <br />
	 */
	public static final String TURNOS_ATENDIDOS_EMPLEADO_ENTRE_FECHAS_AGRUPADA = "Turno_findAtendidosByUsuarioEntreFechasGroupByEmpleado";

	/**
	 * Constante que identifica la Consulta para determinar los turnos que el
	 * cliente tiene en espera
	 * 
	 * {@link Turno} <br />
	 */
	public static final String TURNO_X_EN_ESPERA_CLIENTE = "Turno_findByEnEsperaByCliente";
	

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
	@Column(nullable = true)
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
