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
 * Prueba EmpleadoTest
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
public class EmpleadoTest {

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
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json" })
	public void findTest() {
		Empleado empleado = entityManager.find(Empleado.class, 1);
		Assert.assertEquals("12345", empleado.getClave());
	}

	/**
	 * Metodo de prueba que verifica la insercion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json", "datos/persona.json" })
	public void persistTest() {

		Empleado e1 = entityManager.find(Empleado.class, 1);
		Persona p2 = new Persona();

		Empleado empleado = new Empleado();
		empleado.setId(4);
		empleado.setUsuario("123456");
		empleado.setClave("qwerty");
		empleado.setTercero(p2);

		entityManager.persist(empleado);

		Empleado registrado = entityManager.find(Empleado.class, empleado.getId());
		Assert.assertEquals(empleado, registrado);
	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json" })
	public void updateTest() {

		Empleado empleado = entityManager.find(Empleado.class, 2);

		empleado.setUsuario("29803742");

		Empleado registrado = entityManager.find(Empleado.class, empleado.getId());
		Assert.assertEquals("29803742", registrado.getUsuario());
	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json" })
	public void deleteTest() {
		Empleado empleado = entityManager.find(Empleado.class, 2);

		entityManager.remove(empleado);

		Empleado registrado = entityManager.find(Empleado.class, empleado.getId());
		Assert.assertNull(registrado);
	}
}