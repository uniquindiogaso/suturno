package co.edu.uniquindio.ingesis.suturno.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField tFUsuario;
	private JPasswordField pFNuevaContrasenia;
	private JPasswordField pFVerificarContrasenia;
	private JButton btnAceptar;

	/**
	 * Se crea la ventana
	 */
	public RecuperarContraseniaGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblRecuperarContrasenia = new JLabel("Recuperar Contraseña:");

		JLabel lblNuevaContrasenia = new JLabel("Nueva contraseña:");

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tFUsuario.getText().isEmpty() && pFNuevaContrasenia.getPassword().length != 0
						&& pFVerificarContrasenia.getPassword().length != 0) {
					String nueva = new String(pFNuevaContrasenia.getPassword());
					String verificar = new String(pFVerificarContrasenia.getPassword());
					System.out.println("Nueva pas: " + nueva);
					if (nueva.equals(verificar)) {
						Empleado empleado = EmpleadoDelegate.getInstancia()
								.buscarEmpleadoPorNombreUsuario(tFUsuario.getText());
						EmpleadoDelegate.getInstancia().actualizarClaveEmpleado(empleado.getId(), nueva);
						JOptionPane.showMessageDialog(RecuperarContraseniaGUI.this,
								"Contraseña cambiada correctamente.");
					} else {
						JOptionPane.showMessageDialog(RecuperarContraseniaGUI.this, "Las contraseñas no coinciden.");
					}
				} else {
					JOptionPane.showMessageDialog(RecuperarContraseniaGUI.this, "Debe diligenciar todos los campos.");
				}
			}
		});

		JLabel lblUsuario = new JLabel("Usuario:");

		tFUsuario = new JTextField();
		tFUsuario.setColumns(10);

		JLabel lblVerificarContrase = new JLabel("Verificar contrase:");

		pFNuevaContrasenia = new JPasswordField();

		pFVerificarContrasenia = new JPasswordField();

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuTurnoApplicationRun.getInstancia().getManejadorGUI().setVisible(true);
				SuTurnoApplicationRun.getInstancia().getRecuperarGUI().setVisible(false);
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
																.createSequentialGroup().addGap(50)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPane
																				.createParallelGroup(Alignment.TRAILING)
																				.addGroup(gl_contentPane
																						.createSequentialGroup()
																						.addComponent(lblUsuario)
																						.addGap(62))
																				.addComponent(lblVerificarContrase,
																						Alignment.LEADING))
																		.addComponent(lblNuevaContrasenia))
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
																				.addComponent(tFUsuario,
																						Alignment.LEADING,
																						GroupLayout.DEFAULT_SIZE, 102,
																						Short.MAX_VALUE))))
														.addGroup(gl_contentPane.createSequentialGroup().addGap(113)
																.addComponent(btnAceptar).addGap(32)
																.addComponent(btnAtras)))
												.addContainerGap(149, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblRecuperarContrasenia).addGap(42)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblUsuario).addComponent(
						tFUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pFNuevaContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNuevaContrasenia))
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
