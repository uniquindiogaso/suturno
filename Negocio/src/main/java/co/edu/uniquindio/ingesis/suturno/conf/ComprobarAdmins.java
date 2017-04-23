package co.edu.uniquindio.ingesis.suturno.conf;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
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
			
			System.err.println("No hay usuario administrador activo, se procede a crearlo ...");
			
			//TODO: Data la dinamica del negico; se debe de verificar si el usuario administrador ESTA INACTIVO y pasarlo a activo.		
			
			Empleado e1 = new Empleado();
			e1.setAdmin(true);
			e1.setUsuario("admin");
			e1.setClave("nimda.admin");
						
			Persona persona = new Persona();
			persona.setActivo(true);
			persona.setApellido1("Administrador");
			persona.setApellido2("");
			persona.setDir("Granada");
			persona.setEmail("admin@suturno.com");
			persona.setGenero(Genero.MASCULINO);
			persona.setIdentificacion("00000000");
			persona.setNombre1("Usuario");
			persona.settDoc(TipoDocumento.CEDULA_CUIDADANIA);
			persona.setTel1("3206842320");
			persona.setTel2("7452310");
						
			persona.setEmpleado(e1);			
			
			empleadoEJB.registrarAdministrador(persona);
			System.out.println("Usuario Administrador Registrado Correctamente...");
				
		}else{
			System.out.println("Existe Usuarios Administradores; se omite creacion de administrador ...");
		}
    }

}
