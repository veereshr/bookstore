package com.ooad.bookstore.model;

public class Customer {

	String userID;
	String customerFirstName;
	String customerLastName;
	String customerPassword;
	String confirmCustomerPassword;
	String customerAddress1;
	String customerAddress2;
	String customerState;
	int customerZipCode;
	String mobileNumber;
	boolean customerGender;
	String nameonCard;
	boolean cardType;
	String cardNumber;
	int cvv;
	String expiry;
	int response;

	private static Customer customer = null;

	public static Customer getInstance() {
		if (customer == null) {
			customer = new Customer();
		}
		return customer;
	}

	private Customer() {

	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getConfirmCustomerPassword() {
		return confirmCustomerPassword;
	}

	public void setConfirmCustomerPassword(String confirmCustomerPassword) {
		this.confirmCustomerPassword = confirmCustomerPassword;
	}

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public int getCustomerZipCode() {
		return customerZipCode;
	}

	public void setCustomerZipCode(int customerZipCode) {
		this.customerZipCode = customerZipCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(boolean customerGender) {
		this.customerGender = customerGender;
	}

	public String getNameonCard() {
		return nameonCard;
	}

	public void setNameonCard(String nameonCard) {
		this.nameonCard = nameonCard;
	}

	public boolean isCardType() {
		return cardType;
	}

	public void setCardType(boolean cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	
}
