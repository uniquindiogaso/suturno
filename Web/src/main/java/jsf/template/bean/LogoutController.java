package jsf.template.bean;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.inject.Named;


/**
 * Invalida sesión actual y redirige a la página de inicio de sesión.
 *
 * @author  ova / last modified by $Author: ova $
 * @version $Revision: 97278 $
 */
@Named
@RequestScoped
public class LogoutController {

    public String logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();

        return "/views/logout.xhtml";
    }
}
