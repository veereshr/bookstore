package com.ooad.bookstore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 62, 728, 347);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pay using the registered card");
		rdbtnNewRadioButton.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnNewRadioButton.setBounds(30, 35, 280, 23);
		panel.add(rdbtnNewRadioButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your order has been submitted");
				Purchase purchase = new Purchase();
				purchase.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSubmit.setBounds(497, 112, 89, 31);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.CYAN);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchase purchase = new Purchase();
				purchase.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCancel.setBounds(497, 183, 89, 31);
		panel.add(btnCancel);
		
		JRadioButton rdbtnPayUsingA = new JRadioButton("Pay using a new debit/credit card");
		rdbtnPayUsingA.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnPayUsingA.setBounds(30, 96, 312, 23);
		panel.add(rdbtnPayUsingA);
		
		textField = new JTextField();
		textField.setBounds(169, 184, 209, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCardNumber.setBounds(30, 187, 123, 22);
		panel.add(lblCardNumber);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCvv.setBounds(30, 246, 56, 22);
		panel.add(lblCvv);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 237, 66, 31);
		panel.add(textField_1);
		
		JLabel lblNameOnCard = new JLabel("Name on Card");
		lblNameOnCard.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNameOnCard.setBounds(30, 141, 123, 22);
		panel.add(lblNameOnCard);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 132, 209, 31);
		panel.add(textField_2);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Calibri", Font.BOLD, 20));
		lblExpiryDate.setBounds(30, 296, 123, 22);
		panel.add(lblExpiryDate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(169, 293, 113, 31);
		panel.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(44, 31, 86, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.CYAN);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin customerLogin = new CustomerLogin();
				customerLogin.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 18));
		btnLogout.setBounds(840, 222, 93, 31);
		contentPane.add(btnLogout);
	}
}
