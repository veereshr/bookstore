package com.ooad.bookstore;

/***
 * 
 * @author VikneshKumar
 *
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.ooad.bookstore.model.BookDetails;
import com.ooad.bookstore.util.DBUtilitiesDAOImpl;
import com.ooad.bookstore.util.UtilitiesDAOImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Purchase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane;
	JLabel jLabelDateTime;
	JLabel jLabelDate;
	private static final String CART_ICON = "src/main/resources/cart.jpg";
	private JTable jTable;
	JLabel jLabelGreetingName;

	public Purchase(String userName) {

		initialize(userName);
	}
	
	public Purchase() {
		String guest = "Guest";
		guestInitialize(guest);
	}

	public void initialize(String userName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		jContentPane = new JPanel();
		jContentPane.setBackground(Color.WHITE);
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jContentPane);

		JLabel jLabelWelcomeNote = new JLabel("Welcome to Book Store");
		jLabelWelcomeNote.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));

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

		JButton jButtonAddToCart = new JButton();
		Image img;
		try {
			File sourceImage = new File(CART_ICON);
			img = ImageIO.read(sourceImage);
			jButtonAddToCart.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jButtonAddToCart.setFont(new Font("Calibri", Font.BOLD, 20));

		try {
			if (userName != null) {
				jLabelGreetingName = new JLabel(getUtilitiesDAOImplHelper().getCustomerFirstName(userName));
				jLabelGreetingName.setForeground(Color.MAGENTA);
				jLabelGreetingName.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
				jLabelGreetingName.setBounds(240, 55, 200, 17);
				jContentPane.add(jLabelGreetingName);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JButton jButtonModifyAccount = new JButton("Modify Account");
		jButtonModifyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String customerFirstName = jLabelGreetingName.getText();
					ModifyAccount modifyAccount = new ModifyAccount(customerFirstName);
					modifyAccount.setVisible(true);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		jButtonModifyAccount.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel jLabelAddToCart = new JLabel("Add to Cart");
		jLabelAddToCart.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel jLabel = new JLabel("Book Store");
		jLabel.setForeground(Color.ORANGE);
		jLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 36));

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		GroupLayout groupLayoutJContentPane = new GroupLayout(jContentPane);
		groupLayoutJContentPane.setHorizontalGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayoutJContentPane.createSequentialGroup().addGroup(groupLayoutJContentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(317)
								.addComponent(jLabel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addGap(206)
								.addComponent(jLabelTime, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(2).addComponent(jLabelDateTime, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(796).addComponent(
								jButtonModifyAccount, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(27)
								.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayoutJContentPane.createSequentialGroup()
												.addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 738,
														GroupLayout.PREFERRED_SIZE)
												.addGap(26)
												.addComponent(jButtonAddToCart, GroupLayout.PREFERRED_SIZE, 66,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10).addComponent(jLabelAddToCart, GroupLayout.PREFERRED_SIZE,
														91, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayoutJContentPane.createSequentialGroup()
												.addComponent(jLabelWelcomeNote, GroupLayout.PREFERRED_SIZE, 205,
														GroupLayout.PREFERRED_SIZE)
												.addGap(516)
												.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 46,
														GroupLayout.PREFERRED_SIZE)
												.addGap(2).addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 151,
														GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(16, Short.MAX_VALUE)));
		groupLayoutJContentPane.setVerticalGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(4)
						.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(15).addComponent(
										jLabelTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(15).addComponent(
										jLabelDateTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
						.addGap(12)
						.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelWelcomeNote, GroupLayout.PREFERRED_SIZE, 19,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(137)
										.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(jButtonAddToCart, GroupLayout.PREFERRED_SIZE, 62,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(23)
														.addComponent(jLabelAddToCart, GroupLayout.PREFERRED_SIZE, 19,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(23).addComponent(jButtonModifyAccount, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(25).addComponent(
										jScrollPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)))));

		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Wishlist", "Book", "Type", "Availability", "Price", "Select", "Quantity" }));
		jScrollPane.setViewportView(jTable);
		jContentPane.setLayout(groupLayoutJContentPane);

		setDate();
		displayTable();
	}
	
	public void guestInitialize(String userName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		jContentPane = new JPanel();
		jContentPane.setBackground(Color.WHITE);
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jContentPane);

		JLabel jLabelWelcomeNote = new JLabel("Welcome to Book Store");
		jLabelWelcomeNote.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));

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

		JButton jButtonAddToCart = new JButton();
		Image img;
		try {
			File sourceImage = new File(CART_ICON);
			img = ImageIO.read(sourceImage);
			jButtonAddToCart.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jButtonAddToCart.setFont(new Font("Calibri", Font.BOLD, 20));

		try {
			if (userName != null) {
				jLabelGreetingName = new JLabel(getUtilitiesDAOImplHelper().getCustomerFirstName(userName));
				jLabelGreetingName.setForeground(Color.MAGENTA);
				jLabelGreetingName.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
				jLabelGreetingName.setBounds(240, 55, 200, 17);
				jContentPane.add(jLabelGreetingName);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JButton jButtonModifyAccount = new JButton("Modify Account");
		jButtonModifyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You logged in using a guest account! Please create an account");
			}
		});
		jButtonModifyAccount.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel jLabelAddToCart = new JLabel("Add to Cart");
		jLabelAddToCart.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel jLabel = new JLabel("Book Store");
		jLabel.setForeground(Color.ORANGE);
		jLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 36));

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		GroupLayout groupLayoutJContentPane = new GroupLayout(jContentPane);
		groupLayoutJContentPane.setHorizontalGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayoutJContentPane.createSequentialGroup().addGroup(groupLayoutJContentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(317)
								.addComponent(jLabel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addGap(206)
								.addComponent(jLabelTime, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(2).addComponent(jLabelDateTime, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(796).addComponent(
								jButtonModifyAccount, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(27)
								.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayoutJContentPane.createSequentialGroup()
												.addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 738,
														GroupLayout.PREFERRED_SIZE)
												.addGap(26)
												.addComponent(jButtonAddToCart, GroupLayout.PREFERRED_SIZE, 66,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10).addComponent(jLabelAddToCart, GroupLayout.PREFERRED_SIZE,
														91, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayoutJContentPane.createSequentialGroup()
												.addComponent(jLabelWelcomeNote, GroupLayout.PREFERRED_SIZE, 205,
														GroupLayout.PREFERRED_SIZE)
												.addGap(516)
												.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 46,
														GroupLayout.PREFERRED_SIZE)
												.addGap(2).addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 151,
														GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(16, Short.MAX_VALUE)));
		groupLayoutJContentPane.setVerticalGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(4)
						.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(15).addComponent(
										jLabelTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(15).addComponent(
										jLabelDateTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
						.addGap(12)
						.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelWelcomeNote, GroupLayout.PREFERRED_SIZE, 19,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(137)
										.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(jButtonAddToCart, GroupLayout.PREFERRED_SIZE, 62,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(23)
														.addComponent(jLabelAddToCart, GroupLayout.PREFERRED_SIZE, 19,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(23).addComponent(jButtonModifyAccount, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(25).addComponent(
										jScrollPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)))));

		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "WishList", "Book", "Type", "Availability", "Price", "Select", "Quantity" }));
		jScrollPane.setViewportView(jTable);
		jContentPane.setLayout(groupLayoutJContentPane);

		setDate();
		displayTable();
	}

	private UtilitiesDAOImpl getUtilitiesDAOImplHelper() throws FileNotFoundException, SQLException {
		return UtilitiesDAOImpl.getInstance();
	}

	public void setDate() {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
				SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
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
		String[] columns = { "WishList", "Book", "Type", "Availability", "Price", "Select", "Quantity" };
		Object[][] rows = new Object[arrayList.size()][7];

		for (int i = 0; i < arrayList.size(); i++) {
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
