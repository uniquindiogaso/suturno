package co.edu.uniquindio.ingesis.suPersona.entidades;

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

@RunWith(Arquillian.class)
public class PersonaTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Persona.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/cliente.json", "datos/empleado.json", "datos/Persona.json", "datos/Persona.json" })
	public void findTest() {
		Persona persona = entityManager.find(Persona.class, 1);
		Assert.assertEquals("1", persona.getId());
	}

	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/ciudad.json", "datos/empleado.json", "datos/persona.json" })
	public void persistTest() {
		
		Persona p1 = entityManager.find(Persona.class, 1);
		Persona p2 = entityManager.find(Persona.class, 2);
		
		Persona persona = new Persona();
		persona.setId(3);
		persona.setActivo(1);
		persona.setApellido1("Marín");
		persona.setApellido2("Perez");
		persona.setDir("Granada");
		persona.setEmail("saramarin@gmail.com");
		persona.setGenero("femenino");
		persona.setIdentificacion("9574136672");
		persona.setNombre1("Sara");
		persona.setNombre2();
		persona.setTDoc("Tarjeta de Identidad");
		persona.setTel1("3206842320")
		persona.setTel2("7452310");
		persona.setCiudad_id("1");
		persona.setEmpleado_id("12345");
		
		entityManager.persist(persona);

		Persona registrado = entityManager.find(Persona.class, persona.getId());
		Assert.assertEquals(persona, registrado);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/ciudad.json", "datos/empleado.json", "datos/persona.json" })
	public void updateTest() {

		Persona persona = entityManager.find(Persona.class, 4);

		Persona.setCodigo("1");

//		entityManager.persist(quindio);

		Persona registrado = entityManager.find(Persona.class, persona.getId());
		Assert.assertEquals("11", registrado.getCodigo());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/ciudad.json", "datos/empleado.json", "datos/persona.json"  })
	public void deleteTest(){
		
		Persona persona = entityManager.find(Persona.class, 2);
		
		entityManager.remove(persona);
		
		Persona registrado = entityManager.find(Persona.class, persona.getId());
		Assert.assertNull(registrado);
	}
}