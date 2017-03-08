package co.edu.uniquindio.ingesis.suturno.entidades;

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
public class ServicioTest {

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
	@UsingDataSet({ "datos/servicio.json" })
	public void findTest() {
		Servicio servicio = entityManager.find(Servicio.class, 1);
		Assert.assertEquals("1", servicio.getClave());
	}

	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json" })
	public void persistTest() {
		
		Servicio s1 = entityManager.find(Servicio.class, 1);
		Servicio s2 = entityManager.find(Servicio.class, 2);
		
		Servicio servicio = new Servicio();
		Servicio.setId(5);
		Servicio.setActivo(1);
		Servicio.setCodigo("ser4");
		Servicio.setNombre("Servicio4");
		Servicio.setDescripcion("Nuevo servicio 4");

		entityManager.persist(servicio);

		Servicio registrado = entityManager.find(Servicio.class, Servicio.getId());
		Assert.assertEquals(Servicio, registrado);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json" })
	public void updateTest() {

		Servicio servicio = entityManager.find(Servicio.class, 4);

		Servicio.setCodigo("11");

//		entityManager.persist(quindio);

		Servicio registrado = entityManager.find(Servicio.class, Servicio.getId());
		Assert.assertEquals("11", registrado.getCodigo());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json"  })
	public void deleteTest(){
		
		Servicio servicio = entityManager.find(Servicio.class, 2);
		
		entityManager.remove(servicio);
		
		Servicio registrado = entityManager.find(Servicio.class, Servicio.getId());
		Assert.assertNull(registrado);
	}
}