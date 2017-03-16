package co.edu.uniquindio.ingesis.suturno.entidades;

import java.util.ArrayList;
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

/**
 * Prueba TipoClienteTest
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
public class TipoClienteTest {

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
	 * Metodo de prueba que verifica la insercion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/persona.json" })
	public void persistTest() {

		Persona client1 = entityManager.find(Persona.class, 3);
		Persona client2 = entityManager.find(Persona.class, 4);

		List<Persona> clientes = new ArrayList<Persona>();
		clientes.add(client1);
		clientes.add(client2);

		TipoCliente tCliente = new TipoCliente();

		tCliente.setId(3);
		tCliente.setCodigo("gold");
		tCliente.setNombre("Cliente Premium");
		tCliente.setPrioridad(true);
		tCliente.setPersonas(clientes);

		entityManager.persist(tCliente);

		TipoCliente registrado = entityManager.find(TipoCliente.class, tCliente.getId());
		Assert.assertEquals(tCliente, registrado);
	}

	/**
	 * Metodo de prueba que verifica la busqueda de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/tipocliente.json" })
	public void findTest() {
		TipoCliente tCliente = entityManager.find(TipoCliente.class, 1);
		Assert.assertEquals("gen", tCliente.getCodigo());
	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/tipocliente.json" })
	public void updateTest() {

		TipoCliente mayor = entityManager.find(TipoCliente.class, 2);

		mayor.setNombre("Preferente");

		TipoCliente registrado = entityManager.find(TipoCliente.class, mayor.getId());
		Assert.assertEquals(mayor.getNombre(), registrado.getNombre());

	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/persona.json", "datos/ciudad.json" })
	public void deleteTest() {

		TipoCliente pref = entityManager.find(TipoCliente.class, 1);

		entityManager.remove(pref);

		TipoCliente registrado = entityManager.find(TipoCliente.class, pref.getId());
		Assert.assertNull(registrado);
	}

	/**
	 * Metodo de prueba que verifica el condicionamiento de las query con WHERE
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/tipocliente.json" })
	public void obtenerPrioritariosWhere() {

		TypedQuery<TipoCliente> query = entityManager.createNamedQuery(TipoCliente.GET_PRIORIDAD, TipoCliente.class);
		List<TipoCliente> tipoClientes = query.getResultList();

		Assert.assertTrue("Debe existir minimo un Tipo de Cliente Prioritario", tipoClientes.size() > 0);
	}

	/**
	 * Metodo de prueba que identifica que tipo de cliente tiene un cliente
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/tipocliente.json" })
	public void saberTipoClienteDeCliente() {
		
		Persona cliente=entityManager.find(Persona.class, arg1)

		TypedQuery<TipoCliente> query = entityManager.createNamedQuery(TipoCliente.GET_PRIORIDAD, TipoCliente.class);
		List<TipoCliente> tipoClientes = query.getResultList();

		Assert.assertTrue("Debe existir minimo un Tipo de Cliente Prioritario", tipoClientes.size() > 0);

	}
}