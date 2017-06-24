package com.ooad.bookstore.util;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilitiesDAOImpl {

	private static UtilitiesDAOImpl utilitiesDAOImpl = null;

	public static UtilitiesDAOImpl getInstance() throws FileNotFoundException, SQLException {
		if (utilitiesDAOImpl == null) {
			utilitiesDAOImpl = new UtilitiesDAOImpl();
		}
		return utilitiesDAOImpl;
	}

	private UtilitiesDAOImpl() {

	}

	public String getCustomerPassword(String customerID) {

		PreparedStatement preparedStatement;
		try {
			preparedStatement = DBConnection.getConnection("bookstore").prepareStatement(
					"Select customerPassword from customerAccount where customerID =" + "'" + customerID + "'");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("customerPassword");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
