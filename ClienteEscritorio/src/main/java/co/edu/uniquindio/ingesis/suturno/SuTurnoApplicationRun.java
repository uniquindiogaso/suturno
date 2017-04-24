package co.edu.uniquindio.ingesis.suturno;

import java.util.List;

import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.GeografiaDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.PuestoTrabajoDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.gui.EmpleadoGUI;

public class SuTurnoApplicationRun {

	private static final SuTurnoApplicationRun instancia = new SuTurnoApplicationRun();
	private EmpleadoGUI empleadoGUI;
	private EmpleadoDelegate empleadoDelegate = EmpleadoDelegate.getInstancia();
	private GeografiaDelegate geografiaDelegate = GeografiaDelegate.getInstancia();
	private PuestoTrabajoDelegate puestoDelegate = PuestoTrabajoDelegate.getInstancia();

	public SuTurnoApplicationRun() {
		//empleadoGUI = new EmpleadoGUI();
	}

	public static void main(String[] args) {
		instancia.init();
		System.out.println("Lista: "+instancia.getGeografiaDelegate().listarDepartamentos().size());
		
	}

	public void init() {
		//empleadoGUI.setVisible(false);
	}

	public static SuTurnoApplicationRun getInstancia() {
		return instancia;
	}

	/**
	 * @return the empleadoDelegate
	 */
	public EmpleadoDelegate getEmpleadoDelegate() {
		return empleadoDelegate;
	}

	public GeografiaDelegate getGeografiaDelegate() {
		return geografiaDelegate;
	}

	/**
	 * @return the puestoDelegate
	 */
	public PuestoTrabajoDelegate getPuestoDelegate() {
		return puestoDelegate;
	}
	
	public void listarDepartamentos(){
		geografiaDelegate.listarDepartamentos();
	}

}
