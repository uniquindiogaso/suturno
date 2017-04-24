package co.edu.uniquindio.ingesis.suturno.gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import co.edu.uniquindio.ingesis.suturno.entidades.Ciudad;
import co.edu.uniquindio.ingesis.suturno.entidades.Persona;
import co.edu.uniquindio.ingesis.suturno.entidades.PuestoTrabajo;
import co.edu.uniquindio.ingesis.suturno.utils.Genero;
import co.edu.uniquindio.ingesis.suturno.utils.TipoDocumento;

/**
 * Personalización del modelo de tabla para los empleados
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
 *
 */
public class EmpleadoTableModel extends DefaultTableModel {
	/**
	 * Variable que representa la lista de empleados
	 */
	private List<Persona> empleados;
	/**
	 * Variable que representa las columnas de las que se compone la tabla empleados
	 */
	private String[] columnas = { "ID", "IDENTIFICACIÓN", "TIPO DOCUMENTO", "GENERO", "PRIMER NOMBRE", "SEGUNDO NOMBRE",
			"PRIMER APELLIDO", "SEGUNDO APELLIDO", "EMAIL", "TELEFONO1", "TELEFONO2", "DIRECCIÓN", "CIUDAD", "USUARIO",
			"CONTRASEÑA", "PUESTO DE TRABAJO", "ADMINISTRADOR" };

	/**
	 * Metodo constructor del tableModel de empleado
	 * 
	 * @param empleados
	 *            lista de empleados
	 */
	public EmpleadoTableModel(List<Persona> empleados) {
		super();
		this.empleados = empleados;
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
		Persona empleado = empleados.get(row);
		if (col == 0) {
			return empleado.getEmpleado().getId();
			// return empleado.getId();
		} else if (col == 1) {
			return empleado.getIdentificacion();
		} else if (col == 2) {
			return empleado.gettDoc();
		} else if (col == 3) {
			return empleado.getGenero();
		} else if (col == 4) {
			return empleado.getNombre1();
		} else if (col == 5) {
			return empleado.getNombre2();
		} else if (col == 6) {
			return empleado.getApellido1();
		} else if (col == 7) {
			return empleado.getApellido2();
		} else if (col == 8) {
			return empleado.getEmail();
		} else if (col == 9) {
			return empleado.getTel1();
		} else if (col == 10) {
			return empleado.getTel2();
		} else if (col == 11) {
			return empleado.getDir();
		} else if (col == 12) {
			return empleado.getCiudad();
		} else if (col == 13) {
			return empleado.getEmpleado().getUsuario();
		} else if (col == 14) {
			return empleado.getEmpleado().getClave();
		} // else if(col==15){
		return empleado.getEmpleado().getPuesto();
		// }

		// return empleado.getEmpleado().getAdmin(); Poner get para atributo
		// admin
	}

	/*
	 * Metodo sobreescrito del setValueAt
	 * 
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int row, int col) {
		Persona empleado = empleados.get(row);
		if (col == 1) {
			empleado.setIdentificacion((String) aValue);
		} else if (col == 2) {
			empleado.settDoc((TipoDocumento) aValue);
		} else if (col == 3) {
			empleado.setGenero((Genero) aValue);
		} else if (col == 4) {
			empleado.setNombre1((String) aValue);
		} else if (col == 5) {
			empleado.setNombre2((String) aValue);
		} else if (col == 6) {
			empleado.setApellido1((String) aValue);
		} else if (col == 7) {
			empleado.setApellido2((String) aValue);
		} else if (col == 8) {
			empleado.setEmail((String) aValue);
			;
		} else if (col == 9) {
			empleado.setTel1((String) aValue);
		} else if (col == 10) {
			empleado.setTel2((String) aValue);
		} else if (col == 11) {
			empleado.setDir((String) aValue);
		} else if (col == 12) {
			empleado.setCiudad((Ciudad) aValue);
		} else if (col == 13) {
			empleado.getEmpleado().setUsuario((String) aValue);
		} else if (col == 15) {
			empleado.getEmpleado().setPuesto((PuestoTrabajo) aValue);
		}

		// Falta Admin
		fireTableCellUpdated(row, col);
	}

	/*
	 * Metodo sobreescrito del isCellEditable
	 * 
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return column != 0 && column != 14;
	}

	/**
	 * Metodo get de la lista de empleados
	 * 
	 * @return empleados lista de empleados
	 */
	public List<Persona> getEmpleados() {
		return empleados;
	}

	/**
	 * Metodo set de la lista de empleados
	 * 
	 * @param empleados
	 *            lista de empleados
	 */
	public void setEmpleados(List<Persona> empleados) {
		this.empleados = empleados;
		fireTableDataChanged();
	}

}
