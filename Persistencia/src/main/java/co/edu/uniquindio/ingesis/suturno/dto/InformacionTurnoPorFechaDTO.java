
package co.edu.uniquindio.ingesis.suturno.dto;

/**
 * DTO InformaciónTurnoPorFecha
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 20/03/2017
 */
public class InformacionTurnoPorFechaDTO {

	/**
	 * Variable que representa el atributo id del Turno
	 */
	private int turnoId;
	/**
	 * Variable que representa el atributo nombre del Servicio
	 */
	private String servicioNombre;
	/**
	 * Variable que representa el atributo identificacion del cliente
	 */
	private String clienteIdentificacion;
	/**
	 * Variable que representa el atributo nombre del cliente
	 */
	private String clienteNombre;
	/**
	 * Variable que representa el atributo email del cliente
	 */
	private String clienteEmail;

	/**
	 * Metodo constructor vacio del DTO InformacionTurnoPorFecha
	 */
	public InformacionTurnoPorFechaDTO() {

	}

	/**
	 * Metodo constructor del DTO InformacionTurnoPorFecha
	 * 
	 * @param turnoId
	 *            el id del turno
	 * @param servicioNombre
	 *            el nombre del servicio
	 * @param clienteIdentificacion
	 *            la cedula o identificacion del cliente
	 * @param clienteNombre
	 *            el nombre del cliente
	 * @param clienteEmail
	 *            el email del cliente
	 */
	public InformacionTurnoPorFechaDTO(int turnoId, String servicioNombre, String clienteIdentificacion,
			String clienteNombre, String clienteEmail) {
		super();
		this.turnoId = turnoId;
		this.servicioNombre = servicioNombre;
		this.clienteIdentificacion = clienteIdentificacion;
		this.clienteNombre = clienteNombre;
		this.clienteEmail = clienteEmail;
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 * 
	 * @return turnoId el identificador de la entidad Turno
	 */
	public int getTurnoId() {
		return turnoId;
	}

	/**
	 * Metodo que permite asignar un valor al atributo id
	 * 
	 * @param turnoId
	 *            el identificador de la entidad Turno
	 */
	public void setTurnoId(int turnoId) {
		this.turnoId = turnoId;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre del servicio
	 * 
	 * @return servicioNombre el nombre del servicio
	 */
	public String getServicioNombre() {
		return servicioNombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre del servicio
	 * 
	 * @param servicioNombre
	 *            el nombre del servicio
	 */
	public void setServicioNombre(String servicioNombre) {
		this.servicioNombre = servicioNombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo identificacion del
	 * cliente
	 * 
	 * @return clienteIdentificacion el numero de identificacion del cliente
	 */
	public String getClienteIdentificacion() {
		return clienteIdentificacion;
	}

	/**
	 * Metodo que permite asignar un valor al atributo identificacion del
	 * cliente
	 * 
	 * @param clienteIdentificacion
	 *            el numero de identificacion del cliente
	 */
	public void setClienteIdentificacion(String clienteIdentificacion) {
		this.clienteIdentificacion = clienteIdentificacion;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre del cliente
	 * 
	 * @return clienteNombre el nombre del cliente
	 */
	public String getClienteNombre() {
		return clienteNombre;
	}

	/**
	 * Metodo que permite asignar un valor al atributo nombre del cliente
	 * 
	 * @param clienteNombre
	 *            el nombre del cliente
	 */
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo email del cliente
	 * 
	 * @return clienteEmail el correo electrónico del cliente
	 */
	public String getClienteEmail() {
		return clienteEmail;
	}

	/**
	 * Metodo que permite asignar un valor al atributo email del cliente
	 * 
	 * @param clienteEmail
	 *            el correo electrónico del cliente
	 */
	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}

}
