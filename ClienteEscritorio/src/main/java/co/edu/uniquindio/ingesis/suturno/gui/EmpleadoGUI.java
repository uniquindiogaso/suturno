package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.ws.api.pipe.ThrowableContainerPropertySet;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.EmpleadoDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.GeografiaDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.PuestoTrabajoDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.PuestoTrabajo;
import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Interfaz del empleado del administrador
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
public class EmpleadoGUI extends JFrame {
	/**
	 * Variables que representan los componentes de la ventana
	 */
	private JPanel contentPane;
	private JTextField tFIdentificacionNuevo;
	private JTextField tFUsuario;
	private JTextField tFContrasenia;
	private JTextField tFNombre1;
	private JTextField tFApellido1;
	private JTextField tFEmail;
	private JTextField tFTelefono1;
	private JTextField tFDireccion;
	private JTextField tFNombre2;
	private JTextField tFApellido2;
	private JTextField tFTelefono2;
	private final ButtonGroup grupoAdministrador = new ButtonGroup();
	private JComboBox cBoxTipoDoc;
	private JComboBox cBoxGenero;
	private JComboBox<Ciudad> cBoxCiudad;
	private JComboBox<PuestoTrabajo> cBoxPuesto;
	private JButton btnAgregar;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnSi;
	private JComboBox<Depto> cBoxDepto;
	private JTable tableGestionar;
	private JButton btnEliminar;
	private EmpleadoTableModel empleadoTableModel;
	private JScrollPane scrollTablaEmpleados;

	/**
	 * Se crea la ventana
	 */
	public EmpleadoGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 799, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblEmpleados = new JLabel("EmpleadoGUI");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuTurnoApplicationRun.getInstancia().getEmpleadoGUI().setVisible(false);
				SuTurnoApplicationRun.getInstancia().getManejadorGUI().setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(324)
					.addComponent(lblEmpleados)
					.addContainerGap(385, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(414, Short.MAX_VALUE)
					.addComponent(btnAtras)
					.addGap(300))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblEmpleados)
					.addGap(31)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(btnAtras)
					.addContainerGap())
		);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Nuevo Empleado", null, panel, null);

		JLabel lblIdentificacionNuevo = new JLabel("Identificación:");

		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento:");

		JLabel lblGenero = new JLabel("Genero:");

		JLabel lblNombres = new JLabel("Nombres:");

		JLabel lblApellidos = new JLabel("Apellidos:");

		JLabel lblEmail = new JLabel("Email:");

		JLabel lblTelefonos = new JLabel("Teléfonos:");

		JLabel lblDireccion = new JLabel("Dirección:");

		JLabel lblCiudad = new JLabel("Ciudad:");

		tFIdentificacionNuevo = new JTextField();
		tFIdentificacionNuevo.setColumns(10);

		tFUsuario = new JTextField();
		tFUsuario.setColumns(10);

		tFContrasenia = new JTextField();
		tFContrasenia.setColumns(10);

		tFNombre1 = new JTextField();
		tFNombre1.setColumns(10);

		tFApellido1 = new JTextField();
		tFApellido1.setColumns(10);

		tFEmail = new JTextField();
		tFEmail.setColumns(10);

		tFTelefono1 = new JTextField();
		tFTelefono1.setColumns(10);

		tFDireccion = new JTextField();
		tFDireccion.setColumns(10);

		tFNombre2 = new JTextField();
		tFNombre2.setColumns(10);

		tFApellido2 = new JTextField();
		tFApellido2.setColumns(10);

		tFTelefono2 = new JTextField();
		tFTelefono2.setColumns(10);

		cBoxTipoDoc = new JComboBox();
		cargarComboTipoDoc();

		cBoxGenero = new JComboBox();
		cargarComboGenero();

		cBoxCiudad = new JComboBox();

		cBoxDepto = new JComboBox();
		cBoxDepto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cargarComboCiudad();
			}
		});

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblContrasenia = new JLabel("Contraseña:");

		cBoxPuesto = new JComboBox();

		rdbtnSi = new JRadioButton("Si");
		grupoAdministrador.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		grupoAdministrador.add(rdbtnNo);

		JLabel lblPuestoDeTrabajo = new JLabel("Puesto de trabajo:");

		JLabel lblAdministrador = new JLabel("Administrador:");

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicBotonAgregar();
			}
		});

		JLabel lblDepto = new JLabel("Departamento:");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipoDeDocumento)
						.addComponent(lblIdentificacionNuevo)
						.addComponent(lblGenero)
						.addComponent(lblUsuario)
						.addComponent(lblContrasenia)
						.addComponent(lblPuestoDeTrabajo)
						.addComponent(lblAdministrador)
						.addComponent(lblNombres)
						.addComponent(lblApellidos)
						.addComponent(lblCiudad)
						.addComponent(lblDepto)
						.addComponent(lblEmail)
						.addComponent(lblTelefonos)
						.addComponent(lblDireccion))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregar)
						.addComponent(cBoxGenero, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tFApellido1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFNombre1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tFApellido2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFNombre2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
						.addComponent(tFEmail, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(tFTelefono1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tFTelefono2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(cBoxTipoDoc, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tFIdentificacionNuevo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(cBoxPuesto, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tFDireccion, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addComponent(tFContrasenia, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addComponent(tFUsuario, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(cBoxCiudad, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(cBoxDepto, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rdbtnSi)
							.addGap(18)
							.addComponent(rdbtnNo)))
					.addGap(118))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblIdentificacionNuevo)
						.addComponent(tFIdentificacionNuevo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeDocumento)
						.addComponent(cBoxTipoDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGenero)
								.addComponent(cBoxGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNombres)
							.addGap(11)
							.addComponent(lblApellidos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTelefonos)
							.addGap(18)
							.addComponent(lblDireccion))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tFNombre1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tFApellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFApellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addComponent(tFEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tFTelefono1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFTelefono2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addComponent(tFDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBoxDepto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBoxCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCiudad))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tFUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tFContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasenia))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cBoxPuesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuestoDeTrabajo))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnSi)
						.addComponent(rdbtnNo)
						.addComponent(lblAdministrador))
					.addGap(38)
					.addComponent(btnAgregar)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gestionar Empleado", null, panel_1, null);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int selec = tableGestionar.getSelectedRow();
					System.out.println("Fila selec: " + selec);
					if (selec != -1) {
						Empleado empleado = empleadoTableModel.getEmpleados().get(selec);
						EmpleadoDelegate.getInstancia().desactivarEmpleado(empleado);
						System.out.println("Desactivado: " + empleado.getId());

						JOptionPane.showMessageDialog(EmpleadoGUI.this, "Se elimino el empleado.");
						empleadoTableModel.setEmpleados(EmpleadoDelegate.getInstancia().listarTodosEmpleados());
					}
				} catch (Throwable t) {
					JOptionPane.showMessageDialog(EmpleadoGUI.this, t.getCause().getMessage());
				}

			}
		});

		scrollTablaEmpleados = new JScrollPane();
		scrollTablaEmpleados.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTablaEmpleados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(scrollTablaEmpleados, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
						.addGap(40).addComponent(btnEliminar).addGap(51)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(223).addComponent(btnEliminar)).addGroup(
								gl_panel_1.createSequentialGroup().addGap(42).addComponent(scrollTablaEmpleados,
										GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(71, Short.MAX_VALUE)));

		tableGestionar = new JTable();
		scrollTablaEmpleados.setViewportView(tableGestionar);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);

		cargarTabla();

		cargarComboDepto();
		cargarComboCiudad();
		cargarComboPuesto();
	}

	/**
	 * Crea el actionListener para el botón agregar
	 */
	private void clicBotonAgregar() {
		if (!tFIdentificacionNuevo.getText().isEmpty() && cBoxTipoDoc.getSelectedItem() != null
				&& cBoxGenero.getItemCount() != 0 && !tFNombre1.getText().isEmpty() && !tFApellido1.getText().isEmpty()
				&& !tFEmail.getText().isEmpty() && !tFTelefono1.getText().isEmpty() && !tFDireccion.getText().isEmpty()
				&& cBoxDepto.getItemCount() != 0 && cBoxCiudad.getItemCount() != 0 && !tFUsuario.getText().isEmpty()
				&& !tFContrasenia.getText().isEmpty() && cBoxPuesto.getItemCount() != 0) {
			Persona empleado = new Persona();
			empleado.setIdentificacion(tFIdentificacionNuevo.getText());
			empleado.settDoc((TipoDocumento) cBoxTipoDoc.getSelectedItem());
			empleado.setGenero((Genero) cBoxGenero.getSelectedItem());
			empleado.setNombre1(tFNombre1.getText());
			empleado.setNombre2(tFNombre2.getText());
			empleado.setApellido1(tFApellido1.getText());
			empleado.setApellido2(tFApellido2.getText());
			empleado.setEmail(tFEmail.getText());
			empleado.setTel1(tFTelefono1.getText());
			empleado.setTel2(tFTelefono2.getText());
			empleado.setDir(tFDireccion.getText());
			empleado.setCiudad((Ciudad) cBoxCiudad.getSelectedItem());
			empleado.setActivo(true);
			Empleado datosEmpleado = new Empleado();
			datosEmpleado.setUsuario(tFUsuario.getText());
			datosEmpleado.setClave(tFContrasenia.getText());
			datosEmpleado.setPuesto((PuestoTrabajo) cBoxPuesto.getSelectedItem());
			datosEmpleado.setAdmin(rdbtnSi.isSelected());
			empleado.setEmpleado(datosEmpleado);

			try {
				EmpleadoDelegate.getInstancia().registrarEmpleado(empleado);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(EmpleadoGUI.this, "Se registro el nuevo empleado.");
		}

	}

	/**
	 * Se carga la tabla con los datos del empleado
	 */
	private void cargarTabla() {

		empleadoTableModel = new EmpleadoTableModel(EmpleadoDelegate.getInstancia().listarEmpleadosActivos());
		tableGestionar.setModel(empleadoTableModel);

		System.out.println("Lista empleados: " + empleadoTableModel.getEmpleados().size());
		try {
			empleadoTableModel.addTableModelListener(new TableModelListener() {
				@Override
				public void tableChanged(TableModelEvent e) {
					if (e.getType() == TableModelEvent.UPDATE) {
						int indice = e.getLastRow();
						if (indice < empleadoTableModel.getEmpleados().size()) {
							Empleado empleado = empleadoTableModel.getEmpleados().get(indice);
							EmpleadoDelegate.getInstancia().actualizarEmpleado(empleado.getTercero());
						}
					}
				}
			});
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(EmpleadoGUI.this, t.getCause().getMessage());
		}
	}

	/**
	 * Se carga el combo box con los tipo de documentos disponibles
	 */
	private void cargarComboTipoDoc() {
		cBoxTipoDoc.removeAllItems();
		cBoxTipoDoc.setModel(new DefaultComboBoxModel<>(TipoDocumento.values()));
	}

	/**
	 * Se carga el combo box con lo generos disponibles
	 */
	private void cargarComboGenero() {
		cBoxGenero.removeAllItems();
		cBoxGenero.setModel(new DefaultComboBoxModel<>(Genero.values()));
	}

	/**
	 * Se carga el combo box con las ciudades disponibles
	 */
	private void cargarComboCiudad() {
		cBoxCiudad.removeAllItems();
		if (cBoxDepto.getSelectedItem() != null) {
			List<Ciudad> ciudades = GeografiaDelegate.getInstancia()
					.listarCiudades((Depto) cBoxDepto.getSelectedItem());
			for (Ciudad c : ciudades) {
				cBoxCiudad.addItem(c);
			}
		}

	}

	/**
	 * Se carga el combo box con los departamentos disponibles
	 */
	private void cargarComboDepto() {

		cBoxDepto.removeAllItems();

		System.out.println(" " + GeografiaDelegate.getInstancia().listarDepartamentos());

		List<Depto> d = GeografiaDelegate.getInstancia().listarDepartamentos();

		for (Depto depto : d) {
			cBoxDepto.addItem(depto);
		}

	}

	/**
	 * Se carga el combo box con los puesto de trabajo disponibles
	 */
	private void cargarComboPuesto() {
		cBoxPuesto.removeAllItems();
		List<PuestoTrabajo> puestos = PuestoTrabajoDelegate.getInstancia().listarPuestosTrabajo();
		for (PuestoTrabajo p : puestos)
			cBoxPuesto.addItem(p);
	}
}
