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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CiudadTest {

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
	@UsingDataSet({ "datos/depto.json","datos/ciudad.json" })
	public void findTest() {
		Ciudad ciudad = entityManager.find(Ciudad.class, 1);
		Assert.assertEquals("Armenia", ciudad.getNombre());
	}

	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json","datos/ciudad.json" })
	public void persistTest() {

		Dpto dpto = entityManager.find(Dpto.class, 2);
		
		Ciudad ciudad = new Ciudad();
		ciudad.setId(3);
		ciudad.setCodigo("per");
		ciudad.setNombre("Pereira");
		ciudad.setDpto(dpto);

		entityManager.persist(ciudad);

		Ciudad registrado = entityManager.find(Ciudad.class, ciudad.getId());
		Assert.assertEquals(ciudad, registrado);
	}

	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json","datos/ciudad.json" })
	public void updateTest() {

		Ciudad manizales = entityManager.find(Ciudad.class, 1);

		manizales.setCodigo("Abierto");

//		entityManager.persist(manizales);

		Ciudad registrado = entityManager.find(Ciudad.class, manizales.getId());
		Assert.assertEquals(manizales.getCodigo(), registrado.getCodigo());
		
		Ciudad rusia=new Ciudad();
		
		
	}

	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json","datos/ciudad.json" })
	public void deleteTest(){
		
		Ciudad manizales = entityManager.find(Ciudad.class, 1);
		
		entityManager.remove(manizales);
		
		Ciudad registrado = entityManager.find(Ciudad.class, manizales.getId());
		Assert.assertNull(registrado);
	}
}