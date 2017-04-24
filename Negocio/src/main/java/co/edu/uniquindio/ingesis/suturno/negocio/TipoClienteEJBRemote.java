package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.entidades.TipoCliente;

@Remote
public interface TipoClienteEJBRemote {
	
	
	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/PuestoTrabajoEJB!co.edu.uniquindio.ingesis.suturno.negocio.PuestoTrabajoEJBRemote";
	
	/**
	 * Metodo que permite registrar un servicio
	 * 
	 * @param tipoCliente
	 *            Servicio a ser registrado
	 * @return El servicio registrado, o null en caso de que no se haya podido
	 *         registrar
	 */
	public TipoCliente registrarServicio(TipoCliente tipoCliente);
	
	/**
	 * Metodo que permite buscar un servicio basado en su nombre
	 * 
	 * @param nombre
	 *            Nombre del servicio que se desea buscar
	 * @return El servicio que se corresponde con el nombre dado, en caso de no
	 *         encontar el servicio se retorna null
	 */
	public TipoCliente buscarTipoClientePorNombre(String nombre);
	
	
	/**
	 * Metodo que permite obtener todos los Tipo de Cliente registrados en el sistema
	 * 
	 * @return {@link List} de {@link TipoCliente} registrados en el sistema
	 */
	public List<TipoCliente> listarTipoCliente();
	
	
	
	/**
	 * Metodo que permite remover un TipoCliente
	 * 
	 * @param tipoCliente
	 *            TipoCliente a ser eliminado
	 */
	public void eliminarTipoCliente(TipoCliente tipoCliente);
	
	
	/**
	 * Metodo que permite actualizar un Tipo Cliente
	 * 
	 * @param tipoCliente
	 *            TipoCliente a ser actualizado
	 * @return El TipoCliente actualizar, o null en caso de que no se haya podido
	 *         registrar
	 */
	public TipoCliente actualizarTipoCliente(TipoCliente tipoCliente);

}
