package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.ingesis.suturno.dto.ConteoClientesXServicioDTO;
import co.edu.uniquindio.ingesis.suturno.dto.EmpleandoXClientesDTO;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;

/**
 * Session Bean implementation class TurnoEJB
 */
@Stateless
@LocalBean
public class TurnoEJB implements TurnoEJBRemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public TurnoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Cantidad de Turnos Atendidos por un Empleado especifico en determinada Fecha
     * @param empleadoId
     * @param fInicio
     * @param fFin
     * @return
     */
    public int cantTurnosAtendidosEmpleado(int empleadoId, Date fInicio , Date fFin){
    	
    	Query query = entityManager.createNamedQuery(Turno.TURNOS_ATENDIDOS_EMPLEADO_ENTRE_FECHAS);
    	query.setParameter("empleado", empleadoId);
    	query.setParameter("fechaInicio", fInicio);
    	query.setParameter("fechaFin", fFin);   	
    	    	
    	return query.getResultList().size();
    }
    
    /**
     * Turnos Atendidos por Empleado en determinda fecha
     * @param fInicio
     * @param fFin
     * @return
     */
    public List<EmpleandoXClientesDTO> turnosAtendidosEmpleado(Date fInicio , Date fFin){
    	TypedQuery<EmpleandoXClientesDTO> query = entityManager.createNamedQuery(Turno.TURNOS_ATENDIDOS_EMPLEADO_ENTRE_FECHAS_AGRUPADA, EmpleandoXClientesDTO.class);	
    	query.setParameter("fechaInicio", fInicio);
    	query.setParameter("fechaFin", fFin);   
    	return query.getResultList();
    }
    
    /**
     * Retorna Cantidad de Clientes que solicitan determinando Servicio
     * @param servicioId
     * @return
     */
    public int cantClientesSolicitanServicio(Long servicioId){
    	Query query = entityManager.createNamedQuery(Turno.GET_COUNT_CLIENTES_X_SERVICIO);
    	query.setParameter("servicio", servicioId);
    	return query.getResultList().size();
    }
    
    /**
     *  permite determinar que clientes tienen turnos que aún no han sido atendidos
     * @return
     */
    public List<ConteoClientesXServicioDTO> clientesXServicioSolicitado(){
    	TypedQuery<ConteoClientesXServicioDTO> query = entityManager.createNamedQuery(Turno.GET_CLIENTES_SERVICIO_AGRUPADOS, ConteoClientesXServicioDTO.class);
    	return query.getResultList();
    }
    
    
    public List<Turno> turnosDisponibles(Empleado e){
    	TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.TURNOS_SIN_ATENDER_POR_USUARIO , Turno.class);
    	query.setParameter("empleado", e);
    	return query.getResultList();
    }
    
    public void actualizarTurno(Turno t){
    	entityManager.merge(t);
    }

}
