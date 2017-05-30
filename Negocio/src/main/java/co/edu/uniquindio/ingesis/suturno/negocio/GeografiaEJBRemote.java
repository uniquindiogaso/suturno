package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;

/**
 * EJBRemote encargado de realizar la capa de negocio de la geografía, es decir,
 * la ciudad y el departamento
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Remote
public interface GeografiaEJBRemote {

	/**
	 * Variable que representa la direccion del JNDI
	 */
	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/GeografiaEJB!co.edu.uniquindio.ingesis.suturno.negocio.GeografiaEJBRemote";

	/**
	 * Listar Todas los Departamentos Disponibles
	 * 
	 * @return Lista de Departamentos
	 */
	public List<Depto> listarDepartamentos();

	/**
	 * Listado de Ciudades por Departamento
	 * 
	 * @param dpto
	 *            departanto del cual se quiere filtrar los municipios
	 *            disponibles
	 * @return lista de Ciudades del Dpto seleccionado
	 */
	public List<Ciudad> listarCiudades(Depto dpto);

}
