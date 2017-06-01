package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

/**
 * EJB encargado de realizar la capa de negocio del Empleado
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Stateless
@LocalBean
public class EmpleadoEJB implements EmpleadoEJBRemote {

	/**
	 * Variable que representa el entityManager del EmpleadoEJB
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo constructor por defecto
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
	public Persona registrarEmpleado(Persona empleado) throws Exception {

		if (null == empleado || empleado.getEmpleado() == null) {
			throw new RuntimeException("Datos incompletos");
		}

		Empleado existente = buscarEmpleadoPorIdentificacion(empleado.getIdentificacion());

		if (null != existente) {
			throw new Exception("El empleado ya se encuentra registrado.");
		}

		if (existeNombreUsuario(empleado.getEmpleado().getUsuario())) {
			throw new RuntimeException("El login ya esta siendo usado por otro Empleado.");
		}

		try {
			entityManager.persist(empleado);
			entityManager.flush();
			System.out.println("Empleado Registrado Correctamente .... (registrarEmpleado)");
		} catch (Exception e) {
			System.out.println("Error  Registrado Empleado .... (registrarEmpleado)");
			System.out.println("Error  Registrado Empleado .... (registrarEmpleado)" + e);
			System.out.println("Error  Registrado Empleado .... (registrarEmpleado)" + e.getMessage());
			// Registrar log
			throw new RuntimeException("Problemas al registrar el Empleado.");
		}

		return empleado;
	}

	/**
	 * Registrar SuperAdministrador si no existe
	 * 
	 * @param empleado
	 * @return
	 */
	public Persona registrarAdministrador(Persona empleado) {
		entityManager.persist(empleado);
		return empleado;
	}

	/**
	 * Metodo que permite buscar un Empleado basado en su nombre
	 * 
	 * @param nombreUsuario
	 *            nombre del Usuario que desea buscar
	 * @return El Empleado que se corresponde con el nombre dado, en caso de no
	 *         encontar el Empleado se retorna null
	 */
	public Empleado buscarEmpleadoPorNombreUsuario(String nombreUsuario) {
		TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.GET_X_NOMBREUSUARIO, Empleado.class);
		query.setParameter("nombreUsuario", nombreUsuario);
		List<Empleado> resultado = query.getResultList();
		return resultado.size() > 0 ? resultado.get(0) : null;
	}

	/**
	 * Metodo que permite buscar un Empleado basado en su nombre
	 * 
	 * @param nombreUsuario
	 *            nombre del Usuario que desea buscar
	 * @return El Empleado que se corresponde con el nombre dado, en caso de no
	 *         encontar el Empleado se retorna null
	 */
	public Empleado buscarEmpleadoPorIdentificacion(String identificacion) {
		TypedQuery<Persona> query = entityManager.createNamedQuery(Persona.GET_X_IDENTIFICACION, Persona.class);
		query.setParameter("identificacion", identificacion);
		List<Persona> resultado = query.getResultList();
		return resultado.size() > 0 ? resultado.get(0).getEmpleado() : null;
	}

	/**
	 * Metodo que permite obtener todos los Empleados activos registrados en el
	 * sistema
	 * 
	 * @return
	 */
	public List<Empleado> listarEmpleadosActivos() {
		return entityManager.createNamedQuery(Empleado.GET_ALL_ACTIVOS, Empleado.class).getResultList();
	}

	/**
	 * Metodo que permite obtener todos los Empleados registrados en el sistema
	 * 
	 * @return
	 */
	public List<Empleado> listarTodosEmpleados() {
		return entityManager.createNamedQuery(Empleado.GET_ALL, Empleado.class).getResultList();
	}

	/**
	 * Desactiva de manera temporal un Empleado para que no pueda ser utilizado
	 * en la asignacion de turnos o demas procesos donde este involucrado
	 * 
	 * @param empleado
	 *            Empleado a Desactivar
	 * @return True si se logro desactivar , False si no fue posible desactivar
	 */
	public boolean desactivarEmpleado(Empleado empleado) {

		Persona existe = entityManager.find(Persona.class, empleado.getTercero().getId());

		if (null != existe) {
			existe.setActivo(false);
			entityManager.merge(existe);
			return true;
		}

		return false;
	}

	/**
	 * Eliminar de manera permanente un Empleado de la Base de datos sin
	 * posiblidad de recuperacion
	 * 
	 * @param empleado
	 *            Empleado a eliminar
	 * @return True si se logro eliminar , False si no se logro eliminar el
	 *         Empleado debido a q se estas empleando en algun proceso
	 */
	public void eliminarEmpleado(Empleado empleado) {
		Persona existe = entityManager.find(Persona.class, empleado.getTercero().getId());

		if (null == existe) {
			throw new RuntimeException("ERROR: El servicio no existe");
		}

		if (existe.getTurnos().size() > 0) {
			throw new RuntimeException("ERROR: El empleado ya se le ha asignado Turnos, no se puede eliminar");
		}

		entityManager.remove(empleado);

	}

	/**
	 * Actualizar Informacion del Empleado
	 * 
	 * @param empleado
	 *            Empleado a Actualizar
	 * @return
	 */
	public Persona actualizarEmpleado(Persona empleado) {
		if (null == empleado || empleado.getEmpleado() == null || empleado.getEmpleado().getUsuario().isEmpty()) {
			throw new RuntimeException("Datos incompletos");
		}

		Persona existe = entityManager.find(Persona.class, empleado.getId());

		if (null != existe) {
			Empleado e = buscarEmpleadoPorNombreUsuario(empleado.getEmpleado().getUsuario());
			if (e != null && e.getId() != empleado.getEmpleado().getId()) {
				throw new RuntimeException("ERROR: Ya existe un Empleado con ese nombre");
			}

			e = buscarEmpleadoPorIdentificacion(empleado.getIdentificacion());
			if (e != null && e.getId() != empleado.getEmpleado().getId()) {
				throw new RuntimeException("ERROR: Ya existe un Empleado con ese Numero de Identificacion");
			}
					
			return entityManager.merge(empleado);

		} else {
			throw new RuntimeException("ERROR: El Empleado no existe");
		}

	}
	
	public Empleado actualizarEmpleado( Empleado  e){
		
		System.out.println("e.getTercero().getNombre1() " + e.getTercero().getNombre1());
		
		Empleado empleado = entityManager.find(Empleado.class, e.getId());

		empleado.setUsuario(e.getUsuario());
		empleado.setClave(e.getClave());
		
		empleado.getTercero().setNombre1(e.getTercero().getNombre1());
		empleado.getTercero().setNombre2(e.getTercero().getNombre2());
		empleado.getTercero().setApellido1(e.getTercero().getApellido1());
		empleado.getTercero().setApellido2(e.getTercero().getApellido2());
		empleado.getTercero().setTel1(e.getTercero().getTel1());
		empleado.getTercero().setTel2(e.getTercero().getTel2());
		
		return entityManager.merge(empleado);
	}

	/**
	 * Realiza una buscada de Empleados por nombre de usuario
	 * 
	 * @param nombreUsuario
	 * @return true si encuentra empleados con mismo nombre de usuario false si
	 *         no encuentra ningun empleado
	 */
	private boolean existeNombreUsuario(String nombreUsuario) {
		TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.GET_X_NOMBREUSUARIO, Empleado.class);
		query.setParameter("nombreUsuario", nombreUsuario);

		return query.getResultList().size() == 0 ? false : true;
	}

	/**
	 * Comprobar el acceso a Usuario de acuerdo a su usuario y clave
	 * 
	 * @param usuario
	 *            nombre de usuario autenticar
	 * @param clave
	 *            clave de acceso
	 * @return Empleado si la comprobacion se realiza correcta ; False si no se
	 *         encuentra el Empleado
	 */
	public Empleado verificarAcceso(String usuario, String clave) {
		TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.AUTENTICAR, Empleado.class);
		query.setParameter("usuario", usuario);
		query.setParameter("clave", clave);
		return query.getResultList().size() == 1 ? query.getResultList().get(0) : null;
	}

	/**
	 * Actualizar la Clave de Acceso de Empleado
	 * 
	 * @param empleadoId
	 *            Id de Empleado al que se le actualizara la clave
	 * @param claveNueva
	 *            Nueva Contrase�a
	 * @return True si la actualizacion de clave es correcta
	 */
	public boolean actualizarClaveEmpleado(int empleadoId, String claveNueva) {
		Empleado existe = entityManager.find(Empleado.class, empleadoId);

		if (null != existe) {
			existe.setClave(claveNueva);
			entityManager.merge(existe);
			return true;
		} else {
			throw new RuntimeException("ERROR: El Empleado no existe - No se puede Actualizar la Clave ");
		}
	}

	/**
	 * Asingar Servicios a Empleado
	 * 
	 * @param empleadoId
	 *            Identificacion del Empleado al que se le van a
	 *            actualizar/asignar los servicios
	 * @param servicios
	 *            Lista de Servicios
	 * @return True si se asignaron correctamente los servicios
	 */
	public boolean asignarServiciosEmpleado(int empleadoId, List<Servicio> servicios) {
		Empleado existe = entityManager.find(Empleado.class, empleadoId);

		if (null != existe) {
			existe.setServicios(servicios);
			entityManager.merge(existe);
			return true;
		} else {
			throw new RuntimeException("ERROR: El Empleado no existe - No se Asignar los servicios ");
		}

	}

}
