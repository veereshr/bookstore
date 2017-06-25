package com.ooad.bookstore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ooad.bookstore.model.BookDetails;
import com.ooad.bookstore.util.DBUtilitiesDAOImpl;
import com.ooad.bookstore.util.UtilitiesDAOImpl;

public class BookInventory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane;
	JLabel jLabelDateTime;
	JLabel jLabelDate;
	private static final String CART_ICON = "src/main/resources/cart.jpg";
	private JTable jTable;

	public BookInventory(String userName) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		jContentPane = new JPanel();
		jContentPane.setBackground(Color.WHITE);
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jContentPane);

		JLabel jLabelWelcomeNote = new JLabel("Welcome to Book Inventory");
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
		Image img;
		try {
			File sourceImage = new File(CART_ICON);
			img = ImageIO.read(sourceImage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JButton jButtonModifyAccount = new JButton("Add book");
		jButtonModifyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jButtonModifyAccount.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel jLabel = new JLabel("Book Inventory");
		jLabel.setForeground(Color.ORANGE);
		jLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 36));

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		JButton btnEditBook = new JButton("Edit Book");
		btnEditBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditBook.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setFont(new Font("Calibri", Font.BOLD, 18));
		GroupLayout groupLayoutJContentPane = new GroupLayout(jContentPane);
		groupLayoutJContentPane.setHorizontalGroup(
			groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
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
								.addComponent(jButtonModifyAccount, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeleteBook, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditBook, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayoutJContentPane.setVerticalGroup(
			groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayoutJContentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayoutJContentPane.createSequentialGroup()
									.addGap(15)
									.addComponent(jLabelTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayoutJContentPane.createSequentialGroup()
									.addGap(15)
									.addComponent(jLabelDateTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
							.addGap(12)
							.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelWelcomeNote, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
						.addComponent(jLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(jButtonModifyAccount, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditBook, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDeleteBook, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayoutJContentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))))
		);

		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] {"Book", "Type", "Availability", "Price", "Select", "Quantity" }));
		jScrollPane.setViewportView(jTable);
		jContentPane.setLayout(groupLayoutJContentPane);

		setDate();
		displayTable();

		JLabel jLabelGreetingName;
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
		String[] columns = { "Book", "Type", "Availability", "Price", "Select", "Quantity" };
		Object[][] rows = new Object[arrayList.size()][6];

		for (int i = 0; i < arrayList.size(); i++) {
			rows[i][0] = arrayList.get(i).getBook();
			rows[i][1] = arrayList.get(i).getType();
			rows[i][2] = arrayList.get(i).getAvailability();
			rows[i][3] = arrayList.get(i).getPrice();

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
