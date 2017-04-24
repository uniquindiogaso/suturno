package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

/**
 * Interfaz del servicio del administrador
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
public class ServicioGUI extends JFrame {

	/**
	 * Instancia de la ventana manejador
	 */
	private ManejadorGUI manejador;

	/**
	 * Variables que representan los componentes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFNombre;
	private JTextField textField;
	private JTable tableServicios;
	private ServicioTableModel servicioTableModel;
	private JTextArea tADescripcion;
	private JTextField tFCodigo;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnAtras;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application. public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * ServicioGUI frame = new ServicioGUI(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Se crea la ventana
	 */
	public ServicioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblServicios = new JLabel("ServicioGUI");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.setVisible(true);
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(37).addComponent(tabbedPane,
										GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(234).addComponent(btnAtras)))
						.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(250, Short.MAX_VALUE).addComponent(lblServicios).addGap(224)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblServicios).addGap(18)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(11).addComponent(btnAtras)));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Gestionar Servicio", null, panel, null);

		JLabel lblNombre = new JLabel("Nombre:");

		tFNombre = new JTextField();
		tFNombre.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Servicio servicio = new Servicio();
					servicio.setCodigo(tFCodigo.getText());
					servicio.setNombre(tFNombre.getText());
					servicio.setDescripcion(tADescripcion.getText());
					servicio.setActivo(true);
					SuTurnoApplicationRun.getInstancia().getServicioDelegate().getInstancia()
							.registrarServicio(servicio);
					JOptionPane.showMessageDialog(ServicioGUI.this, "Se registro el servicio exitosamente.");
					servicioTableModel.setServicios(ServicioDelegate.getInstancia().listarServicios());
				} catch (Throwable t) {
					JOptionPane.showMessageDialog(ServicioGUI.this, t.getCause().getMessage());
				}
			}
		});

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarServicio();
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblDescripcion = new JLabel("Descripción:");

		tADescripcion = new JTextArea();

		JLabel lblCodigo = new JLabel("Código:");

		tFCodigo = new JTextField();
		tFCodigo.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(38).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE).addGroup(
								gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblCodigo, GroupLayout.PREFERRED_SIZE, 41,
														GroupLayout.PREFERRED_SIZE)
												.addGap(43)
												.addComponent(tFCodigo, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblDescripcion).addComponent(lblNombre))
												.addGap(26)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(tADescripcion, GroupLayout.DEFAULT_SIZE, 192,
																Short.MAX_VALUE)
														.addComponent(tFNombre, GroupLayout.DEFAULT_SIZE, 192,
																Short.MAX_VALUE))))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 101,
														GroupLayout.PREFERRED_SIZE))))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(27).addComponent(lblCodigo))
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(24).addComponent(tFCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNombre).addComponent(
								tFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDescripcion)
								.addComponent(tADescripcion, GroupLayout.PREFERRED_SIZE, 73,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup().addComponent(btnNuevo).addGap(18)
								.addComponent(btnEliminar)))
				.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE).addGap(19)));

		tableServicios = new JTable();
		scrollPane.setViewportView(tableServicios);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Asignar servicios", null, panel_1, null);

		JButton button = new JButton("-->");

		JLabel lblServicios_1 = new JLabel("Servicios Disponibles");

		JLabel lblEmpleado = new JLabel("Servicios a Empleado");

		JLabel lblIdentificacion = new JLabel("Identificación:");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");

		JButton button_1 = new JButton("<--");

		JScrollPane scrollPane_1 = new JScrollPane();

		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(19)
				.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(
						gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(button_1).addComponent(button))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup().addGap(45)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblIdentificacion)
								.addComponent(lblServicios_1))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
										.addComponent(lblEmpleado).addGap(47))
								.addGroup(
										gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 151,
														GroupLayout.PREFERRED_SIZE)
												.addGap(48).addComponent(btnAceptar).addGap(20)))));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(34)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addGap(6)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblIdentificacion)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAceptar))
						.addGap(33)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblServicios_1)
								.addComponent(lblEmpleado))
						.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
								gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 306,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 303,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(183).addComponent(button).addGap(38)
								.addComponent(button_1)))
				.addContainerGap(26, Short.MAX_VALUE)));

		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Se crea el actionListerner del boton eliminar
	 */
	private void eliminarServicio() {
		try {
			int selec = tableServicios.getSelectedRow();
			if (selec != -1) {
				Servicio servicio = servicioTableModel.getServicios().get(selec);
				SuTurnoApplicationRun.getInstancia().getServicioDelegate().getInstancia().eliminarServicio(servicio);
				JOptionPane.showMessageDialog(ServicioGUI.this, "Se elimino el servicio.");
				servicioTableModel.setServicios(ServicioDelegate.getInstancia().listarServicios());
			}
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(ServicioGUI.this, t.getCause().getMessage());
		}
	}
}
