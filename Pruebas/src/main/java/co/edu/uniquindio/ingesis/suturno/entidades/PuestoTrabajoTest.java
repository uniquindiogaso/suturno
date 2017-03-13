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

/*
 * Prueba PuestoTrabajoTest
 * 
 * @author Gustavo Salgado y Laura Julieth Rúa
 * 
 * @author Ingeniería de Sistemas y Computación
 * 
 * @author Universidad del Quindío
 * 
 * @version 1.0
 * 
 * @since 1/03/2017
 */
@RunWith(Arquillian.class)
public class PuestoTrabajoTest {

	@PersistenceContext
	private EntityManager entityManager;

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
	@UsingDataSet({ "datos/puestotrabajo.json" })
	public void findTest() {
		PuestoTrabajo puesto = entityManager.find(PuestoTrabajo.class, 3);
		Assert.assertEquals("Puesto3", puesto.getNombre());
	}

	/**
	 * Metodo de prueba que verifica la insercion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestotrabajo.json" })
	public void persistTest() {

		PuestoTrabajo p1 = entityManager.find(PuestoTrabajo.class, 1);
		PuestoTrabajo p2 = entityManager.find(PuestoTrabajo.class, 2);

		PuestoTrabajo puesto = new PuestoTrabajo();
		puesto.setId(4);
		puesto.setCodigo("A104");
		puesto.setNombre("Puesto4");

		entityManager.persist(puesto);

		PuestoTrabajo registrado = entityManager.find(PuestoTrabajo.class, puesto.getId());
		Assert.assertEquals(puesto, registrado);
	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestotrabajo.json" })
	public void updateTest() {

		PuestoTrabajo puesto = entityManager.find(PuestoTrabajo.class, 2);

		puesto.setCodigo("A111");

		PuestoTrabajo registrado = entityManager.find(PuestoTrabajo.class, puesto.getId());
		Assert.assertEquals("A111", registrado.getCodigo());
	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestotrabajo.json" })
	public void deleteTest() {

		PuestoTrabajo puesto = entityManager.find(PuestoTrabajo.class, 2);

		entityManager.remove(puesto);

		PuestoTrabajo registrado = entityManager.find(PuestoTrabajo.class, puesto.getId());
		Assert.assertNull(registrado);
	}
}