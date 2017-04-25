package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * Interfaz de la consultas del Administrador
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
public class ConsultasGUI extends JFrame {
	/**
	 * Variable que representan los componentes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFConsulta1;
	private JTextField tFServicio;
	private JComboBox cBoxEmpleado;
	private JComboBox cBoxDiaC1;
	private JComboBox cBoxMesC1;
	private JComboBox cBoxAnioC1;
	private JComboBox cBoxDiaC2;
	private JComboBox cBoxMesC2;
	private JComboBox cBoxAnioC2;
	private JComboBox cBoxDiaC4;
	private JComboBox cBoxMesC4;
	private JComboBox cBoxAnioC4;
	private JComboBox cBoxServicio;
	private JButton btnBuscarC1;
	private JButton btnBuscarC2;
	private JButton btnBuscarC3;
	private JButton btnBuscarC4;

	/**
	 * Se crea la ventana
	 */
	public ConsultasGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 605, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblConsultas = new JLabel("ConsultasGUI");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuTurnoApplicationRun.getInstancia().getConsultasGUI().setVisible(false);
				SuTurnoApplicationRun.getInstancia().getManejadorGUI().setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(272, Short.MAX_VALUE)
										.addComponent(lblConsultas).addGap(260))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(69)
										.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 471,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(39, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(255)
										.addComponent(btnAtras).addContainerGap(265, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblConsultas).addGap(26)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAtras)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Consulta 1", null, panel, null);

		cBoxEmpleado = new JComboBox();

		cBoxDiaC1 = new JComboBox();

		cBoxMesC1 = new JComboBox();

		cBoxAnioC1 = new JComboBox();

		tFConsulta1 = new JTextField();
		tFConsulta1.setColumns(10);

		JLabel lblClientesAtendidosPor = new JLabel("Clientes atendidos por un empleado");

		btnBuscarC1 = new JButton("Buscar");
		btnBuscarC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel
								.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel
												.createParallelGroup(Alignment.TRAILING, false).addGroup(gl_panel
														.createSequentialGroup().addGap(34)
														.addComponent(cBoxEmpleado, GroupLayout.PREFERRED_SIZE, 130,
																GroupLayout.PREFERRED_SIZE)
														.addGap(49)
														.addComponent(cBoxDiaC1, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(cBoxMesC1, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.LEADING,
														gl_panel.createSequentialGroup().addGap(132)
																.addComponent(lblClientesAtendidosPor)))
										.addGroup(gl_panel.createSequentialGroup()
												.addGap(165).addComponent(tFConsulta1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addGap(27).addComponent(cBoxAnioC1,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addGap(9).addComponent(btnBuscarC1)))
								.addContainerGap(65, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(24).addComponent(lblClientesAtendidosPor).addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cBoxEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cBoxDiaC1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cBoxMesC1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cBoxAnioC1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(40)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tFConsulta1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscarC1))
						.addContainerGap(72, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta 2", null, panel_1, null);

		JList listEmpleados = new JList();

		cBoxDiaC2 = new JComboBox();

		cBoxMesC2 = new JComboBox();

		cBoxAnioC2 = new JComboBox();

		JLabel lblClientesAtendidosPor_1 = new JLabel("Clientes atendidos por cada empleado");

		btnBuscarC2 = new JButton("Buscar");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(168)
						.addComponent(cBoxDiaC2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(cBoxMesC2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(cBoxAnioC2, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(178, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(138)
						.addComponent(listEmpleados, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE).addComponent(btnBuscarC2)
						.addGap(25))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(127).addComponent(lblClientesAtendidosPor_1)
						.addContainerGap(157, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap().addComponent(lblClientesAtendidosPor_1).addGap(16)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(cBoxDiaC2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cBoxMesC2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cBoxAnioC2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(listEmpleados, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(63).addComponent(btnBuscarC2)))
				.addContainerGap(13, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consulta 3", null, panel_2, null);

		cBoxServicio = new JComboBox();

		tFServicio = new JTextField();
		tFServicio.setColumns(10);

		JLabel lblClientesHanSolicitado = new JLabel("Clientes han solicitado un determinado servicio");

		btnBuscarC3 = new JButton("Buscar");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(156)
						.addComponent(cBoxServicio, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE).addComponent(btnBuscarC3)
						.addGap(44))
				.addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup().addGap(109).addComponent(lblClientesHanSolicitado))
						.addGroup(gl_panel_2.createSequentialGroup().addGap(171).addComponent(tFServicio,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(134, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(26).addComponent(lblClientesHanSolicitado)
						.addGap(39)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(cBoxServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscarC3))
						.addGap(35).addComponent(tFServicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(54, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Consulta 4", null, panel_3, null);

		JList listServicio = new JList();

		cBoxDiaC4 = new JComboBox();

		cBoxMesC4 = new JComboBox();

		cBoxAnioC4 = new JComboBox();

		JLabel label = new JLabel("Clientes han solicitado cada servicio");

		btnBuscarC4 = new JButton("Buscar");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(136)
						.addComponent(listServicio, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE).addComponent(btnBuscarC4)
						.addGap(23))
				.addGroup(gl_panel_3.createSequentialGroup()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup().addGap(165)
										.addComponent(cBoxDiaC4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cBoxMesC4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(cBoxAnioC4, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_3.createSequentialGroup().addGap(128).addComponent(label,
										GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(156, Short.MAX_VALUE)));
		gl_panel_3
				.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup().addGroup(gl_panel_3
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
										.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
												.addComponent(cBoxDiaC4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cBoxMesC4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cBoxAnioC4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(25).addComponent(listServicio, GroupLayout.PREFERRED_SIZE, 116,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_3.createSequentialGroup().addGap(64).addComponent(btnBuscarC4)))
								.addContainerGap()));
		panel_3.setLayout(gl_panel_3);
		contentPane.setLayout(gl_contentPane);

		cargarComboEmpleados();
		cargarComboServicios();
		cargarCombosDias();
		cargarCombosMeses();
		cargarCombosAnios();
	}

	private void cargarComboEmpleados() {
		cBoxEmpleado.removeAllItems();
		List<Empleado> empleados = EmpleadoDelegate.getInstancia().listarEmpleadosActivos();
		for (Empleado e : empleados) {
			cBoxEmpleado.addItem(e.getTercero().getIdentificacion() + " - " + e.getTercero().getNombre1() + " "
					+ e.getTercero().getApellido1());
		}
	}

	private void cargarComboServicios() {
		cBoxServicio.removeAllItems();
		List<Servicio> servicios = ServicioDelegate.getInstancia().listarServicios();
		for (Servicio s : servicios) {
			cBoxServicio.addItem(s);
		}
	}

	private void cargarCombosDias() {
		cBoxDiaC1.removeAllItems();
		cBoxDiaC2.removeAllItems();
		cBoxDiaC4.removeAllItems();
		for (int i = 1; i <= 31; i++) {
			cBoxDiaC1.addItem(i);
			cBoxDiaC2.addItem(i);
			cBoxDiaC4.addItem(i);
		}
	}

	private void cargarCombosMeses() {
		cBoxMesC1.removeAllItems();
		cBoxMesC2.removeAllItems();
		cBoxMesC4.removeAllItems();
		for (int i = 1; i <= 12; i++) {
			cBoxMesC1.addItem(i);
			cBoxMesC2.addItem(i);
			cBoxMesC4.addItem(i);
		}
	}

	private void cargarCombosAnios() {
		cBoxAnioC1.removeAllItems();
		cBoxAnioC2.removeAllItems();
		cBoxAnioC4.removeAllItems();
		for (int i = 1; i <= 2030; i++) {
			cBoxAnioC1.addItem(i);
			cBoxAnioC2.addItem(i);
			cBoxAnioC4.addItem(i);
		}
	}
}
