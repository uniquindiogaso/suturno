package co.edu.uniquindio.ingesis.suturno.web.bean;

import javax.faces.bean.ManagedBean;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

@ManagedBean
public class PersonaBean {
	
	private String identificacion;
	private TipoDocumento tDoc;
	private Genero genero;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String tel1;
	private String tel2;
	private String dir;
	private Depto dpto;	
	private Ciudad ciudad;
	private boolean activo;
	
	
	/**
	 * 
	 */
	public PersonaBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	/**
	 * @return the tDoc
	 */
	public TipoDocumento[] gettdocs() {
		return TipoDocumento.values();
	}
	
	
	
	/**
	 * @return the tDoc
	 */
	public TipoDocumento gettDoc() {
		return tDoc;
	}


	/**
	 * @param tDoc the tDoc to set
	 */
	public void settDoc(TipoDocumento tDoc) {
		this.tDoc = tDoc;
	}


	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}


	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	/**
	 * @return the nombre1
	 */
	public String getNombre1() {
		return nombre1;
	}


	/**
	 * @param nombre1 the nombre1 to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}


	/**
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}


	/**
	 * @param nombre2 the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}


	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}


	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}


	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	/**
	 * @return the tel1
	 */
	public String getTel1() {
		return tel1;
	}


	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}


	/**
	 * @return the tel2
	 */
	public String getTel2() {
		return tel2;
	}


	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}


	/**
	 * @return the dir
	 */
	public String getDir() {
		return dir;
	}


	/**
	 * @param dir the dir to set
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}


	/**
	 * @return the dpto
	 */
	public Depto getDpto() {
		return dpto;
	}


	/**
	 * @param dpto the dpto to set
	 */
	public void setDpto(Depto dpto) {
		this.dpto = dpto;
	}


	/**
	 * @return the ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}


	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}


	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
	
	
	
	

}
