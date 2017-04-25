package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.entidades.PuestoTrabajo;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

/**
 * Session Bean implementation class PuestoTrabajoEJB
 */
@Stateless
@LocalBean
public class PuestoTrabajoEJB implements PuestoTrabajoEJBRemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;	

    /**
     * Default constructor. 
     */
    public PuestoTrabajoEJB() {
        // TODO Auto-generated constructor stub
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
		if (puesto == null || puesto.getNombre() == null || puesto.getNombre().isEmpty()) {
			throw new RuntimeException("ERROR: Faltan datos");
		}

		if (buscarServicioPorNombre(puesto.getNombre()) != null) {
			throw new RuntimeException("ERROR: El servicio ya existe");
		}

		entityManager.persist(puesto);
		return puesto;
	}
	
	/**
	 * Metodo que permite buscar un Puesto de Trabajo basado en su nombre
	 * 
	 * @param nombre
	 *            Nombre del puesto de trabajo que se desea buscar
	 * @return El puesto de trabajo que se corresponde con el nombre dado, en caso de no
	 *         encontar el puesto de trabajo se retorna null
	 */
	public PuestoTrabajo buscarServicioPorNombre(String nombre) {
		TypedQuery<PuestoTrabajo> query = entityManager.createNamedQuery(PuestoTrabajo.GET_X_NOMBRE, PuestoTrabajo.class);
		query.setParameter("nombreServicio", nombre);
		List<PuestoTrabajo> resultado = query.getResultList();
		return resultado.size() > 0 ? resultado.get(0) : null;
	}
	
	
	/**
	 * Metodo que permite obtener todos los Puestos de Trabajo registrados en el sistema
	 * 
	 * @return {@link List} de {@link PuestoTrabajo} registrados en el sistema
	 */
	public List<PuestoTrabajo> listarPuestosTrabajo() {
		return entityManager.createNamedQuery(PuestoTrabajo.GET_ALL, PuestoTrabajo.class).getResultList();
	}
	
	/**
	 * Metodo que permite obtener todos los Puestos de Trabajo Disponibles ( sin ser asignados a algun empleado ya)
	 * 
	 * @return {@link List} de {@link PuestoTrabajo} disponibles
	 */
	public List<PuestoTrabajo> listarPuestosTrabajoDisponibles(){
		return entityManager.createNamedQuery(PuestoTrabajo.GET_LIBRES, PuestoTrabajo.class).getResultList();
	}
	
	
	
	/**
	 * Metodo que permite remover un Puesto de Trabajo
	 * 
	 * @param puestoTrabajo
	 *            puestoTrabajo a ser eliminado
	 */
	public void eliminarPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
		if (puestoTrabajo == null || puestoTrabajo.getId() == null) {
			throw new RuntimeException("ERROR: Faltan datos");
		}

		puestoTrabajo = entityManager.find(PuestoTrabajo.class, puestoTrabajo.getId());

		if (puestoTrabajo == null) {
			throw new RuntimeException("ERROR: El servicio no existe");
		}

		if (puestoTrabajo.getEmpleado() != null) {
			throw new RuntimeException("ERROR: El puesto de Trabajo no se puede borrar , esta asignado a un Empleado");
		}

		entityManager.remove(puestoTrabajo);
	}
	
	
	/**
	 * Metodo que permite actualizar un Puesto de Trabajo
	 * 
	 * @param puestoTrabajo
	 *            Puesto Trabajo a ser actualizado
	 * @return El PuestoTrabajo actualizar, o null en caso de que no se haya podido
	 *         registrar
	 */
	public PuestoTrabajo actualizarPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
		if (puestoTrabajo == null || puestoTrabajo.getNombre() == null || "".equals(puestoTrabajo.getNombre().trim()) || puestoTrabajo.getId() == null ) {
			throw new RuntimeException("ERROR: Faltan datos");
		}
		
		PuestoTrabajo existe = entityManager.find(PuestoTrabajo.class, puestoTrabajo.getId());
		if( existe != null ){
			existe = buscarServicioPorNombre(puestoTrabajo.getNombre());
			if ( existe != null && existe.getId().intValue() != puestoTrabajo.getId().intValue() ) {
				throw new RuntimeException("ERROR: Ya existe un Puesto de Trabajo con ese nombre");
			}
			return entityManager.merge(puestoTrabajo);
		} else {
			throw new RuntimeException("ERROR: El Puesto de Trabajo no existe");
		}
	}	
	
	

}
