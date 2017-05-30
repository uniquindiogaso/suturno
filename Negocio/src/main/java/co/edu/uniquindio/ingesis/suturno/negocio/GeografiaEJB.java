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
 * EJB encargado de realizar la capa de negocio de la geografía, es decir, la
 * ciudad y el departamento
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Stateless
@LocalBean
public class GeografiaEJB implements GeografiaEJBRemote {

	/**
	 * Variable que representa el entityManager del EmpleadoEJB
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo constructor por defecto
	 */
	public GeografiaEJB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Listar Todas los Departamentos Disponibles
	 * 
	 * @return Lista de Departamentos
	 */
	public List<Depto> listarDepartamentos() {
		return entityManager.createNamedQuery(Depto.GET_ALL, Depto.class).getResultList();
	}

	/**
	 * Listado de Ciudades por Departamento
	 * 
	 * @param dpto
	 *            departanto del cual se quiere filtrar los municipios
	 *            disponibles
	 * @return lista de Ciudades del Dpto seleccionado
	 */
	public List<Ciudad> listarCiudades(Depto dpto) {
		TypedQuery<Ciudad> query = entityManager.createNamedQuery(Ciudad.GET_ALL_BY_DEPTO, Ciudad.class);
		query.setParameter("dptoId", dpto.getId());
		return query.getResultList();
	}

}
