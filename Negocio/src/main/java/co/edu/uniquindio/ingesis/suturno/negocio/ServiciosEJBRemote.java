package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

/**
 * EJBRemote encargado de realizar la capa de negocio del servicio
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Remote		
public interface ServiciosEJBRemote {
	
	/**
	 * Variable que representa la direccion del JNDI
	 */
	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/ServiciosEJB!co.edu.uniquindio.ingesis.suturno.negocio.ServiciosEJBRemote";
	
	/**
	 * Metodo que permite registrar un servicio
	 * 
	 * @param servicio
	 *            Servicio a ser registrado
	 * @return El servicio registrado, o null en caso de que no se haya podido
	 *         registrar
	 */
	public Servicio registrarServicio(Servicio servicio);
	/**
	 * Metodo que permite buscar un servicio basado en su nombre
	 * 
	 * @param nombre
	 *            Nombre del servicio que se desea buscar
	 * @return El servicio que se corresponde con el nombre dado, en caso de no
	 *         encontar el servicio se retorna null
	 */
	public Servicio buscarServicioPorNombre(String nombre);
	/**
	 * Metodo que permite obtener todos los servicios registrados en el sistema
	 * 
	 * @return {@link List} de {@link Servicio} registrados en el sistema
	 */
	public List<Servicio> listarServicios();
	
	/**
	 * Metodo que permite remover un servicio
	 * 
	 * @param servicio
	 *            Servicio a ser eliminado
	 */
	public void eliminarServicio(Servicio servicio);
	/**
	 * Metodo que permite actualizar un servicio
	 * 
	 * @param servicio
	 *            Servicio a ser actualizado
	 * @return El servicio actualizar, o null en caso de que no se haya podido
	 *         registrar
	 */
	public Servicio actualizarServicio(Servicio servicio);
}
