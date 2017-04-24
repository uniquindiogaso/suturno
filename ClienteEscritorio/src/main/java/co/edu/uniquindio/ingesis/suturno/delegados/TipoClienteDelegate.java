package co.edu.uniquindio.ingesis.suturno.delegados;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.ingesis.suturno.entidades.TipoCliente;
import co.edu.uniquindio.ingesis.suturno.negocio.TipoClienteEJBRemote;

/**
 * Delegado del tipo de cliente
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
public class TipoClienteDelegate {

	/**
	 * Variable que representa el TipoClienteEJBRemote
	 */
	private TipoClienteEJBRemote tipoClienteEJB;

	/**
	 * Variable que representa la instancia del TipoClienteDelegate
	 */
	private static final TipoClienteDelegate instancia = new TipoClienteDelegate();

	/**
	 * Metodo constructor del TipoClienteDelegate
	 */
	private TipoClienteDelegate() {
		try {
			tipoClienteEJB = (TipoClienteEJBRemote) new InitialContext().lookup(TipoClienteEJBRemote.JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Metodo que permite registrar un servicio
	 * 
	 * @param tipoCliente
	 *            Servicio a ser registrado
	 * @return El servicio registrado, o null en caso de que no se haya podido
	 *         registrar
	 */
	public TipoCliente registrarServicio(TipoCliente tipoCliente) {
		return tipoClienteEJB.registrarServicio(tipoCliente);
	}

	/**
	 * Metodo que permite buscar un servicio basado en su nombre
	 * 
	 * @param nombre
	 *            Nombre del servicio que se desea buscar
	 * @return El servicio que se corresponde con el nombre dado, en caso de no
	 *         encontar el servicio se retorna null
	 */
	public TipoCliente buscarTipoClientePorNombre(String nombre) {
		return tipoClienteEJB.buscarTipoClientePorNombre(nombre);
	}

	/**
	 * Metodo que permite obtener todos los Tipo de Cliente registrados en el
	 * sistema
	 * 
	 * @return {@link List} de {@link TipoCliente} registrados en el sistema
	 */
	public List<TipoCliente> listarTipoCliente() {
		return tipoClienteEJB.listarTipoCliente();
	}

	/**
	 * Metodo que permite remover un TipoCliente
	 * 
	 * @param tipoCliente
	 *            TipoCliente a ser eliminado
	 */
	public void eliminarTipoCliente(TipoCliente tipoCliente) {
		tipoClienteEJB.eliminarTipoCliente(tipoCliente);
	}

	/**
	 * Metodo que permite actualizar un Tipo Cliente
	 * 
	 * @param tipoCliente
	 *            TipoCliente a ser actualizado
	 * @return El TipoCliente actualizar, o null en caso de que no se haya
	 *         podido registrar
	 */
	public TipoCliente actualizarTipoCliente(TipoCliente tipoCliente) {
		return tipoClienteEJB.actualizarTipoCliente(tipoCliente);
	}

	/**
	 * Metodo get de la instancia del TipoClienteDelegate
	 * 
	 * @return instancia la instancia del TipoClienteDelegate
	 */
	public static TipoClienteDelegate getInstancia() {
		return instancia;
	}

}
