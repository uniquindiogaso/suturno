package co.edu.uniquindio.ingesis.suturno.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Interfaz del login del empleado del administrador
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
public class LoginGUI extends JFrame {

	/**
	 * Instancias de la ventanas: manejador y principal
	 */
	private ManejadorGUI manejador;
	private PrincipalGUI principal;

	/**
	 * Variables que representan los componentes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFUsuario;
	private JPasswordField pFContrasenia;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { LoginGUI frame = new LoginGUI();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Se crea la ventana
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblContrasenia = new JLabel("Contraseña:");

		tFUsuario = new JTextField();
		tFUsuario.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.setVisible(true);
				setVisible(false);
			}
		});

		pFContrasenia = new JPasswordField();

		JLabel lblLogin = new JLabel("LoginGUI");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(50)
								.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addGap(52)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(102).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblContrasenia)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(pFContrasenia))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblUsuario).addGap(28)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblLogin).addComponent(tFUsuario,
														GroupLayout.PREFERRED_SIZE, 116,
														GroupLayout.PREFERRED_SIZE))))))
				.addContainerGap(86, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(22).addComponent(lblLogin).addGap(44)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblUsuario).addComponent(
						tFUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(47)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasenia)
						.addComponent(pFContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(62)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(52, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
