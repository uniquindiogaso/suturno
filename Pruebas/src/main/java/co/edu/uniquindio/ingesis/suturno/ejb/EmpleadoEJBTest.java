package co.edu.uniquindio.ingesis.suturno.ejb;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.negocio.EmpleadoEJB;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;


/**
 * Prueba EmpleadoEJBTest
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 1/03/2017
 */
@RunWith(Arquillian.class)
public class EmpleadoEJBTest {

	/**
	 * Variable que representa el atributo entityManager, que es el administrador de conexiones
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	@EJB
	private EmpleadoEJB empleadoEJB;
	
	

	/**
	 * Metodo estatico que permite identificar en que paquete se corre la prueba
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(EmpleadoEJB.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	/**
	 * Metodo de prueba que verifica la busqueda de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json" })
	public void registrarEmpleado() {
		
//		Persona partner1 = new Persona("111111",TipoDocumento.CEDULA_CUIDADANIA,"Gustavo","Adolfo","Salgado","Ocampo", "mi@gaso.com"); 
//		partner1.setGenero(Genero.MASCULINO);
//		partner1.setActivo(true);
		
		Persona persona = entityManager.find(Persona.class, 1);
		
		Empleado e1 = new Empleado();
		e1.setTercero(persona);
		e1.setAdmin(true);
		e1.setUsuario("gaso");
		e1.setClave(");(/&%$#!");
	
		
		try {
			empleadoEJB.registrarEmpleado(e1);		
		
		} catch (Exception e) {			
			throw new RuntimeException("Error Registrando Empleado " + e.getMessage());
		}
	}

}