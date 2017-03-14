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
 * Prueba DeptoTest
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
public class DeptoTest {

	/*
	 * Variable que representa el atributo entityManager, que es el administrador de conexiones
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
	@UsingDataSet({ "datos/depto.json" })
	public void findTest() {
		Depto depto = entityManager.find(Depto.class, 1);
		Assert.assertEquals("Quindio", depto.getNombre());
	}

	/**
	 * Metodo de prueba que verifica la insercion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json" })
	public void persistTest() {

		Ciudad c1 = entityManager.find(Ciudad.class, 1);
		Ciudad c2 = entityManager.find(Ciudad.class, 2);

		List<Ciudad> ciudades = new ArrayList<>();
		ciudades.add(c1);
		ciudades.add(c2);

		Depto depto = new Depto();
		depto.setId(3);
		depto.setCodigo("AR");
		depto.setNombre("Arauca");
		depto.setCiudades(ciudades);

		entityManager.persist(depto);

		Depto registrado = entityManager.find(Depto.class, depto.getId());
		Assert.assertEquals(depto, registrado);
	}

	/**
	 * Metodo de prueba que verifica la actualizacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json" })
	public void updateTest() {

		Depto quindio = entityManager.find(Depto.class, 1);

		quindio.setCodigo("quind");

		Depto registrado = entityManager.find(Depto.class, quindio.getId());
		Assert.assertEquals("quind", registrado.getCodigo());
	}

	/**
	 * Metodo de prueba que verifica la eliminacion de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({ "datos/depto.json" })
	public void deleteTest() {

		Depto quindio = entityManager.find(Depto.class, 1);

		entityManager.remove(quindio);

		Depto registrado = entityManager.find(Depto.class, quindio.getId());
		Assert.assertNull(registrado);
	}
}