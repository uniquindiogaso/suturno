package co.edu.uniquindio.ingesis.suturno.entidades;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

import co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

/**
 * Prueba TurnoTest
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 1/03/2017
 */
@RunWith(Arquillian.class)
public class TurnoTest {

	/**
	 * Variable que representa el atributo entityManager, que es el
	 * administrador de conexiones
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
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
	@UsingDataSet({ "datos/persona.json", "datos/empleado.json", "datos/turno.json" })
	public void findTest() {
		Turno turno = entityManager.find(Turno.class, 1);
		Assert.assertEquals(1, turno.getId());
	}

	/**
	 * Metodo de prueba que verifica la insercion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/persona.json", "datos/empleado.json", "datos/turno.json", "datos/servicio.json" })
	public void persistTest() {

		Servicio nuevoServi = entityManager.find(Servicio.class, 3);
		Persona cliente = entityManager.find(Persona.class, 3);
		Empleado thomas = entityManager.find(Empleado.class, 2);

		Turno turno = new Turno();
		turno.setId(4);
		turno.setEstado(EstadoTurno.EN_ESPERA);
		turno.setFecha(new Timestamp(new Date().getTime()));
		turno.setNota("Nuevo Turno");
		turno.setServicio(nuevoServi);
		turno.setEmpleado(thomas);
		turno.setCliente(cliente);

		entityManager.persist(turno);

		Turno registrado = entityManager.find(Turno.class, turno.getId());
		Assert.assertEquals(turno, registrado);

		Assert.assertTrue("Servicio no corresponde con el registrado",
				registrado.getServicio().getNombre().equals(nuevoServi.getNombre()));

		Assert.assertNotNull("Debe seleccionar un Cliente", registrado.getCliente());

		Assert.assertNotNull("Debe seleccionar un Empleado que va a atender solicitud", registrado.getEmpleado());
	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/persona.json", "datos/empleado.json", "datos/turno.json" })
	public void updateTest() {

		Turno turno = entityManager.find(Turno.class, 3);

		turno.setNota("Cambiar servicio");

		Turno registrado = entityManager.find(Turno.class, turno.getId());
		Assert.assertEquals("Cambiar servicio", registrado.getNota());
	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/persona.json", "datos/empleado.json", "datos/turno.json" })
	public void deleteTest() {

		Turno turno = entityManager.find(Turno.class, 2);

		entityManager.remove(turno);

		Turno registrado = entityManager.find(Turno.class, turno.getId());
		Assert.assertNull(registrado);
	}

	/**
	 * Metodo de prueba que verifica cuantos turnos tiene un cliente
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json", "datos/tipocliente.json",
			"datos/turno.json" })
	public void saberCantidadTurnosCliente() {

		Persona cliente = entityManager.find(Persona.class, 3);

		TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.GET_TURNOS_CLIENTE, Turno.class);
		query.setParameter("clienteId", cliente.getId());

		int cantTurnos = query.getResultList().size();

		Assert.assertEquals("Se espera obtener la cantidad de turnos que tiene el cliente", cantTurnos, 2);
	}
	
	/**
	 * Metodo de prueba que verifica cuantos turnos tiene un empleado
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json", "datos/tipocliente.json",
			"datos/turno.json" })
	public void saberCantidadTurnosEmpleado() {

		Empleado empleado = entityManager.find(Empleado.class, 2);

		TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.GET_TURNOS_EMPLEADO, Turno.class);
		query.setParameter("empleadoId", empleado.getId());

		int cantTurnos = query.getResultList().size();

		Assert.assertEquals("Se espera obtener la cantidad de turnos que tiene el empleado.", cantTurnos, 2);
	}
}