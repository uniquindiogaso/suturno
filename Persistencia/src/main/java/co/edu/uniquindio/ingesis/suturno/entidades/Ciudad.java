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

/*
 * Entidad Ciudad
 * 
 * @author Gustavo Salgado y Laura Julieth Rúa
 * 
 * @author Ingeniería de Sistemas y Computación
 * 
 * @author Universidad del Quindío
 * 
 * @version 1.0
 * 
 * @since 1/03/2017
 */
@Entity
@Table(name = "suturno_ciudad")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/*
	 * Variable que representa el atributo codigo de la entidad ciudad
	 */
	@NotNull(message = "El Codigo de la ubicacion debe ser obligatorio")
	@Size(max = 5, message = "El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false, length = 5)
	private String codigo;

	/*
	 * Variable que representa el atributo nombre de la entidad ciudad
	 */
	@NotNull(message = "El nombre de la ciudad debe de ser obligatorio")
	@Column(nullable = false, length = 50)
	private String nombre;

	/*
	 * Variable que representa el atributo departamento de la entidad ciudad
	 */
	@ManyToOne(optional = false, targetEntity = Depto.class)
	private Depto depto;

	/*
	 * Lista que representa el atributo persona de la entidad ciudad
	 */
	@OneToMany(mappedBy = "ciudad")
	private List<Persona> personas;

	/**
	 * Metodo constructor de la entidad Ciudad
	 */
	public Ciudad() {
		super();
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad Ciudad
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad Ciudad
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo codigo
	 * 
	 * @return codigo el codigo de la Ciudad
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo codigo
	 * 
	 * @param codigo
	 *            el codigo de la ciudad
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre
	 * 
	 * @return nombre el nombre de la Ciudad
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            el nombre de la ciudad
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo depto
	 * 
	 * @return depto el departamento al que pertenece la Ciudad
	 */
	public Depto getDpto() {
		return depto;
	}

	/**
	 * Metodo que permite asignar un valor al atributo depto
	 * 
	 * @param depto
	 *            el departamento al que pertenece la ciudad
	 */
	public void setDpto(Depto depto) {
		this.depto = depto;
	}

	/**
	 * Metodo que permite obtener el valor del atributo personas
	 * 
	 * @return servicios la lista de personas que pertenecen a la Ciudad
	 */
	public List<Persona> getPersonas() {
		return personas;
	}

	/**
	 * Metodo que permite asignar un valor al atributo personas
	 * 
	 * @param personas
	 *            la lista de personas que pertenecen a la ciudad
	 */
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	/*
	 *
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
