package co.edu.uniquindio.ingesis.suturno.web.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

/**
 * Bean de la persona de la aplicacion suturno
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * @author Ingenieria de Sistemas y Computacion
 * @author Universidad del Quindio
 * @since 06/05/2017
 * @version 1.0
 *
 */
@ManagedBean
public class PersonaBean {
	/**
	 * Variable que representa el atributo identificacion de la persona
	 */
	private String identificacion;
	/**
	 * Variable que representa el atributo tipo de documento de la persona
	 */
	private TipoDocumento tDoc;
	/**
	 * Variable que representa el atributo genero de la persona
	 */
	private Genero genero;
	/**
	 * Variable que representa el primer nombre de la persona
	 */
	private String nombre1;
	/**
	 * Variable que representa el atributo del segundo nombre de la persona
	 */
	private String nombre2;
	/**
	 * Varible que representa el atributo del primer apellido de la persona
	 */
	private String apellido1;
	/**
	 * Variable que representa el atributo del segundo apellido de la persona
	 */
	private String apellido2;
	/**
	 * Variable que representa el atributo del primer telefono de la persona
	 */
	private String tel1;
	/**
	 * Variable que representa el atributo del segundo telefono de la persona
	 */
	private String tel2;

	/**
	 * Variable que represent el atributo de la fecha de nacimiento de la
	 * persona
	 */
	private Date fecha;

	/**
	 * Variable que representa el atributo de la direccion de la persona
	 */
	private String dir;
	/**
	 * Variable que representa el atributo departamento de la persona
	 */
	private Depto dpto;
	/**
	 * Variable que representa el atributo ciudad de la persona
	 */
	private Ciudad ciudad;
	/**
	 * Variable que representa el atributo activo de la persona
	 */
	private boolean activo;

	/**
	 * Metodo constructor del bean de persona
	 */
	public PersonaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo get del atributo identificacion
	 * 
	 * @return identificacion la identificacion de la persona
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Metodo set del atributo identificacion
	 * 
	 * @param identificacion
	 *            la identificacion de la persona
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * Metodo get del array de tipos de documentos
	 * 
	 * @return array con los tipos de documentos
	 */
	public TipoDocumento[] gettdocs() {
		return TipoDocumento.values();
	}

	/**
	 * Metodo get del atributo tipo de documento
	 * 
	 * @return tDoc la enumeracion tipo de documento de la persona
	 */
	public TipoDocumento gettDoc() {
		return tDoc;
	}

	/**
	 * Metodo set del atributo del tipo de documento
	 * 
	 * @param tDoc
	 *            la enumeracion del tipo de cliente de la persona
	 */
	public void settDoc(TipoDocumento tDoc) {
		this.tDoc = tDoc;
	}

	/**
	 * Metodo get del atributo genero
	 * 
	 * @return genero la enumeracion genero de la persona
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Metodo set del atributo genero
	 * 
	 * @param genero
	 *            la enumeracion genero de la persona
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * Metodo get del atributo primer nombre
	 * 
	 * @return nombre1 el primer nombre de la persona
	 */
	public String getNombre1() {
		return nombre1;
	}

	/**
	 * Metodo set del atributo primer nombre
	 * 
	 * @param nombre1
	 *            el primer nombre de la persona
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	/**
	 * Metodo get del atributo segundo nombre
	 * 
	 * @return nombre2 el segundo nombre de la persona
	 */
	public String getNombre2() {
		return nombre2;
	}

	/**
	 * Metodo set del atributo segundo nombre
	 * 
	 * @param nombre2
	 *            el segundo nombre de la persona
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	/**
	 * Metodo get del atributo del primer apellido
	 * 
	 * @return apellido1 el primer apellido de la persona
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Metodo set del atributo del primer apellido
	 * 
	 * @param apellido1
	 *            el primer apellido de la persona
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Metodo get del atributo segundo apellido
	 * 
	 * @return apellido2 el segundo apellido de la persona
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Metodo set del atributo segundo apellido
	 * 
	 * @param apellido2
	 *            el segundo apellido de la persona
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Metodo get del atributo primer telefono
	 * 
	 * @return tel1 el primer telefono de la persona
	 */
	public String getTel1() {
		return tel1;
	}

	/**
	 * Metodo set del atributo primer telefono
	 * 
	 * @param tel1
	 *            el primer telefono de la persona
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	/**
	 * Metodo get del atributo segundo telefono
	 * 
	 * @return tel2 el segundo telefono de la persona
	 */
	public String getTel2() {
		return tel2;
	}

	/**
	 * Metodo set del atributo segundo telefono
	 * 
	 * @param tel2
	 *            el segundo telefono de la persona
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	/**
	 * Metodo get del atributo direccion
	 * 
	 * @return dir la direccion de la persona
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * Metodo set del atributo direccion
	 * 
	 * @param dir
	 *            la direccion de la persona
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * Metodo get del atributo departamento
	 * 
	 * @return dpto el departamento de la persona
	 */
	public Depto getDpto() {
		return dpto;
	}

	/**
	 * Metodo set del atributo departamento
	 * 
	 * @param dpto
	 *            el departamento de la persona
	 */
	public void setDpto(Depto dpto) {
		this.dpto = dpto;
	}

	/**
	 * Metodo get del atributo ciudad
	 * 
	 * @return ciudad la ciudad de la persona
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * Metodo set del atributo ciudad
	 * 
	 * @param ciudad
	 *            la ciudad de la persona
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Metodo get del atributo activo
	 * 
	 * @return activo true o false si la persona esta activa
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Metodo set del atributo activo
	 * 
	 * @param activo
	 *            true o false si la persona esta activa
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Metodo get de la fecha de nacimiento
	 * 
	 * @return fecha la fecha de nacimiento de la persona
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Metodo set de la fecha de nacimiento
	 * 
	 * @param fecha
	 *            la fecha de nacimiento de la persona
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
