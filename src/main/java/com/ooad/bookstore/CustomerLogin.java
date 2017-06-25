package com.ooad.bookstore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.ooad.bookstore.util.UtilitiesDAOImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

/***
 * 
 * @author VikneshKumar
 *
 */

@SuppressWarnings("serial")
public class CustomerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField;
	private JPasswordField jPasswordField;
	private JButton jButtonLogin;
	private JButton jButtonNewUser;
	private JLabel jLabelHeading;

	public CustomerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabelUserID = new JLabel("User ID");
		jLabelUserID.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		jLabelUserID.setBounds(230, 196, 111, 21);
		contentPane.add(jLabelUserID);

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
					JOptionPane.showMessageDialog(null, " UserName or Password fields cannot be empty!");
				} else {

					try {
						if (validateLogin(userName, password)) {
							Purchase dashboard = new Purchase(userName);
							dashboard.setVisible(true);
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

			private boolean validateLogin(String username, String password) throws FileNotFoundException, SQLException {
				return (password.equals(getUtilitiesDAOImplHelper().getCustomerPassword(username)));
			}
		});

		jButtonLogin.setFont(new Font("Calibri", Font.BOLD, 20));
		jButtonLogin.setBounds(376, 330, 143, 33);
		contentPane.add(jButtonLogin);

		jButtonNewUser = new JButton("New User");
		jButtonNewUser.setFont(new Font("Calibri", Font.BOLD, 18));
		jButtonNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					SignUp signup = new SignUp();
					signup.setVisible(true);
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			}
		});
		jButtonNewUser.setBounds(529, 330, 137, 33);
		contentPane.add(jButtonNewUser);

		jLabelHeading = new JLabel("Customer Login");
		jLabelHeading.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 38));
		jLabelHeading.setForeground(Color.ORANGE);
		jLabelHeading.setBounds(344, 99, 329, 47);
		contentPane.add(jLabelHeading);
	}

	private UtilitiesDAOImpl getUtilitiesDAOImplHelper() throws FileNotFoundException, SQLException {
		return UtilitiesDAOImpl.getInstance();
	}

}
