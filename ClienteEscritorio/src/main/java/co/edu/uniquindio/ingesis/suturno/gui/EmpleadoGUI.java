package co.edu.uniquindio.ingesis.suturno.gui;

import java.awt.EventQueue;
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
import javax.swing.table.DefaultTableModel;

import co.edu.uniquindio.ingesis.suturno.SuTurnoApplicationRun;
import co.edu.uniquindio.ingesis.suturno.delegados.GeografiaDelegate;
import co.edu.uniquindio.ingesis.suturno.delegados.PuestoTrabajoDelegate;
import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Depto;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.PuestoTrabajo;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EmpleadoGUI extends JFrame {

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
	private JTextField tFIdentificacionGestionar;
	private JTable tableGestionar;
	private JComboBox cBoxTipoDoc;
	private JComboBox cBoxGenero;
	private JComboBox cBoxCiudad;
	private JComboBox cBoxPuesto;
	private JButton btnAgregar;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnSi;
	private JComboBox cBoxDepto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleadoGUI frame = new EmpleadoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmpleadoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblEmpleados = new JLabel("EmpleadoGUI");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(324).addComponent(lblEmpleados))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(70).addComponent(tabbedPane,
										GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(282, Short.MAX_VALUE).addComponent(btnAtrs).addGap(264)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(28).addComponent(lblEmpleados).addGap(31)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAtrs)
						.addContainerGap(20, Short.MAX_VALUE)));

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
				//cargarComboCiudad();
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
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(73, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblTipoDeDocumento)
								.addComponent(lblIdentificacionNuevo).addComponent(lblGenero).addComponent(lblDireccion)
								.addComponent(lblEmail).addComponent(lblTelefonos)
								.addComponent(lblUsuario).addComponent(lblContrasenia).addComponent(lblPuestoDeTrabajo)
								.addComponent(lblAdministrador)
								.addComponent(lblNombres).addComponent(lblApellidos).addComponent(lblCiudad)
								.addComponent(lblDepto))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cBoxGenero, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(tFApellido1, GroupLayout.PREFERRED_SIZE, 124,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(tFNombre1, GroupLayout.PREFERRED_SIZE, 124,
														GroupLayout.PREFERRED_SIZE))
										.addGap(10)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(tFNombre2, GroupLayout.PREFERRED_SIZE, 124,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(tFApellido2, GroupLayout.PREFERRED_SIZE, 124,
														GroupLayout.PREFERRED_SIZE)))
								.addComponent(tFEmail, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(tFTelefono1, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(tFTelefono2,
												GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cBoxTipoDoc, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(tFIdentificacionNuevo, Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cBoxPuesto, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tFDireccion, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
										.addComponent(tFContrasenia, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
										.addComponent(tFUsuario, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(cBoxCiudad, 0,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(cBoxDepto, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addComponent(rdbtnSi).addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnAgregar).addComponent(rdbtnNo))))
						.addGap(54)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(19)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblIdentificacionNuevo)
								.addComponent(tFIdentificacionNuevo, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(14)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblTipoDeDocumento)
								.addComponent(cBoxTipoDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblGenero)
										.addComponent(cBoxGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNombres).addGap(11)
								.addComponent(lblApellidos).addGap(18).addComponent(lblEmail)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblTelefonos).addGap(18)
								.addComponent(lblDireccion))
								.addGroup(gl_panel.createSequentialGroup().addGap(28)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(tFNombre2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(8).addComponent(tFApellido2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(tFNombre1, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(tFApellido1, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(8).addComponent(tFEmail, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(tFTelefono1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(tFTelefono2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(8).addComponent(tFDireccion, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cBoxDepto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDepto))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cBoxCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCiudad))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tFUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsuario))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tFContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContrasenia))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cBoxPuesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPuestoDeTrabajo))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnSi)
								.addComponent(rdbtnNo).addComponent(lblAdministrador))
						.addGap(26).addComponent(btnAgregar).addContainerGap(14, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gestionar Empleado", null, panel_1, null);

		JLabel lblIdentificacionGestionar = new JLabel("Identificación:");

		tFIdentificacionGestionar = new JTextField();
		tFIdentificacionGestionar.setColumns(10);

		tableGestionar = new JTable();
		tableGestionar.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(59)
						.addComponent(tableGestionar, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(btnModificar)
								.addComponent(btnEliminar))
						.addGap(45))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(101)
						.addComponent(lblIdentificacionGestionar).addGap(18).addComponent(tFIdentificacionGestionar,
								GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(153, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(41)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblIdentificacionGestionar)
										.addComponent(tFIdentificacionGestionar, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(51).addComponent(tableGestionar, GroupLayout.PREFERRED_SIZE, 351,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(182).addComponent(btnModificar).addGap(18)
								.addComponent(btnEliminar)))
						.addContainerGap(40, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);

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
				&& !tFEmail.getText().isEmpty() && !tFTelefono1.getText().isEmpty() && !tFTelefono2.getText().isEmpty()
				&& !tFDireccion.getText().isEmpty() && cBoxDepto.getItemCount() != 0 && cBoxCiudad.getItemCount() != 0
				&& !tFUsuario.getText().isEmpty() && !tFContrasenia.getText().isEmpty()
				&& cBoxPuesto.getItemCount() != 0) {
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
				SuTurnoApplicationRun.getInstancia().getEmpleadoDelegate().registrarEmpleado(empleado);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(EmpleadoGUI.this, "Se registro el nuevo empleado.");
		}

	}

	private void cargarComboTipoDoc() {
		cBoxTipoDoc.removeAllItems();
		cBoxTipoDoc.setModel(new DefaultComboBoxModel<>(TipoDocumento.values()));
	}

	private void cargarComboGenero() {
		cBoxGenero.removeAllItems();
		cBoxGenero.setModel(new DefaultComboBoxModel<>(Genero.values()));
	}

	private void cargarComboCiudad() {
		cBoxCiudad.removeAllItems();
		if (cBoxDepto.getSelectedItem() != null) {
			List<Ciudad> ciudades = SuTurnoApplicationRun.getInstancia().getGeografiaDelegate()
					.listarCiudades((Depto) cBoxDepto.getSelectedItem());
			for (Ciudad c : ciudades) {
				cBoxCiudad.addItem(c);
			}
		}

	}

	private void cargarComboDepto() {
		// cBoxDepto.removeAllItems();
		// System.out.println("Delegate " + GeografiaDelegate.getInstancia().listarDepartamentos());
		List<Depto> deptos = SuTurnoApplicationRun.getInstancia().getGeografiaDelegate().listarDepartamentos();
		/*for (Depto d : deptos) {
			cBoxDepto.addItem(d);
		}*/

	}

	private void cargarComboPuesto() {
		cBoxPuesto.removeAllItems();
		List<PuestoTrabajo> puestos = PuestoTrabajoDelegate.getInstancia().listarPuestosTrabajo();
		for (PuestoTrabajo p : puestos)
			cBoxPuesto.addItem(p);
	}

}
