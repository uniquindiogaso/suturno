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

/*
 * Entidad Depto
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
@Table(name = "suturno_depto")
public class Depto implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Variable que representa el atributo id de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/*
	 * Variable que representa el atributo codigo de la entidad Depto
	 */
	@NotNull(message = "El Codigo de la ubicacion debe ser obligatorio")
	@Size(max = 5, message = "El Codigo debe de tener un maximo de 5 Caracteres")
	@Column(nullable = false, length = 5)
	private String codigo;

	/*
	 * Variable que representa el atributo nombre de la entidad Depto
	 */
	@NotNull(message = "El nombre del departamento debe de ser obligatorio")
	@Column(nullable = false, length = 50)
	private String nombre;

	/*
	 * Variable que representa el atributo ciudades de la entidad Depto
	 */
	@OneToMany(mappedBy = "depto")
	private List<Ciudad> ciudades;

	/**
	 * Metodo constructor de la entidad Depto
	 */
	public Depto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor de la entidad Depto
	 * 
	 * @param codigo
	 *            el codigo del departamento
	 * @param nombre
	 *            el nombre del departamento
	 */
	public Depto(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return id el identificador de la entidad Depto
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @param id
	 *            el identificador de la entidad Depto
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo codigo
	 * 
	 * @return codigo el codigo del departamento
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que permite asignar un valor al atributo codigo
	 * 
	 * @param codigo
	 *            el codigo del departamento
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre
	 * 
	 * @return nombre el nombre del departamento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            el nombre del departamento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo ciudades
	 *
	 * @return ciudades la lista de ciudades que pertenecen al departamento
	 */
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	/**
	 * Metodo que permite asignar un valor al atributo ciudades
	 * 
	 * @param ciudades
	 *            la lista de ciudades que pertenecen al departamento
	 */
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	/**
	 * Metodo sobreescrito de hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Metodo sobreescrito de equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Depto other = (Depto) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
