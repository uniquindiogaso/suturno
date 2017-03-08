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
public class TurnoTest {

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
	@UsingDataSet({ "datos/cliente,json", "datos/empleado.json", "datos/Turno.json", "datos/Turno.json" })
	public void findTest() {
		Turno turno = entityManager.find(Turno.class, 1);
		Assert.assertEquals("1", turno.getId());
	}

	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/cliente,json", "datos/empleado.json", "datos/Turno.json", "datos/Turno.json" })
	public void persistTest() {
		
		Turno t1 = entityManager.find(Turno.class, 1);
		Turno t2 = entityManager.find(Turno.class, 2);
		
		Turno Turno = new Turno();
		Turno.setId(4);
		Turno.setEstado(1);
		Turno.setFecha(12/03/2017);
		Turno.setNota("Nuevo Turno");

		entityManager.persist(Turno);

		Turno registrado = entityManager.find(Turno.class, Turno.getId());
		Assert.assertEquals(Turno, registrado);
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/cliente,json", "datos/empleado.json", "datos/Turno.json", "datos/Turno.json" })
	public void updateTest() {

		Turno Turno = entityManager.find(Turno.class, 4);

		Turno.setCodigo("1");

//		entityManager.persist(quindio);

		Turno registrado = entityManager.find(Turno.class, Turno.getId());
		Assert.assertEquals("11", registrado.getCodigo());
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({  "datos/cliente,json", "datos/empleado.json", "datos/Turno.json", "datos/Turno.json"  })
	public void deleteTest(){
		
		Turno turno = entityManager.find(Turno.class, 2);
		
		entityManager.remove(turno);
		
		Turno registrado = entityManager.find(Turno.class, Turno.getId());
		Assert.assertNull(registrado);
	}
}