package co.edu.uniquindio.ingesis.suturno.desktop.tablemodels;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Empleado;
import co.edu.uniquindio.ingesis.suturno.entidades.PuestoTrabajo;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

/**
 * Personalizaci�n del modelo de tabla para los empleados
 * 
 * @author Gustavo Salgado y Laura Julieth Rua
 * 
 * @author Ingenier�a de Sistemas y Computacion
 * 
 * @author Universidad del Quindio
 * 
 * @version 1.0
 * 
 * @since 12/04/2017
 *
 */
public class EmpleadoTableModel extends DefaultTableModel {
	/**
	 * Variable que representa la lista de empleados
	 */
	private List<Empleado> empleados;
	/**
	 * Variable que representa las columnas de las que se compone la tabla
	 * empleados
	 */
	private String[] columnas = { "ID", "IDENTIFICACION", "TIPO DOCUMENTO", "PRIMER NOMBRE", "SEGUNDO NOMBRE",
			"PRIMER APELLIDO", "SEGUNDO APELLIDO", "EMAIL", "TELEFONO1", "DIRECCION", "CIUDAD", "USUARIO",
			"PUESTO DE TRABAJO", "ADMINISTRADOR" };

	/**
	 * Metodo constructor del tableModel de empleado
	 * 
	 * @param empleados
	 *            lista de empleados
	 */
	public EmpleadoTableModel(List<Empleado> empleados) {
		super();
		this.empleados = empleados;
		System.out.println("Empleados a mostrar " + empleados.size());
		setColumnIdentifiers(columnas);
	}

	/*
	 * Metodo sobreescrito del RowCount
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (empleados == null) {
			return 0;
		}
		return empleados.size();
	}

	/*
	 * Metodo sobreescrito del getValueAt
	 * 
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		Empleado empleado = empleados.get(row);
		if (col == 0) {
			return empleado.getId();
		}
		if (col == 1) {
			return empleado.getTercero().getIdentificacion();
		}
		if (col == 2) {
			return empleado.getTercero().gettDoc();
		}
		if (col == 3) {
			return empleado.getTercero().getNombre1();
		}
		if (col == 4) {
			return empleado.getTercero().getNombre2();
		}
		if (col == 5) {
			return empleado.getTercero().getApellido1();
		}
		if (col == 6) {
			return empleado.getTercero().getApellido2();
		}
		if (col == 7) {
			return empleado.getTercero().getEmail();
		}
		if (col == 8) {
			return empleado.getTercero().getTel1();
		}
		if (col == 9) {
			return empleado.getTercero().getDir();
		}
		if (col == 10) {
			return empleado.getTercero().getCiudad();
		}
		if (col == 11) {
			return empleado.getUsuario();
		}
		if (col == 12) {
			return empleado.getPuesto();
		}
		return empleado.isAdmin();
	}

	/*
	 * Metodo sobreescrito del setValueAt
	 * 
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int row, int col) {
		Empleado empleado = empleados.get(row);
		if (col == 1) {
			empleado.getTercero().setIdentificacion((String) aValue);
		}
		if (col == 2) {
			empleado.getTercero().settDoc((TipoDocumento) aValue);
		}
		if (col == 3) {
			empleado.getTercero().setNombre1((String) aValue);
		}
		if (col == 4) {
			empleado.getTercero().setNombre2((String) aValue);
		}
		if (col == 5) {
			empleado.getTercero().setApellido1((String) aValue);
		}
		if (col == 6) {
			empleado.getTercero().setApellido2((String) aValue);
		}
		if (col == 7) {
			empleado.getTercero().setEmail((String) aValue);
		}
		if (col == 8) {
			empleado.getTercero().setTel1((String) aValue);
		}
		if (col == 9) {
			empleado.getTercero().setDir((String) aValue);
		}
		if (col == 10) {
			empleado.getTercero().setCiudad((Ciudad) aValue);
		}
		if (col == 11) {
			empleado.setUsuario((String) aValue);
		}
		if (col == 12) {
			empleado.setPuesto((PuestoTrabajo) aValue);
		}
		fireTableCellUpdated(row, col);
	}

	/*
	 * Metodo sobreescrito del isCellEditable
	 * 
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return column != 0 && column != 13 && column != 2 && column != 10 && column != 12;
	}

	/**
	 * Metodo get de la lista de empleados
	 * 
	 * @return empleados lista de empleados
	 */
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	/**
	 * Metodo set de la lista de empleados
	 * 
	 * @param empleados
	 *            lista de empleados
	 */
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
		fireTableDataChanged();
	}

}
