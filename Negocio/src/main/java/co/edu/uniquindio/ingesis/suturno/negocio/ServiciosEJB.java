package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;



/**
 * Session Bean implementation class ServiciosEJB
 */
@Stateless
@LocalBean
public class ServiciosEJB implements ServiciosEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;		
	
	/**
	 * Metodo que permite registrar un servicio
	 * 
	 * @param servicio
	 *            Servicio a ser registrado
	 * @return El servicio registrado, o null en caso de que no se haya podido
	 *         registrar
	 */
	public Servicio registrarServicio(Servicio servicio) {
		if (servicio == null || servicio.getNombre() == null || "".equals(servicio.getNombre().trim())) {
			throw new RuntimeException("ERROR: Faltan datos");
		}

		if (buscarServicioPorNombre(servicio.getNombre()) != null) {
			throw new RuntimeException("ERROR: El servicio ya existe");
		}

		entityManager.persist(servicio);
		return servicio;
	}

	/**
	 * Metodo que permite buscar un servicio basado en su nombre
	 * 
	 * @param nombre
	 *            Nombre del servicio que se desea buscar
	 * @return El servicio que se corresponde con el nombre dado, en caso de no
	 *         encontar el servicio se retorna null
	 */
	public Servicio buscarServicioPorNombre(String nombre) {
		TypedQuery<Servicio> query = entityManager.createNamedQuery(Servicio.GET_SERVICIOS_X_NOMBRE, Servicio.class);
		query.setParameter("nombreServicio", nombre);
		List<Servicio> resultado = query.getResultList();
		return resultado.size() > 0 ? resultado.get(0) : null;
	}

	/**
	 * Metodo que permite obtener todos los servicios registrados en el sistema
	 * 
	 * @return {@link List} de {@link Servicio} registrados en el sistema
	 */
	public List<Servicio> listarServicios() {
		return entityManager.createNamedQuery(Servicio.GET_ALL, Servicio.class).getResultList();
	}

	/**
	 * Metodo que permite remover un servicio
	 * 
	 * @param servicio
	 *            Servicio a ser eliminado
	 */
	public void eliminarServicio(Servicio servicio) {
		if (servicio == null || servicio.getId() == null) {
			throw new RuntimeException("ERROR: Faltan datos");
		}

		servicio = entityManager.find(Servicio.class, servicio.getId());

		if (servicio == null) {
			throw new RuntimeException("ERROR: El servicio no existe");
		}

		if (servicio.getEmpleados().size() > 0 || servicio.getTurnos().size() > 0) {
			throw new RuntimeException("ERROR: El servicio esta siendo usado");
		}

		entityManager.remove(servicio);
	}

	/**
	 * Metodo que permite actualizar un servicio
	 * 
	 * @param servicio
	 *            Servicio a ser actualizado
	 * @return El servicio actualizar, o null en caso de que no se haya podido
	 *         registrar
	 */
	public Servicio actualizarServicio(Servicio servicio) {
		if (servicio == null || servicio.getNombre() == null || "".equals(servicio.getNombre().trim()) || servicio.getId() == null ) {
			throw new RuntimeException("ERROR: Faltan datos");
		}
		
		Servicio existe = entityManager.find(Servicio.class, servicio.getId());
		if( existe != null ){
			existe = buscarServicioPorNombre(servicio.getNombre());
			if ( existe != null && existe.getId() != servicio.getId() ) {
				throw new RuntimeException("ERROR: Ya existe un servicio con ese nombre");
			}
			return entityManager.merge(servicio);
		} else {
			throw new RuntimeException("ERROR: El servicio no existe");
		}
	}	

}
