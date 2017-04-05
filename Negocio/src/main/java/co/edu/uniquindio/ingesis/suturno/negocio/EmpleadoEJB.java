package co.edu.uniquindio.ingesis.suturno.negocio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;

/**
 * Session Bean implementation class EmpleadoEJB
 */
@Stateless
@LocalBean
public class EmpleadoEJB implements EmpleadoEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EmpleadoEJB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permite registrar un empleado en la b.d
	 * 
	 * @param empleado
	 *            el empleado a registrar
	 * @throws Exception
	 *             se genera cuando el empleado ya se encuentra registrado y el
	 *             login ya esta siendo usado por otro usuario
	 */
	public void registrarEmpleado(Empleado empleado) throws Exception {
		if (entityManager.find(Persona.class, empleado.getTercero().getIdentificacion()) != null) {
			throw new Exception("El empleado ya se encuentra registrado.");
		}
		/*
		 * if(buscarPorLogin(empleado.getNombreUsuario())!=null){ throw new
		 * RuntimeException("El login ya esta siendo usado por otro usuario.");
		 * }
		 */
		try {
			entityManager.persist(empleado);
		} catch (Exception e) {
			// Registrar log
			throw new RuntimeException("Problemas al registrar el usuario.");
		}
	}
}
