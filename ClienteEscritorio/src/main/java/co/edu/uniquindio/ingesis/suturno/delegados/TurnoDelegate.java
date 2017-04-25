package co.edu.uniquindio.ingesis.suturno.delegados;

import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.ingesis.suturno.dto.ConteoClientesXServicioDTO;
import co.edu.uniquindio.ingesis.suturno.dto.EmpleandoXClientesDTO;
import co.edu.uniquindio.ingesis.suturno.negocio.TurnoEJBRemote;

/**
 * Delegado del Turno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 12/04/2017
 *
 */
public class TurnoDelegate {
	/**
	 * Variable que representa el TurnoEJBRemote
	 */
	private TurnoEJBRemote turnoEJB;

	/**
	 * Variable que representa la instancia del delegado
	 */
	private static final TurnoDelegate instancia = new TurnoDelegate();

	/**
	 * Constructor del TurnoDelegate
	 */
	private TurnoDelegate() {
		try {
			turnoEJB = (TurnoEJBRemote) new InitialContext().lookup(TurnoEJBRemote.JNDI);
		} catch (NamingException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Cantidad de Turnos Atendidos por un Empleado especifico en determinada
	 * Fecha
	 * 
	 * @param empleadoId
	 * @param fInicio
	 * @param fFin
	 * @return
	 */
	public int cantTurnosAtendidosEmpleado(int empleadoId, Date fInicio, Date fFin) {
		return turnoEJB.cantTurnosAtendidosEmpleado(empleadoId, fInicio, fFin);
	}

	/**
	 * Turnos Atendidos por Empleado en determinda fecha
	 * 
	 * @param fInicio
	 * @param fFin
	 * @return
	 */
	public List<EmpleandoXClientesDTO> turnosAtendidosEmpleado(Date fInicio, Date fFin) {
		return turnoEJB.turnosAtendidosEmpleado(fInicio, fFin);
	}

	/**
	 * Retorna Cantidad de Clientes que solicitan determinando Servicio
	 * 
	 * @param servicioId
	 * @return
	 */
	public int cantClientesSolicitanServicio(Long servicioId) {
		return turnoEJB.cantClientesSolicitanServicio(servicioId);
	}

	/**
	 * permite determinar que clientes tienen turnos que aún no han sido
	 * atendidos
	 * 
	 * @return
	 */
	public List<ConteoClientesXServicioDTO> clientesXServicioSolicitado() {
		return turnoEJB.clientesXServicioSolicitado();
	}

	/**
	 * Metodo get de la instancia del TurnoDelegate
	 * 
	 * @return instancia la instancia del TurnoDelegate
	 */
	public static TurnoDelegate getInstancia() {
		return instancia;
	}

}
