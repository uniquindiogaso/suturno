/**
 * 
 */
package co.edu.uniquindio.ingesis.suturno.delegados;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJBRemote;

/**
 * @author gusta
 *
 */
public class EmpleadoDelegate {
	
	private EmpleadoEJBRemote administrador;
	
	private static final EmpleadoDelegate instancia = new EmpleadoDelegate();

	/**
	 * 
	 */
	private  EmpleadoDelegate() {
		try {
			administrador = (EmpleadoEJBRemote) new InitialContext().lookup( EmpleadoEJBRemote.JNDI );
		} catch (NamingException e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}
	
	
	/**
	 * @return the instancia
	 */
	public static EmpleadoDelegate getInstancia() {
		return instancia;
	}
	
	
	public void registrarEmpleado(Empleado empleado) throws Exception{
		 administrador.registrarEmpleado(empleado);
	}


}
