package co.edu.uniquindio.ingesis.suturno.dto;

import co.edu.uniquindio.ingesis.suturno.entidades.Persona;

/**
 * DTO CantTurnosXCliente
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 22/03/2017
 */
public class CantTurnosXClienteDTO {
	
	/**
	 * Variable que representa el atributo cantTurnos de Turno
	 */
	private Long cantTurnos;
	/**
	 * Variable que representa el atributo persona de Persona
	 */
	private Persona persona;

	/**
	 * Metodo constructor vacio del DTO CantTurnosXCliente
	 */
	public CantTurnosXClienteDTO() {
	}

	/** Metodo constructor del DTO CantTurnosXCliente
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
