package co.edu.uniquindio.ingesis.suturno.dto;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;

public class EmpleadoMaxTurnoDTO {
	
	private Long cantTurnos;
	private Empleado empleado;

	public EmpleadoMaxTurnoDTO() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param cantTurnos
	 * @param empleado
	 */
	public EmpleadoMaxTurnoDTO(Long cantTurnos, Empleado empleado) {
		super();
		this.cantTurnos = cantTurnos;
		this.empleado = empleado;
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



	/**
	 * @return the cantTurnos
	 */
	public Long getCantTurnos() {
		return cantTurnos;
	}

	/**
	 * @param cantTurnos the cantTurnos to set
	 */
	public void setCantTurnos(Long cantTurnos) {
		this.cantTurnos = cantTurnos;
	}

		
	
	

}
