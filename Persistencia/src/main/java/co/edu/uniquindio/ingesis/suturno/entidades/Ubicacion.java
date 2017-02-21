package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="suturno_ubicacion")
public class Ubicacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message="El Codigo de la ubicacion debe ser obligatorio")
	@Size(max=5,message="El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false,length=5)
	private String codigo;
	@Column(nullable = false,length=50)
	@NotNull(message="El nombre de la ubicacion debe de ser obligatorio")
	private String nombre;
	
	public Ubicacion() {
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
	
	
	
}
