package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Interfaz principal de la aplicacion suturno
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
public class PrincipalGUI extends JFrame {

	/**
	 * Instancia de la ventana login
	 */
	private LoginGUI login;

	/**
	 * Variable que representa los componentes de la ventana
	 */
	private JPanel contentPane;

	/**
	 * Launch the application. public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * PrincipalGUI frame = new PrincipalGUI(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Se crea la ventana
	 */
	public PrincipalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PrincipalGUI.this, "En construcción");
			}
		});

		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(new LoginGUI()).setVisible(true);
				setVisible(false);
			}
		});

		JButton btnSalir = new JButton("Salir");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addGap(114)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnSalir,
														Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnEmpleado, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(btnCliente, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 104,
																GroupLayout.PREFERRED_SIZE)))
								.addGap(112)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addContainerGap(70, Short.MAX_VALUE)
						.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(33)
						.addComponent(btnEmpleado, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(34).addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(55)));
		contentPane.setLayout(gl_contentPane);
	}
}
