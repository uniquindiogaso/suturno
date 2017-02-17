package entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Programa
 *
 */
@Entity

public class Programa implements Serializable {

	
	private String nombre;
	private String descripcion;
	private String version;
	private static final long serialVersionUID = 1L;

	public Programa() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
   
}
