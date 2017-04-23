package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;

/**
 * Session Bean implementation class GeografiaEJB
 */
@Stateless
@LocalBean
public class GeografiaEJB implements GeografiaEJBRemote {
	
	@PersistenceContext	
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public GeografiaEJB() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Listar Todas los Departamentos Disponibles
     * @return Lista de Departamentos
     */
    public List<Depto> listarDepartamentos(){
    	return entityManager.createNamedQuery(Depto.GET_ALL, Depto.class).getResultList();
    }
    
    /**
     * Listado de Ciudades por Departamento
     * @param dpto departanto del cual se quiere filtrar los municipios disponibles
     * @return lista de Ciudades del Dpto seleccionado
     */
    public List<Ciudad> listarCiudades(Depto dpto){
    	TypedQuery<Ciudad> query = entityManager.createNamedQuery(Ciudad.GET_ALL_BY_DEPTO, Ciudad.class);
    	query.setParameter("dptoId", dpto.getId());
    	return query.getResultList();
    }

}
