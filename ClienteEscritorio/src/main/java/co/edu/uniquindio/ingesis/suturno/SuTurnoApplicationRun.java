package co.edu.uniquindio.ingesis.suturno;

import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.GeografiaDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.PuestoTrabajoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.TipoClienteDelegate;
import co.edu.uniquindio.ingesis.suturno.gui.ConsultasGUI;
import co.edu.uniquindio.ingesis.suturno.gui.EmpleadoGUI;
import co.edu.uniquindio.ingesis.suturno.gui.LoginGUI;
import co.edu.uniquindio.ingesis.suturno.gui.ManejadorGUI;
import co.edu.uniquindio.ingesis.suturno.gui.PrincipalGUI;
import co.edu.uniquindio.ingesis.suturno.gui.RecuperarContraseniaGUI;
import co.edu.uniquindio.ingesis.suturno.gui.ServicioGUI;
import co.edu.uniquindio.ingesis.suturno.gui.TipoClientePrioridadGUI;

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
	private TipoClientePrioridadGUI tipoClienteGUI;
	private LoginGUI loginGUI;
	private RecuperarContraseniaGUI recuperarGUI;
	private ConsultasGUI consultasGUI;
	private ManejadorGUI manejadorGUI;
	
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
		principalGUI = new PrincipalGUI();
		empleadoGUI = new EmpleadoGUI();
		servicioGUI = new ServicioGUI();
		tipoClienteGUI = new TipoClientePrioridadGUI();
		loginGUI = new LoginGUI();
		recuperarGUI = new RecuperarContraseniaGUI();
		consultasGUI= new ConsultasGUI();
		manejadorGUI= new ManejadorGUI();
		
		
		
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
		principalGUI.setVisible(true);
//		empleadoGUI.setVisible(true);
//		servicioGUI.setVisible(true);
//		tipoClienteGUI.setVisible(true);
//		loginGUI.setVisible(true);
//		recuperarGUI.setVisible(true);

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

	/**
	 * @return the principalGUI
	 */
	public PrincipalGUI getPrincipalGUI() {
		return principalGUI;
	}

	/**
	 * @return the empleadoGUI
	 */
	public EmpleadoGUI getEmpleadoGUI() {
		return empleadoGUI;
	}


	/**
	 * @return the servicioGUI
	 */
	public ServicioGUI getServicioGUI() {
		return servicioGUI;
	}


	/**
	 * @return the tipoClienteGUI
	 */
	public TipoClientePrioridadGUI getTipoClienteGUI() {
		return tipoClienteGUI;
	}


	/**
	 * @return the loginGUI
	 */
	public LoginGUI getLoginGUI() {
		return loginGUI;
	}


	/**
	 * @return the recuperarGUI
	 */
	public RecuperarContraseniaGUI getRecuperarGUI() {
		return recuperarGUI;
	}


	/**
	 * @return the consultasGUI
	 */
	public ConsultasGUI getConsultasGUI() {
		return consultasGUI;
	}

	/**
	 * @return the manejadorGUI
	 */
	public ManejadorGUI getManejadorGUI() {
		return manejadorGUI;
	}


	
}
