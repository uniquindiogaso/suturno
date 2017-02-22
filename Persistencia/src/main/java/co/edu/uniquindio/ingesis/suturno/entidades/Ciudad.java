package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="suturno_cuidad")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message="El Codigo de la ubicacion debe ser obligatorio")
	@Size(max=5,message="El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false,length=5)
	private String codigo;
	@NotNull(message="El nombre de la ciudad debe de ser obligatorio")
	@Column(nullable = false,length=50)
	private String nombre;
	@ManyToOne(optional = false, targetEntity = Dpto.class)
	private Dpto dpto;
	@OneToMany(mappedBy="ciudad")
	private List<Persona> personas;
	
	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dpto getDpto() {
		return dpto;
	}

	public void setDpto(Dpto dpto) {
		this.dpto = dpto;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	
		
	
}
