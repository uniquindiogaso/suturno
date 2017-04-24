
package co.edu.uniquindio.ingesis.suturno.delegados;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.negocio.GeografiaEJBRemote;

/**
 * Delegado de la ciudad y el departamento
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 12/04/2017
 */
public class GeografiaDelegate {

	/**
	 * Variable que representa el GeografiaERBRemote
	 */
	private GeografiaEJBRemote geografiaEJB;

	/**
	 * Variable que representa la instancia del GeografiaDelegate
	 */
	private static final GeografiaDelegate instancia = new GeografiaDelegate();

	/**
	 * Metodo Constructor del GeografiaDelegate
	 */
	private GeografiaDelegate() {
		try {
			geografiaEJB = (GeografiaEJBRemote) new InitialContext().lookup(GeografiaEJBRemote.JNDI);
			System.out.println("Delegate: " + geografiaEJB);
			System.out.println("Lista: " + geografiaEJB.listarDepartamentos().size());
		} catch (NamingException e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}

	/**
	 * Listar Todas los Departamentos Disponibles
	 * 
	 * @return Lista de Departamentos
	 */
	public List<Depto> listarDepartamentos() {
		return geografiaEJB.listarDepartamentos();
	}

	/**
	 * Listado de Ciudades por Departamento
	 * 
	 * @param dpto
	 *            departanto del cual se quiere filtrar los municipios
	 *            disponibles
	 * @return lista de Ciudades del Dpto seleccionado
	 */
	public List<Ciudad> listarCiudades(Depto dpto) {
		return geografiaEJB.listarCiudades(dpto);
	}

	/**
	 * Metodo get de la instancia del GeografiaDelegate
	 * 
	 * @return instancia la instancia del GeografiaDelegate
	 */
	public static GeografiaDelegate getInstancia() {
		return instancia;
	}

}
