package co.edu.uniquindio.ingesis.suturno;

import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.GeografiaDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.PuestoTrabajoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.TipoClienteDelegate;
import co.edu.uniquindio.ingesis.suturno.gui.EmpleadoGUI;
import co.edu.uniquindio.ingesis.suturno.gui.PrincipalGUI;
import co.edu.uniquindio.ingesis.suturno.gui.ServicioGUI;

/**
 * Ejecuta la capa de escritorio e inicializa las ventanas
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingeniería de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 12/04/2017
 */
public class SuTurnoApplicationRun {

	/**
	 * Variable que representa la instancia de SuTurnoAplicationRun
	 */
	private static final SuTurnoApplicationRun instancia = new SuTurnoApplicationRun();

	/**
	 * Instancias de las ventanas de la capad de escritorio
	 */
	private PrincipalGUI principalGUI;
	private EmpleadoGUI empleadoGUI;
	private ServicioGUI servicioGUI;

	/**
	 * Instancias de los delegados
	 */
	private EmpleadoDelegate empleadoDelegate = EmpleadoDelegate.getInstancia();
	private GeografiaDelegate geografiaDelegate = GeografiaDelegate.getInstancia();
	private PuestoTrabajoDelegate puestoDelegate = PuestoTrabajoDelegate.getInstancia();
	private ServicioDelegate servicioDelegate = ServicioDelegate.getInstancia();
	private TipoClienteDelegate tipoClienteDelegate = TipoClienteDelegate.getInstancia();

	/**
	 * Metodo constructor del SuTurnoApplicationRun
	 */
	public SuTurnoApplicationRun() {
		 empleadoGUI = new EmpleadoGUI();
		 servicioGUI= new ServicioGUI();
		//principalGUI = new PrincipalGUI();
	}

	/**
	 * Metodo main de la aplicacion suturno
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		instancia.init();
		System.out.println("Lista: " + instancia.getGeografiaDelegate().listarDepartamentos().size());

	}

	/**
	 * Metodo que inicializa los componentes
	 */
	public void init() {
		 empleadoGUI.setVisible(true);
		 servicioGUI.setVisible(true);
		 
		//principalGUI.setVisible(true);

	}

	/**
	 * Metodo get de la instancia de SuTurnoApplicationRun
	 * 
	 * @return instancia la instancia de SuTurnoApplicationRun
	 */
	public static SuTurnoApplicationRun getInstancia() {
		return instancia;
	}

	/**
	 * Metodo get del delegado del empleado
	 * 
	 * @return empleadoDelegate el delegado del empleado
	 */
	public EmpleadoDelegate getEmpleadoDelegate() {
		return empleadoDelegate;
	}

	/**
	 * Metodo get del delegado de geografia
	 * 
	 * @return geografiaDelegate el delegado de geografia
	 */
	public GeografiaDelegate getGeografiaDelegate() {
		return geografiaDelegate;
	}

	/**
	 * Metodo get del delegado del puesto de trabajo
	 * 
	 * @return puestoDelegate el delegado del puesto de trabajo
	 */
	public PuestoTrabajoDelegate getPuestoDelegate() {
		return puestoDelegate;
	}

	/**
	 * Metodo get del delegado del servicio
	 * 
	 * @return servicioDelegate el delegado del servicio
	 */
	public ServicioDelegate getServicioDelegate() {
		return servicioDelegate;
	}

	/**
	 * Metodo get del delegado del tipo de cliente
	 * 
	 * @return tipoClienteDelegate el delegado del tipo de cliente
	 */
	public TipoClienteDelegate getTipoClienteDelegate() {
		return tipoClienteDelegate;
	}

}
