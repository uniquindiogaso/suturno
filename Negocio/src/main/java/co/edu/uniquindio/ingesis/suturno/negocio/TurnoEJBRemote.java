package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.dto.ConteoClientesXServicioDTO;
import co.edu.uniquindio.ingesis.suturno.dto.EmpleandoXClientesDTO;

@Remote
public interface TurnoEJBRemote {

	
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
     *  permite determinar que clientes tienen turnos que aún no han sido atendidos
     * @return
     */
    public List<ConteoClientesXServicioDTO> clientesXServicioSolicitado();
    
    
    
}
