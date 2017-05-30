package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.entidades.PuestoTrabajo;

/**
 * EJBRemote encargado de realizar la capa de negocio del puesto de trabajo
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Remote
public interface PuestoTrabajoEJBRemote {
	
	/**
	 * Variable que representa la direccion del JNDI
	 */
	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/PuestoTrabajoEJB!co.edu.uniquindio.ingesis.suturno.negocio.PuestoTrabajoEJBRemote";
	
	/**
	 * Metodo que permite registrar un servicio
	 * 
	 * @param puesto
	 *            Servicio a ser registrado
	 * @return El servicio registrado, o null en caso de que no se haya podido
	 *         registrar
	 */
	public PuestoTrabajo registrarServicio(PuestoTrabajo puesto);
	
	
	/**
	 * Metodo que permite buscar un Puesto de Trabajo basado en su nombre
	 * 
	 * @param nombre
	 *            Nombre del puesto de trabajo que se desea buscar
	 * @return El puesto de trabajo que se corresponde con el nombre dado, en caso de no
	 *         encontar el puesto de trabajo se retorna null
	 */
	public PuestoTrabajo buscarServicioPorNombre(String nombre);
	
	
	
	/**
	 * Metodo que permite obtener todos los Puestos de Trabajo registrados en el sistema
	 * 
	 * @return {@link List} de {@link PuestoTrabajo} registrados en el sistema
	 */
	public List<PuestoTrabajo> listarPuestosTrabajo();
	
	
	
	/**
	 * Metodo que permite remover un Puesto de Trabajo
	 * 
	 * @param puestoTrabajo
	 *            puestoTrabajo a ser eliminado
	 */
	public void eliminarPuestoTrabajo(PuestoTrabajo puestoTrabajo);
	
	
	
	/**
	 * Metodo que permite actualizar un Puesto de Trabajo
	 * 
	 * @param puestoTrabajo
	 *            Puesto Trabajo a ser actualizado
	 * @return El PuestoTrabajo actualizar, o null en caso de que no se haya podido
	 *         registrar
	 */
	public PuestoTrabajo actualizarPuestoTrabajo(PuestoTrabajo puestoTrabajo);
}
