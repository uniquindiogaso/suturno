package co.edu.uniquindio.ingesis.suturno.negocio;

import javax.ejb.Remote;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;

/**
 * EJBRemote encargado de realizar la capa de negocio del Cliente
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Remote
public interface ClienteEJBRemote {

	/**
	 * Variable que representa la direccion del JNDI
	 */
	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/ClienteEJB!co.edu.uniquindio.ingesis.suturno.negocio.ClienteEJBRemote";

	/**
	 * Permite registrar un cliente en la b.d
	 * 
	 * @param cliente
	 *            el cliente a registrar
	 * @throws Exception
	 *             se genera cuando el cliente ya se encuentra registrado
	 */
	public Persona registrarCliente(Persona cliente) throws Exception;

	/**
	 * Metodo que permite buscar un cliente basado en su numero de
	 * identificación
	 * 
	 * @param identificacion
	 *            el numero de identificación por el que se desea buscar al
	 *            cliente
	 * @return cleinte que se corresponde con el numero dado, en caso de no
	 *         encontar el cliente se retorna null
	 */
	public Persona buscarClientePorIdentificacion(String identificacion);

	/**
	 * Desactiva de manera temporal un cliente
	 * 
	 * @param cliente
	 *            cliente a Desactivar
	 * @return True si se logro desactivar , False si no fue posible desactivar
	 */
	public boolean desactivarCliente(Persona cliente);

	/**
	 * Eliminar de manera permanente un cliente de la Base de datos sin
	 * posiblidad de recuperacion
	 * 
	 * @param cliente
	 *            cliente a eliminar
	 * @return True si se logro eliminar , False si no se logro eliminar el
	 *         cliente debido a q se estas empleando en algun proceso
	 */
	public void eliminarCliente(Persona cliente);

	/**
	 * Actualizar Informacion del cliente
	 * 
	 * @param cliente
	 *            cliente a Actualizar
	 * @return el cliente actuzalizado
	 */
	public Persona actualizarCliente(Persona cliente);

	/**
	 * Permite al cliente solicitar un servicio usando la identificacion del
	 * cliente
	 * 
	 * @param turno
	 *            el turno a solicitar
	 */
	public void solicitarTurno(Turno turno);
}
