package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.sun.tools.xjc.model.CBuiltinLeafInfo;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.ServicioDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

import javax.swing.DefaultListModel;
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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

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
	 * Variables que representan los componentes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFNombre;
	private JTextField tFIdentificacion;
	private JTable tableServicios;
	private ServicioTableModel servicioTableModel;
	private JTextArea tADescripcion;
	private JTextField tFCodigo;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnAtras;
	private JScrollPane scrollServicios;
	private JComboBox cBoxServicios;
	private JLabel lblServicios_1;
	private JButton btnAgregarServicios;

	/**
	 * Se crea la ventana
	 */
	public ServicioGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 555, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblServicios = new JLabel("ServicioGUI");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuTurnoApplicationRun.getInstancia().getManejadorGUI().setVisible(true);
				SuTurnoApplicationRun.getInstancia().getServicioGUI().setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(250, Short.MAX_VALUE)
								.addComponent(lblServicios).addGap(224))
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addGap(37)
										.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 448,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(44, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(232)
								.addComponent(btnAtras).addContainerGap(238, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblServicios).addGap(18)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAtras)
						.addContainerGap(18, Short.MAX_VALUE)));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Gestionar Servicio", null, panel, null);

		JLabel lblNombre = new JLabel("Nombre:");

		tFNombre = new JTextField();
		tFNombre.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarNuevoServicio();
			}
		});

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarServicio();
			}
		});

		scrollServicios = new JScrollPane();
		scrollServicios.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollServicios.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JLabel lblDescripcion = new JLabel("Descripción:");

		tADescripcion = new JTextArea();

		JLabel lblCodigo = new JLabel("Código:");

		tFCodigo = new JTextField();
		tFCodigo.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(38)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollServicios,
						GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
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
										.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
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
				.addComponent(scrollServicios, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
				.addGap(19)));

		tableServicios = new JTable();
		scrollServicios.setViewportView(tableServicios);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Asignar servicios", null, panel_1, null);

		JLabel lblIdentificacion = new JLabel("Identificación:");

		tFIdentificacion = new JTextField();
		tFIdentificacion.setColumns(10);

		cBoxServicios = new JComboBox();

		lblServicios_1 = new JLabel("Servicios:");

		btnAgregarServicios = new JButton("Agregar servicios");
		btnAgregarServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tFIdentificacion.getText().isEmpty() && cBoxServicios.getSelectedItem()!=null){
					Empleado empleado=EmpleadoDelegate.getInstancia().buscarEmpleadoPorIdentificacion(tFIdentificacion.getText());
					List<Servicio> servicioEmpleado=empleado.getServicios();
					servicioEmpleado.add((Servicio) cBoxServicios.getSelectedItem());
					EmpleadoDelegate.getInstancia().asignarServiciosEmpleado(empleado.getId(), servicioEmpleado);
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdentificacion)
						.addComponent(lblServicios_1))
					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cBoxServicios, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tFIdentificacion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
					.addGap(139))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(176)
					.addComponent(btnAgregarServicios)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdentificacion)
						.addComponent(tFIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBoxServicios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblServicios_1))
					.addGap(39)
					.addComponent(btnAgregarServicios)
					.addContainerGap(220, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);

		cargarTabla();
		cargarComboServicios();
	}

	/**
	 * Accion cuando se da clic en el boton nuevo servicio
	 */
	private void agregarNuevoServicio() {
		try {
			if (!tFCodigo.getText().isEmpty() && !tFNombre.getText().isEmpty() && !tADescripcion.getText().isEmpty()) {
				Servicio servicio = new Servicio();
				servicio.setCodigo(tFCodigo.getText());
				servicio.setNombre(tFNombre.getText());
				servicio.setDescripcion(tADescripcion.getText());
				servicio.setActivo(true);
				ServicioDelegate.getInstancia().registrarServicio(servicio);
				JOptionPane.showMessageDialog(ServicioGUI.this, "Se registro el servicio exitosamente.");
				servicioTableModel.setServicios(ServicioDelegate.getInstancia().listarServicios());
			} else {
				JOptionPane.showMessageDialog(ServicioGUI.this, "Debe ingresar todos los datos.");
			}
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(ServicioGUI.this, t.getCause().getMessage());
		}
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

	/**
	 * Se carga la tabla con los datos del servicio
	 */
	private void cargarTabla() {

		servicioTableModel = new ServicioTableModel(ServicioDelegate.getInstancia().listarServicios());
		tableServicios.setModel(servicioTableModel);

		try {
			servicioTableModel.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e) {
					if (e.getType() == TableModelEvent.UPDATE) {
						int indice = e.getLastRow();
						if (indice < servicioTableModel.getServicios().size()) {
							Servicio servicio = servicioTableModel.getServicios().get(indice);
							ServicioDelegate.getInstancia().actualizarServicio(servicio);
						}
					}
				}
			});
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(ServicioGUI.this, t.getCause().getMessage());
		}

	}
	
	/**
	 * Carga el combo box con listado servicios disponibles
	 */
	private void cargarComboServicios(){
		cBoxServicios.removeAllItems();
		List<Servicio> servicios=ServicioDelegate.getInstancia().listarServicios();
		for(Servicio s: servicios){
			cBoxServicios.addItem(s);
		}
	}

}
