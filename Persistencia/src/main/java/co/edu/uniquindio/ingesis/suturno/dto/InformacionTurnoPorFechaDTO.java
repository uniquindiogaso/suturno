/**
 * 
 */
package co.edu.uniquindio.ingesis.suturno.dto;

/**
 * @author gusta
 *
 */
public class InformacionTurnoPorFechaDTO {
	
	private int turnoId;
	private String servicioNombre;
	private String clienteIdentificacion;
	private String clienteNombre;
	private String clienteEmail;
	
	/**
	 * 
	 */
	public InformacionTurnoPorFechaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param turnoId
	 * @param servicioNombre
	 * @param clienteIdentificacion
	 * @param clienteNombre
	 * @param clienteEmail
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
	 * @return the turnoId
	 */
	public int getTurnoId() {
		return turnoId;
	}

	/**
	 * @param turnoId the turnoId to set
	 */
	public void setTurnoId(int turnoId) {
		this.turnoId = turnoId;
	}

	/**
	 * @return the servicioNombre
	 */
	public String getServicioNombre() {
		return servicioNombre;
	}

	/**
	 * @param servicioNombre the servicioNombre to set
	 */
	public void setServicioNombre(String servicioNombre) {
		this.servicioNombre = servicioNombre;
	}

	/**
	 * @return the clienteIdentificacion
	 */
	public String getClienteIdentificacion() {
		return clienteIdentificacion;
	}

	/**
	 * @param clienteIdentificacion the clienteIdentificacion to set
	 */
	public void setClienteIdentificacion(String clienteIdentificacion) {
		this.clienteIdentificacion = clienteIdentificacion;
	}

	/**
	 * @return the clienteNombre
	 */
	public String getClienteNombre() {
		return clienteNombre;
	}

	/**
	 * @param clienteNombre the clienteNombre to set
	 */
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	/**
	 * @return the clienteEmail
	 */
	public String getClienteEmail() {
		return clienteEmail;
	}

	/**
	 * @param clienteEmail the clienteEmail to set
	 */
	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}
	
	

}
