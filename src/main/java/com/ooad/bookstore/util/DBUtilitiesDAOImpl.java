package com.ooad.bookstore.util;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.ooad.bookstore.model.Customer;

public class DBUtilitiesDAOImpl {

	public static final int SUCCESS = 1;
	public static final int SQL_INTEGRITY_CONSTRAIN_VIOLATION_EXCEPTION = 2;
	public static final int SQL_EXCEPTION = 3;
	private static DBUtilitiesDAOImpl dbUtilitiesDAOImpl = null;

	public static DBUtilitiesDAOImpl getInstance() {
		if (dbUtilitiesDAOImpl == null) {
			dbUtilitiesDAOImpl = new DBUtilitiesDAOImpl();
		}
		return dbUtilitiesDAOImpl;
	}

	public DBUtilitiesDAOImpl() {

	}

	public int updateCustomerDetails() throws SQLException, FileNotFoundException {

		String CustomerRegistration = "INSERT INTO customerAccount VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection("bookstore")
					.prepareStatement(CustomerRegistration);
			preparedStatement.setString(1, getCustomerHelper().getUserID());
			preparedStatement.setString(2, getCustomerHelper().getCustomerFirstName());
			preparedStatement.setString(3, getCustomerHelper().getCustomerLastName());
			preparedStatement.setString(4, getCustomerHelper().getCustomerPassword());
			preparedStatement.setString(5, getCustomerHelper().getCustomerAddress1());
			preparedStatement.setString(6, getCustomerHelper().getCustomerAddress2());
			preparedStatement.setString(7, getCustomerHelper().getCustomerState());
			preparedStatement.setInt(8, getCustomerHelper().getCustomerZipCode());
			preparedStatement.setString(9, getCustomerHelper().getMobileNumber());
			preparedStatement.setString(10, getCustomerHelper().getNameonCard());
			preparedStatement.setInt(11, getCustomerHelper().getCvv());
			preparedStatement.setString(12, getCustomerHelper().getCardNumber());
			preparedStatement.setString(13, getCustomerHelper().getExpiry());

			preparedStatement.executeUpdate();
			return SUCCESS;
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return SQL_INTEGRITY_CONSTRAIN_VIOLATION_EXCEPTION;

		} catch (SQLException e) {
			e.printStackTrace();
			return SQL_EXCEPTION;
		}
	}

	private Customer getCustomerHelper() {
		return Customer.getInstance();
	}
}
