package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.el.parser.ParseException;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.TurnoDelegate;
import co.edu.uniquindio.ingesis.suturno.dto.ConteoClientesXServicioDTO;
import co.edu.uniquindio.ingesis.suturno.dto.EmpleandoXClientesDTO;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

import javax.swing.DefaultListModel;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private JComboBox cBoxDiaC1Inicio;
	private JComboBox cBoxMesC1Inicio;
	private JComboBox cBoxAnioC1Inicio;
	private JComboBox cBoxDiaC2Inicio;
	private JComboBox cBoxMesC2Inicio;
	private JComboBox cBoxAnioC2Inicio;
	private JComboBox cBoxServicio;
	private JButton btnBuscarC1;
	private JButton btnBuscarC2;
	private JButton btnBuscarC3;
	private JButton btnBuscarC4;
	private JComboBox cBoxDiaC1Fin;
	private JComboBox cBoxMesC1Fin;
	private JComboBox cBoxAnioC1Fin;
	private JComboBox cBoxDiaC2Fin;
	private JComboBox cBoxMesC2Fin;
	private JComboBox cBoxAnioC2Fin;

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

		cBoxDiaC1Inicio = new JComboBox();

		cBoxMesC1Inicio = new JComboBox();

		cBoxAnioC1Inicio = new JComboBox();

		tFConsulta1 = new JTextField();
		tFConsulta1.setColumns(10);

		JLabel lblClientesAtendidosPor = new JLabel("Clientes atendidos por un empleado");

		btnBuscarC1 = new JButton("Buscar");
		btnBuscarC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inicio = cBoxAnioC1Inicio.getSelectedItem() + "-" + cBoxMesC1Inicio.getSelectedItem() + "-"
						+ cBoxDiaC1Inicio.getSelectedItem();
				String fin = cBoxAnioC1Fin.getSelectedItem() + "-" + cBoxMesC1Fin.getSelectedItem() + "-"
						+ cBoxDiaC1Fin.getSelectedItem();
				Empleado em = (Empleado) cBoxEmpleado.getSelectedItem();
				int total = TurnoDelegate.getInstancia().cantTurnosAtendidosEmpleado(em.getId(),
						cambiarStringADate(inicio), cambiarStringADate(fin));
				tFConsulta1.setText(String.valueOf(total));
			}
		});

		cBoxDiaC1Fin = new JComboBox();

		cBoxMesC1Fin = new JComboBox();

		cBoxAnioC1Fin = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, gl_panel
						.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING,
								false)
								.addGroup(
										gl_panel.createSequentialGroup().addGap(132)
												.addComponent(lblClientesAtendidosPor))
								.addGroup(gl_panel.createSequentialGroup().addGap(32)
										.addComponent(cBoxEmpleado, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addGap(51)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(cBoxDiaC1Inicio, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(tFConsulta1, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(cBoxDiaC1Fin, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGap(34)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnBuscarC1)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(cBoxMesC1Inicio,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(cBoxAnioC1Inicio,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
																.addComponent(cBoxMesC1Fin, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(27).addComponent(cBoxAnioC1Fin,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))))))
						.addContainerGap(50, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(24).addComponent(lblClientesAtendidosPor)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(cBoxDiaC1Inicio, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cBoxMesC1Inicio, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cBoxAnioC1Inicio, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(cBoxDiaC1Fin, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cBoxMesC1Fin, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cBoxAnioC1Fin, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(31)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(tFConsulta1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnBuscarC1)))
								.addGroup(gl_panel.createSequentialGroup().addGap(33).addComponent(cBoxEmpleado,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(50, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta 2", null, panel_1, null);

		JList listEmpleados = new JList();

		cBoxDiaC2Inicio = new JComboBox();

		cBoxMesC2Inicio = new JComboBox();

		cBoxAnioC2Inicio = new JComboBox();

		JLabel lblClientesAtendidosPor_1 = new JLabel("Clientes atendidos por cada empleado");

		btnBuscarC2 = new JButton("Buscar");
		btnBuscarC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inicio = cBoxAnioC2Inicio.getSelectedItem() + "-" + cBoxMesC2Inicio.getSelectedItem() + "-"
						+ cBoxDiaC2Inicio.getSelectedItem();
				String fin = cBoxAnioC2Fin.getSelectedItem() + "-" + cBoxMesC2Fin.getSelectedItem() + "-"
						+ cBoxDiaC2Fin.getSelectedItem();
				Empleado em = (Empleado) cBoxEmpleado.getSelectedItem();
				List<EmpleandoXClientesDTO> total = TurnoDelegate.getInstancia()
						.turnosAtendidosEmpleado(cambiarStringADate(inicio), cambiarStringADate(fin));
				DefaultListModel modelo = new DefaultListModel<>();
				for (EmpleandoXClientesDTO e : total) {
					modelo.addElement(e);
				}
				listEmpleados.setModel(modelo);
			}
		});

		cBoxDiaC2Fin = new JComboBox();

		cBoxMesC2Fin = new JComboBox();

		cBoxAnioC2Fin = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(127).addComponent(lblClientesAtendidosPor_1)
						.addContainerGap(157, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(40)
										.addComponent(cBoxDiaC2Inicio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cBoxMesC2Inicio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cBoxAnioC2Inicio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
										.addComponent(cBoxDiaC2Fin, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cBoxMesC2Fin, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(cBoxAnioC2Fin, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										gl_panel_1.createSequentialGroup().addContainerGap()
												.addComponent(listEmpleados, GroupLayout.PREFERRED_SIZE, 187,
														GroupLayout.PREFERRED_SIZE)
												.addGap(82)))
						.addComponent(btnBuscarC2).addGap(25)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(lblClientesAtendidosPor_1).addGap(16)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(cBoxDiaC2Inicio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cBoxMesC2Inicio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cBoxAnioC2Inicio, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cBoxDiaC2Fin, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cBoxMesC2Fin, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cBoxAnioC2Fin, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18).addComponent(listEmpleados, GroupLayout.PREFERRED_SIZE, 116,
										GroupLayout.PREFERRED_SIZE))
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
		btnBuscarC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicio ser = (Servicio) cBoxServicio.getSelectedItem();
				int total = TurnoDelegate.getInstancia().cantClientesSolicitanServicio(ser.getId());
				tFServicio.setText(String.valueOf(total));
			}
		});
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

		JLabel label = new JLabel("Clientes han solicitado cada servicio");

		btnBuscarC4 = new JButton("Buscar");
		btnBuscarC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicio ser = (Servicio) cBoxServicio.getSelectedItem();

				List<ConteoClientesXServicioDTO> total = TurnoDelegate.getInstancia().clientesXServicioSolicitado();
				DefaultListModel modelo = new DefaultListModel<>();
				for (ConteoClientesXServicioDTO e : total) {
					modelo.addElement(e);
				}
				listServicio.setModel(modelo);
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
				.createSequentialGroup().addGap(128)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(listServicio, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
								.addGap(47).addComponent(btnBuscarC4))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(39, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(label).addGap(18)
						.addComponent(listServicio, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addGap(31))
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup().addGap(58).addComponent(btnBuscarC4)
						.addContainerGap(127, Short.MAX_VALUE)));
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
		cBoxDiaC1Inicio.removeAllItems();
		cBoxDiaC1Fin.removeAllItems();
		cBoxDiaC2Inicio.removeAllItems();
		cBoxDiaC2Fin.removeAllItems();
		for (int i = 1; i <= 31; i++) {
			cBoxDiaC1Inicio.addItem(i);
			cBoxDiaC1Fin.addItem(i);
			cBoxDiaC2Inicio.addItem(i);
			cBoxDiaC2Fin.addItem(i);
		}
	}

	private void cargarCombosMeses() {
		cBoxMesC1Inicio.removeAllItems();
		cBoxMesC1Fin.removeAllItems();
		cBoxMesC2Inicio.removeAllItems();
		cBoxMesC2Fin.removeAllItems();
		for (int i = 1; i <= 12; i++) {
			cBoxMesC1Inicio.addItem(i);
			cBoxMesC1Fin.addItem(i);
			cBoxMesC2Inicio.addItem(i);
			cBoxMesC2Fin.addItem(i);
		}
	}

	private void cargarCombosAnios() {
		cBoxAnioC1Inicio.removeAllItems();
		cBoxAnioC1Fin.removeAllItems();
		cBoxAnioC2Inicio.removeAllItems();
		cBoxAnioC2Fin.removeAllItems();
		for (int i = 1; i <= 2030; i++) {
			cBoxAnioC1Inicio.addItem(i);
			cBoxAnioC1Fin.addItem(i);
			cBoxAnioC2Inicio.addItem(i);
			cBoxAnioC2Fin.addItem(i);
		}
	}

	/**
	 * Permite convertir un String en fecha (Date).
	 * 
	 * @param fecha
	 *            Cadena de fecha dd/MM/yyyy
	 * @return Objeto Date
	 * @throws java.text.ParseException
	 */
	public static Date cambiarStringADate(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return fechaDate;
	}
}
