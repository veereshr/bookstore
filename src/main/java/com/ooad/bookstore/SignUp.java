package com.ooad.bookstore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.ooad.bookstore.model.Customer;
import com.ooad.bookstore.util.DBUtilitiesDAOImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.text.ParseException;

/***
 * 
 * @author VikneshKumar
 *
 */

@SuppressWarnings("serial")
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldFirstName;
	private JTextField jTextFieldLastName;
	private JTextField jTextFieldUserID;
	private JPasswordField jPasswordFieldPassword;
	private JPasswordField jPasswordFieldConfirmPassword;
	private JTextField jTextFieldAddressLine1;
	private JTextField jTextFieldAddressLine2;
	private JTextField jTextFieldState;
	private JTextField jTextFieldZipCode;
	private JTextField jTextFieldMobile;
	private JTextField jTextFieldNameOnCard;
	private JTextField jTextFieldCardNumber;
	private JTextField jTextFieldCvv;
	private JTextField jTextFieldExpirationDate;
	private Pattern pattern;
	private Matcher matcher;
	private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private static final String NAME_REGEX = "[a-zA-Z]+";
	private static final String VALID_DATE_REGEX = "\\d{2}\\/\\d{2}";
	private static final int MAX_LETTERS_IN_NAME = 20;
	private static final int MIN_LETTERS_IN_NAME = 3;
	private static final int MIN_LETTERS_IN_USERID = 3;
	private static final int MAX_LETTERS_IN_USERID = 10;
	private static final int MIN_LETTERS_IN_PASSWORD = 4;
	private static final int MAX_LETTERS_IN_PASSWORD = 10;
	private static final int MAX_LETTERS_IN_ADDRESS = 50;
	private static final int ZIPCODE_LENGTH = 5;
	private static final int CVV_LENGTH = 3;
	private static final int MOBILE_NUMBER_LENGTH = 10;
	private static final int CARD_NUMBER_LENGTH = 16;
	

	public SignUp() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabelAccountDetails = new JLabel("Account Details");
		jLabelAccountDetails.setFont(new Font("Calibri", Font.BOLD, 24));
		jLabelAccountDetails.setBounds(37, 11, 161, 32);
		contentPane.add(jLabelAccountDetails);

		JLabel jLabelFirstname = new JLabel("*FirstName");
		jLabelFirstname.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelFirstname.setBounds(37, 54, 103, 20);
		contentPane.add(jLabelFirstname);

		jTextFieldFirstName = new JTextField();
		jTextFieldFirstName.setColumns(10);
		jTextFieldFirstName.setBounds(201, 53, 175, 24);
		jTextFieldFirstName.setToolTipText(
				"Enter your FirstName. It should have minimum 3 characters and " + "maximum 20 characters");
		contentPane.add(jTextFieldFirstName);

		JLabel jLabelLastname = new JLabel("*LastName");
		jLabelLastname.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelLastname.setBounds(37, 98, 103, 20);
		contentPane.add(jLabelLastname);

		jTextFieldLastName = new JTextField();
		jTextFieldLastName.setColumns(10);
		jTextFieldLastName.setBounds(201, 97, 175, 24);
		jTextFieldLastName.setToolTipText(
				"Enter your LastName. It should have minimum 3 characters and maximum" + " 20 characters");
		contentPane.add(jTextFieldLastName);

		JLabel jLabelUserID = new JLabel("*User ID");
		jLabelUserID.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelUserID.setBounds(37, 143, 92, 20);
		contentPane.add(jLabelUserID);

		jTextFieldUserID = new JTextField();
		jTextFieldUserID.setColumns(10);
		jTextFieldUserID.setBounds(201, 139, 175, 24);
		jTextFieldUserID.setToolTipText(
				"Enter your userID. It should have minimum 3 characters and maximum " + "10 characters");
		contentPane.add(jTextFieldUserID);

		JLabel jLabelPassword = new JLabel("*Password");
		jLabelPassword.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelPassword.setBounds(37, 188, 92, 20);
		contentPane.add(jLabelPassword);

		jPasswordFieldPassword = new JPasswordField();
		jPasswordFieldPassword.setColumns(10);
		jPasswordFieldPassword.setBounds(201, 184, 175, 24);
		jPasswordFieldPassword.setToolTipText("Password should have atleast one special character, "
				+ "one lowercase letter, one uppercase letter, one number");
		contentPane.add(jPasswordFieldPassword);

		JLabel jLabelConfirmPassword = new JLabel("*Confirm Password");
		jLabelConfirmPassword.setFont(new Font("Calibri", Font.ITALIC, 19));
		jLabelConfirmPassword.setBounds(37, 234, 161, 20);
		contentPane.add(jLabelConfirmPassword);

		jPasswordFieldConfirmPassword = new JPasswordField();
		jPasswordFieldConfirmPassword.setColumns(10);
		jPasswordFieldConfirmPassword.setBounds(201, 233, 175, 24);
		contentPane.add(jPasswordFieldConfirmPassword);

		JLabel jLabelAddress1 = new JLabel("*Address Line 1");
		jLabelAddress1.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelAddress1.setBounds(37, 283, 161, 20);
		contentPane.add(jLabelAddress1);

		jTextFieldAddressLine1 = new JTextField();
		jTextFieldAddressLine1.setColumns(10);
		jTextFieldAddressLine1.setBounds(201, 282, 175, 24);
		contentPane.add(jTextFieldAddressLine1);

		JLabel jLabelAddressLine2 = new JLabel("Address Line 2");
		jLabelAddressLine2.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelAddressLine2.setBounds(37, 330, 161, 20);
		contentPane.add(jLabelAddressLine2);

		jTextFieldAddressLine2 = new JTextField();
		jTextFieldAddressLine2.setColumns(10);
		jTextFieldAddressLine2.setBounds(201, 329, 175, 24);
		contentPane.add(jTextFieldAddressLine2);

		JLabel jLabelState = new JLabel("*State");
		jLabelState.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelState.setBounds(37, 378, 161, 20);
		contentPane.add(jLabelState);

		jTextFieldState = new JTextField();
		jTextFieldState.setColumns(10);
		jTextFieldState.setBounds(201, 377, 175, 24);
		jTextFieldState.setToolTipText("Enter your state");
		contentPane.add(jTextFieldState);

		JLabel jLabelZipCode = new JLabel("*ZipCode");
		jLabelZipCode.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelZipCode.setBounds(37, 426, 161, 20);
		contentPane.add(jLabelZipCode);

		jTextFieldZipCode = new JTextField();
		jTextFieldZipCode.setColumns(10);
		jTextFieldZipCode.setBounds(201, 425, 175, 24);
		jTextFieldZipCode.setToolTipText("Enter the zipcode. It should be a 5-digit number");
		contentPane.add(jTextFieldZipCode);

		JLabel jLabelMobile = new JLabel("*Mobile");
		jLabelMobile.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelMobile.setBounds(37, 477, 161, 20);
		contentPane.add(jLabelMobile);

		jTextFieldMobile = new JTextField();
		jTextFieldMobile.setColumns(10);
		jTextFieldMobile.setBounds(201, 476, 175, 24);
		jTextFieldMobile.setToolTipText("Enter your 10 digit mobile number");
		contentPane.add(jTextFieldMobile);

		JLabel jLabelGender = new JLabel("*Gender");
		jLabelGender.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelGender.setBounds(37, 519, 161, 20);
		contentPane.add(jLabelGender);

		JRadioButton radioButtonMale = new JRadioButton("Male");
		radioButtonMale.setBackground(Color.WHITE);
		radioButtonMale.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButtonMale.setBounds(199, 519, 84, 23);
		contentPane.add(radioButtonMale);

		JRadioButton radioButtonFemale = new JRadioButton("Female");
		radioButtonFemale.setBackground(Color.WHITE);
		radioButtonFemale.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButtonFemale.setBounds(285, 519, 92, 23);
		contentPane.add(radioButtonFemale);

		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(radioButtonMale);
		buttonGroup1.add(radioButtonFemale);

		JLabel jLabelCardDetails = new JLabel("Card Details");
		jLabelCardDetails.setFont(new Font("Calibri", Font.BOLD, 24));
		jLabelCardDetails.setBounds(456, 11, 161, 32);
		contentPane.add(jLabelCardDetails);

		JLabel jLabelNameOnCard = new JLabel("*Name on Card");
		jLabelNameOnCard.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelNameOnCard.setBounds(456, 54, 143, 20);
		contentPane.add(jLabelNameOnCard);

		jTextFieldNameOnCard = new JTextField();
		jTextFieldNameOnCard.setColumns(10);
		jTextFieldNameOnCard.setBounds(622, 53, 191, 24);
		contentPane.add(jTextFieldNameOnCard);

		JLabel jLabelCardType = new JLabel("*Card Type");
		jLabelCardType.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelCardType.setBounds(456, 98, 125, 20);
		contentPane.add(jLabelCardType);

		JRadioButton radioButtonDebit = new JRadioButton("Debit");
		radioButtonDebit.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButtonDebit.setBackground(Color.WHITE);
		radioButtonDebit.setBounds(624, 98, 84, 23);
		contentPane.add(radioButtonDebit);

		JRadioButton radioButtonCredit = new JRadioButton("Credit");
		radioButtonCredit.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButtonCredit.setBackground(Color.WHITE);
		radioButtonCredit.setBounds(729, 98, 84, 23);
		contentPane.add(radioButtonCredit);

		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(radioButtonDebit);
		buttonGroup2.add(radioButtonCredit);

		JLabel jLabelCardNumber = new JLabel("*Card Number");
		jLabelCardNumber.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelCardNumber.setBounds(456, 140, 125, 20);
		contentPane.add(jLabelCardNumber);

		jTextFieldCardNumber = new JTextField();
		jTextFieldCardNumber.setColumns(10);
		jTextFieldCardNumber.setBounds(622, 139, 191, 24);
		jTextFieldCardNumber.setToolTipText("Enter your 16-digit card number");
		contentPane.add(jTextFieldCardNumber);

		JLabel jLabelCvv = new JLabel("*CVV");
		jLabelCvv.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelCvv.setBounds(456, 184, 125, 20);
		contentPane.add(jLabelCvv);

		jTextFieldCvv = new JTextField();
		jTextFieldCvv.setColumns(10);
		jTextFieldCvv.setBounds(622, 184, 67, 24);
		jTextFieldCvv.setToolTipText(
				"Enter your 3-digit CVV number. It should be at " + "the back of your debit/credit card");
		contentPane.add(jTextFieldCvv);

		JLabel jLabelExpirationDate = new JLabel("*Expiration Date");
		jLabelExpirationDate.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelExpirationDate.setBounds(456, 225, 143, 20);
		contentPane.add(jLabelExpirationDate);

		jTextFieldExpirationDate = new JTextField();
		jTextFieldExpirationDate.setColumns(10);
		jTextFieldExpirationDate.setBounds(622, 224, 125, 24);
		jTextFieldExpirationDate.setToolTipText("Enter the expiration date of your debit/credit card");
		contentPane.add(jTextFieldExpirationDate);

		JButton jButtonCancel = new JButton("Cancel");
		jButtonCancel.setBackground(Color.CYAN);
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin customerLogin = new CustomerLogin();
				customerLogin.setVisible(true);
			}
		});
		jButtonCancel.setFont(new Font("Calibri", Font.BOLD, 20));
		jButtonCancel.setBounds(648, 283, 155, 33);
		contentPane.add(jButtonCancel);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.CYAN);
		pattern = Pattern.compile(PASSWORD_REGEX);
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int count = 0, flag = 1;
				String alert[] = new String[25];
				StringBuilder stringBuilder = new StringBuilder();
				while (flag > 0) {

					// Checkpoint for FirstName
					if (jTextFieldFirstName.getText().equals("")) {
						alert[count] = "FirstName field cannot be empty" + "\n";
						count++;
					} else if ((jTextFieldFirstName.getText().length() > MAX_LETTERS_IN_NAME)
							&& (jTextFieldFirstName.getText().length() < MIN_LETTERS_IN_NAME)) {
						alert[count] = "FirstName should have min 3 characters and max 20 Characters" + "\n";
						count++;
					} else if (!(Pattern.matches(NAME_REGEX, jTextFieldFirstName.getText()))) {
						alert[count] = "FirstName can only contain alphabets" + "\n";
						count++;
					} else {
						getCustomerHelper().setCustomerFirstName(jTextFieldFirstName.getText());
					}

					// Checkpoint for Last Name
					if (jTextFieldLastName.getText().equals("")) {
						alert[count] = "LastName field cannot be empty" + "\n";
						count++;
					} else if ((jTextFieldLastName.getText().length() > MAX_LETTERS_IN_NAME)
							&& (jTextFieldLastName.getText().length() < MIN_LETTERS_IN_NAME)) {
						alert[count] = "LastName should have min 3 characters and max 20 Characters" + "\n";
						count++;
					} else if (!(Pattern.matches(NAME_REGEX, jTextFieldLastName.getText()))) {
						alert[count] = "LastName can only contain alphabets" + "\n";
						count++;
					} else {
						getCustomerHelper().setCustomerLastName(jTextFieldLastName.getText());
					}

					// Checkpoint for UserID
					if (jTextFieldUserID.getText().equals("")) {
						alert[count] = "UserID field cannot be empty" + "\n";
						count++;
					} else if ((jTextFieldUserID.getText().length() < MIN_LETTERS_IN_USERID)
							&& (jTextFieldUserID.getText().length() > MAX_LETTERS_IN_USERID)) {
						alert[count] = "User ID should have min 3 characters and max 10 Characters" + "\n";
						count++;
					} else {
						getCustomerHelper().setUserID(jTextFieldUserID.getText());
					}

					// Checkpoint for Password
					if (jPasswordFieldPassword.getText().equals("")) {
						alert[count] = "Password field cannot be empty" + "\n";
						count++;
					} else if ((jPasswordFieldPassword.getText().length() < MIN_LETTERS_IN_PASSWORD)
							&& (jPasswordFieldPassword.getText().length() > MAX_LETTERS_IN_PASSWORD)) {
						alert[count] = "Password should have min 4 characters and max 10 Characters" + "\n";
						count++;
					} else if (!isValidPassword()) {
						alert[count] = "Not a valid password. It should have atleast one lowercase, "
								+ "atleast one uppercase, atleast one digit and one special character" + "\n";
						count++;
					} else if (jPasswordFieldPassword.getText().equals(jPasswordFieldConfirmPassword.getText())) {
						getCustomerHelper().setCustomerPassword(jPasswordFieldPassword.getText().toString());
					} else {
						alert[count] = "Passwords doesn't match!" + "\n";
						count++;
					}

					// Checkpoint for Address Line 1
					if (jTextFieldAddressLine1.getText().equals("")) {
						alert[count] = "Address field cannot be empty" + "\n";
						count++;
					} else if (jTextFieldAddressLine1.getText().length() > MAX_LETTERS_IN_ADDRESS) {
						alert[count] = "Address cannot exceed more than 50 Characters" + "\n";
						count++;
					} else {
						getCustomerHelper().setCustomerAddress1(jTextFieldAddressLine1.getText());
					}

					// Checkpoint for Address Line 2
					if (!(jTextFieldAddressLine2.getText().equals(""))) {
						getCustomerHelper().setCustomerAddress2(jTextFieldAddressLine2.getText());
					} else if (jTextFieldAddressLine2.getText().length() > MAX_LETTERS_IN_ADDRESS) {
						alert[count] = "Address cannot exceed more than 50 Characters" + "\n";
						count++;
					}

					// Checkpoint for ZipCode
					if (jTextFieldZipCode.getText().length() != ZIPCODE_LENGTH) {
						alert[count] = "Enter a valid Zipcode" + "\n";
						count++;
					} else {
						getCustomerHelper().setCustomerZipCode(jTextFieldZipCode.getText());
					}

					// Checkpoint for State
					if (jTextFieldState.getText().equals("")) {
						alert[count] = "State cannot be empty!" + "\n";
						count++;
					} else {
						getCustomerHelper().setCustomerState(jTextFieldState.getText());
					}

					// Checkpoint for Mobile Number
					if (jTextFieldMobile.getText().length() != MOBILE_NUMBER_LENGTH) {
						alert[count] = "Enter a valid Mobile Number" + "\n";
						count++;
					} else if (jTextFieldMobile.getText().equals("")) {
						alert[count] = "Mobile Number cannot be empty" + "\n";
						count++;
					} else {
						getCustomerHelper().setMobileNumber(jTextFieldMobile.getText());
					}

					// Checkpoint for Name on Card
					if (jTextFieldNameOnCard.getText().equals("")) {
						alert[count] = "No Data entered for the Name on card field" + "\n";
						count++;
					} else {
						getCustomerHelper().setNameonCard(jTextFieldNameOnCard.getText());
					}

					// Checkpoint for CVV
					if (jTextFieldCvv.getText().equals("")) {
						alert[count] = "CVV number cannot be empty" + "\n";
						count++;
					} else if (jTextFieldCvv.getText().length() != CVV_LENGTH) {
						alert[count] = "Enter a valid CVV number" + "\n";
						count++;
					} else {
						getCustomerHelper().setCvv(jTextFieldCvv.getText());
					}

					// Checkpoint for Card Number
					if (jTextFieldCardNumber.getText().equals("")) {
						alert[count] = "Card Number cannot be empty" + "\n";
						count++;
					} else if (jTextFieldCardNumber.getText().length() != CARD_NUMBER_LENGTH) {
						alert[count] = "Enter a valid Card Number" + "\n";
						count++;
					} else {
						getCustomerHelper().setCardNumber(jTextFieldCardNumber.getText());
					}

					// Checkpoint for Expiration Date
					if (jTextFieldExpirationDate.getText().equals("")) {
						alert[count] = "Expiration Date cannot be empty" + "\n";
						count++;
					} else if (!(jTextFieldExpirationDate.getText().matches(VALID_DATE_REGEX))) {
						alert[count] = "Enter a valid Date" + "\n";
					} else {
						getCustomerHelper().setExpiry(jTextFieldExpirationDate.getText());
					}
					flag--;
				}

				for (int j = 0; j < alert.length; j++) {
					if (alert[j] != null) {
						stringBuilder.append(alert[j]);
					}
				}
				String warning = stringBuilder.toString();
				JOptionPane.showMessageDialog(null, warning);

				if (count == 0) {
					try {
						getCustomerHelper().setResponse(getDBUtilitiesDAOImplHelper().insertCustomerDetails());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (getCustomerHelper().getResponse() == DBUtilitiesDAOImpl.SUCCESS) {
						JOptionPane.showMessageDialog(null,
								getCustomerHelper().getUserID() + " your account has been created!");
						contentPane.setVisible(false);
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
						frame.dispose();
						new CustomerLogin().setVisible(true);
					} else if (getCustomerHelper()
							.getResponse() == DBUtilitiesDAOImpl.SQL_INTEGRITY_CONSTRAIN_VIOLATION_EXCEPTION) {
						JOptionPane.showMessageDialog(null, "Sorry " + getCustomerHelper().getUserID()
								+ " already exists, try with a different one");
					} else if (getCustomerHelper().getResponse() == DBUtilitiesDAOImpl.SQL_EXCEPTION) {
						JOptionPane.showMessageDialog(null, "Sorry registration falied ");
					}
				}
			}

			@SuppressWarnings("deprecation")
			private boolean isValidPassword() {
				matcher = pattern.matcher(jPasswordFieldPassword.getText());
				return matcher.matches();
			}
		});
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSubmit.setBounds(476, 283, 155, 33);
		contentPane.add(btnSubmit);

		JLabel jLabelTip1 = new JLabel("Hover over the Text Field for help! ");
		jLabelTip1.setForeground(Color.MAGENTA);
		jLabelTip1.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelTip1.setBounds(456, 368, 312, 24);
		contentPane.add(jLabelTip1);
		
		JLabel jLabelTip2 = new JLabel("Fields marked with * are mandatory fields");
		jLabelTip2.setForeground(Color.MAGENTA);
		jLabelTip2.setFont(new Font("Calibri", Font.ITALIC, 20));
		jLabelTip2.setBounds(456, 411, 357, 24);
		contentPane.add(jLabelTip2);
	}

	private Customer getCustomerHelper() {
		return Customer.getInstance();
	}

	private DBUtilitiesDAOImpl getDBUtilitiesDAOImplHelper() {
		return DBUtilitiesDAOImpl.getInstance();
	}

	public String returnUserID() {
		String userID = jTextFieldUserID.getText();
		return userID;
	}
}
