package co.edu.uniquindio.ingesis.suturno;

public class SuTurnoApplicationRun {

	private static final SuTurnoApplicationRun instancia = new SuTurnoApplicationRun();

	public SuTurnoApplicationRun() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		instancia.init();
	}

	public void init() {

	}

	public static SuTurnoApplicationRun getInstancia() {
		return instancia;
	}

}
