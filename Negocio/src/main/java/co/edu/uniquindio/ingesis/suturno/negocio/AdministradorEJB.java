package co.edu.uniquindio.ingesis.suturno.negocio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AdministradorEJB
 */
@Stateless
@LocalBean
public class AdministradorEJB implements AdministradorEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public AdministradorEJB() {
        // TODO Auto-generated constructor stub
    }

}
