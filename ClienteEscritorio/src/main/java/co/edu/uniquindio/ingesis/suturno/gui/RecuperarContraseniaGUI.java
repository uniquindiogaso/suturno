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
 * Interfaz de recuperar contraseña del administrador
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
public class RecuperarContraseniaGUI extends JFrame {

	/**
	 * Instancia de la ventana manejador
	 */
	private ManejadorGUI manejador;

	/**
	 * Variable que representa los componentes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFNueva;
	private JPasswordField pFNuevaContrasenia;
	private JPasswordField pFVerificarContrasenia;

	/**
	 * Launch the application public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * RecuperarContraseniaGUI frame = new RecuperarContraseniaGUI();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Se crea la ventana
	 */
	public RecuperarContraseniaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblRecuperarContrasenia = new JLabel("Recuperar Contraseña:");

		JLabel lblNuevaContrasenia = new JLabel("Nueva contraseña:");

		JButton btnAceptar = new JButton("Aceptar");

		JLabel lblUsuario = new JLabel("Usuario:");

		tFNueva = new JTextField();
		tFNueva.setColumns(10);

		JLabel lblVerificarContrase = new JLabel("Verificar contrase:");

		pFNuevaContrasenia = new JPasswordField();

		pFVerificarContrasenia = new JPasswordField();

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.setVisible(true);
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane
												.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
																.createSequentialGroup()
																.addGap(50).addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(lblUsuario).addGap(62))
																		.addComponent(lblNuevaContrasenia,
																				Alignment.LEADING)
																		.addComponent(
																				lblVerificarContrase,
																				Alignment.LEADING))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblRecuperarContrasenia)
																		.addGroup(gl_contentPane
																				.createParallelGroup(Alignment.TRAILING,
																						false)
																				.addComponent(pFVerificarContrasenia,
																						Alignment.LEADING)
																				.addComponent(pFNuevaContrasenia,
																						Alignment.LEADING)
																				.addComponent(tFNueva,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE, 102,
																						Short.MAX_VALUE))))
														.addGroup(gl_contentPane.createSequentialGroup().addGap(113)
																.addComponent(btnAceptar).addGap(32)
																.addComponent(btnAtras)))
												.addContainerGap(119, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblRecuperarContrasenia).addGap(42)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblUsuario).addComponent(
						tFNueva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNuevaContrasenia)
						.addComponent(pFNuevaContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblVerificarContrase)
						.addComponent(pFVerificarContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(btnAceptar).addComponent(btnAtras))
				.addGap(19)));
		contentPane.setLayout(gl_contentPane);
	}
}
