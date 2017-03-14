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

/*
 * Prueba ServicioTest
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
public class ServicioTest {

	/*
	 * Variable que representa el atributo entityManager, que es el
	 * administrador de conexiones
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
	@UsingDataSet({ "datos/servicio.json" })
	public void findTest() {
		Servicio servicio = entityManager.find(Servicio.class, 1);
		Assert.assertEquals("pago", servicio.getCodigo());
	}

	/**
	 * Metodo de prueba que verifica la insercion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json", "datos/empleado.json", "datos/turno.json" })
	public void persistTest() {

		Empleado emp1 = entityManager.find(Empleado.class, 1);
		Empleado emp2 = entityManager.find(Empleado.class, 2);

		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(emp1);
		empleados.add(emp2);

		Turno t1 = entityManager.find(Turno.class, 1);
		Turno t2 = entityManager.find(Turno.class, 2);
		Turno t3 = entityManager.find(Turno.class, 3);

		List<Turno> turnos = new ArrayList<Turno>();
		turnos.add(t1);
		turnos.add(t2);
		turnos.add(t3);

		Servicio servicio = new Servicio();

		servicio.setActivo(true);
		servicio.setCodigo("ser5");
		servicio.setNombre("Servicio5");
		servicio.setDescripcion("Nuevo servicio 5");
		servicio.setEmpleados(empleados);
		servicio.setTurnos(turnos);

		entityManager.persist(servicio);

		Servicio registrado = entityManager.find(Servicio.class, servicio.getId());
		Assert.assertEquals(servicio, registrado);

		Assert.assertTrue("Empleano no esta asociado a Servicio", registrado.getEmpleados().contains(emp2));

		Assert.assertTrue("Turno no asociado a Servicio", registrado.getTurnos().contains(t2));

	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json" })
	public void updateTest() {

		Servicio servicio = entityManager.find(Servicio.class, 4);

		servicio.setCodigo("nuevo1");

		Servicio registrado = entityManager.find(Servicio.class, servicio.getId());
		Assert.assertEquals("nuevo1", registrado.getCodigo());
	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json" })
	public void deleteTest() {

		Servicio servicio = entityManager.find(Servicio.class, 2);

		entityManager.remove(servicio);

		Servicio registrado = entityManager.find(Servicio.class, servicio.getId());
		Assert.assertNull(registrado);
	}
}
