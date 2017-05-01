package co.edu.uniquindio.ingesis.suturno.desktop.tablemodels;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import co.edu.uniquindio.ingesis.suturno.entidades.TipoCliente;

public class TipoClienteTableModel extends DefaultTableModel {
	/**
	 * Variable que representa la lista de tipos de clientes
	 */
	private List<TipoCliente> tipoClientes;

	/**
	 * Variable que representa las columnas de las que se compone la tabla tipos
	 * de clientes
	 */
	private String[] columnas = { "ID", "CODIGO", "NOMBRE", "PRIORIDAD" };

	/**
	 * Metodo constructor del tableModel de tipos de clientes
	 * 
	 * @param tipoClientes
	 *            lista de los tipos de clientes
	 */
	public TipoClienteTableModel(List<TipoCliente> tipoClientes) {
		super();
		this.tipoClientes = tipoClientes;
		setColumnIdentifiers(columnas);
	}

	/*
	 * Metodo sobreescrito del RowCount
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (tipoClientes == null) {
			return 0;
		}
		return tipoClientes.size();
	}

	/*
	 * Metodo sobreescrito del getValueAt
	 * 
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		TipoCliente tipo = tipoClientes.get(row);
		if (col == 0) {
			return tipo.getId();
		}
		if (col == 1) {
			return tipo.getCodigo();
		}
		if (col == 2) {
			return tipo.getNombre();
		}
		return tipo.isPrioridad();
	}

	/*
	 * Metodo sobreescrito del setValueAt
	 * 
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		TipoCliente tipo = tipoClientes.get(row);
		if (column == 1) {
			tipo.setCodigo((String) aValue);
		}
		if (column == 2) {
			tipo.setNombre((String) aValue);
		}
		 tipo.setPrioridad((boolean) aValue);
		fireTableCellUpdated(row, column);
	}

	/*
	 * Metodo sobreescrito del isCellEditable
	 * 
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return column != 0 && column != 3;
	}

	/**
	 * Metodo get de la lista de tipos de clientes
	 * 
	 * @return tipoClientes lista de tipos de clientes
	 */
	public List<TipoCliente> getTipoClientes() {
		return tipoClientes;
	}

	/**
	 * Metodo set de la lista de tipos de clientes
	 * 
	 * @param tipoClientes
	 *            lista de tipos de clientes
	 */
	public void setTipoClientes(List<TipoCliente> tipoClientes) {
		this.tipoClientes = tipoClientes;
		fireTableDataChanged();
	}

}
