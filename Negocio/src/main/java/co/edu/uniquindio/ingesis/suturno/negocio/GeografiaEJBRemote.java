package co.edu.uniquindio.ingesis.suturno.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;

@Remote
public interface GeografiaEJBRemote {

	/**
	 * Listar Todas los Departamentos Disponibles
	 * 
	 * @return Lista de Departamentos
	 */
	public List<Depto> listarDepartamentos();

	/**
	 * Listado de Ciudades por Departamento
	 * 
	 * @param dpto
	 *            departanto del cual se quiere filtrar los municipios
	 *            disponibles
	 * @return lista de Ciudades del Dpto seleccionado
	 */
	public List<Ciudad> listarCiudades(Depto dpto);

}
