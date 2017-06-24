package com.ooad.bookstore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import com.ooad.bookstore.util.UtilitiesDAOImpl;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Purchase extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane;
	private JTable jTable;
	JLabel jLabelDateTime;
	JLabel jLabelDate;
	private static final String CART_ICON = "src/main/resources/cart.jpg";

	public Purchase(String userName) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 1000, 600);
		jContentPane = new JPanel();
		jContentPane.setBackground(Color.WHITE);
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jContentPane);
		jContentPane.setLayout(null);

		JLabel jLabelWelcomeNote = new JLabel("Welcome to Book Store");
		jLabelWelcomeNote.setBounds(32, 55, 205, 19);
		jLabelWelcomeNote.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		jContentPane.add(jLabelWelcomeNote);

		JTabbedPane jJabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jJabbedPane.setBackground(Color.WHITE);
		jJabbedPane.setBounds(30, 85, 746, 465);
		jContentPane.add(jJabbedPane);

		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.WHITE);
		jJabbedPane.addTab("Shop Items", null, jPanel, null);
		jPanel.setLayout(null);

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(0, 0, 719, 415);
		jScrollPane.setBackground(Color.WHITE);
		jPanel.add(jScrollPane);

		jTable = new JTable();
		jTable.setBackground(Color.WHITE);
		jTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Icon", "Book", "Description", "Availability", "Price", "Select", "Quantity" }));
		jScrollPane.setViewportView(jTable);

		JScrollBar jScrollBarVertical = new JScrollBar();
		jScrollBarVertical.setBounds(720, 0, 21, 415);
		jPanel.add(jScrollBarVertical);

		JScrollBar jScrollBarHorizontal = new JScrollBar();
		jScrollBarHorizontal.setBackground(Color.WHITE);
		jScrollBarHorizontal.setOrientation(JScrollBar.HORIZONTAL);
		jScrollBarHorizontal.setBounds(0, 414, 725, 23);
		jPanel.add(jScrollBarHorizontal);

		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(Color.WHITE);
		jJabbedPane.addTab("Review Order", null, jPanel2, null);

		JLabel jLabelTime = new JLabel("Time");
		jLabelTime.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabelTime.setBounds(753, 24, 46, 19);
		jContentPane.add(jLabelTime);

		jLabelDateTime = new JLabel();
		jLabelDateTime.setForeground(Color.MAGENTA);
		jLabelDateTime.setBackground(Color.WHITE);
		jLabelDateTime.setFont(new Font("Calibri", Font.BOLD, 20));
		jLabelDateTime.setBounds(801, 24, 117, 19);
		jContentPane.add(jLabelDateTime);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Calibri", Font.BOLD, 20));
		lblDate.setBounds(753, 55, 46, 19);
		jContentPane.add(lblDate);

		jLabelDate = new JLabel();
		jLabelDate.setForeground(Color.MAGENTA);
		jLabelDate.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabelDate.setBackground(Color.WHITE);
		jLabelDate.setBounds(801, 55, 151, 19);
		jContentPane.add(jLabelDate);

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
		jButtonAddToCart.setBounds(796, 209, 66, 62);
		jContentPane.add(jButtonAddToCart);

		JButton jButtonModifyAccount = new JButton("Modify Account");
		jButtonModifyAccount.setFont(new Font("Calibri", Font.BOLD, 18));
		jButtonModifyAccount.setBounds(801, 294, 159, 38);
		jContentPane.add(jButtonModifyAccount);

		JLabel jLabelAddToCart = new JLabel("Add to Cart");
		jLabelAddToCart.setFont(new Font("Calibri", Font.BOLD, 18));
		jLabelAddToCart.setBounds(872, 232, 91, 19);
		jContentPane.add(jLabelAddToCart);
		
		JLabel jLabel = new JLabel("Book Store");
		jLabel.setForeground(Color.ORANGE);
		jLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 36));
		jLabel.setBounds(322, 9, 225, 31);
		jContentPane.add(jLabel);

		setDate();

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
}
