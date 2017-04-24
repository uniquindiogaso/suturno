
package co.edu.uniquindio.ingesis.suturno.delegados;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.ingesis.suturno.entidades.PuestoTrabajo;
import co.edu.uniquindio.ingesis.suturno.negocio.PuestoTrabajoEJB;
import co.edu.uniquindio.ingesis.suturno.negocio.PuestoTrabajoEJBRemote;

/**
 * * Delegado del puesto de trabajo
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 12/04/2017
 */
public class PuestoTrabajoDelegate {

	/**
	 * Variable que representa el PuestoTrabajoEJBRemote
	 */
	private PuestoTrabajoEJBRemote puestoEJB;

	/**
	 * Variable que representa la instancia del PuestoTrabajoDelegate
	 */
	private static final PuestoTrabajoDelegate instancia = new PuestoTrabajoDelegate();

	/**
	 * Metodo constructor del PuestoTrabajoDelegate
	 */
	private PuestoTrabajoDelegate() {
		try {
			puestoEJB = (PuestoTrabajoEJBRemote) new InitialContext().lookup(PuestoTrabajoEJB.JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Metodo que permite registrar un servicio
	 * 
	 * @param puesto
	 *            Servicio a ser registrado
	 * @return El servicio registrado, o null en caso de que no se haya podido
	 *         registrar
	 */
	public PuestoTrabajo registrarServicio(PuestoTrabajo puesto) {
		return puestoEJB.registrarServicio(puesto);
	}

	/**
	 * Metodo que permite buscar un Puesto de Trabajo basado en su nombre
	 * 
	 * @param nombre
	 *            Nombre del puesto de trabajo que se desea buscar
	 * @return El puesto de trabajo que se corresponde con el nombre dado, en
	 *         caso de no encontar el puesto de trabajo se retorna null
	 */
	public PuestoTrabajo buscarServicioPorNombre(String nombre) {
		return puestoEJB.buscarServicioPorNombre(nombre);
	}

	/**
	 * Metodo que permite obtener todos los Puestos de Trabajo registrados en el
	 * sistema
	 * 
	 * @return {@link List} de {@link PuestoTrabajo} registrados en el sistema
	 */
	public List<PuestoTrabajo> listarPuestosTrabajo() {
		return puestoEJB.listarPuestosTrabajo();
	}

	/**
	 * Metodo que permite remover un Puesto de Trabajo
	 * 
	 * @param puestoTrabajo
	 *            puestoTrabajo a ser eliminado
	 */
	public void eliminarPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
		puestoEJB.eliminarPuestoTrabajo(puestoTrabajo);
	}

	/**
	 * Metodo que permite actualizar un Puesto de Trabajo
	 * 
	 * @param puestoTrabajo
	 *            Puesto Trabajo a ser actualizado
	 * @return El PuestoTrabajo actualizar, o null en caso de que no se haya
	 *         podido registrar
	 */
	public PuestoTrabajo actualizarPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
		return puestoEJB.actualizarPuestoTrabajo(puestoTrabajo);
	}

	/**
	 * Metodo get de la instancia del PuestoTrabajoDelegate
	 * 
	 * @return instancia la instancia del PuestoTrabajoDelegate
	 */
	public static PuestoTrabajoDelegate getInstancia() {
		return instancia;
	}

}
