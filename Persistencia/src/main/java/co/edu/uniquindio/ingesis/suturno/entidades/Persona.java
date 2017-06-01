package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;
import co.edu.uniquindio.ingesis.suturno.validators.Email;

/**
 * Entidad Persona
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
@NamedQueries({ @NamedQuery(name = Persona.GET_ALL, query = "SELECT p FROM Persona p"),
		@NamedQuery(name = Persona.GET_X_IDENTIFICACION, query = "SELECT p FROM Persona p WHERE p.identificacion= :identificacion "),
		@NamedQuery(name = Persona.GET_TIPOCLIENTE_CLIENTE, query = "SELECT t FROM Persona p LEFT JOIN (p.tiposCliente) t WHERE p.id= :personaId ") })
@Table(name = "suturno_persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Constante que identifica la consulta que obtener todos los registros de
	 * {@link Persona} <br />
	 */
	public static final String GET_ALL = "Persona_findAll";

	/**
	 * Constante que identifica la consulta que obtiene a que tipo de cliente
	 * pertenece el cliente {@link Persona} <br />
	 */
	public static final String GET_TIPOCLIENTE_CLIENTE = "TipoCliente_findByCliente";

	/**
	 * Constante que identifica la consulta que la Persona de acuerdo a su
	 * numero de Identificacion {@link Persona} <br />
	 */
	public static final String GET_X_IDENTIFICACION = "PersonaByIdentificacion";

	/**
	 * Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Variable que representa el atributo identificacion de la Persona
	 */
	@NotNull(message = "La identificacion debe de ser obligatoria")
	@Column(nullable = false, length = 11)
	private String identificacion;

	/**
	 * Variable que representa el atributo tipo de documento de la Persona
	 */
	@NotNull(message = "El tipo de documento debe de ser obligatorio")
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoDocumento tDoc;

	/**
	 * Variable que representa el atributo genero de la Persona
	 */
	@Enumerated(EnumType.ORDINAL)
	@Column(length = 9)
	private Genero genero;

	/**
	 * Variable que representa el atributo nombre 1 de la Persona
	 */
	@NotNull(message = "El nombre1 debe de ser obligatorio")
	@Column(nullable = false, length = 50)
	private String nombre1;

	/**
	 * Variable que representa el atributo nombre 2 de la Persona
	 */
	@Column(length = 50)
	private String nombre2;

	/**
	 * Variable que representa el atributo apellido 1 de la Persona
	 */
	@NotNull(message = "El apellido1 debe de ser obligatorio")
	@Column(nullable = false, length = 50)
	private String apellido1;

	/**
	 * Variable que representa el atributo apellido 2 de la Persona
	 */
	@Column(length = 50)
	private String apellido2;

	/**
	 * Variable que representa el atributo email de la Persona
	 */
	@Column(length = 50)
	//@Email(message = "Correo Electronico Invalido")
	private String email;

	/**
	 * Variable que representa el atributo telefono 1 de la Persona
	 */
	@Column(length = 15)
	private String tel1;

	/**
	 * Variable que representa el atributo telefono 2 de la Persona
	 */
	@Column(length = 15)
	private String tel2;
	
	/**
	 * Variable que representa el atributo fecha de nacimiento de la Persona
	 */
	@Transient
	private Date fechaNacimiento;

	/**
	 * Variable que representa el atributo direcci�n de la Persona
	 */
	@Column(length = 100)
	private String dir;

	/**
	 * Variable que representa el atributo ciudad al que pertenece la Persona
	 */
	@ManyToOne(optional = true)
	private Ciudad ciudad;

	/**
	 * Variable que representa el atributo activo de la Persona
	 */
	@Column()
	private boolean activo;

	/**
	 * Variable que representa el atributo lista de tipos de cliente de la
	 * Persona
	 */
	@ManyToMany()
	private List<TipoCliente> tiposCliente;

	/**
	 * Variable que representa el atributo lsita de turnos de la Persona
	 */
	@OneToMany(mappedBy = "cliente")
	private List<Turno> turnos;

	/**
	 * Variable que representa el atributo empleado de la Persona
	 */
	@OneToOne(cascade = CascadeType.PERSIST)
	private Empleado empleado;
	
	@Transient
	private String nombreCompleto;

	/**
	 * Metodo constructor de la entidad Persona
	 */
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param identificacion
	 * @param tDoc
	 * @param nombre1
	 * @param nombre2
	 * @param apellido1
	 * @param apellido2
	 * @param email
	 * @param fecha
	 */
	public Persona(String identificacion, TipoDocumento tDoc, String nombre1, String nombre2, String apellido1,
			String apellido2, String email, Date fecha) {
		super();
		this.identificacion = identificacion;
		this.tDoc = tDoc;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.fechaNacimiento=fecha;
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad Persona
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo que permite asignar un valor al atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad Persona
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo identificacion
	 * 
	 * @return identificacion el numero de identificacion de la persona
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Metodo que permite asignar un valor al atributo identificacion
	 * 
	 * @param identificacion
	 *            el numero de identificacion de la persona
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * Metodo que permite obtener el valor del atributo tDoc
	 * 
	 * @return tDoc el tipo de documento de la persona
	 */
	public TipoDocumento gettDoc() {
		return tDoc;
	}

	/**
	 * Metodo que permite asignar un valor al atributo tDoc
	 * 
	 * @param tDoc
	 *            el tipo de documento de la persona
	 */
	public void settDoc(TipoDocumento tDoc) {
		this.tDoc = tDoc;
	}

	/**
	 * Metodo que permite obtener el valor del atributo genero
	 * 
	 * @return genero el genero de la persona, femenino o masculino
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Metodo que permite asignar un valor al atributo genero
	 * 
	 * @param genero
	 *            el genero de la persona, femenino o masculino
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre1
	 * 
	 * @return nombre1 el primer nombre de la persona
	 */
	public String getNombre1() {
		return nombre1;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre1
	 * 
	 * @param nombre1
	 *            el primer nombre de la persona
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre2
	 * 
	 * @return nombre2 el segundo nombre de la persona, si lo tiene
	 */
	public String getNombre2() {
		return nombre2;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre2
	 * 
	 * @param nombre2
	 *            el segundo nombre de la persona, si lo tiene
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	/**
	 * Metodo que permite obtener el valor del atributo apellido1
	 * 
	 * @return apellido1 el primer apellido de la persona
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Metodo que permite asignar un valor al atributo apellido1
	 * 
	 * @param apellido1
	 *            el primer apellido de la persona
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Metodo que permite obtener el valor del atributo apellido2
	 * 
	 * @return apellido2 el segundo apellido de la persona
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Metodo que permite asignar un valor al atributo apellido2
	 * 
	 * @param apellido2
	 *            el segundo apellido de la persona
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Metodo que permite obtener el valor del atributo email
	 * 
	 * @return email el correo electr�nico de la persona
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que permite asignar un valor al atributo email
	 * 
	 * @param email
	 *            el correo electr�nico de la persona
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que permite obtener el valor del atributo tel1
	 * 
	 * @return tel1 el tel�fono de la persona, celular o fijo
	 */
	public String getTel1() {
		return tel1;
	}

	/**
	 * Metodo que permite asignar un valor al atributo tel1
	 * 
	 * @param tel1
	 *            el tel�fono de la persona, celular o fijo
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	/**
	 * Metodo que permite obtener el valor del atributo tel2
	 * 
	 * @return tel2 otro tel�fono de la persona, celular o fijo
	 */
	public String getTel2() {
		return tel2;
	}

	/**
	 * Metodo que permite asignar un valor al atributo tel2
	 * 
	 * @param tel2
	 *            otro tel�fono de la persona, celular o fijo
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	/**
	 * Metodo que permite obtener el valor del atributo dir
	 * 
	 * @return dir la direcci�n de la persona
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * Metodo que permite asignar un valor al atributo dir
	 * 
	 * @param dir
	 *            la direcci�n de la persona
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * Metodo que permite obtener el valor del atributo ciudad
	 * 
	 * @return ciudad la ciudad a la cual pertenece la persona
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * Metodo que permite asignar un valor al atributo ciudad
	 * 
	 * @param ciudad
	 *            la ciudad a la cual pertenece la persona
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Metodo que permite obtener el valor del atributo activo
	 * 
	 * @return activo true si la persona est� activa en el sistema o false si la
	 *         persona est� inactiva en el sistema
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo activo
	 * 
	 * @param activo
	 *            true si la persona est� activa en el sistema o false si la
	 *            persona est� inactiva en el sistema
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo tiposCliente
	 * 
	 * @return tiposCliente lista de a cuales de tipos de clientes pertenece la
	 *         persona
	 */
	public List<TipoCliente> getTiposCliente() {
		return tiposCliente;
	}

	/**
	 * Metodo que permite asignar un valor al atributo tiposCliente
	 * 
	 * @param tiposCliente
	 *            lista de a cuales de tipos de clientes pertenece la persona
	 */
	public void setTiposCliente(List<TipoCliente> tiposCliente) {
		this.tiposCliente = tiposCliente;
	}

	/**
	 * Metodo que permite obtener el valor del atributo turnos
	 * 
	 * @return turnos lista de turnos que tiene la persona
	 */
	public List<Turno> getTurnos() {
		return turnos;
	}

	/**
	 * Metodo que permite asignar un valor al atributo turnos
	 * 
	 * @param turnos
	 *            lista de turnos que tiene la persona
	 */
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	/**
	 * Metodo que permite obtener el valor del atributo empleado
	 * 
	 * @return empleado el empleado al cual pertenece la persona
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * Metodo que permite asignar un valor al atributo empleados
	 * 
	 * @param empleado
	 *            el empleado al cual pertenece la persona
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	/**
	 * Metodo get del atributo fecha de nacimiento
	 * @return fechaNacimiento la fecha de nacimiento de la persona
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Metodo set del atributo fehca de nacimiento
	 * @param fechaNacimiento la fecha de nacimiento de la persona
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Campo Calculado que unifica el nombre de una persona
	 * @return nombreCompleto Persona
	 */
	public String getNombreCompleto() {
		nombreCompleto = String.format("%s %s %s %s", nombre1 , nombre2 != null ? nombre2 : "" , apellido1 , apellido2 != null ? apellido2 : "");
		return nombreCompleto;
	}
	
	
	
	

}
