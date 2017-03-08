package co.edu.uniquindio.ingesis.suturno.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "suturno_dpto")
public class Dpto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message = "El Codigo de la ubicacion debe ser obligatorio")
	@Size(max = 5, message = "El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false, length = 5)
	private String codigo;
	@NotNull(message = "El nombre del departamento debe de ser obligatorio")
	@Column(nullable = false, length = 50)
	private String nombre;
	@OneToMany(mappedBy = "dpto")
	private List<Ciudad> ciudades;

	public Dpto() {
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

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dpto other = (Dpto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

	
	
	
}
