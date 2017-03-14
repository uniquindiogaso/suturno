package co.edu.uniquindio.ingesis.suturno.entidades;


import java.util.ArrayList;
import java.util.List;

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

import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

@RunWith(Arquillian.class)
public class PersonaTest {

	/*
	 * Variable que representa el atributo entityManager, que es al administrador de conexiones
	 */
	@PersistenceContext
	private EntityManager entityManager;
	/*
	 * Metodo estatico que permite identificar en que paquete se corre la prueba
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Persona.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	/**
	 * Metodo de prueba que verifica la busqueda de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json"})
	public void findTest() {
		Persona persona = entityManager.find(Persona.class, 1);
		Assert.assertEquals(1, persona.getId());
	}

	/**
	 * Metodo de prueba que verifica la insercion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/ciudad.json", "datos/empleado.json", "datos/persona.json" , "datos/tipocliente.json"})
	public void persistTest() {
		
		Persona p1 = entityManager.find(Persona.class, 1);
		Persona p2 = entityManager.find(Persona.class, 2);
		
		Ciudad armenia = entityManager.find(Ciudad.class, 1);
		
		Assert.assertNotNull("La ciudad para el cliente no debe ser nula",armenia);
		
		
		TipoCliente clienteGeneral = entityManager.find(TipoCliente.class, 1);
		TipoCliente clienteMayor= entityManager.find(TipoCliente.class, 2);	
		
		List<TipoCliente> tipoClient = new ArrayList<TipoCliente>();
		
		tipoClient.add(clienteGeneral);
		tipoClient.add(clienteMayor); 
		
		Persona persona = new Persona();
		persona.setId(3);
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
		persona.setCiudad(armenia);
		//Esta Persona no es un Empleado por eso se deja null
		persona.setEmpleado(null);
		persona.setTiposCliente(tipoClient);
		
		
		
		entityManager.persist(persona);

		Persona registrado = entityManager.find(Persona.class, persona.getId());
		Assert.assertEquals(persona, registrado);
		
		Assert.assertTrue("Tipo Cliente no registrado", registrado.getTiposCliente().contains(clienteMayor));
	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/ciudad.json", "datos/empleado.json", "datos/persona.json" })
	public void updateTest() {

		Persona persona = entityManager.find(Persona.class, 2);

		persona.setApellido1("Perez");

		Persona registrado = entityManager.find(Persona.class, persona.getId());
		Assert.assertEquals("Perez", registrado.getApellido1());
	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/ciudad.json", "datos/empleado.json", "datos/persona.json"  })
	public void deleteTest(){
		
		Persona persona = entityManager.find(Persona.class, 2);
		
		entityManager.remove(persona);
		
		Persona registrado = entityManager.find(Persona.class, persona.getId());
		Assert.assertNull("No se encontro la Persona, no es posible eliminarla",registrado);
	}
}