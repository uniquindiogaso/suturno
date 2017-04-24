package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Interfaz del manejador del administrador
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
public class ManejadorGUI extends JFrame {

	/**
	 * Instancias de las ventanas: tipoCliente, consultas, empleado, principal,
	 * recuperar contraseña, servicio
	 */
	private TipoClientePrioridadGUI tipoCliente;
	private ConsultasGUI consultas;
	private EmpleadoGUI empleado;
	private PrincipalGUI principal;
	private RecuperarContraseniaGUI recuperar;
	private ServicioGUI servicio;

	/**
	 * Variable que representa los componentes de la ventana
	 */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ManejadorGUI frame = new
	 * ManejadorGUI(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Se crea la ventana
	 */
	public ManejadorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultas.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnServicios = new JButton("Servicios");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicio.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoCliente.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnRecuperarConstrasenia = new JButton("Recuperar Constrase\u00F1a");
		btnRecuperarConstrasenia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recuperar.setVisible(true);
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(150)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSalir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(btnEmpleados, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnClientes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnServicios, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnConsultas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRecuperarConstrasenia, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
				.addGap(182)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(43)
				.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnEmpleados, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnServicios, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnConsultas, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
				.addComponent(btnRecuperarConstrasenia, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(16)));
		contentPane.setLayout(gl_contentPane);
	}

}
