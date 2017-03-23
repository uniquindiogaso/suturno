package co.edu.uniquindio.ingesis.suturno.dto;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

public class ConteoClientesXServicioDTO {
	
	private Long cantClientes;
	private Servicio servicio;

	public ConteoClientesXServicioDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cantClientes
	 * @param servicio
	 */
	public ConteoClientesXServicioDTO(Long cantClientes, Servicio servicio) {
		super();
		this.cantClientes = cantClientes;
		this.servicio = servicio;
	}

	/**
	 * @return the cantClientes
	 */
	public Long getCantClientes() {
		return cantClientes;
	}

	/**
	 * @param cantClientes the cantClientes to set
	 */
	public void setCantClientes(Long cantClientes) {
		this.cantClientes = cantClientes;
	}

	/**
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((servicio == null) ? 0 : servicio.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConteoClientesXServicioDTO other = (ConteoClientesXServicioDTO) obj;
		if (servicio == null) {
			if (other.servicio != null)
				return false;
		} else if (!servicio.equals(other.servicio))
			return false;
		return true;
	}
	
	
	

}
