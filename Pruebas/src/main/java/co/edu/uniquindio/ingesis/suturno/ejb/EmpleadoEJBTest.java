package co.edu.uniquindio.ingesis.suturno.ejb;

import java.util.ArrayList;
import java.util.List;

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
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.TipoCliente;
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
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json", "datos/tipocliente.json"  })
	public void registrarEmpleado() {
		

//		Ciudad armenia = entityManager.find(Ciudad.class, 1);
//
//		TipoCliente clienteGeneral = entityManager.find(TipoCliente.class, 1);
//		TipoCliente clienteMayor = entityManager.find(TipoCliente.class, 2);
//
//		List<TipoCliente> tipoClient = new ArrayList<TipoCliente>();
//
//		tipoClient.add(clienteGeneral);
//		tipoClient.add(clienteMayor);

		Persona persona = new Persona();
		persona.setId(new Long("1"));
		persona.setActivo(true);
		persona.setApellido1("Marin");
		persona.setApellido2("Perez");
		persona.setDir("Granada");
		persona.setEmail("saramarin@gmail.com");
		persona.setGenero(Genero.FEMENINO);
		persona.setIdentificacion("9574136672");
		persona.setNombre1("Sara");
		persona.settDoc(TipoDocumento.TARJETA_IDENTIDAD);
		persona.setTel1("3206842320");
		persona.setTel2("7452310");
		//persona.setCiudad(armenia);			
		//persona.setTiposCliente(tipoClient);	
		
		Empleado e1 = new Empleado();
		e1.setAdmin(true);
		e1.setUsuario("gaso");
		e1.setClave(");(/&%$#!");
		
		persona.setEmpleado(e1);
	
		
		try {
			empleadoEJB.registrarEmpleado(persona);		
		
		} catch (Exception e) {			
			throw new RuntimeException("Error Registrando Empleado " + e);
		}
	}

}