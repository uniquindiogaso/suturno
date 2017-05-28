package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class ModalControllerBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2485099815602886575L;

	public ModalControllerBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String abrirModalEmpleado(){
		System.out.println("Cual abre? ... con params");
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("/views/empleado/empleadoForm", options, null);
        
        return "";
	}

}
