package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Turno;
import co.edu.uniquindio.ingesis.suturno.negocio.TurnoEJB;
import co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno;

@ManagedBean
public class TurnoBean {
	
	private Turno turnoSeleccionado;
	@EJB
	private TurnoEJB turnoEJB;
	
	private String observacion;
	private Empleado empleado;

	public TurnoBean() {		
	}
	
	public List<Turno> obtenerTurnosPendientes(Empleado e){
		System.out.println("turnos para " + e.getUsuario());
		List<Turno> t = turnoEJB.turnosDisponibles(e);
		System.out.println("Turnos sin atender " + t.size());
		return turnoEJB.turnosDisponibles(e);
	}
	
	public void inicarAtencionTurno(Empleado e){
		if( turnoSeleccionado != null ){
			System.out.println("Iniciando Atencion ...");
			turnoSeleccionado.setEstado(EstadoTurno.EN_ATENCION);
			turnoSeleccionado.setEmpleado(e);
			turnoEJB.actualizarTurno(turnoSeleccionado);
		}
		
	}
	
	public void finalizarAtencionTurno(){
		
		System.out.println("Turno Seleccionado para FINALIZAR ");
		
		if( turnoSeleccionado != null ){
			turnoSeleccionado.setEstado(EstadoTurno.FINALIZADO);
			turnoEJB.actualizarTurno(turnoSeleccionado);
		}
	}
	
	/**
	 * Revertir la atencion y volverla a poner en espera.
	 * @param actionEvent
	 */
	public void anularAtencionTurno(ActionEvent actionEvent){
		if( turnoSeleccionado != null ){
			turnoSeleccionado.setEmpleado(null);
			turnoSeleccionado.setEstado(EstadoTurno.EN_ESPERA);
			turnoEJB.actualizarTurno(turnoSeleccionado);
		}
	}
	
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
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
