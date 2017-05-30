package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.dto.ConteoClientesXServicioDTO;
import co.edu.uniquindio.ingesis.suturno.dto.EmpleandoXClientesDTO;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;

@Remote
public interface TurnoEJBRemote {

	public static final String JNDI = "java:global/EAR/Negocio-0.0.1-SNAPSHOT/TurnoEJB!co.edu.uniquindio.ingesis.suturno.negocio.TurnoEJBRemote";
	
    /**
     * Cantidad de Turnos Atendidos por un Empleado especifico en determinada Fecha
     * @param empleadoId
     * @param fInicio
     * @param fFin
     * @return
     */
    public int cantTurnosAtendidosEmpleado(int empleadoId, Date fInicio , Date fFin);
    
    /**
     * Turnos Atendidos por Empleado en determinda fecha
     * @param fInicio
     * @param fFin
     * @return
     */
    public List<EmpleandoXClientesDTO> turnosAtendidosEmpleado(Date fInicio , Date fFin);
    
    /**
     * Retorna Cantidad de Clientes que solicitan determinando Servicio
     * @param servicioId
     * @return
     */
    public int cantClientesSolicitanServicio(Long servicioId);
    
    
    /**
     * Permite determinar que clientes tienen turnos que aun no han sido atendidos
     * @return la lista de turnos
     */
    public List<ConteoClientesXServicioDTO> clientesXServicioSolicitado();
    
    
    /**
     * Permite determinar que turnos no ha sido atendidos por el empleado
     * @param e el empleado que no ha atendido los turnos
     * @return la lista de turnos
     */
    public List<Turno> turnosDisponibles(Empleado e);
    
    /**
     * Actualiza el turno
     * @param t el turno a actualizar
     */
    public void actualizarTurno(Turno t);
}