package com.ooad.bookstore.util;

/***
 * 
 * @author VikneshKumar
 *
 */

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.ooad.bookstore.model.BookDetails;
import com.ooad.bookstore.model.Customer;

public class DBUtilitiesDAOImpl {

	public static final int SUCCESS = 1;
	public static final int SQL_INTEGRITY_CONSTRAIN_VIOLATION_EXCEPTION = 2;
	public static final int SQL_EXCEPTION = 3;
	private static DBUtilitiesDAOImpl dbUtilitiesDAOImpl = null;
	public static final String DATABASE_NAME = "bookstore";

	public static DBUtilitiesDAOImpl getInstance() {
		if (dbUtilitiesDAOImpl == null) {
			dbUtilitiesDAOImpl = new DBUtilitiesDAOImpl();
		}
		return dbUtilitiesDAOImpl;
	}

	private DBUtilitiesDAOImpl() {

	}

	public int insertCustomerDetails() throws SQLException, FileNotFoundException {

		String customerRegistration = "INSERT INTO customerAccount VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection(DATABASE_NAME)
					.prepareStatement(customerRegistration);
			preparedStatement.setString(1, getCustomerHelper().getUserID());
			preparedStatement.setString(2, getCustomerHelper().getCustomerFirstName());
			preparedStatement.setString(3, getCustomerHelper().getCustomerLastName());
			preparedStatement.setString(4, getCustomerHelper().getCustomerPassword());
			preparedStatement.setString(5, getCustomerHelper().getCustomerAddress1());
			preparedStatement.setString(6, getCustomerHelper().getCustomerAddress2());
			preparedStatement.setString(7, getCustomerHelper().getCustomerState());
			preparedStatement.setString(8, getCustomerHelper().getCustomerZipCode());
			preparedStatement.setString(9, getCustomerHelper().getMobileNumber());
			preparedStatement.setString(10, getCustomerHelper().getNameonCard());
			preparedStatement.setString(11, getCustomerHelper().getCvv());
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

	public ArrayList<BookDetails> getBookDetails() {

		String getBookDetails = "SELECT bookID, bookName, bookType, bookAvailability, bookPrice FROM bookDetails";
		PreparedStatement prepareStatement;
		try {
			prepareStatement = DBConnection.getConnection(DATABASE_NAME).prepareStatement(getBookDetails);
			ResultSet resultSet = prepareStatement.executeQuery();
			ArrayList<BookDetails> arrayList = new ArrayList<BookDetails>();
			while (resultSet.next()) {
				BookDetails bookDetails = new BookDetails();
				bookDetails.setISBN(resultSet.getString("bookID"));
				bookDetails.setBook(resultSet.getString("bookName"));
				bookDetails.setType(resultSet.getString("bookType"));
				bookDetails.setAvailability(resultSet.getString("bookAvailability"));
				bookDetails.setPrice(resultSet.getString("bookPrice"));
				arrayList.add(bookDetails);
			}
			return arrayList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public BookDetails getBookDetails(String ISBN){
		String getBookDetails = "SELECT bookID,bookName, bookType, bookAvailability, bookPrice FROM bookDetails where bookID=?";
		PreparedStatement prepareStatement;
		try {
			prepareStatement = DBConnection.getConnection(DATABASE_NAME).prepareStatement(getBookDetails);
			prepareStatement.setString(1, ISBN);
			ResultSet resultSet = prepareStatement.executeQuery();
			BookDetails bookDetails = null;
			if (resultSet.next()) {
				bookDetails = new BookDetails();
				bookDetails.setISBN(resultSet.getString("bookID"));
				bookDetails.setBook(resultSet.getString("bookName"));
				bookDetails.setType(resultSet.getString("bookType"));
				bookDetails.setAvailability(resultSet.getString("bookAvailability"));
				bookDetails.setPrice(resultSet.getString("bookPrice"));
			}
			return bookDetails;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	private Customer getCustomerHelper() {
		return Customer.getInstance();
	}
	
	

}
