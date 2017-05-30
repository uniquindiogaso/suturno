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

@ManagedBean
public class ServicioConverter implements Converter{

	@EJB
	private ServiciosEJB serviciosEJB;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String id) {
		if (id != null && !"".equals(id.trim())) {
			try {
				//String nombreServicio=String.valueOf(id);
				//Integer idServicio = Integer.parseInt(id);
				//return serviciosEJB.buscarServicioPorNombre(idServicio);
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
			return ((Servicio) servicio).getId().toString();
		}
		return null;
	}

}
