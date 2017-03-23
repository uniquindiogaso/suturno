package co.edu.uniquindio.ingesis.suturno.dto;

import co.edu.uniquindio.ingesis.suturno.entidades.Persona;

public class CantTurnosXClienteDTO {
	
	private Long cantTurnos;
	private Persona persona;

	public CantTurnosXClienteDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cantTurnos
	 * @param persona
	 */
	public CantTurnosXClienteDTO(Long cantTurnos, Persona persona) {
		super();
		this.cantTurnos = cantTurnos;
		this.persona = persona;
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

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	

}
