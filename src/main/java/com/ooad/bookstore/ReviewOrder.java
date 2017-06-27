package com.ooad.bookstore;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ooad.bookstore.model.Customer;
import com.ooad.bookstore.util.UtilitiesDAOImpl;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class ReviewOrder extends JFrame {

	private JPanel jContentPane;
	JLabel jLabelDateTime;
	JLabel jLabelDate;
	public JTable jTable;

	public ReviewOrder(String customerFirstName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		jContentPane = new JPanel();
		jContentPane.setBackground(Color.WHITE);
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jContentPane);

		JLabel jLabelWelcomeNote = new JLabel("Review Order");
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

		JLabel jLabel = new JLabel("Book Store");
		jLabel.setForeground(Color.ORANGE);
		jLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 36));

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(jScrollPane, BorderLayout.CENTER);

		JButton btnProceedToCheckout = new JButton("Checkout");
		btnProceedToCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Payment payment = new Payment();
				payment.setVisible(true);
			}
		});
		btnProceedToCheckout.setBackground(Color.CYAN);
		btnProceedToCheckout.setFont(new Font("Calibri", Font.BOLD, 18));

		JLabel jLabelTotal = new JLabel("Total - ");
		jLabelTotal.setFont(new Font("Calibri", Font.BOLD, 20));

		JLabel jLabelTotalPrice = new JLabel("");
		jLabelTotalPrice.setFont(new Font("Calibri", Font.BOLD, 20));

		JButton btnContinueShopping = new JButton("Continue Shopping");
		btnContinueShopping.setBackground(Color.CYAN);
		btnContinueShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Purchase.jLabelGreetingNameGuest.getText() == "Guest") {
					Purchase purchase = new Purchase();
					purchase.setVisible(true);
					dispose();
				} else {
					Purchase purchase = new Purchase(Purchase.jLabelGreetingNameUser.getText());
					purchase.setVisible(true);
					dispose();
				}
			}
		});
		btnContinueShopping.setFont(new Font("Calibri", Font.BOLD, 16));

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerLogin customerLogin = new CustomerLogin();
				customerLogin.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 18));
		btnLogout.setBackground(Color.CYAN);
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
						.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(27).addGroup(
								groupLayoutJContentPane.createParallelGroup(Alignment.LEADING, false).addGroup(
										groupLayoutJContentPane.createSequentialGroup().addGroup(groupLayoutJContentPane
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayoutJContentPane.createSequentialGroup()
														.addComponent(jLabelTotal)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jLabelTotalPrice, GroupLayout.PREFERRED_SIZE, 51,
																GroupLayout.PREFERRED_SIZE)
														.addGap(227))
												.addComponent(jScrollPane, Alignment.LEADING,
														GroupLayout.PREFERRED_SIZE, 718, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 160,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnProceedToCheckout, GroupLayout.PREFERRED_SIZE, 160,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayoutJContentPane.createSequentialGroup()
														.addComponent(jLabelWelcomeNote, GroupLayout.PREFERRED_SIZE,
																205, GroupLayout.PREFERRED_SIZE)
														.addGap(516)
														.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 46,
																GroupLayout.PREFERRED_SIZE)
														.addGap(2).addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE,
																151, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnContinueShopping)))))
						.addContainerGap(26, Short.MAX_VALUE)));
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
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(157)
										.addComponent(btnProceedToCheckout, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addComponent(btnContinueShopping, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addGap(23).addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayoutJContentPane.createSequentialGroup().addGap(25).addComponent(
										jScrollPane, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayoutJContentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(jLabelTotal).addComponent(jLabelTotalPrice, GroupLayout.PREFERRED_SIZE,
										26, GroupLayout.PREFERRED_SIZE))
						.addGap(39)));

		jTable = new JTable();
		jTable.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "Book", "Type", "Price" }));
		jScrollPane.setViewportView(jTable);
		jContentPane.setLayout(groupLayoutJContentPane);
		setDate();
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

	private UtilitiesDAOImpl getUtilitiesDAOImplHelper() throws FileNotFoundException, SQLException {
		return UtilitiesDAOImpl.getInstance();
	}
}
