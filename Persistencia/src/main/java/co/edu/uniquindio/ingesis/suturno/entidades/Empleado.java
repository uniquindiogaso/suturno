package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="suturno_empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull(message="El tercero debe de ser obligatorio")
	@OneToOne(mappedBy="empleado")
	private Persona tercero;
	
	@NotNull(message="El usuario debe de ser obligatorio")
	@Column(nullable = false,length=50)
	private String usuario;
	
	@NotNull(message="La clave debe de ser obligatoria")
	@Column(nullable = false,length=50)
	private String clave;
	
	@Column
	private boolean admin;
	
	@OneToOne
	private PuestoTrabajo puesto;
	
	@ManyToMany
	private List<Servicio> servicios;
	
	@OneToMany(mappedBy="empleado")
	private List<Turno> turnos;
	
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getTercero() {
		return tercero;
	}

	public void setTercero(Persona tercero) {
		this.tercero = tercero;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public PuestoTrabajo getPuesto() {
		return puesto;
	}

	public void setPuesto(PuestoTrabajo puesto) {
		this.puesto = puesto;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	
	

	
}
