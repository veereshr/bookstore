package com.ooad.bookstore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.ooad.bookstore.util.DBConnection;
import com.ooad.bookstore.util.DBUtilitiesDAOImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/***
 * 
 * @author VikneshKumar
 * 
 */

public class DataEntry extends JFrame {

	private JPanel contentPane;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataEntry frame = new DataEntry("","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param userName
	 */
	String userName = null;
	private JLabel lblBookId;
	private JTextField textField_4;
	private JButton btnCancel;

	public DataEntry(final String userName, String type) {
		

			this.userName = userName;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 719, 472);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblBookName = new JLabel("Book Name");
			lblBookName.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
			lblBookName.setBounds(60, 79, 138, 23);
			contentPane.add(lblBookName);

			JLabel lblPrice = new JLabel("Price");
			lblPrice.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
			lblPrice.setBounds(60, 238, 138, 23);
			contentPane.add(lblPrice);

			JLabel lblAvailability = new JLabel("Availability");
			lblAvailability
					.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
			lblAvailability.setBounds(60, 185, 138, 23);
			contentPane.add(lblAvailability);

			JLabel lblBookType = new JLabel("Book Type");
			lblBookType.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
			lblBookType.setBounds(60, 133, 138, 23);
			contentPane.add(lblBookType);

			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String bookName = textField_0.getText();
					String bookType = textField_1.getText();
					String availability = textField_2.getText();
					String price = textField_3.getText();
					String ISBN = textField_4.getText();
					if (addBook(bookName, bookType, availability, price, ISBN) == DBUtilitiesDAOImpl.SUCCESS) {
						JOptionPane.showMessageDialog(null,
								"Successfully added to the database");
					}
					BookInventory bookInventory = new BookInventory(userName);
					bookInventory.setVisible(true);
					dispose();
				}

			});

			btnSave.setFont(new Font("Calibri", Font.BOLD, 20));
			btnSave.setBounds(257, 366, 143, 33);
			contentPane.add(btnSave);

			textField_0 = new JTextField();
			textField_0.setColumns(10);
			textField_0.setBounds(244, 72, 290, 30);
			contentPane.add(textField_0);

			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(244, 132, 290, 30);
			contentPane.add(textField_1);

			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(244, 184, 290, 30);
			contentPane.add(textField_2);

			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(244, 237, 290, 30);
			contentPane.add(textField_3);

			lblBookId = new JLabel("Book ISBN");
			lblBookId.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
			lblBookId.setBounds(60, 288, 138, 23);
			contentPane.add(lblBookId);

			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(244, 287, 290, 30);
			contentPane.add(textField_4);

			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BookInventory bookInventory = new BookInventory(userName);
					bookInventory.setVisible(true);
					dispose();
				}
			});
			btnCancel.setFont(new Font("Calibri", Font.BOLD, 20));
			btnCancel.setBounds(424, 366, 143, 33);
			contentPane.add(btnCancel);
		
		
		
	}

	protected int addBook(String bookName, String bookType,
			String availability, String price, String ISBN) {
		String insertBook = "INSERT into bookdetails (bookID, bookName,bookType,bookAvailability,bookPrice) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection(
					DBUtilitiesDAOImpl.DATABASE_NAME).prepareStatement(
					insertBook);
			preparedStatement.setString(1, ISBN);
			preparedStatement.setString(2, bookName);
			preparedStatement.setString(3, bookType);
			preparedStatement.setString(4, availability);
			preparedStatement.setString(5, price);
			preparedStatement.executeUpdate();
			return DBUtilitiesDAOImpl.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return DBUtilitiesDAOImpl.SQL_EXCEPTION;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
