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

@ManagedBean
@ViewScoped
public class TurnoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Turno turnoSeleccionado;
	@EJB
	private TurnoEJB turnoEJB;
	

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
			System.out.println("Iniciando Atencion ..." + turnoSeleccionado);
		}
		
	}
	
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
