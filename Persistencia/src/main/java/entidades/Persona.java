package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.GeneroEnum;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@Table(name="persona")

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=12)
	private String cedula;
	@Column(nullable = false,length=30)
	private String nombre;
	@Column(nullable = false,length=30)
	//@NotNull
	private String apellido;
	
	//Fecha
	//Email (length=100,unique=true)
	
	@Enumerated(EnumType.STRING)
	@Column(length=13)
	private GeneroEnum genero;
	
	@ElementCollection
	private Map<String,String> telefonos;
	
	
	
	public Persona() {
		super();
	}   
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
		
	public GeneroEnum getGenero() {
		return genero;
	}
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	
	public Map<String, String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Map<String, String> telefonos) {
		this.telefonos = telefonos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Persona other = (Persona) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}
	
	
   
}
