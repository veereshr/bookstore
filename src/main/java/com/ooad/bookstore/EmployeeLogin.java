package com.ooad.bookstore;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ooad.bookstore.util.UtilitiesDAOImpl;


public class EmployeeLogin extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private JButton jButtonLogin;
	private JButton jButtonNewUser;
	private JLabel jLabelHeading;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin frame = new EmployeeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabelEmployeeID = new JLabel("ID");
		jLabelEmployeeID.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		jLabelEmployeeID.setBounds(230, 196, 111, 21);
		contentPane.add(jLabelEmployeeID);

		JLabel jLabelPassword = new JLabel("Password");
		jLabelPassword.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		jLabelPassword.setBounds(230, 262, 111, 21);
		contentPane.add(jLabelPassword);

		jTextField = new JTextField();
		jTextField.setBounds(376, 194, 290, 30);
		contentPane.add(jTextField);
		jTextField.setColumns(10);

		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(376, 260, 290, 30);
		contentPane.add(jPasswordField);

		jButtonLogin = new JButton("Login");
		jButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String userName = jTextField.getText();
				@SuppressWarnings("deprecation")
				String password = jPasswordField.getText();
				if (userName.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "UserName or Password fields cannot be empty!");
				} else {

					try {
						if (validateLogin(userName, password)) {
							BookInventory inventory = new BookInventory(userName);
							inventory.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect Credentials");
						}
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			private boolean validateLogin(String id, String password) throws FileNotFoundException, SQLException {
				return (getUtilitiesDAOImplHelper().validateEmployeeCredentials(id, password));
			}
		});

		jButtonLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		jButtonLogin.setBounds(376, 330, 143, 33);
		contentPane.add(jButtonLogin);

//		jButtonNewUser = new JButton("New User");
//		jButtonNewUser.setFont(new Font("Calibri", Font.BOLD, 18));
//		jButtonNewUser.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent actionEvent) {
//				try {
//					SignUp signup = new SignUp();
//					signup.setVisible(true);
//				} catch (ParseException pe) {
//					pe.printStackTrace();
//				}
//			}
//		});
//		jButtonNewUser.setBounds(529, 330, 137, 33);
//		contentPane.add(jButtonNewUser);

		jLabelHeading = new JLabel("Employee Login");
		jLabelHeading.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 38));
		jLabelHeading.setForeground(Color.ORANGE);
		jLabelHeading.setBounds(344, 99, 329, 47);
		contentPane.add(jLabelHeading);
	}
	
	private UtilitiesDAOImpl getUtilitiesDAOImplHelper() throws FileNotFoundException, SQLException {
		return UtilitiesDAOImpl.getInstance();
	}

}
