package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entidad PuestoTrabajo
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
@NamedQueries({ @NamedQuery(name = PuestoTrabajo.GET_ALL, query = "SELECT entidad FROM PuestoTrabajo entidad"),
	@NamedQuery(name = PuestoTrabajo.GET_X_NOMBRE, query = "SELECT p FROM PuestoTrabajo p WHERE p.nombre= :puesto"),
	@NamedQuery(name = PuestoTrabajo.GET_LIBRES, query = "SELECT p FROM PuestoTrabajo p WHERE p.empleado IS NULL")})
@Table(name = "suturno_puestotrabajo")
public class PuestoTrabajo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constante que identifica la consulta que obtener todos los registros de
	 * {@link PuestoTrabajo} <br />
	 */
	public static final String GET_ALL = "PuestoTrabajo_findAll";

	
	/**
	 * Constante que identifica la consulta que obtener todos los registros de
	 * {@link PuestoTrabajo} de acuerdo al nombre suministrado<br />
	 */
	public static final String GET_X_NOMBRE = "PuestoTrabajo_findByNombre";
	
	
	/**
	 * Constante que identifica la consulta que obtener todos los registros de
	 * {@link PuestoTrabajo} libres<br />
	 */
	public static final String GET_LIBRES = "PuestoTrabajo_Libres";
	
	
	/**
	 * Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Variable que representa el atributo codigo del puesto de trabajo
	 */
	@NotNull(message = "El Codigo de la ubicacion debe ser obligatorio")
	@Size(max = 5, message = "El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false, length = 5)
	private String codigo;

	/**
	 * Variable que representa el atributo nombre del puesto de trabajo
	 */
	@Column(nullable = false, length = 50)
	@NotNull(message = "El nombre de la ubicacion debe de ser obligatorio")
	private String nombre;

	/**
	 * Variable que representa el atributo empleado que tiene el puesto de
	 * trabajo
	 */
	@OneToOne(mappedBy = "puesto")
	private Empleado empleado;

	/**
	 * Metodo constructor de la entidad PuestoTrabajo
	 */
	public PuestoTrabajo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad PuestoTrabajo
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo que permite asignar un valor al atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad PuestoTrabajo
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo codigo
	 * 
	 * @return codigo el codigo del puesto de trabajo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo codigo
	 * 
	 * @param codigo
	 *            el codigo del puesto de trabajo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre
	 * 
	 * @return nombre el nombre del puesto de trabajo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            el nombre del puesto de trabajo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo empleado
	 * 
	 * @return empleado el empleado que tiene el puesto de trabajo
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * Metodo que permite asignar un valor al atributo empleados
	 * 
	 * @param empleado
	 *            el empleado que tiene el puesto de trabajo
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
