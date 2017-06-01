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
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;

/**
 * EJB encargado de realizar la capa de negocio del turno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 17/04/2017
 * @version 1.0
 */
@Stateless
@LocalBean
public class TurnoEJB implements TurnoEJBRemote {
	
	/**
	 * Variable que representa el entityManager del EmpleadoEJB
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo constructor por defecto
	 */
    public TurnoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Cantidad de Turnos Atendidos por un Empleado especifico en determinada Fecha
     * @param empleadoId id del empleado
     * @param fInicio fecha de inicio de los turnos
     * @param fFin fecha final de los turnos
     * @return lista de turnos
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
     * @param fInicio fecha de inicio de los turnos
     * @param fFin fecha final de los turnos
     * @return lista de turnos
     */
    public List<EmpleandoXClientesDTO> turnosAtendidosEmpleado(Date fInicio , Date fFin){
    	TypedQuery<EmpleandoXClientesDTO> query = entityManager.createNamedQuery(Turno.TURNOS_ATENDIDOS_EMPLEADO_ENTRE_FECHAS_AGRUPADA, EmpleandoXClientesDTO.class);	
    	query.setParameter("fechaInicio", fInicio);
    	query.setParameter("fechaFin", fFin);   
    	return query.getResultList();
    }
    
    /**
     * Retorna Cantidad de Clientes que solicitan determinando Servicio
     * @param servicioId id del servicio
     * @return lista de turnos
     */
    public int cantClientesSolicitanServicio(Long servicioId){
    	Query query = entityManager.createNamedQuery(Turno.GET_COUNT_CLIENTES_X_SERVICIO);
    	query.setParameter("servicio", servicioId);
    	return query.getResultList().size();
    }
    
    /**
     * Permite determinar que clientes tienen turnos que aun no han sido atendidos
     * @return la lista de turnos
     */
    public List<ConteoClientesXServicioDTO> clientesXServicioSolicitado(){
    	TypedQuery<ConteoClientesXServicioDTO> query = entityManager.createNamedQuery(Turno.GET_CLIENTES_SERVICIO_AGRUPADOS, ConteoClientesXServicioDTO.class);
    	return query.getResultList();
    }
    
    /**
     * Permite determinar que turnos no ha sido atendidos por el empleado
     * @param e el empleado que no ha atendido los turnos
     * @return la lista de turnos
     */
    public List<Turno> turnosDisponibles(Empleado e){
    	TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.TURNOS_SIN_ATENDER_POR_USUARIO , Turno.class);
    	query.setParameter("empleado", e);
    	return query.getResultList();
    }
    
    /**
     * Actualiza el turno
     * @param t el turno a actualizar
     */
    public void actualizarTurno(Turno t){
    	System.out.println("Actualizar Estado para " + t.getId());
    	Turno turno = entityManager.find(Turno.class, t.getId());
    	turno.setEstado(t.getEstado());
    	turno.setEmpleado(t.getEmpleado());
    	if( null != t.getNota()){
    		turno.setNota(t.getNota());
    	}
    	entityManager.merge(turno);
    }
    
    /**
     * Returna el ultimo turno asignado al Cliente
     * @param cliente
     * @return
     */
    public Turno turnosPendientesCliente(Persona cliente){
    	TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.TURNO_X_EN_ESPERA_CLIENTE , Turno.class);
    	query.setParameter("clienteId", cliente.getId());
    	List<Turno> turnos = query.getResultList();
    	return turnos.isEmpty() ? null : turnos.get(0);
    }

}
