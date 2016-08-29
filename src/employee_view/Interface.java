package employee_view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.SessionFactory;

import com.toedter.calendar.JDateChooser;

import dao.BookDao;
import dao.InitialiseSFHibernate;
import dao.NotInCollectionDao;
import dao.PublisherDao;
import dao.TransactionDao;
import dao.VendorDao;
import javafx.scene.image.Image;
import model.Book;
import model.Cart;
import model.CartItem;
import model.NotInCollection;
import model.Publisher;
import model.Transaction;
import model.Vendor;
import pdfwriter.ReportViewer;
import pdfwriter.ReportWriter;
import views.ErrorDialog;
import views.SuccessDialog;
import views.ToastMessage;

public class Interface {

	private static JTextField txtUsername;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JPasswordField passwordField;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField txtBookTitle;
	private static JTextField txtAuthorName;
	private static JTextField txtPublisher;
	private static JTextField textField_10;
	private static JTextField textField_11;
	private static JTextField textField_12;
	private static JTextField textField_13;
	private static JTextField textField_14;
	private static JTextField textField_15;
	private static JTextField textField_16;
	private static JTextField textField_7;
	private static Cart cart;

	private static JTextField textField_8;
	private static JTextField textField_9;
	private static JTextField textField_17;
	private static JTextField textField_18;
	private static JTextField textField_19;
	private static JTextField textField_20;
	private static JTextField textField_21;
	private static JTextField textField_22;
	private static JTextField txtIsbnOwner;
	public static Integer sessionID; // 1 owner 2 manager 3 sales-clerk 4
										// employee

	public static void application() {

		JFrame window = new JFrame("Book Shop Automation");
		window.setVisible(true);
		cart = new Cart();
		window.setSize(700, 500);
		// window.setResizable(false);

		window.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		window.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel Customer = new JPanel();
		tabbedPane.addTab("Customer", null, Customer, null);
		CardLayout customerCard = new CardLayout(0, 0);
		Customer.setLayout(customerCard);

		JPanel viewBook = new JPanel();

		viewBook.setVisible(false);
		viewBook.setLayout(null);

		/*
		 * JLabel lblNewLabel = new JLabel("IMG");
		 * lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblNewLabel.setBounds(280, 22, 118, 141); viewBook.add(lblNewLabel);
		 */

		JLabel label = new JLabel("");
		label.setBounds(256, 30, 146, 142);
		viewBook.add(label);
		
		try
		{
			BufferedImage img=ImageIO.read(new File("images/images.jpeg"));
			ImageIcon icon=new ImageIcon(img);
			label.setIcon(icon);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(190, 184, 289, 14);
		viewBook.add(lblNewLabel_1);

		JLabel lblAuthorName = new JLabel("Author Name : ");
		lblAuthorName.setBounds(136, 232, 187, 14);
		viewBook.add(lblAuthorName);

		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setBounds(136, 267, 164, 14);
		viewBook.add(lblPrice);

		JLabel lblNoOfCopies = new JLabel("Number of copies : ");
		lblNoOfCopies.setBounds(136, 336, 187, 14);
		viewBook.add(lblNoOfCopies);

		JLabel lblIsbn = new JLabel("ISBN : ");
		lblIsbn.setBounds(136, 372, 164, 14);
		viewBook.add(lblIsbn);

		JLabel mlblAName = new JLabel("New label");
		mlblAName.setBounds(414, 232, 210, 14);
		viewBook.add(mlblAName);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(414, 267, 210, 14);
		viewBook.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(414, 336, 210, 14);
		viewBook.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(414, 372, 210, 14);
		viewBook.add(lblNewLabel_4);

		JButton button = new JButton("< Back");
		button.setBounds(10, 399, 121, 23);
		viewBook.add(button);

		/*
		 * JButton btnAddToCart = new JButton("Add to cart");
		 * btnAddToCart.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) {
		 * viewBook.setVisible(false); paymentPanel.setVisible(true);
		 * 
		 * } }) btnAddToCart.setBounds(280, 409, 118, 23);
		 * viewBook.add(btnAddToCart);
		 */
		JLabel lblRackNumber = new JLabel("Rack Number : ");
		lblRackNumber.setBounds(136, 304, 164, 14);
		viewBook.add(lblRackNumber);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(414, 304, 187, 14);
		viewBook.add(lblNewLabel_5);

		JPanel loginPanel = new JPanel();

		JPanel orderBookPanel = new JPanel();

		orderBookPanel.setVisible(false);
		orderBookPanel.setLayout(null);

		JLabel lblBookTitle = new JLabel("Book Title : ");
		lblBookTitle.setBounds(64, 112, 172, 14);
		orderBookPanel.add(lblBookTitle);

		textField_2 = new JTextField();
		textField_2.setBounds(288, 109, 265, 20);
		orderBookPanel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblAuthorName_1 = new JLabel("Author Name : ");
		lblAuthorName_1.setBounds(64, 157, 172, 14);
		orderBookPanel.add(lblAuthorName_1);

		textField_3 = new JTextField();
		textField_3.setBounds(288, 154, 265, 20);
		orderBookPanel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblPublisher = new JLabel("Publisher : ");
		lblPublisher.setBounds(64, 210, 187, 14);
		orderBookPanel.add(lblPublisher);

		textField_4 = new JTextField();
		textField_4.setBounds(288, 207, 265, 20);
		orderBookPanel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblFillInThese = new JLabel("Fill in these details for the procurement of the book");
		lblFillInThese.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFillInThese.setBounds(121, 34, 457, 14);
		orderBookPanel.add(lblFillInThese);

		JButton btnPlaceOrder = new JButton("Place order");
		btnPlaceOrder.setBounds(246, 340, 179, 23);
		orderBookPanel.add(btnPlaceOrder);

		JLabel lblIsbn_3 = new JLabel("ISBN : ");
		lblIsbn_3.setBounds(64, 266, 136, 14);
		orderBookPanel.add(lblIsbn_3);

		textField_16 = new JTextField();
		textField_16.setBounds(288, 263, 265, 20);
		orderBookPanel.add(textField_16);
		textField_16.setColumns(10);

		JPanel Query = new JPanel();
		Customer.add(Query, "name_22829458616742");
		Query.setLayout(null);

		JButton btnSearch = new JButton("Search");

		btnSearch.setBounds(563, 40, 89, 23);
		Query.add(btnSearch);

		textField = new JTextField();
		textField.setBounds(218, 41, 335, 20);
		Query.add(textField);
		textField.setColumns(10);

		JLabel lblSearchByBook = new JLabel("Search by Book title");
		lblSearchByBook.setBounds(39, 44, 149, 14);
		Query.add(lblSearchByBook);

		JLabel lblSearchByAuthor = new JLabel("Search by author");
		lblSearchByAuthor.setBounds(39, 81, 149, 14);
		Query.add(lblSearchByAuthor);

		textField_1 = new JTextField();
		textField_1.setBounds(218, 78, 335, 20);
		Query.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBounds(563, 77, 89, 23);
		Query.add(btnSearch_1);
		/*
		 * JLabel lblMyCart = new JLabel("My Cart"); lblMyCart.setBounds(557,
		 * 117, 46, 20); Query.add(lblMyCart);
		 * 
		 * JList list = new JList(); list.setBounds(493, 136, 164, 246);
		 * Query.add(list);
		 * 
		 * JButton btnEditCart = new JButton("Edit Cart");
		 * btnEditCart.setBounds(486, 382, 75, 23); Query.add(btnEditCart);
		 * 
		 * JButton btnDeleteCart = new JButton("Delete Cart");
		 * btnDeleteCart.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) { } });
		 * btnDeleteCart.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 * btnDeleteCart.setBounds(590, 382, 89, 23); Query.add(btnDeleteCart);
		 * 
		 * JButton btnFinaliseCart = new JButton("Finalise Cart");
		 * btnFinaliseCart.setBounds(527, 409, 103, 23);
		 * Query.add(btnFinaliseCart);
		 */
		JButton btnViewSelectedBook = new JButton("View selected book");
		btnViewSelectedBook.setBounds(255, 399, 252, 23);
		Query.add(btnViewSelectedBook);

		// JList for book query
		DefaultListModel<String> model = new DefaultListModel<>();

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(131, 127, 466, 244);
		Query.add(scrollPane_1);

		JList queryBookList = new JList(model);
		scrollPane_1.setViewportView(queryBookList);

		// adding to the customer tab
		Customer.add(viewBook, "name_25346409520612");
		Customer.add(orderBookPanel, "name_117790567923386");

		JButton button_1 = new JButton("< Back");
		button_1.setBounds(10, 399, 89, 23);
		orderBookPanel.add(button_1);
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Query.setVisible(true);
				orderBookPanel.setVisible(false);
			}
		});

		JPanel Employee = new JPanel();
		tabbedPane.addTab("Employee", null, Employee, null);
		CardLayout employeeCard = new CardLayout(0, 0);
		Employee.setLayout(employeeCard);

		Employee.add(loginPanel, "name_22371360198077");
		loginPanel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(209, 133, 94, 14);
		loginPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(208, 187, 79, 14);
		loginPanel.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(338, 131, 149, 20);
		loginPanel.add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnLogin.setBounds(293, 263, 89, 35);
		loginPanel.add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setBounds(338, 184, 149, 23);
		loginPanel.add(passwordField);

		JPanel salesclerkPanel = new JPanel();
		Employee.add(salesclerkPanel, "name_90015226973982");
		salesclerkPanel.setLayout(null);

		JButton btnNewButton = new JButton("Generate Receipt");
		btnNewButton.setBounds(186, 168, 201, 36);
		salesclerkPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Update database");
		btnNewButton_1.setBounds(186, 239, 201, 36);
		salesclerkPanel.add(btnNewButton_1);

		// next button for the salesclerk
		// uses Cart

		JButton btnLogOut_3 = new JButton("Log out");
		btnLogOut_3.setBounds(580, 11, 89, 23);
		salesclerkPanel.add(btnLogOut_3);

		JLabel lblLoggedInAs = new JLabel("Logged in as : Sales Clerk");
		lblLoggedInAs.setBounds(340, 15, 230, 14);
		salesclerkPanel.add(lblLoggedInAs);

		JPanel statisticsPanel = new JPanel();
		Employee.add(statisticsPanel, "name_177266559159994");
		statisticsPanel.setLayout(null);

		JLabel lblStartDate = new JLabel("Start Date : ");
		lblStartDate.setBounds(10, 27, 103, 14);
		statisticsPanel.add(lblStartDate);

		JLabel lblLastDate = new JLabel("Last Date : ");
		lblLastDate.setBounds(10, 53, 103, 14);
		statisticsPanel.add(lblLastDate);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(125, 27, 221, 14);
		statisticsPanel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(125, 53, 221, 14);
		statisticsPanel.add(lblNewLabel_10);

		JButton button_4 = new JButton(" < Back");
		button_4.setBounds(10, 398, 89, 23);
		statisticsPanel.add(button_4);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(121, 99, 453, 276);
		statisticsPanel.add(scrollPane_4);

		JTextArea statisticsArea = new JTextArea();
		scrollPane_4.setViewportView(statisticsArea);

		JPanel ownerPanel = new JPanel();
		Employee.add(ownerPanel, "name_110106080647965");
		ownerPanel.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("View Sales Statistics");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(122, 55, 228, 14);
		ownerPanel.add(lblNewLabel_8);

		JLabel lblEnterStartDate = new JLabel("Start date : ");
		lblEnterStartDate.setBounds(66, 168, 101, 14);
		ownerPanel.add(lblEnterStartDate);

		JButton button_2 = new JButton("Get statistics");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_2.setBounds(122, 303, 202, 38);
		ownerPanel.add(button_2);

		JLabel lblEnterLastDate = new JLabel("Last date : ");
		lblEnterLastDate.setBounds(66, 229, 101, 14);
		ownerPanel.add(lblEnterLastDate);

		JLabel lblEnterTheDates = new JLabel("Enter the dates for which sales statistics have to be shown :");
		lblEnterTheDates.setBounds(66, 116, 327, 14);
		ownerPanel.add(lblEnterTheDates);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(195, 162, 155, 20);
		ownerPanel.add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(195, 223, 155, 20);
		ownerPanel.add(dateChooser_1);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(580, 11, 89, 23);
		ownerPanel.add(btnLogOut);

		JLabel lblViewInventoryLevel = new JLabel("View Inventory Level");
		lblViewInventoryLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblViewInventoryLevel.setBounds(501, 83, 135, 20);
		ownerPanel.add(lblViewInventoryLevel);

		JLabel lblIsbn_4 = new JLabel("ISBN");
		lblIsbn_4.setBounds(444, 130, 42, 14);
		ownerPanel.add(lblIsbn_4);

		txtIsbnOwner = new JTextField();
		txtIsbnOwner.setBounds(501, 127, 123, 20);
		ownerPanel.add(txtIsbnOwner);
		txtIsbnOwner.setColumns(10);

		JButton btnInvLevel = new JButton(">");
		btnInvLevel.setBounds(624, 126, 45, 23);
		ownerPanel.add(btnInvLevel);

		JLabel lbldisplayInvLevel = new JLabel("");
		lbldisplayInvLevel.setBounds(534, 168, 71, 20);
		ownerPanel.add(lbldisplayInvLevel);

		btnInvLevel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BookDao bd = new BookDao();
				try {
					lbldisplayInvLevel
							.setText((bd.getInventoryLevel(Integer.parseInt(txtIsbnOwner.getText()))).toString());
				} catch (Exception e1) {
					new ErrorDialog().invoke("Please enter ISBN in correct format!");
					e1.printStackTrace();
				}

			}
		});

		JLabel lblViewListOf = new JLabel("View list of books ");
		lblViewListOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblViewListOf.setBounds(495, 273, 141, 14);
		ownerPanel.add(lblViewListOf);

		JLabel lblBelowThreshold = new JLabel("below threshold");
		lblBelowThreshold.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBelowThreshold.setBounds(501, 293, 108, 14);
		ownerPanel.add(lblBelowThreshold);

		JButton btnGetList = new JButton("Get List >");

		btnGetList.setBounds(473, 318, 132, 23);
		ownerPanel.add(btnGetList);

		JLabel lblLoggedInAs_2 = new JLabel("Logged in as : Owner");
		lblLoggedInAs_2.setBounds(351, 15, 228, 14);
		ownerPanel.add(lblLoggedInAs_2);

		JPanel generalPanel = new JPanel();
		Employee.add(generalPanel, "name_23515077757223");
		generalPanel.setLayout(null);

		JLabel lblUpdateTheDatabase = new JLabel("Update the database : ");
		lblUpdateTheDatabase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUpdateTheDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTheDatabase.setBounds(246, 58, 189, 14);
		generalPanel.add(lblUpdateTheDatabase);

		JLabel lblIsbn_2 = new JLabel("ISBN :");
		lblIsbn_2.setBounds(96, 92, 46, 14);
		generalPanel.add(lblIsbn_2);

		textField_6 = new JTextField();
		textField_6.setBounds(203, 89, 208, 20);
		generalPanel.add(textField_6);
		textField_6.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(439, 88, 89, 23);
		generalPanel.add(btnFind);

		JPanel absentPanel = new JPanel();
		absentPanel.setBounds(74, 133, 541, 255);
		generalPanel.add(absentPanel);
		absentPanel.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel(
				"Please fill up the details. ");
		lblNewLabel_11.setBounds(108, 11, 423, 14);
		absentPanel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Book title");
		lblNewLabel_12.setBounds(29, 36, 101, 14);
		absentPanel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Author");
		lblNewLabel_13.setBounds(29, 72, 73, 14);
		absentPanel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Publisher ID");
		lblNewLabel_14.setBounds(29, 114, 113, 14);
		absentPanel.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Price");
		lblNewLabel_15.setBounds(29, 192, 46, 14);
		absentPanel.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Image file");
		lblNewLabel_16.setBounds(29, 153, 101, 14);
		absentPanel.add(lblNewLabel_16);

		JLabel lblNewLabel_18 = new JLabel("Threshold Level");
		lblNewLabel_18.setBounds(305, 192, 143, 14);
		absentPanel.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Rack no");
		lblNewLabel_19.setBounds(359, 114, 73, 14);
		absentPanel.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("No of copies");
		lblNewLabel_20.setBounds(347, 150, 101, 14);
		absentPanel.add(lblNewLabel_20);

		txtBookTitle = new JTextField();
		txtBookTitle.setBounds(141, 33, 194, 20);
		absentPanel.add(txtBookTitle);
		txtBookTitle.setColumns(10);

		txtAuthorName = new JTextField();
		txtAuthorName.setBounds(141, 69, 194, 20);
		absentPanel.add(txtAuthorName);
		txtAuthorName.setColumns(10);

		txtPublisher = new JTextField();
		txtPublisher.setBounds(141, 111, 187, 20);
		absentPanel.add(txtPublisher);
		txtPublisher.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(141, 189, 38, 20);
		absentPanel.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(140, 150, 86, 20);
		absentPanel.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(464, 111, 46, 20);
		absentPanel.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(464, 147, 46, 20);
		absentPanel.add(textField_13);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(464, 189, 46, 20);
		absentPanel.add(textField_14);
		textField_14.setColumns(10);

		textField_22 = new JTextField();
		textField_22.setBounds(331, 224, 46, 20);
		absentPanel.add(textField_22);
		textField_22.setColumns(10);

		JLabel lblAverageNumberOf = new JLabel("Average procurement time");
		lblAverageNumberOf.setBounds(29, 227, 286, 14);
		absentPanel.add(lblAverageNumberOf);

		JPanel presentPanel = new JPanel();
		presentPanel.setBounds(105, 151, 439, 94);
		generalPanel.add(presentPanel);
		presentPanel.setLayout(null);

		JLabel lblNumberOfCopies = new JLabel("No of copies to be added");
		lblNumberOfCopies.setBounds(12, 0, 235, 14);
		presentPanel.add(lblNumberOfCopies);

		textField_15 = new JTextField();
		textField_15.setBounds(292, 0, 135, 20);
		presentPanel.add(textField_15);
		textField_15.setColumns(10);

		JButton btnLogOut_1 = new JButton("Log out");
		btnLogOut_1.setBounds(580, 11, 89, 23);
		generalPanel.add(btnLogOut_1);

		JPanel newPublisherPanel = new JPanel();

		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(254, 399, 134, 23);
		generalPanel.add(btnSaveChanges);

		JLabel lblLoggedInAs_1 = new JLabel("Logged in as : General Employee");
		lblLoggedInAs_1.setBounds(309, 15, 269, 14);
		generalPanel.add(lblLoggedInAs_1);

		JButton back_button_8 = new JButton("< Back");

		back_button_8.setBounds(10, 399, 121, 23);
		generalPanel.add(back_button_8);

		JPanel requestsPanel = new JPanel();
		Employee.add(requestsPanel, "name_86279287264191");
		requestsPanel.setLayout(null);

		JLabel lblTheFollowingBooks = new JLabel("The following books have been requested : ");
		lblTheFollowingBooks.setBounds(135, 40, 364, 14);
		requestsPanel.add(lblTheFollowingBooks);

		JButton button_3 = new JButton("  <  Back");
		button_3.setBounds(10, 399, 105, 23);
		requestsPanel.add(button_3);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(135, 89, 464, 283);
		requestsPanel.add(scrollPane_2);

		JTextArea requestsTextArea = new JTextArea();
		scrollPane_2.setViewportView(requestsTextArea);

		Employee.add(newPublisherPanel, "name_2628904785364");
		newPublisherPanel.setLayout(null);

		JLabel label_1 = new JLabel("Publisher ID : ");
		label_1.setBounds(108, 128, 167, 14);
		newPublisherPanel.add(label_1);

		JLabel lblNewLabel = new JLabel("Publisher Name : ");
		lblNewLabel.setBounds(108, 177, 167, 14);
		newPublisherPanel.add(lblNewLabel);

		JLabel lblVendorId = new JLabel("Vendor ID : ");
		lblVendorId.setBounds(108, 229, 137, 14);
		newPublisherPanel.add(lblVendorId);

		textField_8 = new JTextField();
		textField_8.setBounds(268, 125, 167, 20);
		newPublisherPanel.add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(268, 174, 167, 20);
		newPublisherPanel.add(textField_9);
		textField_9.setColumns(10);

		textField_17 = new JTextField();
		textField_17.setBounds(268, 223, 167, 20);
		newPublisherPanel.add(textField_17);
		textField_17.setColumns(10);

		JButton button_6 = new JButton("< Back");

		button_6.setBounds(10, 399, 143, 23);
		newPublisherPanel.add(button_6);

		JButton btnSaveChanges_1 = new JButton("Save changes");
		btnSaveChanges_1.setBounds(268, 322, 184, 23);
		newPublisherPanel.add(btnSaveChanges_1);

		JLabel lblAddNewPublisher = new JLabel("Add new publisher to database : ");
		lblAddNewPublisher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddNewPublisher.setBounds(229, 56, 267, 14);
		newPublisherPanel.add(lblAddNewPublisher);

		JPanel newVendorPanel = new JPanel();
		Employee.add(newVendorPanel, "name_2665824118634");
		newVendorPanel.setLayout(null);

		JLabel lblNewLabel_17 = new JLabel("Vendor ID : ");
		lblNewLabel_17.setBounds(201, 126, 101, 14);
		newVendorPanel.add(lblNewLabel_17);

		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(201, 171, 89, 14);
		newVendorPanel.add(lblName);

		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(201, 220, 101, 14);
		newVendorPanel.add(lblAddress);

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(201, 266, 89, 20);
		newVendorPanel.add(lblEmail);

		textField_18 = new JTextField();
		textField_18.setBounds(330, 123, 122, 20);
		newVendorPanel.add(textField_18);
		textField_18.setColumns(10);

		textField_19 = new JTextField();
		textField_19.setBounds(330, 168, 122, 20);
		newVendorPanel.add(textField_19);
		textField_19.setColumns(10);

		textField_20 = new JTextField();
		textField_20.setBounds(330, 220, 122, 20);
		newVendorPanel.add(textField_20);
		textField_20.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setBounds(330, 266, 122, 20);
		newVendorPanel.add(textField_21);
		textField_21.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel("Add new vendor to database");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_21.setBounds(169, 50, 254, 14);
		newVendorPanel.add(lblNewLabel_21);

		JButton button_7 = new JButton(" < Back");
		button_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newVendorPanel.setVisible(false);
				newPublisherPanel.setVisible(true);

				textField_9.setText("");
				textField_17.setText("");
			}
		});
		button_7.setBounds(10, 399, 89, 23);
		newVendorPanel.add(button_7);

		JButton btnSaveChanges_2 = new JButton("Save changes");

		btnSaveChanges_2.setBounds(295, 338, 192, 23);
		newVendorPanel.add(btnSaveChanges_2);

		JPanel belowThresholdPanel = new JPanel();
		Employee.add(belowThresholdPanel, "name_4576716399347");
		belowThresholdPanel.setLayout(null);

		JLabel lblViewList = new JLabel("List of books that have fallen below the threshold");
		lblViewList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblViewList.setBounds(152, 44, 357, 14);
		belowThresholdPanel.add(lblViewList);

		JButton btnNewButton_3 = new JButton("< Back");

		btnNewButton_3.setBounds(10, 399, 89, 23);
		belowThresholdPanel.add(btnNewButton_3);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(152, 79, 438, 299);
		belowThresholdPanel.add(scrollPane_3);

		JTextArea textArea_threshold = new JTextArea();
		scrollPane_3.setViewportView(textArea_threshold);

		JPanel managerPanel = new JPanel();
		Employee.add(managerPanel, "name_23429361542622");
		managerPanel.setLayout(null);

		JButton btnViewRequests = new JButton("View not in collection requests");
		btnViewRequests.setBounds(213, 283, 282, 33);
		managerPanel.add(btnViewRequests);

		JButton btnUpdateDatabase = new JButton("Update database");
		btnUpdateDatabase.setBounds(213, 141, 282, 33);
		managerPanel.add(btnUpdateDatabase);

		JButton btnLogOut_2 = new JButton("Log out");
		btnLogOut_2.setBounds(580, 11, 89, 23);
		managerPanel.add(btnLogOut_2);

		JButton generate = new JButton("Generate receipt");
		generate.setBounds(213, 202, 282, 33);
		managerPanel.add(generate);

		JButton btnViewNotInStock = new JButton("View not in stock requests");
		btnViewNotInStock.setBounds(213, 337, 282, 33);
		managerPanel.add(btnViewNotInStock);

		JLabel lblLoggedInAs_3 = new JLabel("Logged in as : Manager");
		lblLoggedInAs_3.setBounds(308, 15, 238, 14);
		managerPanel.add(lblLoggedInAs_3);
		// Owner.setLayout(null);

		JPanel genreceiptPanel = new JPanel();
		Employee.add(genreceiptPanel, "name_23371904062736");
		genreceiptPanel.setLayout(null);

		textField_5 = new JTextField();
		textField_5.setBounds(351, 154, 168, 20);
		genreceiptPanel.add(textField_5);
		textField_5.setColumns(10);
		// textField_5.setText("qwq");

		JLabel lblIsbn_1 = new JLabel("ISBN : ");
		lblIsbn_1.setBounds(197, 157, 113, 14);
		genreceiptPanel.add(lblIsbn_1);

		JLabel lblEnterTheIsbn = new JLabel("Enter the ISBN number of the following book :");
		lblEnterTheIsbn.setBounds(230, 84, 382, 14);
		genreceiptPanel.add(lblEnterTheIsbn);

		/*
		 * JLabel lblNewLabel_6 = new JLabel("Book title : ");
		 * lblNewLabel_6.setBounds(251, 119, 59, 14);
		 * genreceiptPanel.add(lblNewLabel_6);
		 */
		/*
		 * JLabel lblNewLabel_7 = new JLabel("New label");
		 * lblNewLabel_7.setBounds(351, 119, 223, 14);
		 * genreceiptPanel.add(lblNewLabel_7);
		 */

		JButton btnNext = new JButton("Add book to cart");
		btnNext.setBounds(271, 240, 180, 23);
		genreceiptPanel.add(btnNext);

		JButton btnGenerateReceipt = new JButton("Generate Receipt");
		btnGenerateReceipt.setBounds(243, 304, 231, 34);
		genreceiptPanel.add(btnGenerateReceipt);

		JLabel lblNoOfCopies_1 = new JLabel("No of copies : ");
		lblNoOfCopies_1.setBounds(197, 201, 153, 14);
		genreceiptPanel.add(lblNoOfCopies_1);

		textField_7 = new JTextField();
		textField_7.setBounds(351, 198, 168, 20);
		genreceiptPanel.add(textField_7);
		textField_7.setColumns(10);

		JButton button_5 = new JButton("< Back");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField_5.setText("");
				textField_7.setText("");
				if (sessionID == 3) {
					genreceiptPanel.setVisible(false);
					salesclerkPanel.setVisible(true);
				} else if (sessionID == 2) {
					genreceiptPanel.setVisible(false);
					managerPanel.setVisible(true);
				}

			}
		});
		button_5.setBounds(10, 399, 137, 23);
		genreceiptPanel.add(button_5);
		// textField_7.setText("av");

		Query.setVisible(true);
		viewBook.setVisible(false);
		managerPanel.setVisible(false);
		generalPanel.setVisible(false);
		genreceiptPanel.setVisible(false);
		presentPanel.setVisible(false);
		absentPanel.setVisible(false);
		loginPanel.setVisible(true);
		ownerPanel.setVisible(false);
		salesclerkPanel.setVisible(false);

		// all button listeners are here
		// added by rameshwar

		// next button of the generate receipt
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Integer ISBN, noOfCopies;
				if (textField_5.getText().equals("") || textField_7.getText().equals("")) {
					new ErrorDialog().invoke("Please enter all values!");
					return;
				}
				try {
					ISBN = Integer.parseInt(textField_5.getText());
					noOfCopies = Integer.parseInt(textField_7.getText());
				} catch (Exception e4) {
					new ErrorDialog().invoke("Please enter proper integral values!!");
					return;
				}

				Book book = new BookDao().getBookByISBN(ISBN);
				if (book == null) {
					new ErrorDialog().invoke("No such book exists!");
					return;
				}
				if (noOfCopies < 0) {
					new ErrorDialog().invoke("Please enter a proper value for quantity!");
					return;
				}
				if (noOfCopies > book.getNoOfCopies()) {
					new ErrorDialog().invoke("There are only " + book.getNoOfCopies() + " left");
					return;
				}
				cart.getCart().add(new CartItem(book, noOfCopies));
				// clear the screen
				textField_5.setText("");
				textField_7.setText("");
			}
		});

		// TODO for all save changes actionn listeners

		btnGenerateReceipt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cart != null && (cart.getCart() == null || cart.getCart().isEmpty())) {
					new ErrorDialog().invoke("There is nothing for transaction");
					return;
				}

				try {
					new ReportWriter().createPDF(cart);

					// if success
					// subtract the copies
					for (CartItem b : cart.getCart()) {
						b.getBook().setNoOfCopies(b.getBook().getNoOfCopies() - b.getQuantity());
						new BookDao().addBook(b.getBook(), -b.getQuantity());
						// add book to transaction
						new TransactionDao()
								.addTransaction(new Transaction(new Date(), b.getBook().getISBN(), b.getQuantity()));
					}
					// transaction complete
					try {
						new ReportViewer().viewPdf();

					} catch (Exception e12121) {
						e12121.printStackTrace();
					}
				} catch (Exception e21) {
					e21.printStackTrace();
				}
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// hardcoding the login for now
				// System.out.println(txtUsername.getText() + " " +
				// passwordField.getText());
				if (txtUsername.getText().equals("manager") && passwordField.getText().equals("manager123")) {

					// new SuccessDialog().invoke("Successful login as
					// manager");
					new ToastMessage("Successful login", 500).setVisible(true);

					loginPanel.setVisible(false);
					managerPanel.setVisible(true);
					sessionID = 2;
				} else if (txtUsername.getText().equals("salesclerk")
						&& passwordField.getText().equals("salesclerk123")) {
					new ToastMessage("Successful login", 500).setVisible(true);
					cart = new Cart();
					loginPanel.setVisible(false);
					salesclerkPanel.setVisible(true);
					sessionID = 3;
				} else if (passwordField.getText().equals("emp123") && (txtUsername.getText().equals("emp1")
						|| txtUsername.getText().equals("emp2") || txtUsername.getText().equals("emp3"))) {
					new ToastMessage("Successful login", 500).setVisible(true);
					loginPanel.setVisible(false);
					generalPanel.setVisible(true);
					sessionID = 4;

					back_button_8.setVisible(false);

				} else if (passwordField.getText().equals("owner123") && txtUsername.getText().equals("owner")) {
					new ToastMessage("Successful login", 500).setVisible(true);
					loginPanel.setVisible(false);
					ownerPanel.setVisible(true);
					sessionID = 1;
				} else {
					new ErrorDialog().invoke("Incorrect credentials");
					passwordField.setText("");
				}

			}
		});

		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newPublisherPanel.setVisible(false);
				generalPanel.setVisible(true);
			}
		});

		btnUpdateDatabase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				managerPanel.setVisible(false);
				generalPanel.setVisible(true);
			}
		});

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				viewBook.setVisible(false);
				Query.setVisible(true);
			}
		});

		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Integer ISBN = Integer.valueOf(textField_6.getText());
					if (new BookDao().doesBookExist(ISBN)) {
						new SuccessDialog().invoke("Book exists");
						presentPanel.setVisible(true);
						absentPanel.setVisible(false);

					} else {
						new ErrorDialog().invoke("This book isn't registered in database! Please register");
						absentPanel.setVisible(true);
						presentPanel.setVisible(false);
						textField_10.setText("");
						textField_12.setText("");
						textField_13.setText("");
						textField_14.setText("");
						textField_22.setText(""); // TODO : What is this
													// @Bhagwat!!
						textField_8.setText("");
						txtBookTitle.setText("");
						txtAuthorName.setText("");
						textField_11.setText("");

					}
				} catch (Exception e1) {
					e1.printStackTrace();
					new ErrorDialog().invoke("Your request could not be processed");
				}

			}
		});

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = textField.getText();
				try {
					if (title == null || title.equals("")) {
						new ErrorDialog().invoke("Please enter the book title");
						return;
					}
					List<Book> bookList = new BookDao().getBooksByTitle(title);
					if (bookList == null || bookList.isEmpty()) {
						JDialog.setDefaultLookAndFeelDecorated(true);
						int response = JOptionPane.showConfirmDialog(Query,
								"No such book in database! Do you want to request for it?", "Not in database",
								JOptionPane.INFORMATION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
							Query.setVisible(false);
							orderBookPanel.setVisible(true);
						}
						return;
					}

					model.removeAllElements();
					for (Book b : bookList) {
						model.addElement(capitalizeFirstLetter(b.getBookTitle().toLowerCase()) + "   by "
								+ capitalizeFirstLetter(b.getAuthorName().toLowerCase()) + "   ISBN :" + b.getISBN());
					}

				} catch (Exception e) {
					return;
				}
			}
		});

		btnSearch_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = textField_1.getText();
				try {

					if (title == null || title.equals("")) {
						new ErrorDialog().invoke("Please enter the author name");
						return;
					}
					List<Book> bookList = new BookDao().getBooksByAuthorName(title);
					model.removeAllElements();
					for (Book b : bookList) {

						model.addElement(capitalizeFirstLetter(b.getBookTitle().toLowerCase()) + "   by "
								+ capitalizeFirstLetter(b.getAuthorName().toLowerCase()) + " ISBN :" + b.getISBN());
					}

					if (bookList == null || bookList.isEmpty()) {
						JDialog.setDefaultLookAndFeelDecorated(true);
						int response = JOptionPane.showConfirmDialog(Query,
								"No such book in database! Do you want to request for it?", "Not in database",
								JOptionPane.INFORMATION_MESSAGE);
						if (response == JOptionPane.YES_OPTION) {
							Query.setVisible(false);
							orderBookPanel.setVisible(true);
						}

					}
				} catch (Exception e) {
					return;
				}
			}
		});

		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					java.util.Date toDate = dateChooser_1.getDate();
					java.util.Date fromDate = dateChooser.getDate();
					if (toDate == null || fromDate == null)
						throw new Exception();
					else {

					}
				} catch (Exception e2) {
					return;
				}

			}
		});

		btnLogOut_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				salesclerkPanel.setVisible(false);
				loginPanel.setVisible(true);
				txtUsername.setText("");
				passwordField.setText("");
			}
		});

		btnLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ownerPanel.setVisible(false);
				loginPanel.setVisible(true);
				txtUsername.setText("");
				passwordField.setText("");
			}
		});

		btnLogOut_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				generalPanel.setVisible(false);
				loginPanel.setVisible(true);
				txtUsername.setText("");
				passwordField.setText("");
			}
		});

		btnLogOut_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				managerPanel.setVisible(false);
				loginPanel.setVisible(true);
				txtUsername.setText("");
				passwordField.setText("");
			}

		});

		// get statistics button of the sales dao
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (dateChooser.getDate() == null || dateChooser_1.getDate() == null) {
					new ErrorDialog().invoke("Please enter the values");
					return;
				} else {
					String resultString = new TransactionDao().getStatistics(dateChooser.getDate(),
							dateChooser_1.getDate());
					statisticsArea.setText(resultString);
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
					lblNewLabel_9.setText(sdf.format(dateChooser.getDate()));
					lblNewLabel_10.setText(sdf.format(dateChooser_1.getDate()));

					ownerPanel.setVisible(false);
					statisticsPanel.setVisible(true);
				}
			}
		});

		// bhagwat

		btnSaveChanges_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vendor newvendor = new Vendor();
				if (textField_18.getText().trim().equals("") || textField_19.getText().trim().equals("")
						|| textField_20.getText().trim().equals("") || textField_21.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(window, "All fields are mandatory");
					return;
				}

				try {
					newvendor.setVendorId(Integer.parseInt(textField_18.getText()));
				}
				catch (Exception e1) {
					new ErrorDialog().invoke("Please enter proper details!!");
					e1.printStackTrace();
					return;
				}
				newvendor.setVendorName(textField_19.getText());
				newvendor.setVendorAddress(textField_20.getText());
				newvendor.setVendorEmail(textField_21.getText());

				VendorDao vd = new VendorDao();
				vd.addVendor(newvendor);

				newVendorPanel.setVisible(false);
				newPublisherPanel.setVisible(true);
				return;
			}
		});

		// publisher button
		btnSaveChanges_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Publisher newpub = new Publisher();
				if (textField_8.getText().trim().equals("") || textField_9.getText().trim().equals("")
						|| textField_17.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(window, "All fields are mandatory");
					return;
				}

				try {

					newpub.setPublisherId(Integer.parseInt(textField_8.getText()));
					if (new PublisherDao().getPublisherById(newpub.getPublisherId()) != null) {
						new ErrorDialog().invoke("Publisher exists");
						return;
					}
					Integer id1;
				
		     		id1 = Integer.parseInt(textField_17.getText());
					System.out.println(id1+" is the id");
					
					if (new VendorDao().searchVendorById(id1) == false) {
						System.out.println(id1 + "huji");
						JOptionPane.showMessageDialog(window,
								"This vendor doesn't already exist. Redirecting to add new vendor...");
						newPublisherPanel.setVisible(false);
						newVendorPanel.setVisible(true);
						textField_18.setText(textField_17.getText());
						textField_18.setEditable(false);
						textField_19.setText("");
						textField_20.setText("");
						textField_21.setText("");

						return;
					} else {
						System.out.println("Huah");
					Vendor vendor1 = new VendorDao().getVendorById(id1);
					newpub.setVendor(vendor1);
					}
				} catch (Exception e1) {
					new ErrorDialog().invoke("Please enter proper details for publisher!!");
					//e1.printStackTrace();
				}

				newpub.setPublisherName(textField_9.getText());
				PublisherDao pd = new PublisherDao();
				pd.addPublisher(newpub);
				newPublisherPanel.setVisible(false);
				generalPanel.setVisible(true);
			}
		});

		btnSaveChanges.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (absentPanel.isVisible()) {

					Book newbook = new Book();
					if (txtBookTitle.getText().trim().equals("") || txtAuthorName.getText().trim().equals("")
							|| txtPublisher.getText().trim().equals("") || textField_11.getText().trim().equals("")
							|| textField_10.getText().trim().equals("") || textField_12.getText().trim().equals("")
							|| textField_13.getText().trim().equals("") || textField_14.getText().trim().equals("")
							|| textField_22.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(window, "All fields are mandatory");
						return;
					}
					Integer nOC = 0;
					try {
						newbook.setPrice(Integer.parseInt(textField_10.getText()));
						newbook.setRackNo(Integer.parseInt(textField_12.getText()));
						nOC = Integer.parseInt(textField_13.getText());
						newbook.setNoOfCopies(nOC);
						newbook.setThreshold(Integer.parseInt(textField_14.getText()));
						newbook.setAverageDays(Integer.parseInt(textField_22.getText()));

						Integer id1 = Integer.parseInt(txtPublisher.getText());
						//PublisherDao pd = new PublisherDao();
						Publisher pub1 = new PublisherDao().getPublisherById(id1);
						if (pub1 == null) {
							JOptionPane.showMessageDialog(window,
									"This publisher isn't already a part of the database. Redirecting to add new vendor...");
							newPublisherPanel.setVisible(true);
							generalPanel.setVisible(false);
							textField_8.setText(txtPublisher.getText());
							textField_8.setEditable(false);
							textField_9.setText("");
							textField_17.setText("");

							return; // rameshwar123
						}
						newbook.setPublisher(pub1);
						// rameshwar123
						try {
							newbook.setISBN(Integer.parseInt(textField_6.getText()));
						} catch (Exception e12) {
							// e12.printStackTrace();
							return;
						}
						newbook.setBookTitle(txtBookTitle.getText());
						newbook.setAuthorName(txtAuthorName.getText());
						newbook.setImageFileName(textField_11.getText());
						BookDao bd = new BookDao();
						bd.addBook(newbook, nOC);

						textField_6.setText("");
						txtBookTitle.setText("");
						txtAuthorName.setText("");
						txtPublisher.setText("");
						textField_11.setText("");
						textField_10.setText("");
						textField_12.setText("");
						textField_13.setText("");
						textField_14.setText("");
						textField_22.setText("");
						absentPanel.setVisible(false);

					} catch (Exception e1) {
						new ErrorDialog().invoke("Please enter proper details!!");
						e1.printStackTrace();
						return;
					}

				} else if (presentPanel.isVisible()) {
					BookDao bd = new BookDao();
					try {
						bd.addBook((bd.getBookByISBN(Integer.valueOf(textField_6.getText()))),
								Integer.valueOf(textField_15.getText()));
						textField_6.setText("");
						textField_15.setText("");
						presentPanel.setVisible(false);
					} catch (Exception qw) {
						new ErrorDialog().invoke("Your request could not be processed");
					}
				}

			}
		});

		// CHANGE MADE BY RAMESHWAR
		btnViewSelectedBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (queryBookList.isSelectionEmpty() && queryBookList.getModel().getSize() != 0)
					JOptionPane.showMessageDialog(window, "Select one of the above books to view by clicking");
				else if (queryBookList.getModel().getSize() == 0) {
					JOptionPane.showMessageDialog(window, "No books available to view");
				} else {
					int choice = queryBookList.getSelectedIndex();
					// JOptionPane.showMessageDialog(window, choice);
					Query.setVisible(false);
					viewBook.setVisible(true);
					// JOptionPane.showMessageDialog(window, model.get(choice));
					String isbn = "";
					String s = model.get(choice);
					/*
					 * for (int i = 0; i < s.length(); i++) { Character c =
					 * s.charAt(i); if (Character.isDigit(c)) isbn = isbn +
					 * c.toString(); }
					 */
					isbn = (s.substring(s.lastIndexOf(":") + 1)); // rameshwar123
					BookDao dao1 = new BookDao();
					Book thisBook;
					try {
						thisBook = dao1.getBookByISBN(Integer.parseInt(isbn));
					} catch (Exception e12) {
						new ErrorDialog().invoke("Please enter a valid integer");
						return;
					}
					// increment requests if book is not in Stock RAMESHWAR
					if (thisBook.getNoOfCopies() == 0) {
						thisBook.setNoOfRequests(thisBook.getNoOfRequests() + 1);
						new BookDao().updateRequests(thisBook);
						new ErrorDialog().invoke(
								"The book is presently not in stock.The book will be available in 2-3 business days.");
					}

					lblNewLabel_1.setText(thisBook.getBookTitle());
					mlblAName.setText(thisBook.getAuthorName());
					lblNewLabel_2.setText(thisBook.getPrice().toString());
					lblNewLabel_5.setText(thisBook.getRackNo().toString());
					lblNewLabel_4.setText(thisBook.getISBN().toString());
					lblNewLabel_3.setText(thisBook.getNoOfCopies().toString());

				}

			}
		});

		// BACK BUTTON IN VIEW STATISTICS
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				statisticsPanel.setVisible(false);
				ownerPanel.setVisible(true);
			}
		});

		// rameshwar123
		btnPlaceOrder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textField_16.getText().equals("") || textField_2.getText().equals("")
						|| textField_3.getText().equals("") || textField_4.getText().equals("")) {
					new ErrorDialog().invoke("Please enter all values for order");
					return;
				}
				NotInCollection c = new NotInCollection();
				try {
					c.setISBNCode(Integer.parseInt(textField_16.getText()));
				} catch (Exception e1212) {
					new ErrorDialog().invoke("ISBN code must be valid!");
					return;
				}

				c.setAuthorName(textField_3.getText());
				c.setBookTitle(textField_2.getText());
				c.setPublisherName(textField_4.getText());
				c.setNoOfRequests(c.getNoOfRequests() + 1);

				// rameshwar123
				if (new BookDao().doesBookExist(c.getISBNCode())) {
					new ErrorDialog().invoke(
							"Book of this ISBN code are present in the database. Kindly check query or retry!!");
					return;
				}

				new NotInCollectionDao().addRequest(c);

				textField_4.setText("");
				textField_3.setText("");
				textField_2.setText("");
				textField_16.setText("");

				new ToastMessage("Order was successfully placed", 750);
				orderBookPanel.setVisible(false);
				Query.setVisible(true);

			}
		});

		// back button in requests view

		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				requestsPanel.setVisible(false);
				managerPanel.setVisible(true);
				requestsTextArea.setText("");
			}
		});

		// not in collection requests
		btnViewRequests.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				requestsTextArea.setText("");
				requestsPanel.setVisible(true);
				managerPanel.setVisible(false);

				// get the not in collection requests
				List<NotInCollection> list = new NotInCollectionDao().viewRequests();
				StringBuilder stringBuilder = new StringBuilder("REQUESTS\n\n");
				int i = 1;
				for (NotInCollection c : list) {
					stringBuilder.append(i + ". ISBN Code: " + c.getISBNCode() + "\n   Book Title: " + c.getBookTitle()
							+ "\n  Author Name:" + c.getAuthorName() + "\n  Publisher Name: " + c.getPublisherName());
					stringBuilder.append("\n\n");
					i++;
				}
				requestsTextArea.setText(stringBuilder.toString());
			}
		});

		btnViewNotInStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<Book> result = new BookDao().getRequests();
				StringBuilder stringBuilder = new StringBuilder("");
				int i = 1;
				for (Book b : result) {
					stringBuilder.append(i + ". ISBN Code: " + b.getISBN() + "\n   Book title: " + b.getBookTitle()
							+ "\n Author Name: " + b.getAuthorName() + "\n  No. of requests: " + b.getNoOfRequests()
							+ "\n\n");
				}
				managerPanel.setVisible(false);
				requestsTextArea.setText(stringBuilder.toString());
				requestsPanel.setVisible(true);
			}
		});

		// generate recipt
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				salesclerkPanel.setVisible(false);
				genreceiptPanel.setVisible(true);

			}
		});

		generate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				managerPanel.setVisible(false);
				if (cart != null && cart.getCart() != null && cart.getCart().isEmpty())
					cart.getCart().clear();
				genreceiptPanel.setVisible(true);

			}
		});

		btnGetList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// TODO Auto-generated
														// method stub
				List<Book> result = new BookDao().getBooksBelowThreshold();
				StringBuilder stringBuilder = new StringBuilder("");
				int i = 1;
				for (Book b : result) {
					stringBuilder.append(i + ". ISBN Code: " + b.getISBN() + "\n   Book title: " + b.getBookTitle()
							+ "\n Author Name: " + b.getAuthorName() + "\n Stockist address: "
							+ b.getPublisher().getVendor().getVendorAddress() + "\n\n");
					i++;
				}

				ownerPanel.setVisible(false);
				textArea_threshold.setText(stringBuilder.toString());
				belowThresholdPanel.setVisible(true);

			}
		});

		// update database
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				salesclerkPanel.setVisible(false);
				generalPanel.setVisible(true);
				// make login label and button invisible
				// make back button visible
				lblLoggedInAs_1.setVisible(false);
				btnLogOut_1.setVisible(false);
				back_button_8.setVisible(true);

			}
		});

		back_button_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sessionID == 2) {
					generalPanel.setVisible(false);
					managerPanel.setVisible(true);

				}

				else if (sessionID == 3) {
					generalPanel.setVisible(false);
					salesclerkPanel.setVisible(true);
				}

			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ownerPanel.setVisible(true);
				belowThresholdPanel.setVisible(false);
				textArea_threshold.setText("");

			}
		});

	}

	// AUXILIARY FUNCTION FOR PRETTY PRINTING
	public static String capitalizeFirstLetter(String original) {
		if (original == null || original.length() == 0) {
			return original;
		}
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}

	public static void main(String[] args) {
		int i;
		/*for(i=1000;i<1030;i++)
		{
			Book book=new Book();
			book.setBookTitle("asas");
			//book.setBookTitle("ghaia");
			book.setAverageDays(12);
			book.setImageFileName("ass");
			book.setISBN(i+1000);
			book.setNoOfCopies(12);
			book.setNoOfRequests(12);
			book.setPrice(12);
			book.setRackNo(12);
			book.setAuthorName("assasa");
			book.setThreshold(12);
			Publisher pub=new Publisher();
			pub.setPublisherId(1000+i);
			pub.setPublisherName("asas");
			Vendor ven=new Vendor();
			ven.setVendorAddress("da");
			ven.setVendorEmail("dad");
			ven.setVendorId(i+1000);
			ven.setVendorName("dsadas");
			new VendorDao().addVendor(ven);
			pub.setVendor(ven);
			new PublisherDao().addPublisher(pub);
			book.setPublisher(pub);
			new BookDao().addBook(book, book.getNoOfCopies());
			
		
		}*/
		
		//one time initialisation 
		SessionFactory sf=new InitialiseSFHibernate().getSessionFactory();
		application();
	}
}