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

@RunWith(Arquillian.class)
public class DeptoTest {

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
	@UsingDataSet({ "datos/depto.json" })
	//@Ignore
	public void findTest() {
		Dpto dpto = entityManager.find(Dpto.class, 1);
		Assert.assertEquals("Quindio", dpto.getNombre());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json" })
	public void persistTest() {
		
		Ciudad c1 = entityManager.find(Ciudad.class, 1);
		Ciudad c2 = entityManager.find(Ciudad.class, 2);
		
		List<Ciudad> ciudades = new ArrayList<>();
		ciudades.add(c1);
		ciudades.add(c2);

		Dpto dpto = new Dpto();
		dpto.setId(3);
		dpto.setCodigo("AR");
		dpto.setNombre("Arauca");
		dpto.setCiudades(ciudades);

		entityManager.persist(dpto);

		Dpto registrado = entityManager.find(Dpto.class, dpto.getId());
		Assert.assertEquals(dpto, registrado);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json" })
	public void updateTest() {

		Dpto quindio = entityManager.find(Dpto.class, 1);

		quindio.setCodigo("Ayer");

//		entityManager.persist(quindio);

		Dpto registrado = entityManager.find(Dpto.class, quindio.getId());
		Assert.assertEquals("Ayer", registrado.getCodigo());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json" })
	public void deleteTest(){
		
		Dpto quindio = entityManager.find(Dpto.class, 1);
		
		entityManager.remove(quindio);
		
		Dpto registrado = entityManager.find(Dpto.class, quindio.getId());
		Assert.assertNull(registrado);
	}
}