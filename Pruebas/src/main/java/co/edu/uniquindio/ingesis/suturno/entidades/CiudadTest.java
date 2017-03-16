package co.edu.uniquindio.ingesis.suturno.entidades;

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
 * Prueba CiudadTest
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
public class CiudadTest {

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
	@UsingDataSet({ "datos/depto.json", "datos/ciudad.json" })
	public void persistTest() {

		Depto depto = entityManager.find(Depto.class, 2);

		Ciudad ciudad = new Ciudad();
		ciudad.setId(3);
		ciudad.setCodigo("per");
		ciudad.setNombre("Pereira");
		ciudad.setDpto(depto);

		entityManager.persist(ciudad);

		Ciudad registrado = entityManager.find(Ciudad.class, ciudad.getId());
		Assert.assertEquals(ciudad, registrado);
	}

	/**
	 * Prueba de Limite de Registros por Query
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json", "datos/ciudad.json" })
	public void limitarRegistros() {

		TypedQuery<Ciudad> queryCiudades = entityManager.createNamedQuery(Ciudad.GET_ALL, Ciudad.class);
		// Limitar cantidad de registros a 10
		queryCiudades = queryCiudades.setMaxResults(10);
		List<Ciudad> ciudades = queryCiudades.getResultList();

		Assert.assertEquals("Se espera limitar a 10 el resultado de la Query", ciudades.size(), 10);
	}

	/**
	 * Metodo de prueba que verifica la busqueda de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json", "datos/ciudad.json" })
	public void findTest() {
		Ciudad ciudad = entityManager.find(Ciudad.class, 1);
		Assert.assertEquals("Armenia", ciudad.getNombre());
	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json", "datos/ciudad.json" })
	public void updateTest() {

		Ciudad manizales = entityManager.find(Ciudad.class, 1);

		manizales.setCodigo("mani");

		Ciudad registrado = entityManager.find(Ciudad.class, manizales.getId());
		Assert.assertEquals(manizales.getCodigo(), registrado.getCodigo());

	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json", "datos/ciudad.json" })
	public void deleteTest() {

		Ciudad manizales = entityManager.find(Ciudad.class, 1);

		entityManager.remove(manizales);

		Ciudad registrado = entityManager.find(Ciudad.class, manizales.getId());
		Assert.assertNull(registrado);
	}
}