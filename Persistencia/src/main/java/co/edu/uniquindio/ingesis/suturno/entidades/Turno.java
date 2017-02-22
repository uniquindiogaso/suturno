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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import utils.EstadoTurno;

@Entity
@Table(name="suturno_turno")
public class Turno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message="La fecha debe de ser obligatoria")
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false)
	private Timestamp fecha;
	
	@NotNull(message="El empleado debe de ser obligatorio")
	@ManyToOne(optional = false)
	private Empleado empleado;
	
	@NotNull(message="El cliente debe de ser obligatorio")	
	@ManyToOne(optional = false)
	private Persona cliente;
	
	@NotNull(message="El servicio debe de ser obligatorio")
	
	@ManyToOne(optional = false)
	private Servicio servicio;
	private String nota;
	@NotNull(message="El estado debe de ser obligatorio")
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EstadoTurno estado;

	public Turno() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public EstadoTurno getEstado() {
		return estado;
	}

	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}
	
	

	
	
}
