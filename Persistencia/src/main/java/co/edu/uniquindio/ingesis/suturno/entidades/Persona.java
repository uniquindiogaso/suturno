package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import co.edu.uniquindio.ingesis.suturno.validators.Email;
import utils.Genero;
import utils.TipoDocumento;

@Entity
@Table(name="suturno_persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message="La identificacion debe de ser obligatoria")
	@Column(nullable = false,length=11)
	private String identificacion;
	@NotNull(message="El tipo de documento debe de ser obligatorio")
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private TipoDocumento tDoc;
	@Enumerated(EnumType.ORDINAL)
	@Column(length=9)
	private Genero genero;
	@NotNull(message="El nombre1 debe de ser obligatorio")
	@Column(nullable = false,length=50)
	private String nombre1;
	@Column(length=50)
	private String nombre2;
	@NotNull(message="El apellido1 debe de ser obligatorio")
	@Column(nullable = false,length=50)
	private String apellido1;
	@Column(length=50)
	private String apellido2;
	@Column(length=50)
	@Email(message="Correo Electronico Invalido")
	private String email;
	@Column(length=15)
	private String tel1;
	@Column(length=15)
	private String tel2;
	@Column(length=100)
	private String dir;
	
	@ManyToOne(optional = false)	
	private Ciudad ciudad;
	
	@Column()
	private boolean activo;	
	@ManyToMany()
	private List<TipoCliente> tiposCliente;
	
	@OneToMany(mappedBy="cliente")
	private List<Turno> turnos;
	
	@OneToOne()
	private Empleado empleado;
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public TipoDocumento gettDoc() {
		return tDoc;
	}

	public void settDoc(TipoDocumento tDoc) {
		this.tDoc = tDoc;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<TipoCliente> getTiposCliente() {
		return tiposCliente;
	}

	public void setTiposCliente(List<TipoCliente> tiposCliente) {
		this.tiposCliente = tiposCliente;
	}	
	
	
	
}
