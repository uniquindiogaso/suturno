package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

@Remote
public interface EmpleadoEJBRemote {

	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/EmpleadoEJB!co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJBRemote";

	/**
	 * Permite registrar un empleado en la b.d
	 * 
	 * @param empleado
	 *            el empleado a registrar
	 * @throws Exception
	 *             se genera cuando el empleado ya se encuentra registrado y el
	 *             login ya esta siendo usado por otro usuario
	 */
	public Persona registrarEmpleado(Persona empleado) throws Exception;
	
	
	
	/**
	 * Registrar SuperAdministrador si no existe
	 * @param empleado
	 * @return
	 */
	public Persona registrarAdministrador(Persona empleado);

	/**
	 * Metodo que permite buscar un Empleado basado en su nombre
	 * 
	 * @param nombreUsuario
	 *            nombre del Usuario que desea buscar
	 * @return El Empleado que se corresponde con el nombre dado, en caso de no
	 *         encontar el Empleado se retorna null
	 */
	public Empleado buscarEmpleadoPorNombreUsuario(String nombreUsuario);

	/**
	 * Metodo que permite buscar un Empleado basado en su nombre
	 * 
	 * @param nombreUsuario
	 *            nombre del Usuario que desea buscar
	 * @return El Empleado que se corresponde con el nombre dado, en caso de no
	 *         encontar el Empleado se retorna null
	 */
	public Empleado buscarEmpleadoPorIdentificacion(String identificacion);

	/**
	 * Metodo que permite obtener todos los Empleados activos registrados en el
	 * sistema
	 * 
	 * @return
	 */
	public List<Empleado> listarEmpleadosActivos();

	/**
	 * Metodo que permite obtener todos los Empleados registrados en el sistema
	 * 
	 * @return
	 */
	public List<Empleado> listarTodosEmpleados();

	/**
	 * Desactiva de manera temporal un Empleado para que no pueda ser utilizado
	 * en la asignacion de turnos o demas procesos donde este involucrado
	 * 
	 * @param empleado
	 *            Empleado a Desactivar
	 * @return True si se logro desactivar , False si no fue posible desactivar
	 */
	public boolean desactivarEmpleado(Empleado empleado);

	/**
	 * Eliminar de manera permanente un Empleado de la Base de datos sin
	 * posiblidad de recuperacion
	 * 
	 * @param empleado
	 *            Empleado a eliminar
	 * @return True si se logro eliminar , False si no se logro eliminar el
	 *         Empleado debido a q se estas empleando en algun proceso
	 */
	public void eliminarEmpleado(Empleado empleado);

	/**
	 * Actualizar Informacion del Empleado
	 * 
	 * @param empleado
	 *            Empleado a Actualizar
	 * @return
	 */
	public Persona actualizarEmpleado(Persona empleado);

	
	
	/**
	 * Comprobar el acceso a Usuario de acuerdo a su usuario y clave
	 * @param usuario nombre de usuario autenticar
	 * @param clave clave de acceso
	 * @return Empleado si la comprobacion se realiza correcta ; False si no se encuentra el Empleado
	 */
	public Empleado verificarAcceso(String usuario , String clave);
	
	
	/**
	 * Actualizar la Clave de Acceso de Empleado
	 * @param empleadoId Id de Empleado al que se le actualizara la clave
	 * @param claveNueva Nueva Contraseña
	 * @return True si la actualizacion de clave es correcta 
	 */
	public boolean actualizarClaveEmpleado(Long empleadoId, String claveNueva);
	
	
	/**
	 * Asingar Servicios a Empleado
	 * @param empleadoId Identificacion del Empleado al que se le van a actualizar/asignar los servicios
	 * @param servicios Lista de Servicios
	 * @return True si se asignaron correctamente los servicios
	 */
	public boolean asignarServiciosEmpleado(Long empleadoId, List<Servicio> servicios);
}
