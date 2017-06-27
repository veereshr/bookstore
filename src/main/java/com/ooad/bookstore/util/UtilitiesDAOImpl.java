package com.ooad.bookstore.util;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class UtilitiesDAOImpl extends AbstractTableModel {

	private static UtilitiesDAOImpl utilitiesDAOImpl = null;
	private String[] columns;
	private Object[][] rows;

	public static UtilitiesDAOImpl getInstance() throws FileNotFoundException, SQLException {
		if (utilitiesDAOImpl == null) {
			utilitiesDAOImpl = new UtilitiesDAOImpl();
		}
		return utilitiesDAOImpl;
	}

	private UtilitiesDAOImpl() {

	}

	public UtilitiesDAOImpl(Object[][] data, String[] columnName) {
		this.columns = columnName;
		this.rows = data;

	}

	public String getCustomerPassword(String customerID) {

		PreparedStatement preparedStatement;
		try {
			preparedStatement = DBConnection.getConnection(DBUtilitiesDAOImpl.DATABASE_NAME).prepareStatement(
					"Select customerPassword from customerAccount where customerID =" + "'" + customerID + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("customerPassword");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean validateEmployeeCredentials(String id, String password) {

		PreparedStatement preparedStatement;
		try {
			preparedStatement = DBConnection.getConnection(DBUtilitiesDAOImpl.DATABASE_NAME)
					.prepareStatement("Select accpass from employee where id =" + "'" + id + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("accpass").equals(password);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getCustomerFirstName(String customerID) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DBConnection.getConnection("bookstore").prepareStatement(
					"Select customerFirstName from customerAccount where customerID =" + "'" + customerID + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("customerFirstName");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getColumnCount() {
		return this.columns.length;
	}

	public int getRowCount() {
		return this.rows.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.rows[rowIndex][columnIndex];
	}

	public String getColumnName(int column) {
		return this.columns[column];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return column == 5;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int colIndex) {

		if (colIndex == 5) {
			boolean select = (Boolean) value;
			rows[rowIndex][colIndex] = select;
		}

		super.setValueAt(value, rowIndex, colIndex);
	}
}


