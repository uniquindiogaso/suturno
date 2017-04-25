package co.edu.uniquindio.ingesis.suturno.dto;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;

public class EmpleandoXClientesDTO {
	
	private Empleado empleado;
	private int cant;

	public EmpleandoXClientesDTO() {
			
	}

	/**
	 * @param empleado
	 * @param cant
	 */
	public EmpleandoXClientesDTO(Empleado empleado, int cant) {
		super();
		this.empleado = empleado;
		this.cant = cant;
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
	 * @return the cant
	 */
	public int getCant() {
		return cant;
	}

	/**
	 * @param cant the cant to set
	 */
	public void setCant(int cant) {
		this.cant = cant;
	}
	
	

}
