package co.edu.uniquindio.ingesis.suturno.desktop.delegados;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJBRemote;

/**
 * Delegado del Empleado
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingenier�a de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 12/04/2017
 *
 */
public class EmpleadoDelegate {

	/**
	 * Variable que representa el EmpleadoEJBRemote
	 */
	private EmpleadoEJBRemote empleadoEJB;

	/**
	 * Variable que representa la instancia del delegado
	 */
	private static final EmpleadoDelegate instancia = new EmpleadoDelegate();

	/**
	 * Constructor del EmpleadoDelegate
	 */
	private EmpleadoDelegate() {
		try {
			System.out.println("[JDNI] " + EmpleadoEJBRemote.JNDI);
			empleadoEJB = (EmpleadoEJBRemote) new InitialContext().lookup(EmpleadoEJBRemote.JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
			System.exit(-1);
		}

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
		return empleadoEJB.registrarEmpleado(empleado);
	}

	/**
	 * Registrar SuperAdministrador si no existe
	 * 
	 * @param empleado
	 * @return el administrador
	 */
	public Persona registrarAdministrador(Persona empleado) {
		return empleadoEJB.registrarAdministrador(empleado);
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
		return empleadoEJB.buscarEmpleadoPorNombreUsuario(nombreUsuario);
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
		return empleadoEJB.buscarEmpleadoPorIdentificacion(identificacion);
	}

	/**
	 * Metodo que permite obtener todos los EmpleadoGUI activos registrados en
	 * el sistema
	 * 
	 * @return lista de empleados activos
	 */
	public List<Empleado> listarEmpleadosActivos() {
		return empleadoEJB.listarEmpleadosActivos();
	}

	/**
	 * Metodo que permite obtener todos los EmpleadoGUI registrados en el
	 * sistema
	 * 
	 * @return lista de todos los empleados
	 */
	public List<Empleado> listarTodosEmpleados() {
		return empleadoEJB.listarTodosEmpleados();
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
		return empleadoEJB.desactivarEmpleado(empleado);
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
		empleadoEJB.eliminarEmpleado(empleado);
	}

	/**
	 * Actualizar Informacion del Empleado
	 * 
	 * @param empleado
	 *            Empleado a Actualizar
	 * @return el empleados actualizado
	 */
	public Persona actualizarEmpleado(Persona empleado) {
		return empleadoEJB.actualizarEmpleado(empleado);
	}

	/**
	 * Metodo get de la instancia del EmpleadoDelegate
	 * 
	 * @return instancia la instancia del EmpleadoDelegate
	 */
	public static EmpleadoDelegate getInstancia() {
		return instancia;
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
		return empleadoEJB.verificarAcceso(usuario, clave);
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
		return empleadoEJB.actualizarClaveEmpleado(empleadoId, claveNueva);
	}

	/**
	 * Asignar Servicios a Empleado
	 * 
	 * @param empleadoId
	 *            Identificacion del Empleado al que se le van a
	 *            actualizar/asignar los servicios
	 * @param servicios
	 *            Lista de Servicios
	 * @return True si se asignaron correctamente los servicios
	 */
	public boolean asignarServiciosEmpleado(int empleadoId, List<Servicio> servicios) {
		return empleadoEJB.asignarServiciosEmpleado(empleadoId, servicios);
	}

}
