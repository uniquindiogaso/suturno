package co.edu.uniquindio.ingesis.suturno.desktop.tablemodels;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import co.edu.uniquindio.ingesis.suturno.entidades.Servicio;

/**
 * Personalizaci�n del modelo de tabla para los servicios
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
public class ServicioTableModel extends DefaultTableModel {
	/**
	 * Variable que representa la lista de servicios
	 */
	private List<Servicio> servicios;

	/**
	 * Variable que representa las columnas de las que se compone la tabla
	 * servicios
	 */
	private String[] columnas = {"ID", "CODIGO", "NOMBRE", "DESCRIPCI�N" };

	/**
	 * Metodo constructor del tableModel de servicio
	 * 
	 * @param servicios
	 */
	public ServicioTableModel(List<Servicio> servicios) {
		super();
		this.servicios = servicios;
		setColumnIdentifiers(columnas);
	}

	/*
	 * Metodo sobreescrito del RowCount
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (servicios == null) {
			return 0;
		}
		return servicios.size();
	}

	/*
	 * Metodo sobreescrito del getValueAt
	 * 
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		Servicio servicio = servicios.get(row);
		if (col == 0) {
			return servicio.getId();
		}
		if (col == 1) {
			return servicio.getCodigo();
		}
		if (col == 2) {
			return servicio.getNombre();
		}
		return servicio.getDescripcion();
	}

	/*
	 * Metodo sobreescrito del setValueAt
	 * 
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		Servicio servicio = servicios.get(row);
		if (column == 1) {
			servicio.setCodigo((String) aValue);
		}
		if (column == 2) {
			servicio.setNombre((String) aValue);
		}
		servicio.setDescripcion((String) aValue);

		fireTableCellUpdated(row, column);
	}

	/*
	 * Metodo sobreescrito del isCellEditable
	 * 
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return column != 0;
	}

	/**
	 * Metodo get de la lista de servicios
	 * 
	 * @return lista de servicios
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	/**
	 * Metodo set de la lista de servicios
	 * 
	 * @param servicios
	 *            lista de servicios
	 */
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
		fireTableDataChanged();
	}

}
