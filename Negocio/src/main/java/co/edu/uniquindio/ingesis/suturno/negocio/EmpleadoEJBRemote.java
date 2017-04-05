package co.edu.uniquindio.ingesis.suturno.negocio;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;

@Remote
public interface EmpleadoEJBRemote {

	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/EmpleadoEJB!co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJB, java:global/EAR/Negocio-0.0.1-SNAPSHOT/EmpleadoEJB!co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJBRemote";

	/**
	 * Permit registrar un empleado en la b.d
	 * 
	 * @param empleado
	 *            el empleado a registrar
	 * 
	 * @throws Exception
	 *             se genera cuando el empleado ya se encuentra registrado y el
	 *             login ya esta siendo usado por otro usuario
	 */
	public void registrarEmpleado(Empleado empleado) throws Exception;
}
