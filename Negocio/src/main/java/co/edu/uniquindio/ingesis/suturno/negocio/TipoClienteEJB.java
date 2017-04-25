package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.entidades.TipoCliente;

/**
 * Session Bean implementation class TipoClienteEJB
 */
@Stateless
@LocalBean
public class TipoClienteEJB implements TipoClienteEJBRemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;	

    /**
     * Default constructor. 
     */
    public TipoClienteEJB() {
        // TODO Auto-generated constructor stub
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
		if (tipoCliente == null || tipoCliente.getNombre() == null || "".equals(tipoCliente.getNombre().trim())) {
			throw new RuntimeException("ERROR: Faltan datos");
		}

		if (buscarTipoClientePorNombre(tipoCliente.getNombre()) != null) {
			throw new RuntimeException("ERROR: El servicio ya existe");
		}

		entityManager.persist(tipoCliente);
		return tipoCliente;
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
		TypedQuery<TipoCliente> query = entityManager.createNamedQuery(TipoCliente.GET_X_NOMBRE, TipoCliente.class);
		query.setParameter("tipoCliente", nombre);
		List<TipoCliente> resultado = query.getResultList();
		return resultado.size() > 0 ? resultado.get(0) : null;
	}
    
	
	/**
	 * Metodo que permite obtener todos los Tipo de Cliente registrados en el sistema
	 * 
	 * @return {@link List} de {@link TipoCliente} registrados en el sistema
	 */
	public List<TipoCliente> listarTipoCliente() {
		return entityManager.createNamedQuery(TipoCliente.GET_ALL, TipoCliente.class).getResultList();
	}
	
	
	
	/**
	 * Metodo que permite remover un TipoCliente
	 * 
	 * @param tipoCliente
	 *            TipoCliente a ser eliminado
	 */
	public void eliminarTipoCliente(TipoCliente tipoCliente) {
		if (tipoCliente == null || tipoCliente.getId() == null) {
			throw new RuntimeException("ERROR: Faltan datos");
		}

		tipoCliente = entityManager.find(TipoCliente.class, tipoCliente.getId());

		if (tipoCliente == null) {
			throw new RuntimeException("ERROR: El servicio no existe");
		}

		if (tipoCliente.getPersonas().size() > 0 ) {
			throw new RuntimeException("ERROR: El servicio esta siendo usado");
		}

		entityManager.remove(tipoCliente);
	}
	
	
	/**
	 * Metodo que permite actualizar un Tipo Cliente
	 * 
	 * @param tipoCliente
	 *            TipoCliente a ser actualizado
	 * @return El TipoCliente actualizar, o null en caso de que no se haya podido
	 *         registrar
	 */
	public TipoCliente actualizarTipoCliente(TipoCliente tipoCliente) {
		if (tipoCliente == null || tipoCliente.getNombre() == null || "".equals(tipoCliente.getNombre().trim()) || tipoCliente.getId() == null ) {
			throw new RuntimeException("ERROR: Faltan datos");
		}
		
		TipoCliente existe = entityManager.find(TipoCliente.class, tipoCliente.getId());
		if( existe != null ){
			existe = buscarTipoClientePorNombre(tipoCliente.getNombre());
			if ( existe != null && existe.getId().intValue() != tipoCliente.getId().intValue() ) {
			throw new RuntimeException("ERROR: Ya existe un Tipo Cliente con ese nombre");
		}
			return entityManager.merge(tipoCliente);
		} else {
			throw new RuntimeException("ERROR: El Tipo Cliente no existe");
		}
	}	
	
	
	
	

}
