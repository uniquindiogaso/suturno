package co.edu.uniquindio.ingesis.suturno.negocio;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;

/**
 * EJB encargado de realizar la capa de negocio del Cliente
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Stateless
@LocalBean
public class ClienteEJB implements ClienteEJBRemote {

	/**
	 * Variable que representa el entityManager del ClienteEJB
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private ServiciosEJB serviciosEJB;

	/**
	 * Metodo constructor por defecto
	 */
	public ClienteEJB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permite registrar un cliente en la b.d
	 * 
	 * @param cliente
	 *            el cliente a registrar
	 * @throws Exception
	 *             se genera cuando el cliente ya se encuentra registrado
	 */
	public Persona registrarCliente(Persona cliente) throws Exception {

		if (null == cliente) {
			throw new RuntimeException("Datos incompletos");
		}

		Persona existente = buscarClientePorIdentificacion(cliente.getIdentificacion());

		if (null != existente) {
			throw new Exception("El cliente ya se encuentra registrado.");
		}

		try {
			entityManager.persist(cliente);
			entityManager.flush();
			System.out.println("Cliente Registrado Correctamente .... (registrarCliente)");
		} catch (Exception e) {
			System.out.println("Error  Registrado Empleado .... (registrarCliente)");
			System.out.println("Error  Registrado Empleado .... (registrarCliente)" + e);
			System.out.println("Error  Registrado Empleado .... (registrarCliente)" + e.getMessage());
			// Registrar log
			throw new RuntimeException("Problemas al registrar el cliente.");
		}

		return cliente;
	}

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
	public Persona buscarClientePorIdentificacion(String identificacion) {
		TypedQuery<Persona> query = entityManager.createNamedQuery(Persona.GET_X_IDENTIFICACION, Persona.class);
		query.setParameter("identificacion", identificacion);
		List<Persona> resultado = query.getResultList();
		return resultado.size() > 0 ? resultado.get(0) : null;
	}

	/**
	 * Desactiva de manera temporal un cliente
	 * 
	 * @param cliente
	 *            cliente a Desactivar
	 * @return True si se logro desactivar , False si no fue posible desactivar
	 */
	public boolean desactivarCliente(Persona cliente) {

		Persona existe = entityManager.find(Persona.class, cliente.getId());

		if (null != existe) {
			existe.setActivo(false);
			entityManager.merge(existe);
			return true;
		}

		return false;
	}

	/**
	 * Eliminar de manera permanente un cliente de la Base de datos sin
	 * posiblidad de recuperacion
	 * 
	 * @param cliente
	 *            cliente a eliminar
	 * @return True si se logro eliminar , False si no se logro eliminar el
	 *         cliente debido a q se estas empleando en algun proceso
	 */
	public void eliminarCliente(Persona cliente) {
		Persona existe = entityManager.find(Persona.class, cliente.getId());

		if (null == existe) {
			throw new RuntimeException("ERROR: El cliente no existe");
		}

		if (existe.getTurnos().size() > 0) {
			throw new RuntimeException("ERROR: El cliente ya se le ha asignado Turnos, no se puede eliminar");
		}

		entityManager.remove(cliente);

	}

	/**
	 * Actualizar Informacion del cliente
	 * 
	 * @param cliente
	 *            cliente a Actualizar
	 * @return el cliente actuzalizado
	 */
	public Persona actualizarCliente(Persona cliente) {
		if (null == cliente || cliente.getEmpleado() == null || cliente.getEmpleado().getUsuario().isEmpty()) {
			throw new RuntimeException("Datos incompletos");
		}

		Persona existe = entityManager.find(Persona.class, cliente.getId());

		if (null != existe) {
			Persona c = buscarClientePorIdentificacion(cliente.getIdentificacion());
			if (c != null && c.getId() != cliente.getEmpleado().getId()) {
				throw new RuntimeException("ERROR: Ya existe un cliente con ese Numero de Identificacion");
			}

			return entityManager.merge(cliente);

		} else {
			throw new RuntimeException("ERROR: El cliente no existe");
		}

	}

	/**
	 * Permite al cliente solicitar un servicio usando la identificacion del
	 * cliente
	 * 
	 * @param turno
	 *            el turno a solicitar
	 */
	public void solicitarTurno(Turno turno) {
		if (turno == null || turno.getCliente() == null || turno.getServicio() == null) {
			throw new RuntimeException("Datos faltantes");
		}
		if (buscarClientePorIdentificacion(turno.getCliente().getIdentificacion()) == null) {
			throw new RuntimeException("Cliente NO existe");
		}
		if (serviciosEJB.buscarServicioPorNombre(turno.getServicio().getNombre()) == null) {
			throw new RuntimeException("Servicio NO existe");
		}
		Date fechaActual = new GregorianCalendar().getTime();
		turno.setFecha(new Timestamp(fechaActual.getTime()));
		;
		entityManager.persist(turno);
	}

}
