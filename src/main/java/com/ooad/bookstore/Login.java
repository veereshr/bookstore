package com.ooad.bookstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

/***
 * 
 * @author VikneshKumar
 *
 */

public class Login {

	private JFrame frame;
	private static final String CUSTOMER_LOGIN_IMAGE = "src/main/resources/customerLogin.jpg";
	private static final String EMPLOYEE_LOGIN_IMAGE = "src/main/resources/employeeLogin.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel jLabelHeading = new JLabel("Book Store");
		jLabelHeading.setForeground(Color.ORANGE);
		jLabelHeading.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 36));
		jLabelHeading.setBounds(404, 36, 225, 37);
		frame.getContentPane().add(jLabelHeading);

		JButton jButtonCustomerLogin = new JButton();
		Image img;
		try {
			File sourceImage = new File(CUSTOMER_LOGIN_IMAGE);
			img = ImageIO.read(sourceImage);
			jButtonCustomerLogin.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		jButtonCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				CustomerLogin customerLogin = new CustomerLogin();
				customerLogin.setVisible(true);
			}
		});
		jButtonCustomerLogin.setBounds(223,128,225,232);
		frame.getContentPane().add(jButtonCustomerLogin);

		JButton jButtonEmployeeLogin = new JButton();
		Image image;
		try {
			File sourceImage = new File(EMPLOYEE_LOGIN_IMAGE);
			image = ImageIO.read(sourceImage);
			jButtonEmployeeLogin.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		jButtonEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				EmployeeLogin employeeLogin = new EmployeeLogin();
				employeeLogin.setVisible(true);
			}
		});
		
		
		jButtonEmployeeLogin.setBounds(605, 128, 225, 232);
		frame.getContentPane().add(jButtonEmployeeLogin);
		
		
		JLabel jLabelCustomerLogin = new JLabel("Customer Login");
		jLabelCustomerLogin.setFont(new Font("Calibri", Font.BOLD, 34));
		jLabelCustomerLogin.setBounds(223, 393, 225, 37);
		frame.getContentPane().add(jLabelCustomerLogin);
		
		JLabel jLabelEmployeeLogin = new JLabel("Employee Login");
		jLabelEmployeeLogin.setFont(new Font("Calibri", Font.BOLD, 34));
		jLabelEmployeeLogin.setBounds(605, 393, 234, 37);
		frame.getContentPane().add(jLabelEmployeeLogin);
	}

}
