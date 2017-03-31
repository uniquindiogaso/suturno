package co.edu.uniquindio.ingesis.suturno.entidades;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import co.edu.uniquindio.ingesis.suturno.dto.CantTurnosXClienteDTO;
import co.edu.uniquindio.ingesis.suturno.dto.ConteoClientesXServicioDTO;
import co.edu.uniquindio.ingesis.suturno.dto.EmpleadoMaxTurnoDTO;
import co.edu.uniquindio.ingesis.suturno.dto.InformacionTurnoPorFechaDTO;
import co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno;

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
			"datos/servicio.json", "datos/turno.json" })
	public void saberCantidadTurnosCliente() {

		Persona cliente = entityManager.find(Persona.class, 3);

		TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.GET_TURNOS_CLIENTE, Turno.class);
		query.setParameter("clienteId", cliente.getId());

		int cantTurnos = query.getResultList().size();

		Assert.assertEquals("Se espera obtener la cantidad de turnos que tiene el cliente", 5, cantTurnos);
	}

	/**
	 * Metodo de prueba que verifica cuantos turnos tiene un empleado
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json", "datos/tipocliente.json",
			"datos/servicio.json", "datos/turno.json" })
	public void saberCantidadTurnosEmpleado() {

		Empleado empleado = entityManager.find(Empleado.class, 2);

		TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.GET_TURNOS_EMPLEADO, Turno.class);
		query.setParameter("empleadoId", empleado.getId());

		int cantTurnos = query.getResultList().size();

		Assert.assertEquals("Se espera obtener la cantidad de turnos que tiene el empleado.", 6, cantTurnos);
	}

	/**
	 * Metodo de prueba que verifica los Clientes Atendidos en una Fecha
	 * Determinada
	 * 
	 * @throws ParseException
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json", "datos/tipocliente.json",
			"datos/turno.json" })
	public void clientesAntendidosXFecha() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaString = "2017-03-21";
		Date fecha = formatter.parse(fechaString);

		TypedQuery<Turno> query = entityManager.createNamedQuery(Turno.GET_CLIENTES_X_FECHA, Turno.class);
		query.setParameter("fecha", fecha);

		int cantturnosFecha = query.getResultList().size();

		Assert.assertTrue(cantturnosFecha == 8);

	}

	/**
	 * Metodo de prueba que verifica los Clientes Atendidos en una Fecha
	 * Determinada
	 * 
	 * @throws ParseException
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/ciudad.json", "datos/empleado.json", "datos/persona.json", "datos/tipocliente.json",
			"datos/turno.json" })
	public void infoTurnoDTO() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaString = "2017-03-21";
		Date fecha = formatter.parse(fechaString);

		TypedQuery<InformacionTurnoPorFechaDTO> query = entityManager.createNamedQuery(Turno.GET_TURNO_FECHA,
				InformacionTurnoPorFechaDTO.class);
		query.setParameter("fecha", fecha);

		int cantturnosFecha = query.getResultList().size();

		System.out.println("DTO" + cantturnosFecha);

		// Assert.assertTrue(cantturnosFecha == 1);
		Assert.assertEquals(1, cantturnosFecha);

	}

	/**
	 * Metodo de prueba que verifica los Clientes Atendidos en una Fecha
	 * Determinada
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json", "datos/ciudad.json", "datos/empleado.json", "datos/persona.json",
			"datos/tipocliente.json", "datos/turno.json" })
	public void countClientesXServicio() {

		Servicio servicio = entityManager.find(Servicio.class, 2);

		Query query = entityManager.createNamedQuery(Turno.GET_COUNT_CLIENTES_X_SERVICIO);
		query.setParameter("servicio", servicio);

		Long cantClientesXServicio = (Long) query.getSingleResult();

		System.out.println("COUNT Clientes x Servicio : " + cantClientesXServicio);

		Assert.assertTrue(cantClientesXServicio == 5);

	}

	/**
	 * Metodo de prueba que permite determinar el número de clientes que tienen
	 * turno para una fecha dada
	 * 
	 * @throws ParseException
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json", "datos/ciudad.json", "datos/empleado.json", "datos/persona.json",
			"datos/tipocliente.json", "datos/turno.json" })
	public void countClientesXFecha() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaString = "2017-03-21";
		Date fecha = formatter.parse(fechaString);

		Query query = entityManager.createNamedQuery(Turno.GET_COUNT_CLIENTES_X_TURNO);
		query.setParameter("fecha", fecha);

		Long cantClientesFecha = (Long) query.getSingleResult();

		System.out.println("COUNT Clientes x Fecha : " + cantClientesFecha);

		// Revisar
		Assert.assertTrue(cantClientesFecha == 5);

	}

	/**
	 * Metodo de prueba que permite probar el número de clientes que han
	 * solicitado cada servicio
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json", "datos/ciudad.json", "datos/empleado.json", "datos/persona.json",
			"datos/tipocliente.json", "datos/turno.json" })
	public void numClientesXServicioDTO() {

		Servicio servicio1 = entityManager.find(Servicio.class, 1);

		TypedQuery<ConteoClientesXServicioDTO> query = entityManager
				.createNamedQuery(Turno.GET_CLIENTES_SERVICIO_AGRUPADOS, ConteoClientesXServicioDTO.class);

		List<ConteoClientesXServicioDTO> clientesXServicio = query.getResultList();

		for (ConteoClientesXServicioDTO dto : clientesXServicio) {
			System.out.println(dto.getCantClientes() + ": " + dto.getServicio().getNombre());
		}

		// Revisar
		Assert.assertTrue(clientesXServicio.size() == 4);

	}

	/**
	 * Metodo de prueba que permite probar que clientes tienen turnos que aún no
	 * han sido atendidos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json", "datos/ciudad.json", "datos/empleado.json", "datos/persona.json",
			"datos/tipocliente.json", "datos/turno.json" })
	public void numTurnosSinAtenderXCliente() {

		Servicio servicio1 = entityManager.find(Servicio.class, 1);

		TypedQuery<CantTurnosXClienteDTO> query = entityManager
				.createNamedQuery(Turno.GET_CANT_TURNO_CLIENTE_SIN_ATENDER, CantTurnosXClienteDTO.class);

		List<CantTurnosXClienteDTO> turnosXCliente = query.getResultList();

		for (CantTurnosXClienteDTO dto : turnosXCliente) {
			System.out.println(dto.getCantTurnos() + ": " + dto.getPersona().getIdentificacion());
		}

		// Assert.assertTrue(turnosXCliente.size() == 3);

	}

	/**
	 * Metodo de prueba que permite probar cual es el empleado que más clientes
	 * ha atendido
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/servicio.json", "datos/ciudad.json", "datos/empleado.json", "datos/persona.json",
			"datos/tipocliente.json", "datos/turno.json" })
	public void empleadoMasProactivo() {

		Servicio servicio1 = entityManager.find(Servicio.class, 1);

		TypedQuery<EmpleadoMaxTurnoDTO> query = entityManager.createNamedQuery(Turno.GET_EMPLEADO_GOLD,
				EmpleadoMaxTurnoDTO.class);

		List<EmpleadoMaxTurnoDTO> turnosXCliente = query.getResultList();

		for (EmpleadoMaxTurnoDTO dto : turnosXCliente) {
			System.out.println(dto.getCantTurnos() + ": " + dto.getEmpleado().getTercero().getIdentificacion());
		}

		// Assert.assertTrue(turnosXCliente.size() == 3);

	}
}