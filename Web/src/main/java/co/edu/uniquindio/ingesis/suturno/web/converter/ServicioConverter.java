package co.edu.uniquindio.ingesis.suturno.web.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.negocio.ServiciosEJB;

/**
 * Converter para Servicios
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 06/05/2017
 * @version 1.0
 *
 */
@ManagedBean
public class ServicioConverter implements Converter{

	@EJB
	private ServiciosEJB serviciosEJB;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String id) {
		if (id != null && !"".equals(id.trim())) {
			try {
				
				Servicio servicio = serviciosEJB.buscarServicioPorNombre(id);
				System.out.println("SERVICIO:"+servicio + " nombre "+id) ;
				return servicio;
			} catch (Exception e) {
				e.printStackTrace();
				throw new ConverterException(
						new FacesMessage("ERROR:" + componente.getId() + ": No se pudo convertir el valor " + id));
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object servicio) {
		if (servicio != null) {
			return ((Servicio) servicio).getNombre();
		}
		return null;
	}

}