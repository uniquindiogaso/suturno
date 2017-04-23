package co.edu.uniquindio.ingesis.suturno;

import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

public class SuTurnoApplicationRun {

	private static final SuTurnoApplicationRun instancia = new SuTurnoApplicationRun();

	public SuTurnoApplicationRun() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		instancia.init();
	}

	public void init() {

		Persona persona = new Persona();
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
		//persona.setCiudad(armenia);			
		//persona.setTiposCliente(tipoClient);	
		
		Empleado e1 = new Empleado();
		e1.setAdmin(true);
		e1.setUsuario("gaso");
		e1.setClave(");(/&%$#!");
		
		persona.setEmpleado(e1);
		
		try {
			EmpleadoDelegate.getInstancia().registrarEmpleado(persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static SuTurnoApplicationRun getInstancia() {
		return instancia;
	}

}
