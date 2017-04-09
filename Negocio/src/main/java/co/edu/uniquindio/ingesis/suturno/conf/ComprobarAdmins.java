package co.edu.uniquindio.ingesis.suturno.conf;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJB;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

/**
 * Session Bean implementation class ComprobarAdmins
 */
@Singleton
@LocalBean
@Startup
public class ComprobarAdmins {

	@PersistenceContext
	private EntityManager entityManager;
	
	@EJB
	private EmpleadoEJB empleadoEJB;
	
    /**
     * Default constructor. 
     */
    public ComprobarAdmins() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void checkAdmins(){
    	Query query = entityManager.createNamedQuery(Empleado.GET_CANT_ADMINS,Empleado.class);		

		//Comprobar Cantidad de Administradores en Base de datos
		if ( 0 == (Long) query.getSingleResult()){
			
			System.out.println("No hay usuario administrador activo, se procede a crearlo ...");
			
			//TODO: Data la dinamica del negico; se debe de verificar si el usuario administrador ESTA INACTIVO y pasarlo a activo.		
					
			Persona partner1 = new Persona("0",TipoDocumento.CEDULA_CUIDADANIA,"Usuario","","","Administrador", "admin@suturno.com"); 
			partner1.setGenero(Genero.MASCULINO);
			partner1.setActivo(true);
			
						
			Empleado e1 = new Empleado();
			e1.setTercero(partner1);
			e1.setAdmin(true);
			e1.setUsuario("admin");
			e1.setClave("nimda.admin");
			
//			try {
//				empleadoEJB.registrarEmpleado(e1);		
//			
//			} catch (Exception e) {			
//				throw new RuntimeException("Error Registrando Empleado " + e.getMessage());
//			}
			
		}else{
			System.out.println("Existe Usuarios Administradores; se omite creacion de administrador ...");
		}
    }

}
