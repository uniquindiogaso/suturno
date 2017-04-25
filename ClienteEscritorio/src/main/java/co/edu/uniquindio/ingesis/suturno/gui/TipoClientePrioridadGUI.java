package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.TipoClienteDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.entidades.TipoCliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

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
	 * Variables de los componentes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFCodigo;
	private final ButtonGroup grupoPrioridad = new ButtonGroup();
	private JButton btnNuevo;
	private JButton btnAtras;
	private JTextField tFNombre;
	private JTable tableTipoCliente;
	private JScrollPane scrollTipoCliente;
	private TipoClienteTableModel tipoClienteTableModel;

	/**
	 * Se crea la ventana
	 */
	public TipoClientePrioridadGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 443, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTipoCliente = new JLabel("Tipo Cliente");

		JLabel lblCodigo = new JLabel("Código:");

		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblPrioridad = new JLabel("Prioridad:");

		JRadioButton rdbtnSi = new JRadioButton("Si");
		grupoPrioridad.add(rdbtnSi);

		JRadioButton rdbtnNo = new JRadioButton("No");
		grupoPrioridad.add(rdbtnNo);

		tFCodigo = new JTextField();
		tFCodigo.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!tFCodigo.getText().isEmpty() && !tFNombre.getText().isEmpty()) {
						TipoCliente tipo = new TipoCliente();
						tipo.setCodigo(tFCodigo.getText());
						tipo.setNombre(tFNombre.getText());
						tipo.setPrioridad(rdbtnSi.isSelected());

						TipoClienteDelegate.getInstancia().registrarServicio(tipo);
						JOptionPane.showMessageDialog(TipoClientePrioridadGUI.this,"Se agrego un nuevo tipo de cliente.");
						tipoClienteTableModel.setTipoClientes(TipoClienteDelegate.getInstancia().listarTipoCliente());
					} else {
						JOptionPane.showMessageDialog(TipoClientePrioridadGUI.this,
								"Debe diligenciar todos los campos.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuTurnoApplicationRun.getInstancia().getManejadorGUI().setVisible(true);
				SuTurnoApplicationRun.getInstancia().getTipoClienteGUI().setVisible(false);
			}
		});

		tFNombre = new JTextField();
		tFNombre.setColumns(10);

		scrollTipoCliente = new JScrollPane();
		scrollTipoCliente.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTipoCliente.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int selec = tableTipoCliente.getSelectedRow();
					if (selec != -1) {
						TipoCliente tipo = tipoClienteTableModel.getTipoClientes().get(selec);
						TipoClienteDelegate.getInstancia().eliminarTipoCliente(tipo);

						JOptionPane.showMessageDialog(TipoClientePrioridadGUI.this, "Se elimino el tipo de cliente.");
						tipoClienteTableModel.setTipoClientes(TipoClienteDelegate.getInstancia().listarTipoCliente());
					}
				} catch (Throwable t) {
					JOptionPane.showMessageDialog(TipoClientePrioridadGUI.this, t.getCause().getMessage());
				}

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(
								Alignment.LEADING)
								.addGroup(gl_contentPane
										.createSequentialGroup().addGap(89).addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblPrioridad).addGap(18).addComponent(rdbtnSi)
														.addPreferredGap(ComponentPlacement.RELATED, 65,
																Short.MAX_VALUE)
														.addComponent(rdbtnNo))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNombre).addComponent(lblCodigo))
														.addGap(18)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(tFCodigo, GroupLayout.PREFERRED_SIZE, 142,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(tFNombre, 142, 142, 142))))
										.addGap(89))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(147)
										.addComponent(lblTipoCliente)))
								.addContainerGap(38, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(28)
								.addComponent(scrollTipoCliente, GroupLayout.PREFERRED_SIZE, 280,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(btnNuevo)
										.addComponent(btnEliminar).addComponent(btnAtras))
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(30).addComponent(lblTipoCliente).addGap(45)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblCodigo).addGap(36)
										.addComponent(lblNombre).addGap(27))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(tFCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36)
										.addComponent(tFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPrioridad)
								.addComponent(rdbtnNo).addComponent(rdbtnSi))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(36).addComponent(
										scrollTipoCliente, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(71).addComponent(btnNuevo)
										.addGap(18).addComponent(btnEliminar).addGap(28).addComponent(btnAtras)))
						.addContainerGap(84, Short.MAX_VALUE)));

		tableTipoCliente = new JTable();
		scrollTipoCliente.setViewportView(tableTipoCliente);
		contentPane.setLayout(gl_contentPane);

		cargarTabla();
	}

	/**
	 * Se carga la tabla con los datos de los tipos de clientes
	 */
	private void cargarTabla() {

		tipoClienteTableModel = new TipoClienteTableModel(TipoClienteDelegate.getInstancia().listarTipoCliente());
		tableTipoCliente.setModel(tipoClienteTableModel);
		try {
			tipoClienteTableModel.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e) {
					if (e.getType() == TableModelEvent.UPDATE) {
						int indice = e.getLastRow();
						if (indice < tipoClienteTableModel.getTipoClientes().size()) {
							TipoCliente tipo = tipoClienteTableModel.getTipoClientes().get(indice);
							TipoClienteDelegate.getInstancia().actualizarTipoCliente(tipo);
						}
					}

				}
			});
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(TipoClientePrioridadGUI.this, t.getCause().getMessage());
		}

	}

}