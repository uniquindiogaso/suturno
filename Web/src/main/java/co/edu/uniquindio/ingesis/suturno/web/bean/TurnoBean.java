package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;
import co.edu.uniquindio.ingesis.suturno.negocio.TurnoEJB;
import co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno;

/**
 * Bean de control componente de turnos para aplicacion suturno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 06/05/2017
 * @version 1.0
 *
 */
@ManagedBean
@ViewScoped
public class TurnoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Turno seleccionado en la lista que procede a realizar una accion
	 */
	private Turno turnoSeleccionado;
	/**
	 * Acceso a componentes de consulta/persistencia en Base de datos
	 */
	@EJB
	private TurnoEJB turnoEJB;
	
	/**
	 * Usuario del Sistema que realiza el registro del Turno
	 */
	private Empleado empleado;

	public TurnoBean() {		
	}
	
	/**
	 * Obtener los Turnos que puede atender un Empleado
	 * @param e Empleado autenticado 
	 * @return Listado de Turnos que puede atender
	 */
	public List<Turno> obtenerTurnosPendientes(Empleado e){
		System.out.println("turnos para " + e.getUsuario());
		List<Turno> t = turnoEJB.turnosDisponibles(e);
		System.out.println("Turnos sin atender " + t.size());
		return turnoEJB.turnosDisponibles(e);
	}
	
	/**
	 * Metodo que dispara la accion de cambio
	 *  de estado a En Atencion ; registrando la informacion del usuario que realiza dicha
	 *  actividad.
	 * @param e Empleado que inicia la atencion del turno
	 */
	public void inicarAtencionTurno(Empleado e){
		if( turnoSeleccionado != null ){
			System.out.println("Iniciando Atencion ...");
			turnoSeleccionado.setEstado(EstadoTurno.EN_ATENCION);
			turnoSeleccionado.setEmpleado(e);
			turnoEJB.actualizarTurno(turnoSeleccionado);
			System.out.println("Iniciando Atencion ..." + turnoSeleccionado);
		}
		
	}
	/**
	 * Finalizacion del Turno: Pone el turno 
	 * en estado finalizado siendo esto un estado de exito dentro de la 
	 * atencion del turno
	 */
	public void finalizarAtencionTurno(){
	
		if( turnoSeleccionado != null ){
			turnoSeleccionado.setEstado(EstadoTurno.FINALIZADO);
			turnoEJB.actualizarTurno(turnoSeleccionado);
			turnoSeleccionado = null;
			
		}else{
			System.out.println("Turno Seleccionado para F esta vacio ");
		}
	}
	
	/**
	 * Revertir la atencion y volverla a poner en espera.
	 * @param actionEvent
	 */
	public void anularAtencionTurno(){
		if( turnoSeleccionado != null ){
			turnoSeleccionado.setEmpleado(null);
			turnoSeleccionado.setEstado(EstadoTurno.EN_ESPERA);
			turnoSeleccionado.setNota(null);
			turnoEJB.actualizarTurno(turnoSeleccionado);
			turnoSeleccionado = null;
		}
	}
	
	/**
	 * Cambiar de estado el Turno a Cancelado
	 * Esto ocurre cuando el Cliente por algun motivo abandona la consulta 
	 * que iba a realizar.
	 * @param actionEvent
	 */
	public void cancelarTurno(ActionEvent actionEvent){
		if( turnoSeleccionado != null ){
			turnoSeleccionado.setEstado(EstadoTurno.CANCELADO);
			turnoEJB.actualizarTurno(turnoSeleccionado);
		}
	}

	/**
	 * @return the turnoSeleccionado
	 */
	public Turno getTurnoSeleccionado() {
		return turnoSeleccionado;
	}

	/**
	 * @param turnoSeleccionado the turnoSeleccionado to set
	 */
	public void setTurnoSeleccionado(Turno turnoSeleccionado) {
		this.turnoSeleccionado = turnoSeleccionado;
	}


	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	
	
	
	
	

}
