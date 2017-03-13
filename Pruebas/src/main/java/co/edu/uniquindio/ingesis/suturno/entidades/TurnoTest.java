package co.edu.uniquindio.ingesis.suturno.entidades;

import java.sql.Timestamp;
import java.util.Date;

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

import co.edu.uniquindio.ingesis.suturno.utils.EstadoTurno;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

/*
 * Prueba TurnoTest
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
public class TurnoTest {

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
	@UsingDataSet({ "datos/persona.json", "datos/empleado.json", "datos/turno.json" })
	public void persistTest() {

		Turno t1 = entityManager.find(Turno.class, 1);
		Turno t2 = entityManager.find(Turno.class, 2);

		Turno turno = new Turno();
		turno.setId(4);
		turno.setEstado(EstadoTurno.EN_ESPERA);
		turno.setFecha(new Timestamp(new Date().getTime()));
		turno.setNota("Nuevo Turno");
		turno.setServicio(new Servicio("12345", "Pagar", "Ultimatum de pago", true));

		Persona persona = new Persona();
		persona.setId(3);
		persona.setActivo(true);
		persona.setApellido1("Marin");
		persona.setApellido2("Perez");
		persona.setDir("Granada");
		persona.setEmail("saramarin@gmail.com");
		persona.setGenero(Genero.FEMENINO);
		persona.setIdentificacion("9574136672");
		persona.setNombre1("Sara");
		persona.settDoc(TipoDocumento.TARJETA_IDENTIDAD);
		persona.setTel1("3206842320");
		persona.setTel2("7452310");
		persona.setCiudad(null);
		persona.setEmpleado(null);
		turno.setCliente(persona);

		entityManager.persist(turno);

		Turno registrado = entityManager.find(Turno.class, turno.getId());
		Assert.assertEquals(turno, registrado);
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
}