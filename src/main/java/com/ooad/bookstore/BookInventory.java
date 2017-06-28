package com.ooad.bookstore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ooad.bookstore.model.BookDetails;
import com.ooad.bookstore.util.DBConnection;
import com.ooad.bookstore.util.DBUtilitiesDAOImpl;
import com.ooad.bookstore.util.UtilitiesDAOImpl;

public class BookInventory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane;
	JLabel jLabelDateTime;
	JLabel jLabelDate;
	private static final String CART_ICON = "src/main/resources/cart.jpg";
	private JTable jTable;
	JLabel jLabelGreetingName;

	public BookInventory(final String userName) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		jContentPane = new JPanel();
		jContentPane.setBackground(Color.WHITE);
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jContentPane);

		JLabel jLabelWelcomeNote = new JLabel("Welcome to Book Inventory");
		jLabelWelcomeNote.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC,
				20));

		JLabel jLabelTime = new JLabel("Time");
		jLabelTime.setFont(new Font("Calibri", Font.BOLD, 20));

		jLabelDateTime = new JLabel();
		jLabelDateTime.setForeground(Color.MAGENTA);
		jLabelDateTime.setBackground(Color.WHITE);
		jLabelDateTime.setFont(new Font("Calibri", Font.BOLD, 20));

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Calibri", Font.BOLD, 20));

		jLabelDate = new JLabel();
		jLabelDate.setForeground(Color.MAGENTA);
		jLabelDate.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabelDate.setBackground(Color.WHITE);
		Image img;
		try {
			File sourceImage = new File(CART_ICON);
			img = ImageIO.read(sourceImage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JButton jButtonAddBook = new JButton("Add book");
		jButtonAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataEntry dataEntry = new DataEntry(userName, "add");
				dataEntry.setVisible(true);
				dispose();
			}
		});
		jButtonAddBook.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel jLabel = new JLabel("Book Inventory");
		jLabel.setForeground(Color.ORANGE);
		jLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC,
				36));

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(jScrollPane, BorderLayout.CENTER);

		JButton btnEditBook = new JButton("Logout");
		btnEditBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeLogin login = new EmployeeLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnEditBook.setFont(new Font("Calibri", Font.BOLD, 18));

		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String ISBN = (String) jTable.getValueAt(
							jTable.getSelectedRow(), 0);
					if(deleteBook(ISBN)==DBUtilitiesDAOImpl.SUCCESS){
						JOptionPane.showMessageDialog(null,
								"Successfully deleted book from the database");
					}
					BookInventory bookInventory = new BookInventory(userName);
					bookInventory.setVisible(true);
					dispose();
				}
				catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
					JOptionPane.showMessageDialog(null,
							"Please select a book to delete");
				}
			}
		});
		btnDeleteBook.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JButton btnEditBook_1 = new JButton("Edit Book");
		btnEditBook_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String ISBN = (String) jTable.getValueAt(
							jTable.getSelectedRow(), 0);
						DataEntry dataEntry = new DataEntry(userName, ISBN);
						dataEntry.setVisible(true);
						dispose();	
				}
				catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
					JOptionPane.showMessageDialog(null,
							"Please select a book to edit");
				}
				
				
			}
		});
		btnEditBook_1.setFont(new Font("Calibri", Font.BOLD, 18));
		GroupLayout groupLayoutJContentPane = new GroupLayout(jContentPane);
		groupLayoutJContentPane.setHorizontalGroup(
			groupLayoutJContentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayoutJContentPane.createSequentialGroup()
					.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGap(317)
							.addComponent(jLabel)
							.addGap(150)
							.addComponent(jLabelTime, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(jLabelDateTime, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayoutJContentPane.createSequentialGroup()
									.addComponent(jLabelWelcomeNote)
									.addGap(487)
									.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 738, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDeleteBook, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditBook_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonAddBook, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(groupLayoutJContentPane.createSequentialGroup()
					.addContainerGap(805, Short.MAX_VALUE)
					.addComponent(btnEditBook, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayoutJContentPane.setVerticalGroup(
			groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayoutJContentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelDateTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelWelcomeNote, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
						.addComponent(jLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(jButtonAddBook, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditBook_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDeleteBook, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
							.addComponent(btnEditBook, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(35))))
		);

		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] { "ISBN",
				"Book", "Type", "Availability", "Price" }));
		jScrollPane.setViewportView(jTable);
		jContentPane.setLayout(groupLayoutJContentPane);

		setDate();
		displayTable();

		JLabel jLabelGreetingName;
		try {
			if (userName != null) {
				jLabelGreetingName = new JLabel(getUtilitiesDAOImplHelper()
						.getCustomerFirstName(userName));
				jLabelGreetingName.setForeground(Color.MAGENTA);
				jLabelGreetingName.setFont(new Font("Calibri", Font.BOLD
						| Font.ITALIC, 20));
				jLabelGreetingName.setBounds(240, 55, 200, 17);
				jContentPane.add(jLabelGreetingName);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected int deleteBook(String ISBN) {

		String insertBook = "DELETE from bookdetails where bookID=?";
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection(
					DBUtilitiesDAOImpl.DATABASE_NAME).prepareStatement(
					insertBook);
			preparedStatement.setString(1, ISBN);
			preparedStatement.executeUpdate();
			return DBUtilitiesDAOImpl.SUCCESS;
	}
		catch (SQLException e) {
			e.printStackTrace();
			return DBUtilitiesDAOImpl.SQL_EXCEPTION;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	private UtilitiesDAOImpl getUtilitiesDAOImplHelper()
			throws FileNotFoundException, SQLException {
		return UtilitiesDAOImpl.getInstance();
	}

	public void setDate() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"EEE, d MMM yyyy");
				Calendar calendar = Calendar.getInstance();
				Date date = calendar.getTime();
				jLabelDateTime.setText(timeFormat.format(date));
				jLabelDate.setText(dateFormat.format(date));
			}

		};
		new Timer(1000, actionListener).start();
	}

	public void displayTable() {
		ArrayList<BookDetails> arrayList = new ArrayList<BookDetails>();
		arrayList = getDBUtilitiesDAOImplHelper().getBookDetails();
		String[] columns = { "ISBN", "Book", "Type", "Availability", "Price" };
		Object[][] rows = new Object[arrayList.size()][5];

		for (int i = 0; i < arrayList.size(); i++) {
			rows[i][0] = arrayList.get(i).getISBN();
			rows[i][1] = arrayList.get(i).getBook();
			rows[i][2] = arrayList.get(i).getType();
			rows[i][3] = arrayList.get(i).getAvailability();
			rows[i][4] = arrayList.get(i).getPrice();

		}
		UtilitiesDAOImpl utilitiesDAOImpl = new UtilitiesDAOImpl(rows, columns);
		jTable.setModel(utilitiesDAOImpl);
		jTable.setRowHeight(100);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(150);

	}

	private DBUtilitiesDAOImpl getDBUtilitiesDAOImplHelper() {
		return DBUtilitiesDAOImpl.getInstance();
	}
}
