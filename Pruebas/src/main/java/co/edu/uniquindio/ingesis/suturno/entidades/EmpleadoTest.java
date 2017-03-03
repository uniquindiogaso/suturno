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
public class EmpleadoTest {

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
	@UsingDataSet({ "datos/Empleado.json", "datos/empleado.json" })
	public void findTest() {
		Empleado empleado = entityManager.find(Empleado.class, 1);
		Assert.assertEquals("12345", empleado.getClave());
	}

	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/Empleado.json" })
	public void persistTest() {
		
		Empleado p1 = entityManager.find(Empleado.class, 1);
		Empleado p2 = entityManager.find(Empleado.class, 2);
		
		Empleado empleado = new Empleado();
		empleado.setId(4);
		empleado.setCodigo("A104");
		empleado.setNombre("empleado4");

		entityManager.persist(empleado);

		Empleado registrado = entityManager.find(Empleado.class, empleado.getId());
		Assert.assertEquals(empleado, registrado);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/Empleado.json" })
	public void updateTest() {

		Empleado empleado = entityManager.find(Empleado.class, 2);

		empleado.setCodigo("A111");

//		entityManager.persist(quindio);

		Empleado registrado = entityManager.find(Empleado.class, empleado.getId());
		Assert.assertEquals("A111", registrado.getCodigo());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/Empleado.json" })
	public void deleteTest(){
		
		Empleado empleado = entityManager.find(Empleado.class, 2);
		
		entityManager.remove(empleado);
		
		Empleado registrado = entityManager.find(Empleado.class, empleado.getId());
		Assert.assertNull(registrado);
	}
}