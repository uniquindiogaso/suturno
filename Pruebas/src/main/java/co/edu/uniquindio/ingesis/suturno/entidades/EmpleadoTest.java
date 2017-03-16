package co.edu.uniquindio.ingesis.suturno.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

/**
 * Prueba EmpleadoTest
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
public class EmpleadoTest {

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
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json", "datos/persona.json", "datos/servicio.json",
			"datos/turno.json" })
	public void persistTest() {

		Empleado e1 = entityManager.find(Empleado.class, 1);
		Persona p = entityManager.find(Persona.class, 1);

		Servicio pagarFactura = entityManager.find(Servicio.class, 1);
		Servicio nuevoServicio = entityManager.find(Servicio.class, 3);

		List<Servicio> servicios = new ArrayList<Servicio>();

		servicios.add(pagarFactura);
		servicios.add(nuevoServicio);

		Turno t1 = entityManager.find(Turno.class, 1);
		Turno t2 = entityManager.find(Turno.class, 2);
		Turno t3 = entityManager.find(Turno.class, 3);
		Turno t4 = entityManager.find(Turno.class, 4);

		List<Turno> turnos = new ArrayList<Turno>();

		turnos.add(t1);
		turnos.add(t2);
		turnos.add(t3);

		PuestoTrabajo puesto1 = entityManager.find(PuestoTrabajo.class, 1);

		Empleado empleado = new Empleado();
		empleado.setId(4);
		empleado.setUsuario("123456");
		empleado.setClave("qwerty");
		empleado.setAdmin(true);
		empleado.setTercero(p);
		empleado.setServicios(servicios);
		empleado.setPuesto(puesto1);

		empleado.setTurnos(turnos);

		entityManager.persist(empleado);

		Empleado registrado = entityManager.find(Empleado.class, empleado.getId());
		Assert.assertEquals(empleado, registrado);

		Assert.assertTrue("Servicio no asociado a Empleado", registrado.getServicios().contains(nuevoServicio));

		Assert.assertNotNull("Debe tener asociado un puesto de Trabajo", registrado.getPuesto());

		Assert.assertTrue("El Turno no puede existir", !registrado.getTurnos().contains(t4));
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

	/**
	 * Comprobar Autenticacion por medio de Query
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json", "datos/persona.json" })
	public void comprobrarAutenticacionQuery() {

		Empleado empleado = entityManager.find(Empleado.class, 1);

		Query query = entityManager.createQuery("SELECT e FROM Empleado e WHERE	e.usuario=:usuario AND e.clave=:clave");
		query.setParameter("usuario", empleado.getUsuario());
		query.setParameter("clave", empleado.getClave());

		List<Empleado> empleadoBD = query.getResultList();

		Assert.assertNotNull("Usuario debio de ser encontrado", empleadoBD);

		Assert.assertTrue("Solo debe existir un usuario con datos de autenticacion", empleadoBD.size() == 1);

		Assert.assertEquals(empleado.getUsuario(), empleadoBD.get(0).getUsuario());
	}

	/**
	 * Comprobar Autenticacion por medio de NameQuery
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json", "datos/persona.json" })
	public void comprobrarAutenticacionNameQuery() {

		Empleado empleado = entityManager.find(Empleado.class, 1);

		TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.AUTENTICAR, Empleado.class);
		query.setParameter("usuario", empleado.getUsuario());
		query.setParameter("clave", empleado.getClave());

		List<Empleado> empleadoBD = query.getResultList();

		Assert.assertNotNull("Usuario debio de ser encontrado", empleadoBD);

		Assert.assertTrue("Solo debe existir un usuario con datos de autenticacion", empleadoBD.size() == 1);

		Assert.assertEquals(empleado.getUsuario(), empleadoBD.get(0).getUsuario());
	}

	/**
	 * Metodo de prueba que verifica cual es el puesto de trabajo al que
	 * pertenece el empleado
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/puestoTrabajo.json", "datos/empleado.json" })
	public void saberPuestoEmpleado() {

		PuestoTrabajo puesto = entityManager.find(PuestoTrabajo.class, 3);

		TypedQuery<Empleado> query = entityManager.createNamedQuery(Empleado.GET_EMPLEADO_PUESTO, Empleado.class);
		query.setParameter("puestoId", puesto.getId());

		// Devolver el nombre del puesto
		// int cantTurnos = query.get;

		// Assert.assertEquals("Se esperan obtener el nombre del puesto de
		// trabajo del empleado", cantTurnos, 2);
	}
}