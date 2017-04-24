package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uniquindio.ingesis.suturno.delegados.TipoClienteDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.TipoCliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Interfaz del tipo de cliente y la prioridad del administrador
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
public class TipoClientePrioridadGUI extends JFrame {

	/**
	 * Instancia de la ventana manejador
	 */
	private ManejadorGUI manejador;

	/**
	 * Variables de los componetes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFIdentificacion;
	private final ButtonGroup grupoPrioridad = new ButtonGroup();
	private JButton btnAceptar;
	private JComboBox cBoxTipoCliente;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TipoClientePrioridadGUI frame =
	 * new TipoClientePrioridadGUI(); frame.setVisible(true); } catch (Exception
	 * e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Se crea la ventana
	 */
	public TipoClientePrioridadGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTipoClienteY = new JLabel("Tipo Cliente y Prioridad");

		JLabel lblIdentificacion = new JLabel("Identificación:");

		JLabel lblTipoDeCliente = new JLabel("Tipo de Cliente:");

		JLabel lblPrioridad = new JLabel("Prioridad:");

		JRadioButton rdbtnSi = new JRadioButton("Si");
		grupoPrioridad.add(rdbtnSi);

		JRadioButton rdbtnNo = new JRadioButton("No");
		grupoPrioridad.add(rdbtnNo);

		tFIdentificacion = new JTextField();
		tFIdentificacion.setColumns(10);

		cBoxTipoCliente = new JComboBox();
		cargarComboTipoCliente();

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoCliente tipo = new TipoCliente();
				TipoClienteDelegate.getInstancia().actualizarTipoCliente(tipo);
			}
		});

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
								.addGroup(gl_contentPane.createSequentialGroup().addGap(89).addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING).addComponent(lblTipoDeCliente)
										.addComponent(lblPrioridad).addComponent(lblIdentificacion)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(23).addComponent(btnAceptar)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(tFIdentificacion,
																		GroupLayout.PREFERRED_SIZE, 130,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addComponent(rdbtnSi)
																				.addPreferredGap(
																						ComponentPlacement.RELATED, 58,
																						Short.MAX_VALUE)
																				.addComponent(rdbtnNo).addPreferredGap(
																						ComponentPlacement.RELATED))
																		.addComponent(cBoxTipoCliente, 0,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))))
												.addGroup(Alignment.TRAILING,
														gl_contentPane.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnAtras).addGap(31))))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(147)
										.addComponent(lblTipoClienteY)))
						.addContainerGap(86, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(30).addComponent(lblTipoClienteY).addGap(45)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblIdentificacion)
								.addComponent(tFIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(36)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblTipoDeCliente)
								.addComponent(cBoxTipoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(42)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPrioridad)
								.addComponent(rdbtnNo).addComponent(rdbtnSi))
						.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnAtras)
								.addComponent(btnAceptar))
						.addGap(50)));
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Carga el combo box con los tipos de clientes disponibles
	 */
	public void cargarComboTipoCliente() {
		cBoxTipoCliente.removeAllItems();
		List<TipoCliente> tipos = TipoClienteDelegate.getInstancia().listarTipoCliente();
		for (TipoCliente t : tipos) {
			cBoxTipoCliente.addItem(t);
		}
	}
}
