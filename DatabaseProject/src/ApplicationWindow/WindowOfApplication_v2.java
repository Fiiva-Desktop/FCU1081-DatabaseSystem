package ApplicationWindow;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class WindowOfApplication_v2 extends JFrame {
	/*
	 */
	private static final long serialVersionUID = -5641183030199674262L;

	/* application base panel */
	private JPanel panel_base;
	private CardLayout baseCard = new CardLayout();
	
	/* login page */
	private JPanel panel_login;
	private JTextField textFieldLoginAccount;
	private JPasswordField pwdFieldLoginPassword;
	
	/* sign up page - user */
	private JPanel panel_signUp4User;
	private JTextField textFieldSignUpUserName;
	private JTextField textFieldSignUpUserBirthday;
	private JTextField textFieldSignUpUserPhone;
	private JTextField textFieldSignUpUserEmail;
	private JTextField textFieldSignUpUserAddress;
	private JPasswordField pwdFieldSignUpUserPassword;
	private JPasswordField pwdFieldSignUpUserPwdAgain;
	
	/* sign up page - delivery man */
	private JPanel panel_signUp4Dman;
	private JTextField textFieldSignUpDmanName;
	private JTextField textFieldSignUpDmanBirthday;
	private JTextField textFieldSignUpDmanPhone;
	private JTextField textFieldSignUpDmanEmail;
	private JTextField textFieldSignUpDmanAddress;
	private JTextField textFieldSignUpDmanIdentity;
	private JTextField textFieldSignUpDmanBankAccount;
	private JPasswordField pwdFieldSignUpDmanPassword;
	private JPasswordField pwdFieldSignUpDmanPwdAgain;

	/* after login base panel */
	private JPanel panel_afterLoginBase;
	
	/* bar panel */
	private JPanel panel_bar;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	
	/* pages base panel */
	private JPanel panel_pagesBase;
	private CardLayout pagesCard = new CardLayout();
	
	/* page home */
	private JLabel lblFavoriteStoreCount;
	private JTable tableHomeFavorite;
	private DefaultTableModel tableModelHomeFavorite = new DefaultTableModel();
	private ArrayList<Integer> arrayListHomeFavoriteStoreID = new ArrayList<Integer>();
	
	/* page search */
	private JTextField textFieldSearchPageSearch;
	private ArrayList<String> randomItem = new ArrayList<String>();
	private JButton btnRandomSelect1;
	private JButton btnRandomSelect2;
	private JButton btnRandomSelect3;
	private JButton btnRandomSelect4;
	
	/* search result */
	private JLabel lblSearchComdition;
	private JLabel lblResultCount;
	private JTable tableSearchResult;
	private DefaultTableModel tableModelSearchResult = new DefaultTableModel();
	private ArrayList<Integer> arrayListSearchResultStoreID = new ArrayList<Integer>();
	
	/* create order */
	private JLabel lblCreateOrderStoreName;
	private JTable tableCreateOrderItemInfo;
	private DefaultTableModel tableModelItemInfo = new DefaultTableModel();
	private SpinnerNumberModel[] spinnerArray;
	
	/* comment */
	private JTable tableStoreComment;
	private DefaultTableModel tableModelComment = new DefaultTableModel();
	private JLabel lblCommentCount;
	
	/* page history */
	private JLabel lblOrderHistoryCount;
	private JTable tableOrderHistory;
	private DefaultTableModel tableModelOrderHistory = new DefaultTableModel();
	
	/* order history info */
	private JTable tableOrderInfo;
	DefaultTableModel tableModelOrderInfo = new DefaultTableModel();
	private JLabel lblOrderInfoStatementData; 
	private JLabel lblOrderInfoOrderTimeData;
	private JLabel lblOrderInfoTotalPrice;
	
	/* page profile */
	private JLabel lblProfileUserNameData;
	private JLabel lblProfileUserBirthdayData;
	private JLabel lblProfileUserPhoneData;
	private JLabel lblProfileUserEmailData;
	private JLabel lblProfileUserAddressData;
	private JLabel lblProfileUserStatementData;
	
	/* change password */
	private JPasswordField pwdFieldOldPassword;
	private JPasswordField pwdFieldNewPassword;
	private JPasswordField pwdFieldNewPasswordAgain;
	
	/* change phone */
	private JTextField textFieldOldPhone;
	private JTextField textFieldNewPhone;
	
	/* change address */
	DefaultListModel<String> listModelProfileAddress = new DefaultListModel<String>();
	private JTextField textFieldNewAddress;
	
	/* else variable */
	private Font textFont = new Font("微軟正黑體", Font.CENTER_BASELINE, 19);
	private int searchResultCount;
	private int orderHistoryCount;
	private int favoriteStoreCount;
	private int itemCounter;
	private String USERID = new String();
	private String SELECTSTOREID = new String();
	private boolean fromFavorite = false;
	private ArrayList<Integer> itemPrice = new ArrayList<Integer>();
	private ArrayList<String> itemName = new ArrayList<String>();
	private ArrayList<Integer> menuID = new ArrayList<Integer>();
	private SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
	
	
	
	

	

	/*
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowOfApplication_v2 window = new WindowOfApplication_v2();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("系統錯誤 22");
				}
			}
		});
	}

	
	public WindowOfApplication_v2() {
		super("DB Project");
		this.setResizable(false);
		this.setBounds(100, 100, 421, 736);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		/* base panel of application */
		panel_base = new JPanel();
		this.getContentPane().add(panel_base, "panel_appBase");
		panel_base.setLayout(baseCard);
		
		
		
		/* login page */
		panel_login = new JPanel();
		panel_base.add(panel_login, "page_login");
		panel_login.setLayout(null);
		JLabel labelLoginAccount = new JLabel("電話", SwingConstants.CENTER);
		labelLoginAccount.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		labelLoginAccount.setBounds(10, 213, 99, 62);
		panel_login.add(labelLoginAccount);
		
		textFieldLoginAccount = new JTextField();
		textFieldLoginAccount.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 25));
		textFieldLoginAccount.setBounds(123, 228, 261, 40);
		panel_login.add(textFieldLoginAccount);
		textFieldLoginAccount.setColumns(10);
		
		JLabel labelLoginPassword = new JLabel("密碼", SwingConstants.CENTER);
		labelLoginPassword.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		labelLoginPassword.setBounds(10, 336, 99, 62);
		panel_login.add(labelLoginPassword);
		
		pwdFieldLoginPassword = new JPasswordField();
		pwdFieldLoginPassword.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 25));
		pwdFieldLoginPassword.setBounds(123, 351, 261, 40);
		panel_login.add(pwdFieldLoginPassword);
		
		JLabel lblProjectName = new JLabel("Project Name", SwingConstants.CENTER);
		lblProjectName.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 50));
		lblProjectName.setBounds(0, 0, 398, 205);
		panel_login.add(lblProjectName);
		
		JButton btnLogin = new JButton("登入");
		btnLogin.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldLoginAccount.getText().equals("")) JOptionPane.showConfirmDialog(null, "請輸入電話", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				else if(pwdFieldLoginPassword.getText().equals("")) JOptionPane.showConfirmDialog(null, "請輸入密碼", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				else {
					DBConnect DBC = new DBConnect();
					String query = "SELECT UserID "+
								   "FROM   fast_food_delivered_managerment.user "+
								   "WHERE  UserPhone = '"+textFieldLoginAccount.getText()+"' AND "+
								   "       UserPassword = '"+pwdFieldLoginPassword.getText()+"' ";
					try {
						ResultSet resultset = DBC.getStatement().executeQuery(query);
						while(resultset.next()) {
							USERID = resultset.getString("UserID");
						}
						/* login finish */
						tableModelHomeFavorite.setRowCount(0);
						arrayListHomeFavoriteStoreID.clear();
						favoriteStoreCount = 0;
						String tableTitle[] = {"店家名稱", "店家地址", "店家評分"};
						tableModelHomeFavorite.setColumnIdentifiers(tableTitle);
						query = "Select   FS.StoreID, FS.StoreName, FS.StoreAddress, AVG(CommentLevel) " + 
									   "From     fast_food_delivered_managerment.store         AS FS, " +
									   "         fast_food_delivered_managerment.favorite_list AS FF, " +
									   "         fast_food_delivered_managerment.comment       AS FC "  +
									   "WHERE    FF.UserID = "+USERID+" AND " +
									   "         FF.StoreID = FS.StoreID AND " +
									   "         FC.StoreID = FS.StoreID " +
									   "GROUP BY FS.StoreID ";
						try {
							resultset = DBC.getStatement().executeQuery(query);
							while(resultset.next()) {
								int storeID = resultset.getInt("FS.StoreID");
								String storeName = resultset.getString("FS.StoreName");
								String storeAddress = resultset.getString("FS.StoreAddress");
								Double avgCommentLevel = resultset.getDouble("AVG(CommentLevel)");
								String tableLine[] = {storeName, storeAddress, String.format("%.1f", avgCommentLevel)};
								tableModelHomeFavorite.addRow(tableLine);
								arrayListHomeFavoriteStoreID.add(storeID);
								favoriteStoreCount++;
							}
							
							tableHomeFavorite.getColumn("店家名稱").setPreferredWidth(200);
							tableHomeFavorite.getColumn("店家地址").setPreferredWidth(400);
							tableHomeFavorite.getColumn("店家評分").setPreferredWidth(100);
							lblFavoriteStoreCount.setText("收藏了"+favoriteStoreCount+"家");
							baseCard.show(panel_base, "panel_afterLoginBase");
						} catch (SQLException e1) {
							e1.printStackTrace();
							System.out.println("系統錯誤 01");
							textFieldLoginAccount.setText("");
							pwdFieldLoginPassword.setText("");
							JOptionPane.showConfirmDialog(null, "電話或密碼錯誤", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}
							
					} catch (SQLException e2) {
						JOptionPane.showConfirmDialog(null, "電話或密碼錯誤.", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();
						System.out.println("系統錯誤 27");
						textFieldLoginAccount.setText("");
						pwdFieldLoginPassword.setText("");
					}
				}
					
			}
		});
		btnLogin.setBounds(10, 486, 388, 73);
		panel_login.add(btnLogin);
		
		JButton btnSignUp = new JButton("註冊");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseCard.show(panel_base, "userSignUpPage");
			}
		});
		btnSignUp.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		btnSignUp.setBounds(10, 572, 388, 73);
		panel_login.add(btnSignUp);
		
		
		
		/* sign up page - user */
		panel_signUp4User = new JPanel();
		panel_base.add(panel_signUp4User, "userSignUpPage");
		panel_signUp4User.setLayout(null);
		
		JButton btnSignUpUserBack2Login = new JButton("返回");
		btnSignUpUserBack2Login.setFont(textFont);
		btnSignUpUserBack2Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSignUpUserName.setText("");
				textFieldSignUpUserBirthday.setText("");
				textFieldSignUpUserPhone.setText("");
				textFieldSignUpUserEmail.setText("");
				pwdFieldSignUpUserPassword.setText("");
				pwdFieldSignUpUserPwdAgain.setText("");
				baseCard.show(panel_base, "page_login");
			}
		});
		btnSignUpUserBack2Login.setBounds(14, 13, 99, 34);
		panel_signUp4User.add(btnSignUpUserBack2Login);
		
		JButton btnSignUp2Dman = new JButton("外送員註冊");
		btnSignUp2Dman.setFont(textFont);
		btnSignUp2Dman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSignUpUserName.setText("");
				textFieldSignUpUserBirthday.setText("");
				textFieldSignUpUserPhone.setText("");
				textFieldSignUpUserEmail.setText("");
				pwdFieldSignUpUserPassword.setText("");
				pwdFieldSignUpUserPwdAgain.setText("");
				baseCard.show(panel_base, "dmanSignUpPage");
			}
		});
		btnSignUp2Dman.setBounds(214, 90, 180, 34);
		panel_signUp4User.add(btnSignUp2Dman);
		
		JLabel lblSignUpUser = new JLabel("使用者註冊", SwingConstants.CENTER);
		lblSignUpUser.setBorder(BorderFactory.createLoweredBevelBorder());
		lblSignUpUser.setFont(textFont);
		lblSignUpUser.setBounds(14, 90, 180, 34);
		panel_signUp4User.add(lblSignUpUser);
		
		JLabel lblSignUpUserName = new JLabel("姓名");
		lblSignUpUserName.setFont(textFont);
		lblSignUpUserName.setBounds(14, 180, 99, 27);
		panel_signUp4User.add(lblSignUpUserName);
		
		textFieldSignUpUserName = new JTextField();
		textFieldSignUpUserName.setFont(textFont);
		textFieldSignUpUserName.setBounds(127, 180, 267, 27);
		panel_signUp4User.add(textFieldSignUpUserName);
		textFieldSignUpUserName.setColumns(10);
		
		JLabel lblSignUpUserBirthday = new JLabel("出生日期");
		lblSignUpUserBirthday.setFont(textFont);
		lblSignUpUserBirthday.setBounds(14, 220, 99, 27);
		panel_signUp4User.add(lblSignUpUserBirthday);
		
		textFieldSignUpUserBirthday = new JTextField();
		textFieldSignUpUserBirthday.setFont(textFont);
		textFieldSignUpUserBirthday.setBounds(127, 220, 267, 27);
		panel_signUp4User.add(textFieldSignUpUserBirthday);
		textFieldSignUpUserBirthday.setColumns(10);
		
		JLabel lblSignUpUserPhone = new JLabel("電話號碼");
		lblSignUpUserPhone.setFont(textFont);
		lblSignUpUserPhone.setBounds(14, 260, 99, 27);
		panel_signUp4User.add(lblSignUpUserPhone);
		
		textFieldSignUpUserPhone = new JTextField();
		textFieldSignUpUserPhone.setFont(textFont);
		textFieldSignUpUserPhone.setColumns(10);
		textFieldSignUpUserPhone.setBounds(127, 260, 267, 27);
		panel_signUp4User.add(textFieldSignUpUserPhone);
		
		JLabel lblSignUpUserEmail = new JLabel("電子信箱");
		lblSignUpUserEmail.setFont(textFont);
		lblSignUpUserEmail.setBounds(14, 300, 99, 27);
		panel_signUp4User.add(lblSignUpUserEmail);
		
		textFieldSignUpUserEmail = new JTextField();
		textFieldSignUpUserEmail.setFont(textFont);
		textFieldSignUpUserEmail.setColumns(10);
		textFieldSignUpUserEmail.setBounds(127, 300, 267, 27);
		panel_signUp4User.add(textFieldSignUpUserEmail);
		
		JLabel lblSignUpUserAddress = new JLabel("外送地址");
		lblSignUpUserAddress.setFont(textFont);
		lblSignUpUserAddress.setBounds(14, 340, 99, 27);
		panel_signUp4User.add(lblSignUpUserAddress);
		
		textFieldSignUpUserAddress = new JTextField();
		textFieldSignUpUserAddress.setFont(textFont);
		textFieldSignUpUserAddress.setColumns(10);
		textFieldSignUpUserAddress.setBounds(128, 340, 266, 27);
		panel_signUp4User.add(textFieldSignUpUserAddress);
		
		JLabel lblSignUpUserPassword = new JLabel("密碼");
		lblSignUpUserPassword.setFont(textFont);
		lblSignUpUserPassword.setBounds(14, 380, 99, 27);
		panel_signUp4User.add(lblSignUpUserPassword);
		
		pwdFieldSignUpUserPassword = new JPasswordField();
		pwdFieldSignUpUserPassword.setFont(textFont);
		pwdFieldSignUpUserPassword.setColumns(10);
		pwdFieldSignUpUserPassword.setBounds(127, 380, 267, 27);
		panel_signUp4User.add(pwdFieldSignUpUserPassword);
		
		JLabel lblSignUpUserPwdAgain = new JLabel("確認密碼");
		lblSignUpUserPwdAgain.setFont(textFont);
		lblSignUpUserPwdAgain.setBounds(14, 420, 99, 27);
		panel_signUp4User.add(lblSignUpUserPwdAgain);
		
		pwdFieldSignUpUserPwdAgain = new JPasswordField();
		pwdFieldSignUpUserPwdAgain.setFont(textFont);
		pwdFieldSignUpUserPwdAgain.setColumns(10);
		pwdFieldSignUpUserPwdAgain.setBounds(127, 420, 267, 27);
		panel_signUp4User.add(pwdFieldSignUpUserPwdAgain);
		
		JButton btnSignUpUserReset = new JButton("重填");
		btnSignUpUserReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSignUpUserName.setText("");
				textFieldSignUpUserBirthday.setText("");
				textFieldSignUpUserPhone.setText("");
				textFieldSignUpUserEmail.setText("");
				textFieldSignUpUserAddress.setText("");
				pwdFieldSignUpUserPassword.setText("");
				pwdFieldSignUpUserPwdAgain.setText("");
			}
		});
		btnSignUpUserReset.setFont(textFont);
		btnSignUpUserReset.setBounds(14, 654, 99, 34);
		panel_signUp4User.add(btnSignUpUserReset);

		JButton btnSignUpUser = new JButton("註冊");
		btnSignUpUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean error = false;
				String errorMessage = "";
				if     (textFieldSignUpUserName.getText().equals("")) {
					error = true;
					errorMessage = "姓名欄位不能為空白";
				}
				else if(textFieldSignUpUserBirthday.getText().equals("")) {
					error = true;
					errorMessage = "出生日期不能為空白";
				}
				else if(textFieldSignUpUserPhone.getText().equals("")) {
					error = true;
					errorMessage = "電話號碼不能為空白";
				}
				else if(textFieldSignUpUserEmail.getText().equals("")) {
					error = true;
					errorMessage = "電子信箱不能為空白";
				}
				else if(textFieldSignUpUserAddress.getText().equals("")) {
					error = true;
					errorMessage = "外送地址不能為空白";
				}
				else if(pwdFieldSignUpUserPassword.getText().equals("")) {
					error = true;
					errorMessage = "密碼不能為空白";
				}
				else if(pwdFieldSignUpUserPwdAgain.getText().equals("")) {
					error = true;
					errorMessage = "請確認密碼";
				}
				else {
					if     (textFieldSignUpUserEmail.getText().indexOf('@') < 1) {
						error = true;
						errorMessage = "請輸入正確的電子信箱";
					}
					else if(!pwdFieldSignUpUserPassword.getText().equals(pwdFieldSignUpUserPwdAgain.getText())) {
						error = true;
						errorMessage = "請在確認密碼欄位輸入相同的密碼";
					}
					else {
						DBConnect DBC = new DBConnect();
						try {
							int MaxUserID = 0;
							ResultSet resultset = DBC.getStatement().executeQuery("SELECT MAX(UserID) FROM fast_food_delivered_managerment.user");
							while(resultset.next()) MaxUserID = resultset.getInt("MAX(UserID)");
							MaxUserID += 1;
							String sql = "INSERT INTO fast_food_delivered_managerment.user(UserID, UserName, UserBirthday, UserPhone, UserEmail, UserStatement, UserPassword) "+
										 "VALUES      ('"+
														  MaxUserID+"', '"+
														  textFieldSignUpUserName.getText()+"', '"+
														  textFieldSignUpUserBirthday.getText()+"', '"+
														  textFieldSignUpUserPhone.getText()+"', '"+
														  textFieldSignUpUserEmail.getText()+"', '"+
														  "NotCertified', '"+
														  pwdFieldSignUpUserPassword.getText()+"')";
							DBC.getStatement().executeUpdate(sql);						
							
							sql = "INSERT INTO fast_food_delivered_managerment.address(UserID, DeliveryAddress)"+
								  "VALUES      ('"+MaxUserID+"', '"+textFieldSignUpUserAddress.getText()+"')";
							DBC.getStatement().executeUpdate(sql);
							JOptionPane.showConfirmDialog(null, "註冊成功", "訊息", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
							textFieldSignUpUserName.setText("");
							textFieldSignUpUserBirthday.setText("");
							textFieldSignUpUserPhone.setText("");
							textFieldSignUpUserEmail.setText("");
							textFieldSignUpUserAddress.setText("");
							pwdFieldSignUpUserPassword.setText("");
							pwdFieldSignUpUserPwdAgain.setText("");
							baseCard.show(panel_base, "page_login");
						} catch (SQLException e1) {
							e1.printStackTrace();
							error = true;
							errorMessage = "電話/電子信箱已被註冊過";
							//JOptionPane.showConfirmDialog(null, , "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}	
					}
				}
				if(error) JOptionPane.showConfirmDialog(null, errorMessage, "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);				
			}
		});
		btnSignUpUser.setFont(textFont);
		btnSignUpUser.setBounds(295, 654, 99, 34);
		panel_signUp4User.add(btnSignUpUser);
		
		
		
		/* sign up page - delivery man */
		panel_signUp4Dman = new JPanel();
		panel_base.add(panel_signUp4Dman, "dmanSignUpPage");
		panel_signUp4Dman.setLayout(null);
		
		JButton btnSignUpDmanBack2Login = new JButton("返回");
		btnSignUpDmanBack2Login.setFont(textFont);
		btnSignUpDmanBack2Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSignUpDmanName.setText("");
				textFieldSignUpDmanBirthday.setText("");
				textFieldSignUpDmanPhone.setText("");
				textFieldSignUpDmanEmail.setText("");
				textFieldSignUpDmanAddress.setText("");
				textFieldSignUpDmanIdentity.setText("");
				textFieldSignUpDmanBankAccount.setText("");
				pwdFieldSignUpDmanPassword.setText("");
				pwdFieldSignUpDmanPwdAgain.setText("");
				baseCard.show(panel_base, "page_login");
			}
		});
		btnSignUpDmanBack2Login.setBounds(14, 13, 99, 34);
		panel_signUp4Dman.add(btnSignUpDmanBack2Login);
		
		JButton btnSignUp4User = new JButton("使用者註冊");
		btnSignUp4User.setFont(textFont);
		btnSignUp4User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSignUpDmanName.setText("");
				textFieldSignUpDmanBirthday.setText("");
				textFieldSignUpDmanPhone.setText("");
				textFieldSignUpDmanEmail.setText("");
				textFieldSignUpDmanAddress.setText("");
				textFieldSignUpDmanIdentity.setText("");
				textFieldSignUpDmanBankAccount.setText("");
				pwdFieldSignUpDmanPassword.setText("");
				pwdFieldSignUpDmanPwdAgain.setText("");
				baseCard.show(panel_base, "userSignUpPage");;
			}
		});
		btnSignUp4User.setBounds(14, 90, 180, 34);
		panel_signUp4Dman.add(btnSignUp4User);
		
		JLabel lblSignUpDman = new JLabel("外送員註冊", SwingConstants.CENTER);
		lblSignUpDman.setBorder(BorderFactory.createLoweredBevelBorder());
		lblSignUpDman.setFont(textFont);
		lblSignUpDman.setBounds(214, 90, 180, 34);
		panel_signUp4Dman.add(lblSignUpDman);
		
		JLabel lblSignUpDmanName = new JLabel("姓名");
		lblSignUpDmanName.setFont(textFont);
		lblSignUpDmanName.setBounds(14, 180, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanName);
		
		textFieldSignUpDmanName = new JTextField();
		textFieldSignUpDmanName.setFont(textFont);
		textFieldSignUpDmanName.setBounds(128, 180, 266, 27);
		panel_signUp4Dman.add(textFieldSignUpDmanName);
		textFieldSignUpDmanName.setColumns(10);
		
		JLabel lblSignUpDmanBirthday = new JLabel("出生日期");
		lblSignUpDmanBirthday.setFont(textFont);
		lblSignUpDmanBirthday.setBounds(14, 220, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanBirthday);
		
		textFieldSignUpDmanBirthday = new JTextField();
		textFieldSignUpDmanBirthday.setFont(textFont);
		textFieldSignUpDmanBirthday.setBounds(128, 220, 266, 27);
		panel_signUp4Dman.add(textFieldSignUpDmanBirthday);
		textFieldSignUpDmanBirthday.setColumns(10);
		
		JLabel lblSignUpDmanPhoneNumber = new JLabel("電話號碼");
		lblSignUpDmanPhoneNumber.setFont(textFont);
		lblSignUpDmanPhoneNumber.setBounds(14, 260, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanPhoneNumber);
		
		textFieldSignUpDmanPhone = new JTextField();
		textFieldSignUpDmanPhone.setFont(textFont);
		textFieldSignUpDmanPhone.setBounds(128, 260, 266, 27);
		panel_signUp4Dman.add(textFieldSignUpDmanPhone);
		textFieldSignUpDmanPhone.setColumns(10);
		
		JLabel lblSignUpDmanEmail = new JLabel("電子信箱");
		lblSignUpDmanEmail.setFont(textFont);
		lblSignUpDmanEmail.setBounds(14, 300, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanEmail);
		
		textFieldSignUpDmanEmail = new JTextField();
		textFieldSignUpDmanEmail.setFont(textFont);
		textFieldSignUpDmanEmail.setBounds(128, 300, 266, 27);
		panel_signUp4Dman.add(textFieldSignUpDmanEmail);
		textFieldSignUpDmanEmail.setColumns(10);
		
		JLabel lblSignUpDmanAddress = new JLabel("居住地址");
		lblSignUpDmanAddress.setFont(textFont);
		lblSignUpDmanAddress.setBounds(14, 340, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanAddress);
		
		textFieldSignUpDmanAddress = new JTextField();
		textFieldSignUpDmanAddress.setFont(textFont);
		textFieldSignUpDmanAddress.setBounds(128, 340, 266, 27);
		panel_signUp4Dman.add(textFieldSignUpDmanAddress);
		textFieldSignUpDmanAddress.setColumns(10);
		
		JLabel lblSignUpDmanIdentity = new JLabel("身分證字號");
		lblSignUpDmanIdentity.setFont(textFont);
		lblSignUpDmanIdentity.setBounds(14, 380, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanIdentity);
		
		textFieldSignUpDmanIdentity = new JTextField();
		textFieldSignUpDmanIdentity.setFont(textFont);
		textFieldSignUpDmanIdentity.setColumns(10);
		textFieldSignUpDmanIdentity.setBounds(128, 380, 266, 27);
		panel_signUp4Dman.add(textFieldSignUpDmanIdentity);
		
		JLabel lblSignUpDmanBankAccount = new JLabel("銀行帳戶");
		lblSignUpDmanBankAccount.setFont(textFont);
		lblSignUpDmanBankAccount.setBounds(14, 420, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanBankAccount);
		
		textFieldSignUpDmanBankAccount = new JTextField();
		textFieldSignUpDmanBankAccount.setFont(textFont);
		textFieldSignUpDmanBankAccount.setColumns(10);
		textFieldSignUpDmanBankAccount.setBounds(128, 420, 266, 27);
		panel_signUp4Dman.add(textFieldSignUpDmanBankAccount);
		
		JLabel lblSignUpDmanPassword = new JLabel("密碼");
		lblSignUpDmanPassword.setFont(textFont);
		lblSignUpDmanPassword.setBounds(14, 460, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanPassword);
		
		pwdFieldSignUpDmanPassword = new JPasswordField();
		pwdFieldSignUpDmanPassword.setFont(textFont);
		pwdFieldSignUpDmanPassword.setBounds(128, 460, 266, 27);
		panel_signUp4Dman.add(pwdFieldSignUpDmanPassword);
		pwdFieldSignUpDmanPassword.setColumns(10);
		
		JLabel lblSignUpDmanPwdAgin = new JLabel("確認密碼");
		lblSignUpDmanPwdAgin.setFont(textFont);
		lblSignUpDmanPwdAgin.setBounds(14, 500, 99, 27);
		panel_signUp4Dman.add(lblSignUpDmanPwdAgin);
		
		pwdFieldSignUpDmanPwdAgain = new JPasswordField();
		pwdFieldSignUpDmanPwdAgain.setFont(textFont);
		pwdFieldSignUpDmanPwdAgain.setBounds(128, 500, 266, 27);
		panel_signUp4Dman.add(pwdFieldSignUpDmanPwdAgain);
		pwdFieldSignUpDmanPwdAgain.setColumns(10);
		
		JButton btnSignUpDmanReset = new JButton("重填");
		btnSignUpDmanReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldSignUpDmanName.setText("");
				textFieldSignUpDmanBirthday.setText("");
				textFieldSignUpDmanPhone.setText("");
				textFieldSignUpDmanEmail.setText("");
				textFieldSignUpDmanAddress.setText("");
				textFieldSignUpDmanIdentity.setText("");
				textFieldSignUpDmanBankAccount.setText("");
				pwdFieldSignUpDmanPassword.setText("");
				pwdFieldSignUpDmanPwdAgain.setText("");
			}
		});
		btnSignUpDmanReset.setFont(textFont);
		btnSignUpDmanReset.setBounds(14, 654, 99, 34);
		panel_signUp4Dman.add(btnSignUpDmanReset);

		JButton btnSignUpDman = new JButton("註冊");
		btnSignUpDman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean error = false;
				String errorMessage = "";
				if     (textFieldSignUpDmanName.getText().equals("")) {
					error = true;
					errorMessage = "姓名欄位不能為空白";
				}
				else if(textFieldSignUpDmanBirthday.getText().equals("")) {
					error = true;
					errorMessage = "出生日期不能為空白";
				}
				else if(textFieldSignUpDmanPhone.getText().equals("")) {
					error = true;
					errorMessage = "電話號碼不能為空白";
				}
				else if(textFieldSignUpDmanEmail.getText().equals("")) {
					error = true;
					errorMessage = "電子信箱不能為空白";
				}
				else if(textFieldSignUpDmanAddress.getText().equals("")) {
					error = true;
					errorMessage = "居住地址不能為空白";
				}
				else if(textFieldSignUpDmanBankAccount.getText().equals("")) {
					error = true;
					errorMessage = "銀行帳戶不能為空白";
				}
				else if(pwdFieldSignUpDmanPassword.getText().equals("")) {
					error = true;
					errorMessage = "密碼不能為空白";
				}
				else if(pwdFieldSignUpDmanPwdAgain.getText().equals("")) {
					error = true;
					errorMessage = "請確認密碼";
				}
				else {
					if     (textFieldSignUpDmanEmail.getText().indexOf('@') < 1) {
						error = true;
						errorMessage = "請輸入正確的電子信箱";
					}
					else if(!pwdFieldSignUpDmanPassword.getText().equals(pwdFieldSignUpDmanPwdAgain.getText())) {
						error = true;
						errorMessage = "請在確認密碼欄位輸入相同的密碼";
					}
					else {
						DBConnect DBC = new DBConnect();
						try {
							int MaxDeliceryID = 0;
							ResultSet resultset = DBC.getStatement().executeQuery("SELECT MAX(DeliveryManID) FROM fast_food_delivered_managerment.delivery_man");
							while(resultset.next()) MaxDeliceryID = resultset.getInt("MAX(DeliveryManID)");
							MaxDeliceryID += 1;
							String sql = "INSERT INTO fast_food_delivered_managerment.delivery_man"+
										 "(DeliveryManID, DeliveryManName, DeliveryManBirthday, DeliveryManPhone, DeliveryManEmail,"+
										 " DeliveryManStatement, DeliveryManPassword, DeliveryManFee, DeliveryManIdentity, DeliveryManBankAccount) "+
										 "VALUES      ('"+
										 				  MaxDeliceryID+"', '"+
										 				  textFieldSignUpDmanName.getText()+"', '"+
										 				  textFieldSignUpDmanBirthday.getText()+"', '"+
										 				  textFieldSignUpDmanPhone.getText()+"', '"+
										 				  textFieldSignUpDmanEmail.getText()+"', '"+
														  "not_service', '"+
														  pwdFieldSignUpDmanPassword.getText()+"', '"+
														  "25', '"+
														  textFieldSignUpDmanIdentity.getText()+"', '"+
														  textFieldSignUpDmanBankAccount.getText()+"')";
							DBC.getStatement().executeUpdate(sql);
						} catch (SQLException e1) {
							error = true;
							JOptionPane.showConfirmDialog(null, "電話/電子信箱/身分證字號/銀行帳戶\n已被註冊過", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
							System.out.println("系統錯誤 03");
						}	
					}
				}
				if(error) JOptionPane.showConfirmDialog(null, errorMessage, "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				else if(!error) JOptionPane.showConfirmDialog(null, "註冊成功", "訊息", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				textFieldSignUpDmanName.setText("");
				textFieldSignUpDmanBirthday.setText("");
				textFieldSignUpDmanPhone.setText("");
				textFieldSignUpDmanEmail.setText("");
				textFieldSignUpDmanAddress.setText("");
				textFieldSignUpDmanIdentity.setText("");
				textFieldSignUpDmanBankAccount.setText("");
				pwdFieldSignUpDmanPassword.setText("");
				pwdFieldSignUpDmanPwdAgain.setText("");
				baseCard.show(panel_base, "page_login");
			}
		});
		btnSignUpDman.setFont(textFont);
		btnSignUpDman.setBounds(295, 654, 99, 34);
		panel_signUp4Dman.add(btnSignUpDman);
		
		
		
		/* base of after login */
		panel_afterLoginBase = new JPanel();
		panel_base.add(panel_afterLoginBase, "panel_afterLoginBase");
		panel_afterLoginBase.setLayout(null);
		
		
		
		/* bar panel */
		panel_bar = new JPanel();
		panel_bar.setLocation(0, 624);
		panel_bar.setSize(new Dimension(408, 77));
		panel_afterLoginBase.add(panel_bar);
		panel_bar.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnNewButton = new JButton("Home");
		btnNewButton.setFont(textFont);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelHomeFavorite.setRowCount(0);
				arrayListHomeFavoriteStoreID.clear();
				favoriteStoreCount = 0;
				String tableTitle[] = {"店家名稱", "店家地址", "店家評分"};
				tableModelHomeFavorite.setColumnIdentifiers(tableTitle);
				DBConnect DBC = new DBConnect();
				String query = "Select   FS.StoreID, FS.StoreName, FS.StoreAddress, AVG(CommentLevel) " + 
							   "From     fast_food_delivered_managerment.store         AS FS, " +
							   "         fast_food_delivered_managerment.favorite_list AS FF, " +
							   "         fast_food_delivered_managerment.comment       AS FC "  +
							   "WHERE    FF.UserID = "+USERID+" AND " +
							   "         FF.StoreID = FS.StoreID AND " +
							   "         FC.StoreID = FS.StoreID " +
							   "GROUP BY FS.StoreID ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						int storeID = resultset.getInt("FS.StoreID");
						String storeName = resultset.getString("FS.StoreName");
						String storeAddress = resultset.getString("FS.StoreAddress");
						Double avgCommentLevel = resultset.getDouble("AVG(CommentLevel)");
						String tableLine[] = {storeName, storeAddress, String.format("%.1f", avgCommentLevel)};
						tableModelHomeFavorite.addRow(tableLine);
						arrayListHomeFavoriteStoreID.add(storeID);
						favoriteStoreCount++;
					}						
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 04");
				}
				tableHomeFavorite.getColumn("店家名稱").setPreferredWidth(200);
				tableHomeFavorite.getColumn("店家地址").setPreferredWidth(400);
				tableHomeFavorite.getColumn("店家評分").setPreferredWidth(100);
				lblFavoriteStoreCount.setText("收藏了"+favoriteStoreCount+"家");
				pagesCard.show(panel_pagesBase, "pageHome");
			}
		});
		panel_bar.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(textFont);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSearchPageSearch.setText("");
				randomItem.clear();
				DBConnect DBC = new DBConnect();
				String query = "Select Distinct ItemName " + 
							   "From   fast_food_delivered_managerment.menu";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						randomItem.add(resultset.getString("ItemName"));
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 05");
				}
				btnRandomSelect1.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				btnRandomSelect2.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				btnRandomSelect3.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				btnRandomSelect4.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				pagesCard.show(panel_pagesBase, "pageSearch");
			}
		});
		panel_bar.add(btnNewButton_1);

		btnNewButton_2 = new JButton("History");
		btnNewButton_2.setFont(textFont);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelOrderHistory.setRowCount(0);
				orderHistoryCount = 0;
				String tableTitle[] = {"訂單時間", "店家名稱", "訂單總額", "訂單狀態"};
				tableModelOrderHistory.setColumnIdentifiers(tableTitle);
				DBConnect DBC = new DBConnect();
				String query = "Select   FO.OrderTime, FS.StoreName, SUM(ItemQuantity*ItemPrice), FO.OrderStatement " + 
							   "From     fast_food_delivered_managerment.order      AS FO, " + 
							   "         fast_food_delivered_managerment.order_item AS FOI, " + 
							   "         fast_food_delivered_managerment.menu       AS FM, " + 
							   "         fast_food_delivered_managerment.store      AS FS " + 
							   "WHERE    FO.UserID    = FOI.UserID AND " + 
							   "         FO.OrderTime = FOI.OrderTime AND " + 
							   "         FOI.MenuID   = FM.MenuID AND " + 
							   "         FM.StoreID   = FS.StoreID AND " + 
							   "         FO.UserID    = "+USERID+" "+
							   "GROUP BY FO.OrderTime "+
							   "ORDER BY FO.OrderTime DESC ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						String orderTime = resultset.getString("FO.OrderTime");
						String storeName = resultset.getString("FS.StoreName");
						String totle = resultset.getString("SUM(ItemQuantity*ItemPrice)");
						String orderState = resultset.getString("FO.OrderStatement");
						if(orderState.equals("running")) orderState = "執行中";
						else if(orderState.equals("cancel")) orderState = "已取消";
						else if(orderState.equals("finish")) orderState = "已完成";
						String tableLine[] = {orderTime.substring(0, orderTime.length()-2), storeName, totle, orderState};
						tableModelOrderHistory.addRow(tableLine);
						orderHistoryCount++;
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 06");
				}
				tableOrderHistory.getColumn("訂單時間").setPreferredWidth(450);
				tableOrderHistory.getColumn("店家名稱").setPreferredWidth(200);
				tableOrderHistory.getColumn("訂單總額").setPreferredWidth(125);
				tableOrderHistory.getColumn("訂單狀態").setPreferredWidth(150);
				lblOrderHistoryCount.setText("共"+orderHistoryCount+"筆");
				pagesCard.show(panel_pagesBase, "pageHistory");
			}
		});
		panel_bar.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Profile");
		btnNewButton_3.setFont(textFont);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect DBC = new DBConnect();
				String query = "SELECT   UserName, UserBirthday, UserPhone, UserEmail, DeliveryAddress, UserStatement " + 
							   "FROM     fast_food_delivered_managerment.user    AS FU, " +
							   "         fast_food_delivered_managerment.address AS FA " +
							   "WHERE    FU.UserID = "+USERID+" AND " +
							   "         FA.UserID = FU.UserID " + 
							   "GROUP BY FU.UserID ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						lblProfileUserNameData.setText(resultset.getString("UserName"));
						lblProfileUserBirthdayData.setText(String.format("%tF", resultset.getDate("UserBirthday")));
						lblProfileUserPhoneData.setText(resultset.getString("UserPhone"));
						lblProfileUserEmailData.setText(resultset.getString("UserEmail"));
						lblProfileUserAddressData.setText(resultset.getString("DeliveryAddress"));
						if(resultset.getString("UserStatement").equals("NotCertified")) lblProfileUserStatementData.setText("尚未驗證信箱");
						else if(resultset.getString("UserStatement").equals("Suspension")) lblProfileUserStatementData.setText("已停止");
						else lblProfileUserStatementData.setText("帳號已驗證");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 07");
				}
				pagesCard.show(panel_pagesBase, "pageProfile");
			}
		});
		panel_bar.add(btnNewButton_3);
		
		
		
		/* pages base */
		panel_pagesBase = new JPanel();
		panel_pagesBase.setBounds(0, 0, 408, 625);
		panel_afterLoginBase.add(panel_pagesBase);
		panel_pagesBase.setLayout(pagesCard);
		
		
		
		/* home page */
		JPanel panel_pageHome = new JPanel();
		panel_pagesBase.add(panel_pageHome, "pageHome");
		panel_pageHome.setLayout(null);
		
		JLabel lblFavoriteTable = new JLabel("我的收藏店家");
		lblFavoriteTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoriteTable.setFont(new Font("微軟正黑體", Font.BOLD, 45));
		lblFavoriteTable.setBounds(14, 30, 380, 50);
		panel_pageHome.add(lblFavoriteTable);
		
		lblFavoriteStoreCount = new JLabel("收藏店家數量", SwingConstants.RIGHT);
		lblFavoriteStoreCount.setFont(textFont);
		lblFavoriteStoreCount.setBounds(274, 93, 120, 30);
		panel_pageHome.add(lblFavoriteStoreCount);
		
		JScrollPane scrollPane_favoriteStore = new JScrollPane();
		scrollPane_favoriteStore.setBounds(14, 136, 380, 476);
		panel_pageHome.add(scrollPane_favoriteStore);
		
		tableHomeFavorite = new JTable();
		tableHomeFavorite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableModelItemInfo.setRowCount(0);
				String tableTitle[] = {"品項名稱", "品項價格", "數量"};
				tableModelItemInfo.setColumnIdentifiers(tableTitle);
				itemName.clear();
				itemPrice.clear();
				menuID.clear();
				itemCounter = 0;
				DBConnect DBC = new DBConnect();
				String query = "SELECT FS.StoreID, FS.StoreName, FM.ItemName, FM.ItemPrice, FM.MenuID "+
							   "FROM   fast_food_delivered_managerment.store AS FS, "+
							   "       fast_food_delivered_managerment.menu  AS FM "+
							   "WHERE  FS.StoreID = FM.StoreID AND "+
							   "       FS.StoreName = '"+tableHomeFavorite.getValueAt(tableHomeFavorite.getSelectedRow(), 0)+"' ";				
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						SELECTSTOREID = resultset.getString("FS.StoreID");
						lblCreateOrderStoreName.setText(resultset.getString("FS.StoreName"));
						itemName.add(resultset.getString("FM.ItemName"));
						itemPrice.add(resultset.getInt("FM.ItemPrice"));
						menuID.add(resultset.getInt("FM.MenuID"));
						itemCounter++;
					}
					
					spinnerArray = new SpinnerNumberModel[itemCounter];
					for(int i=0; i<itemCounter; i++) spinnerArray[i] = new SpinnerNumberModel(0, 0, 1000, 1);
					
					for(int i=0; i<itemCounter; i++) {
						Object tableLine[] = {itemName.get(i), itemPrice.get(i), spinnerArray[i]};
						tableModelItemInfo.addRow(tableLine);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("系統錯誤 23");
				}
				tableCreateOrderItemInfo.getColumn("數量").setCellRenderer(new SpinnerRenderer());
				tableCreateOrderItemInfo.getColumn("數量").setCellEditor(new SpinnerEditor());
				fromFavorite = true;
				pagesCard.show(panel_pagesBase, "pageSearch_result_order");
			}
		});
		scrollPane_favoriteStore.setViewportView(tableHomeFavorite);
		tableHomeFavorite.setModel(tableModelHomeFavorite);
		tableHomeFavorite.setRowHeight(30);
		tableHomeFavorite.setFont(textFont);
		
		
		
		/* search page */
		JPanel panel_pageSearch = new JPanel();
		panel_pagesBase.add(panel_pageSearch, "pageSearch");
		panel_pageSearch.setLayout(null);
		
		textFieldSearchPageSearch = new JTextField();
		textFieldSearchPageSearch.setFont(textFont);
		textFieldSearchPageSearch.setBounds(14, 13, 267, 30);
		panel_pageSearch.add(textFieldSearchPageSearch);
		textFieldSearchPageSearch.setColumns(10);
		
		JButton btnSearchPageSearch = new JButton("搜尋");
		btnSearchPageSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelSearchResult.setRowCount(0);
				arrayListSearchResultStoreID.clear();
				searchResultCount = 0;
				String searchCondition = textFieldSearchPageSearch.getText();
				if(searchCondition.equals(""))lblSearchComdition.setText("搜尋店家關鍵字: 所有店家"); 
				else lblSearchComdition.setText("搜尋店家關鍵字: "+searchCondition);
				String query = "SELECT   FS.StoreID, FS.StoreName, FS.StoreAddress, AVG(CommentLevel) " +
							   "FROM     fast_food_delivered_managerment.store   AS FS," +
							   "         fast_food_delivered_managerment.comment AS FC " +
							   "WHERE    FS.StoreID = FC.StoreID AND StoreName LIKE '%" + searchCondition + "%'" +
							   "GROUP BY FS.StoreID ";
				DBConnect DBC = new DBConnect();
				ResultSet resultset;
				try {
					String tableTitle[] = {"店家名稱", "店家地址", "店家評分"};
					tableModelSearchResult.setColumnIdentifiers(tableTitle);
					resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						searchResultCount++;
						int storeID = resultset.getInt("StoreID");
						String storeName = resultset.getString("StoreName");
						String storeAddress = resultset.getString("StoreAddress");
						double storeCommentLevel = resultset.getDouble("AVG(CommentLevel)");
						arrayListSearchResultStoreID.add(storeID);
						String tableLine[] = {storeName, storeAddress, String.format("%.1f", storeCommentLevel)};
						tableModelSearchResult.addRow(tableLine);
					}
					tableSearchResult.getColumn("店家名稱").setPreferredWidth(200);
					tableSearchResult.getColumn("店家地址").setPreferredWidth(400);
					tableSearchResult.getColumn("店家評分").setPreferredWidth(100);
					lblResultCount.setText("共" + searchResultCount + "間店家");
					pagesCard.show(panel_pagesBase, "pageSearch_result");					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 08");
				}
			}
		});
		btnSearchPageSearch.setFont(textFont);
		btnSearchPageSearch.setBounds(295, 11, 99, 34);
		panel_pageSearch.add(btnSearchPageSearch);
		
		JLabel lblSearchPageText = new JLabel("想吃什麼?");
		lblSearchPageText.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 40));
		lblSearchPageText.setBounds(14, 95, 380, 50);
		panel_pageSearch.add(lblSearchPageText);
		
		btnRandomSelect1 = new JButton("隨機食物1");
		btnRandomSelect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelSearchResult.setRowCount(0);
				arrayListSearchResultStoreID.clear();
				searchResultCount = 0;
				DBConnect DBC = new DBConnect();
				String query = "SELECT   FS.StoreID, FS.StoreName, FS.StoreAddress, AVG(CommentLevel) " + 
							   "FROM     fast_food_delivered_managerment.store   AS FS, " + 
							   "         fast_food_delivered_managerment.comment AS FC, " + 
							   "         fast_food_delivered_managerment.menu    AS FM " + 
							   "WHERE    FS.StoreID = FC.StoreID AND  " + 
							   "         FS.StoreID = FM.StoreID AND " + 
							   "         FM.ItemName = '"+btnRandomSelect1.getText()+"' ";
				try {
					String tableTitle[] = {"店家名稱", "店家地址", "店家評分"};
					tableModelSearchResult.setColumnIdentifiers(tableTitle);
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						searchResultCount++;
						int storeID = resultset.getInt("StoreID");
						String storeName = resultset.getString("StoreName");
						String storeAddress = resultset.getString("StoreAddress");
						double storeCommentLevel = resultset.getDouble("AVG(CommentLevel)");
						arrayListSearchResultStoreID.add(storeID);
						String tableLine[] = {storeName, storeAddress, String.format("%.1f", storeCommentLevel)};
						tableModelSearchResult.addRow(tableLine);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 09");
				}
				tableSearchResult.getColumn("店家名稱").setPreferredWidth(200);
				tableSearchResult.getColumn("店家地址").setPreferredWidth(400);
				tableSearchResult.getColumn("店家評分").setPreferredWidth(100);
				lblSearchComdition.setText("搜尋食物關鍵字: "+btnRandomSelect1.getText());
				lblResultCount.setText("共" + searchResultCount + "間店家");
				pagesCard.show(panel_pagesBase, "pageSearch_result");
			}
		});
		btnRandomSelect1.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 25));
		btnRandomSelect1.setBounds(14, 158, 186, 180);
		panel_pageSearch.add(btnRandomSelect1);
		
		btnRandomSelect2 = new JButton("隨機食物2");
		btnRandomSelect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelSearchResult.setRowCount(0);
				arrayListSearchResultStoreID.clear();
				searchResultCount = 0;
				DBConnect DBC = new DBConnect();
				String query = "SELECT   FS.StoreID, FS.StoreName, FS.StoreAddress, AVG(CommentLevel) " + 
							   "FROM     fast_food_delivered_managerment.store   AS FS, " + 
							   "         fast_food_delivered_managerment.comment AS FC, " + 
							   "         fast_food_delivered_managerment.menu    AS FM " + 
							   "WHERE    FS.StoreID = FC.StoreID AND  " + 
							   "         FS.StoreID = FM.StoreID AND " + 
							   "         FM.ItemName = '"+btnRandomSelect2.getText()+"' ";
				try {
					String tableTitle[] = {"店家名稱", "店家地址", "店家評分"};
					tableModelSearchResult.setColumnIdentifiers(tableTitle);
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						searchResultCount++;
						int storeID = resultset.getInt("StoreID");
						String storeName = resultset.getString("StoreName");
						String storeAddress = resultset.getString("StoreAddress");
						double storeCommentLevel = resultset.getDouble("AVG(CommentLevel)");
						arrayListSearchResultStoreID.add(storeID);
						String tableLine[] = {storeName, storeAddress, String.format("%.1f", storeCommentLevel)};
						tableModelSearchResult.addRow(tableLine);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 10");
				}
				tableSearchResult.getColumn("店家名稱").setPreferredWidth(200);
				tableSearchResult.getColumn("店家地址").setPreferredWidth(400);
				tableSearchResult.getColumn("店家評分").setPreferredWidth(100);
				lblSearchComdition.setText("搜尋食物關鍵字: "+btnRandomSelect2.getText());
				lblResultCount.setText("共" + searchResultCount + "間店家");
				pagesCard.show(panel_pagesBase, "pageSearch_result");				
			}
		});
		btnRandomSelect2.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 25));
		btnRandomSelect2.setBounds(208, 158, 186, 180);
		panel_pageSearch.add(btnRandomSelect2);
		
		btnRandomSelect3 = new JButton("隨機食物3");
		btnRandomSelect3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelSearchResult.setRowCount(0);
				arrayListSearchResultStoreID.clear();
				searchResultCount = 0;
				DBConnect DBC = new DBConnect();
				String query = "SELECT   FS.StoreID, FS.StoreName, FS.StoreAddress, AVG(CommentLevel) " + 
							   "FROM     fast_food_delivered_managerment.store   AS FS, " + 
							   "         fast_food_delivered_managerment.comment AS FC, " + 
							   "         fast_food_delivered_managerment.menu    AS FM " + 
							   "WHERE    FS.StoreID = FC.StoreID AND  " + 
							   "         FS.StoreID = FM.StoreID AND " + 
							   "         FM.ItemName = '"+btnRandomSelect3.getText()+"' ";
				try {
					String tableTitle[] = {"店家名稱", "店家地址", "店家評分"};
					tableModelSearchResult.setColumnIdentifiers(tableTitle);
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						searchResultCount++;
						int storeID = resultset.getInt("StoreID");
						String storeName = resultset.getString("StoreName");
						String storeAddress = resultset.getString("StoreAddress");
						double storeCommentLevel = resultset.getDouble("AVG(CommentLevel)");
						arrayListSearchResultStoreID.add(storeID);
						String tableLine[] = {storeName, storeAddress, String.format("%.1f", storeCommentLevel)};
						tableModelSearchResult.addRow(tableLine);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 11");
				}
				tableSearchResult.getColumn("店家名稱").setPreferredWidth(200);
				tableSearchResult.getColumn("店家地址").setPreferredWidth(400);
				tableSearchResult.getColumn("店家評分").setPreferredWidth(100);
				lblSearchComdition.setText("搜尋食物關鍵字: "+btnRandomSelect3.getText());
				lblResultCount.setText("共" + searchResultCount + "間店家");
				pagesCard.show(panel_pagesBase, "pageSearch_result");	
			}
		});
		btnRandomSelect3.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 25));
		btnRandomSelect3.setBounds(14, 351, 186, 180);
		panel_pageSearch.add(btnRandomSelect3);
		
		btnRandomSelect4 = new JButton("隨機食物4");
		btnRandomSelect4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModelSearchResult.setRowCount(0);
				arrayListSearchResultStoreID.clear();
				searchResultCount = 0;
				DBConnect DBC = new DBConnect();
				String query = "SELECT   FS.StoreID, FS.StoreName, FS.StoreAddress, AVG(CommentLevel) " + 
							   "FROM     fast_food_delivered_managerment.store   AS FS, " + 
							   "         fast_food_delivered_managerment.comment AS FC, " + 
							   "         fast_food_delivered_managerment.menu    AS FM " + 
							   "WHERE    FS.StoreID = FC.StoreID AND  " + 
							   "         FS.StoreID = FM.StoreID AND " + 
							   "         FM.ItemName = '"+btnRandomSelect4.getText()+"' ";
				try {
					String tableTitle[] = {"店家名稱", "店家地址", "店家評分"};
					tableModelSearchResult.setColumnIdentifiers(tableTitle);
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						searchResultCount++;
						int storeID = resultset.getInt("StoreID");
						String storeName = resultset.getString("StoreName");
						String storeAddress = resultset.getString("StoreAddress");
						double storeCommentLevel = resultset.getDouble("AVG(CommentLevel)");
						arrayListSearchResultStoreID.add(storeID);
						String tableLine[] = {storeName, storeAddress, String.format("%.1f", storeCommentLevel)};
						tableModelSearchResult.addRow(tableLine);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 12");
				}
				tableSearchResult.getColumn("店家名稱").setPreferredWidth(200);
				tableSearchResult.getColumn("店家地址").setPreferredWidth(400);
				tableSearchResult.getColumn("店家評分").setPreferredWidth(100);
				lblSearchComdition.setText("搜尋食物關鍵字: "+btnRandomSelect4.getText());
				lblResultCount.setText("共" + searchResultCount + "間店家");
				pagesCard.show(panel_pagesBase, "pageSearch_result");	
			}
		});
		btnRandomSelect4.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 25));
		btnRandomSelect4.setBounds(208, 352, 186, 178);
		panel_pageSearch.add(btnRandomSelect4);
		
		JButton btnRefreshItem = new JButton("刷新項目");
		btnRefreshItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomItem.clear();
				DBConnect DBC = new DBConnect();
				String query = "Select Distinct ItemName " + 
							   "From   fast_food_delivered_managerment.menu";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						randomItem.add(resultset.getString("ItemName"));
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 13");
				}
				btnRandomSelect1.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				btnRandomSelect2.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				btnRandomSelect3.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				btnRandomSelect4.setText(randomItem.get(new Random().nextInt(randomItem.size())));
				pagesCard.show(panel_pagesBase, "pageSearch");
			}
		});
		btnRefreshItem.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		btnRefreshItem.setBounds(14, 542, 380, 70);
		panel_pageSearch.add(btnRefreshItem);
		
		
		
		/* search result */
		JPanel panel_pageSearchResultList = new JPanel();
		panel_pagesBase.add(panel_pageSearchResultList, "pageSearch_result");
		panel_pageSearchResultList.setLayout(null);
		
		JButton btnSearchResultBack2Search = new JButton("返回");
		btnSearchResultBack2Search.setFont(textFont);
		btnSearchResultBack2Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSearchPageSearch.setText("");
				pagesCard.show(panel_pagesBase, "pageSearch");
			}
		});
		btnSearchResultBack2Search.setBounds(14, 13, 99, 34);
		panel_pageSearchResultList.add(btnSearchResultBack2Search);
		
		lblSearchComdition = new JLabel("搜尋條件");
		lblSearchComdition.setFont(textFont);
		lblSearchComdition.setBounds(127, 15, 267, 30);
		panel_pageSearchResultList.add(lblSearchComdition);
		
		lblResultCount = new JLabel("搜尋結果", SwingConstants.RIGHT);
		lblResultCount.setFont(textFont);
		lblResultCount.setBounds(127, 53, 267, 27);
		panel_pageSearchResultList.add(lblResultCount);
		
		JScrollPane scrollPane_searchResult = new JScrollPane();
		scrollPane_searchResult.setBounds(14, 93, 380, 519);
		panel_pageSearchResultList.add(scrollPane_searchResult);
		
		tableSearchResult = new JTable();
		tableSearchResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableModelItemInfo.setRowCount(0);
				String tableTitle[] = {"品項名稱", "品項價格", "數量"};
				tableModelItemInfo.setColumnIdentifiers(tableTitle);
				itemName.clear();
				itemPrice.clear();
				menuID.clear();
				itemCounter = 0;
				DBConnect DBC = new DBConnect();
				String query = "SELECT FS.StoreID, FS.StoreName, FM.ItemName, FM.ItemPrice, FM.MenuID "+
							   "FROM   fast_food_delivered_managerment.store AS FS, "+
							   "       fast_food_delivered_managerment.menu  AS FM "+
							   "WHERE  FS.StoreID = FM.StoreID AND "+
							   "       FS.StoreName = '"+tableSearchResult.getValueAt(tableSearchResult.getSelectedRow(), 0)+"' ";				
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						SELECTSTOREID = resultset.getString("FS.StoreID");
						lblCreateOrderStoreName.setText(resultset.getString("FS.StoreName"));
						itemName.add(resultset.getString("FM.ItemName"));
						itemPrice.add(resultset.getInt("FM.ItemPrice"));
						menuID.add(resultset.getInt("FM.MenuID"));
						itemCounter++;
					}
					
					spinnerArray = new SpinnerNumberModel[itemCounter];
					for(int i=0; i<itemCounter; i++) spinnerArray[i] = new SpinnerNumberModel(0, 0, 1000, 1);
					
					for(int i=0; i<itemCounter; i++) {
						Object tableLine[] = {itemName.get(i), itemPrice.get(i), spinnerArray[i]};
						tableModelItemInfo.addRow(tableLine);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("系統錯誤 24");
				}
				tableCreateOrderItemInfo.getColumn("數量").setCellRenderer(new SpinnerRenderer());
				tableCreateOrderItemInfo.getColumn("數量").setCellEditor(new SpinnerEditor());
				fromFavorite = false;
				pagesCard.show(panel_pagesBase, "pageSearch_result_order");
			}
		});
		scrollPane_searchResult.setViewportView(tableSearchResult);
		tableSearchResult.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 13));
		tableSearchResult.setModel(tableModelSearchResult);
		tableSearchResult.setRowHeight(30);
		tableSearchResult.setFont(textFont);
		
		
		
		/* order item */
		JPanel panel_pageSearchResultListCreateOrder = new JPanel();
		panel_pagesBase.add(panel_pageSearchResultListCreateOrder, "pageSearch_result_order");
		panel_pageSearchResultListCreateOrder.setLayout(null);
		
		JButton btnCreateOrderBack2SearchResult = new JButton("返回");
		btnCreateOrderBack2SearchResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fromFavorite) pagesCard.show(panel_pagesBase, "pageHome");
				else pagesCard.show(panel_pagesBase, "pageSearch_result");
			}
		});
		btnCreateOrderBack2SearchResult.setFont(textFont);
		btnCreateOrderBack2SearchResult.setBounds(14, 13, 99, 34);
		panel_pageSearchResultListCreateOrder.add(btnCreateOrderBack2SearchResult);
		
		lblCreateOrderStoreName = new JLabel("店家名稱", SwingConstants.CENTER);
		lblCreateOrderStoreName.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 55));
		lblCreateOrderStoreName.setBounds(14, 60, 380, 65);
		panel_pageSearchResultListCreateOrder.add(lblCreateOrderStoreName);
		
		JButton btnCreateOrderCollectStore = new JButton("收藏");
		btnCreateOrderCollectStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect DBC = new DBConnect();
				String sql = "INSERT INTO fast_food_delivered_managerment.favorite_list(UserID, StoreID)"+
							 "VALUES      ('"+USERID+"','"+SELECTSTOREID+"')";
				try {
					DBC.getStatement().executeUpdate(sql);
					JOptionPane.showConfirmDialog(null, "加入收藏完成", "訊息", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null, "已經加入收藏", "訊息", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCreateOrderCollectStore.setFont(textFont);
		btnCreateOrderCollectStore.setBounds(295, 13, 99, 34);
		panel_pageSearchResultListCreateOrder.add(btnCreateOrderCollectStore);
		
		JScrollPane scrollPane_ItemName = new JScrollPane();
		scrollPane_ItemName.setBounds(14, 138, 380, 395);
		panel_pageSearchResultListCreateOrder.add(scrollPane_ItemName);
		
		tableCreateOrderItemInfo = new JTable();
		scrollPane_ItemName.setViewportView(tableCreateOrderItemInfo);
		tableCreateOrderItemInfo.setModel(tableModelItemInfo);
		tableCreateOrderItemInfo.setRowHeight(30);
		tableCreateOrderItemInfo.setFont(textFont);
		
		JButton btnCreateOrderBuy = new JButton("購買");
		btnCreateOrderBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buyDetail = "";//String.format("%-20s|%7s", "item name", "count");
				buyDetail += "\n-------------------------\n";
				int totalPrice = 0;
				for(int i=0; i<itemCounter; i++) {
					if(spinnerArray[i].getValue().toString().equals("0")) continue;
					totalPrice += itemPrice.get(i)* Integer.parseInt(spinnerArray[i].getValue().toString());
					buyDetail += String.format("%-20s", itemName.get(i).toString());
					buyDetail += String.format("%7d", spinnerArray[i].getValue());
					buyDetail += "\n-------------------------\n";
				}
				
				if(totalPrice == 0) JOptionPane.showConfirmDialog(null,
																  "請選擇商品數量", 
																  "結帳", 
																  JOptionPane.DEFAULT_OPTION, 
																  JOptionPane.INFORMATION_MESSAGE);
				else {
					int opt = JOptionPane.showConfirmDialog(null,
															buyDetail+"購買金額: "+ totalPrice, 
															"結帳", 
															JOptionPane.YES_NO_OPTION, 
															JOptionPane.INFORMATION_MESSAGE);
					if(opt == 0) {
						DBConnect DBC = new DBConnect();
						Date currentTime = new Date();
						String sql1 = "INSERT INTO fast_food_delivered_managerment.order(" +
									  "OrderTime, DeliveryManID, UserID, OrderStatement, ManagerID, OrderIsDeal) "+
									  "VALUES     ('"+dateFormat.format(currentTime)+"', 1, "+USERID+", 'running', 1, 0)";
						String sql2 = "INSERT INTO fast_food_delivered_managerment.order_item(" +
									  "UserID, OrderTime, MenuID, ItemQuantity) "+
									  "VALUES     ("+USERID+", '"+dateFormat.format(currentTime)+"', ";	
						try {
							DBC.getStatement().executeUpdate(sql1);
							
							for(int i=0; i<itemCounter; i++) {
								if(Integer.parseInt(spinnerArray[i].getValue().toString()) != 0) {
									String orderItem = sql2 + menuID.get(i).toString() + ", " + spinnerArray[i].getValue().toString() + ")";
									DBC.getStatement().executeUpdate(orderItem);
								}
							}
							JOptionPane.showConfirmDialog(null, "訂單建立完成", "訊息", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
							/* goto history page */
							tableModelOrderHistory.setRowCount(0);
							orderHistoryCount = 0;
							String tableTitle[] = {"訂單時間", "店家名稱", "訂單總額", "訂單狀態"};
							tableModelOrderHistory.setColumnIdentifiers(tableTitle);
							String query = "Select   FO.OrderTime, FS.StoreName, SUM(ItemQuantity*ItemPrice), FO.OrderStatement " + 
										   "From     fast_food_delivered_managerment.order      AS FO, " + 
										   "         fast_food_delivered_managerment.order_item AS FOI, " + 
										   "         fast_food_delivered_managerment.menu       AS FM, " + 
										   "         fast_food_delivered_managerment.store      AS FS " + 
										   "WHERE    FO.UserID    = FOI.UserID AND " + 
										   "         FO.OrderTime = FOI.OrderTime AND " + 
										   "         FOI.MenuID   = FM.MenuID AND " + 
										   "         FM.StoreID   = FS.StoreID AND " + 
										   "         FO.UserID    = "+USERID+" "+
										   "GROUP BY FO.OrderTime "+
										   "ORDER BY FO.OrderTime DESC ";
							try {
								ResultSet resultset = DBC.getStatement().executeQuery(query);
								while(resultset.next()) {
									String orderTime = resultset.getString("FO.OrderTime");
									String storeName = resultset.getString("FS.StoreName");
									String totle = resultset.getString("SUM(ItemQuantity*ItemPrice)");
									String orderState = resultset.getString("FO.OrderStatement");
									if(orderState.equals("running")) orderState = "執行中";
									else if(orderState.equals("cancel")) orderState = "已取消";
									else if(orderState.equals("finish")) orderState = "已完成";
									String tableLine[] = {orderTime.substring(0, orderTime.length()-2), storeName, totle, orderState};
									tableModelOrderHistory.addRow(tableLine);
									orderHistoryCount++;
								}
								
							} catch (SQLException e1) {
								e1.printStackTrace();
								System.out.println("系統錯誤 14");
							}
							tableOrderHistory.getColumn("訂單時間").setPreferredWidth(450);
							tableOrderHistory.getColumn("店家名稱").setPreferredWidth(200);
							tableOrderHistory.getColumn("訂單總額").setPreferredWidth(125);
							tableOrderHistory.getColumn("訂單狀態").setPreferredWidth(150);
							lblOrderHistoryCount.setText("共"+orderHistoryCount+"筆");
							/*  */
							pagesCard.show(panel_pagesBase, "pageHistory");
						} catch (SQLException e1) {
							e1.printStackTrace();
							System.out.println("系統錯誤 15");
						}
					}
				}
			}
		});
		
		JButton btnCreateOrderComment = new JButton("評論");
		btnCreateOrderComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int commentCount = 0;
				tableModelComment.setRowCount(0);
				String tableTitle[] = {"評分", "評論"};
				tableModelComment.setColumnIdentifiers(tableTitle);
				DBConnect DBC = new DBConnect();
				String query = "SELECT FC.CommentLevel, FC.CommentContent "+
							   "FROM   fast_food_delivered_managerment.comment AS FC "+
							   "WHERE  FC.StoreID = "+SELECTSTOREID+" AND "+
							   "       FC.CommentVisible = TRUE";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						String tableLine[] = {resultset.getString("FC.CommentLevel"), resultset.getString("FC.CommentContent")};
						tableModelComment.addRow(tableLine);
						commentCount++;
					}
					tableStoreComment.getColumn("評分").setPreferredWidth(50);
					tableStoreComment.getColumn("評論").setPreferredWidth(500);
					lblCommentCount.setText("共"+commentCount+"筆評論");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				pagesCard.show(panel_pagesBase, "pageSearch_result_order_comment");
			}
		});
		btnCreateOrderComment.setFont(new Font("微軟正黑體", Font.BOLD, 32));
		btnCreateOrderComment.setBounds(24, 558, 99, 42);
		panel_pageSearchResultListCreateOrder.add(btnCreateOrderComment);
		btnCreateOrderBuy.setBounds(295, 558, 99, 42);
		btnCreateOrderBuy.setFont(new Font("微軟正黑體", Font.BOLD, 32));
		panel_pageSearchResultListCreateOrder.add(btnCreateOrderBuy);
		
		
		
		/* comment page */
		JPanel panel_pageSearchResultListCreateOrderStoreComment = new JPanel();
		panel_pagesBase.add(panel_pageSearchResultListCreateOrderStoreComment, "pageSearch_result_order_comment");
		panel_pageSearchResultListCreateOrderStoreComment.setLayout(null);
		
		JButton btnStoreCommentBack2Order = new JButton("返回");
		btnStoreCommentBack2Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagesCard.show(panel_pagesBase, "pageSearch_result_order");
			}
		});
		btnStoreCommentBack2Order.setFont(new Font("微軟正黑體", Font.BOLD, 19));
		btnStoreCommentBack2Order.setBounds(14, 13, 99, 34);
		panel_pageSearchResultListCreateOrderStoreComment.add(btnStoreCommentBack2Order);
		
		JLabel lblStoreComment = new JLabel("店家評論");
		lblStoreComment.setFont(textFont);
		lblStoreComment.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreComment.setFont(new Font("微軟正黑體", Font.BOLD, 45));
		lblStoreComment.setBounds(14, 60, 380, 50);
		panel_pageSearchResultListCreateOrderStoreComment.add(lblStoreComment);
		
		lblCommentCount = new JLabel("評論數量", SwingConstants.RIGHT);
		lblCommentCount.setFont(textFont);
		lblCommentCount.setBounds(14, 123, 380, 30);
		panel_pageSearchResultListCreateOrderStoreComment.add(lblCommentCount);
		
		JScrollPane scrollPane_storeComment = new JScrollPane();
		scrollPane_storeComment.setBounds(14, 166, 380, 446);
		panel_pageSearchResultListCreateOrderStoreComment.add(scrollPane_storeComment);
		
		tableStoreComment = new JTable();
		tableStoreComment.setFont(textFont);
		tableStoreComment.setModel(tableModelComment);
		scrollPane_storeComment.setViewportView(tableStoreComment);
		tableStoreComment.setRowHeight(80);
		
		
		
		/* history page */
		JPanel panel_pageHistory = new JPanel();
		panel_pagesBase.add(panel_pageHistory, "pageHistory");
		panel_pageHistory.setLayout(null);
		
		JLabel lblOrderhistroy = new JLabel("歷史訂單");
		lblOrderhistroy.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderhistroy.setFont(new Font("微軟正黑體", Font.BOLD, 45));
		lblOrderhistroy.setBounds(14, 30, 380, 50);
		panel_pageHistory.add(lblOrderhistroy);
		
		JScrollPane scrollPane_orderHistory = new JScrollPane();
		scrollPane_orderHistory.setBounds(14, 136, 380, 476);
		panel_pageHistory.add(scrollPane_orderHistory);
		
		tableOrderHistory = new JTable();
		tableOrderHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableModelOrderInfo.setRowCount(0);
				String tableTitle[] = {"品項名稱", "品項價格", "數量"};
				tableModelOrderInfo.setColumnIdentifiers(tableTitle);
				DBConnect DBC = new DBConnect();
				String orderTime = tableOrderHistory.getValueAt(tableOrderHistory.getSelectedRow(), 0).toString();
				lblOrderInfoOrderTimeData.setText(orderTime);
				String totalPrice = tableOrderHistory.getValueAt(tableOrderHistory.getSelectedRow(), 2).toString();
				lblOrderInfoTotalPrice.setText("總計: "+totalPrice+" 元");
				String query = "SELECT FO.OrderStatement, FM.ItemName, FM.ItemPrice, FOI.ItemQuantity "+
							   "FROM   fast_food_delivered_managerment.menu       AS FM, "+
							   "       fast_food_delivered_managerment.order_item AS FOI, "+
							   "       fast_food_delivered_managerment.order      AS FO "+
							   "WHERE  FOI.UserID = "+USERID+" AND "+
							   "       FOI.OrderTime = '"+orderTime+"' AND "+
							   "       FOI.MenuID = FM.MenuID AND "+
							   "       FOI.OrderTime = FO.OrderTime AND "+
							   "       FOI.UserID = FO.UserID ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						String orderState = resultset.getString("FO.orderStatement");
						if(orderState.equals("running")) orderState = "執行中";
						else if(orderState.equals("cancel")) orderState = "已取消";
						else if(orderState.equals("finish")) orderState = "已完成";
						lblOrderInfoStatementData.setText(orderState);
						String tableLine[] = {resultset.getString("FM.ItemName"), resultset.getString("FM.ItemPrice"), resultset.getString("FOI.ItemQuantity")};
						tableModelOrderInfo.addRow(tableLine);
					}					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("系統錯誤 25");
				}
				pagesCard.show(panel_pagesBase, "pageHistory_info");
			}
		});
		scrollPane_orderHistory.setViewportView(tableOrderHistory);
		tableOrderHistory.setModel(tableModelOrderHistory);
		tableOrderHistory.setRowHeight(30);
		tableOrderHistory.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 15));
		
		lblOrderHistoryCount = new JLabel("歷史訂單筆數", SwingConstants.RIGHT);
		lblOrderHistoryCount.setFont(textFont);
		lblOrderHistoryCount.setBounds(274, 93, 120, 30);
		panel_pageHistory.add(lblOrderHistoryCount);
		
		
		
		/* history order info */
		JPanel panel_pageHistoryOrderInfo = new JPanel();
		panel_pagesBase.add(panel_pageHistoryOrderInfo, "pageHistory_info");
		panel_pageHistoryOrderInfo.setLayout(null);
		
		JButton btnOrderInfoBack2History = new JButton("返回");
		btnOrderInfoBack2History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagesCard.show(panel_pagesBase, "pageHistory");
			}
		});
		btnOrderInfoBack2History.setFont(textFont);
		btnOrderInfoBack2History.setBounds(14, 13, 99, 34);
		panel_pageHistoryOrderInfo.add(btnOrderInfoBack2History);
		
		JLabel lblOrderInfoStatement = new JLabel("訂單當前狀態:", SwingConstants.RIGHT);
		lblOrderInfoStatement.setFont(textFont);
		lblOrderInfoStatement.setBounds(14, 101, 120, 42);
		panel_pageHistoryOrderInfo.add(lblOrderInfoStatement);
		
		lblOrderInfoStatementData = new JLabel("statement data");
		lblOrderInfoStatementData.setFont(textFont);
		lblOrderInfoStatementData.setBounds(148, 101, 246, 42);
		panel_pageHistoryOrderInfo.add(lblOrderInfoStatementData);
		
		JLabel lblOrderInfoOrderTime = new JLabel("訂單建立時間:", SwingConstants.RIGHT);
		lblOrderInfoOrderTime.setFont(textFont);
		lblOrderInfoOrderTime.setBounds(14, 156, 120, 42);
		panel_pageHistoryOrderInfo.add(lblOrderInfoOrderTime);
		
		lblOrderInfoOrderTimeData = new JLabel("order time data");
		lblOrderInfoOrderTimeData.setFont(textFont);
		lblOrderInfoOrderTimeData.setBounds(148, 156, 246, 42);
		panel_pageHistoryOrderInfo.add(lblOrderInfoOrderTimeData);
		
		lblOrderInfoTotalPrice = new JLabel("總計: ");
		lblOrderInfoTotalPrice.setFont(textFont);
		lblOrderInfoTotalPrice.setBounds(14, 558, 380, 42);
		panel_pageHistoryOrderInfo.add(lblOrderInfoTotalPrice);
		
		JScrollPane scrollPane_orderInfo = new JScrollPane();
		scrollPane_orderInfo.setBounds(14, 211, 380, 334);
		panel_pageHistoryOrderInfo.add(scrollPane_orderInfo);
		
		tableOrderInfo = new JTable();
		scrollPane_orderInfo.setViewportView(tableOrderInfo);
		tableOrderInfo.setModel(tableModelOrderInfo);
		tableOrderInfo.setFont(textFont);
		tableOrderInfo.setRowHeight(30);
		
		
		
		/* profile page */
		JPanel panel_pageProfile = new JPanel();
		panel_pagesBase.add(panel_pageProfile, "pageProfile");
		panel_pageProfile.setLayout(null);

		JLabel lblProfileTitle = new JLabel("個人資料", SwingConstants.CENTER);
		lblProfileTitle.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 45));
		lblProfileTitle.setBounds(14, 30, 380, 50);
		panel_pageProfile.add(lblProfileTitle);

		JLabel lblProfileUserName = new JLabel("使用者名稱");
		lblProfileUserName.setFont(textFont);
		lblProfileUserName.setBounds(14, 107, 99, 27);
		panel_pageProfile.add(lblProfileUserName);
		
		lblProfileUserNameData = new JLabel("user name data");
		lblProfileUserNameData.setBorder(BorderFactory.createEtchedBorder());
		lblProfileUserNameData.setFont(textFont);
		lblProfileUserNameData.setBounds(127, 107, 267, 27);
		panel_pageProfile.add(lblProfileUserNameData);
		
		JLabel lblProfileUserBirthday = new JLabel("生日");
		lblProfileUserBirthday.setFont(textFont);
		lblProfileUserBirthday.setBounds(14, 147, 99, 27);
		panel_pageProfile.add(lblProfileUserBirthday);
		
		lblProfileUserBirthdayData = new JLabel("user birthday data");
		lblProfileUserBirthdayData.setBorder(BorderFactory.createEtchedBorder());
		lblProfileUserBirthdayData.setFont(textFont);
		lblProfileUserBirthdayData.setBounds(127, 147, 267, 27);
		panel_pageProfile.add(lblProfileUserBirthdayData);
		
		JLabel lblProfileUserPhone = new JLabel("電話號碼");
		lblProfileUserPhone.setFont(textFont);
		lblProfileUserPhone.setBounds(14, 187, 99, 27);
		panel_pageProfile.add(lblProfileUserPhone);
		
		lblProfileUserPhoneData = new JLabel("user phone data");
		lblProfileUserPhoneData.setBorder(BorderFactory.createEtchedBorder());
		lblProfileUserPhoneData.setFont(textFont);
		lblProfileUserPhoneData.setBounds(127, 187, 267, 27);
		panel_pageProfile.add(lblProfileUserPhoneData);
		
		JLabel lblProfileUserEmail = new JLabel("電子信箱");
		lblProfileUserEmail.setFont(textFont);
		lblProfileUserEmail.setBounds(14, 227, 99, 27);
		panel_pageProfile.add(lblProfileUserEmail);
		
		lblProfileUserEmailData = new JLabel("user email data");
		lblProfileUserEmailData.setBorder(BorderFactory.createEtchedBorder());
		lblProfileUserEmailData.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 13));
		lblProfileUserEmailData.setBounds(127, 227, 267, 27);
		panel_pageProfile.add(lblProfileUserEmailData);
		
		JLabel lblProfileUserStatement = new JLabel("帳號狀態");
		lblProfileUserStatement.setFont(textFont);
		lblProfileUserStatement.setBounds(14, 267, 99, 27);
		panel_pageProfile.add(lblProfileUserStatement);
		
		lblProfileUserStatementData = new JLabel("user statement data");
		lblProfileUserStatementData.setFont(textFont);
		lblProfileUserStatementData.setBorder(BorderFactory.createEtchedBorder());
		lblProfileUserStatementData.setBounds(127, 267, 267, 27);
		panel_pageProfile.add(lblProfileUserStatementData);
		
		JLabel lblProfileUserAddress = new JLabel("默認地址");
		lblProfileUserAddress.setFont(textFont);
		lblProfileUserAddress.setBounds(14, 307, 99, 27);
		panel_pageProfile.add(lblProfileUserAddress);
		
		lblProfileUserAddressData = new JLabel("user address data");
		lblProfileUserAddressData.setBorder(BorderFactory.createEtchedBorder());
		lblProfileUserAddressData.setFont(textFont);
		lblProfileUserAddressData.setBounds(127, 307, 267, 27);
		panel_pageProfile.add(lblProfileUserAddressData);
		
		JButton btnChangePhone = new JButton("更改電話號碼");
		btnChangePhone.setFont(textFont);
		btnChangePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldOldPhone.setText("");
				textFieldNewPhone.setText("");
				pagesCard.show(panel_pagesBase, "pageProfile_changePhone");
			}
		});
		btnChangePhone.setBounds(14, 410, 380, 50);
		panel_pageProfile.add(btnChangePhone);
		
		JButton btnChangeAddress = new JButton("新增/刪除地址");
		btnChangeAddress.setFont(textFont);
		btnChangeAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNewAddress.setText("");
				listModelProfileAddress.clear();
				DBConnect DBC = new DBConnect();
				String query = "SELECT DeliveryAddress "+
							   "FROM   fast_food_delivered_managerment.address "+
							   "WHERE  UserID = "+USERID+" ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						listModelProfileAddress.addElement(resultset.getString("DeliveryAddress"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 16");
				}
				
				pagesCard.show(panel_pagesBase, "pageProfile_changeAddress");
			}
		});
		btnChangeAddress.setBounds(14, 480, 380, 50);
		panel_pageProfile.add(btnChangeAddress);
		
		JButton btnChangePassword = new JButton("修改密碼");
		btnChangePassword.setFont(textFont);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdFieldOldPassword.setText("");
				pwdFieldNewPassword.setText("");
				pwdFieldNewPasswordAgain.setText("");
				pagesCard.show(panel_pagesBase, "pageProfile_changePassword");
			}
		});
		btnChangePassword.setBounds(14, 550, 380, 50);
		panel_pageProfile.add(btnChangePassword);
		
		
		
		/* change password */
		JPanel panel_pageProfileChangePassword = new JPanel();
		panel_pagesBase.add(panel_pageProfileChangePassword, "pageProfile_changePassword");
		panel_pageProfileChangePassword.setLayout(null);
		
		JButton btnChangePasswordBack2Profile = new JButton("返回");
		btnChangePasswordBack2Profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdFieldOldPassword.setText("");
				pwdFieldNewPassword.setText("");
				pwdFieldNewPasswordAgain.setText("");
				DBConnect DBC = new DBConnect();
				String query = "SELECT   UserName, UserBirthday, UserPhone, UserEmail, DeliveryAddress, UserStatement " + 
							   "FROM     fast_food_delivered_managerment.user    AS FU, " +
							   "         fast_food_delivered_managerment.address AS FA " +
							   "WHERE    FU.UserID = "+USERID+" AND " +
							   "         FA.UserID = FU.UserID " + 
							   "GROUP BY FU.UserID ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						lblProfileUserNameData.setText(resultset.getString("UserName"));
						lblProfileUserBirthdayData.setText(String.format("%tF", resultset.getDate("UserBirthday")));
						lblProfileUserPhoneData.setText(resultset.getString("UserPhone"));
						lblProfileUserEmailData.setText(resultset.getString("UserEmail"));
						lblProfileUserAddressData.setText(resultset.getString("DeliveryAddress"));
						if(resultset.getString("UserStatement").equals("NotCertified")) lblProfileUserStatementData.setText("尚未驗證信箱");
						else if(resultset.getString("UserStatement").equals("Suspension")) lblProfileUserStatementData.setText("已停止");
						else lblProfileUserStatementData.setText("帳號已驗證");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 17");
				}
				pagesCard.show(panel_pagesBase, "pageProfile");
			}
		});
		btnChangePasswordBack2Profile.setFont(textFont);
		btnChangePasswordBack2Profile.setBounds(14, 13, 99, 34);
		panel_pageProfileChangePassword.add(btnChangePasswordBack2Profile);
		
		JLabel lblOldPassword = new JLabel("舊密碼");
		lblOldPassword.setFont(textFont);
		lblOldPassword.setBounds(14, 100, 99, 27);
		panel_pageProfileChangePassword.add(lblOldPassword);
		
		pwdFieldOldPassword = new JPasswordField();
		pwdFieldOldPassword.setFont(textFont);
		pwdFieldOldPassword.setBounds(127, 100, 267, 27);
		panel_pageProfileChangePassword.add(pwdFieldOldPassword);
		
		JLabel lblNewPassword = new JLabel("新密碼");
		lblNewPassword.setFont(textFont);
		lblNewPassword.setBounds(14, 170, 99, 27);
		panel_pageProfileChangePassword.add(lblNewPassword);
		
		pwdFieldNewPassword = new JPasswordField();
		pwdFieldNewPassword.setFont(textFont);
		pwdFieldNewPassword.setBounds(127, 171, 267, 27);
		panel_pageProfileChangePassword.add(pwdFieldNewPassword);
		
		JLabel lblNewPasswordAgain = new JLabel("確認新密碼");
		lblNewPasswordAgain.setFont(textFont);
		lblNewPasswordAgain.setBounds(14, 240, 99, 27);
		panel_pageProfileChangePassword.add(lblNewPasswordAgain);
		
		pwdFieldNewPasswordAgain = new JPasswordField();
		pwdFieldNewPasswordAgain.setFont(textFont);
		pwdFieldNewPasswordAgain.setBounds(127, 241, 267, 27);
		panel_pageProfileChangePassword.add(pwdFieldNewPasswordAgain);
		
		JButton btnChangePasswordReset = new JButton("重填");
		btnChangePasswordReset.setFont(textFont);
		btnChangePasswordReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pwdFieldOldPassword.setText("");
				pwdFieldNewPassword.setText("");
				pwdFieldNewPasswordAgain.setText("");
			}
		});
		btnChangePasswordReset.setBounds(14, 578, 99, 34);
		panel_pageProfileChangePassword.add(btnChangePasswordReset);
		
		JButton btnChangePasswordChange = new JButton("更改");
		btnChangePasswordChange.setFont(textFont);
		btnChangePasswordChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect DBC = new DBConnect();
				String query = "SELECT UserPassword "+
							   "FROM   fast_food_delivered_managerment.user "+
							   "WHERE  UserID = "+USERID+"";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					String currentPassword = "";
					while(resultset.next()) {
						currentPassword = resultset.getString("UserPassword");
					}
					
					if(String.valueOf(pwdFieldOldPassword.getText()).equals(currentPassword)) {
						if(String.valueOf(pwdFieldNewPassword.getText()).equals(String.valueOf(pwdFieldNewPasswordAgain.getText()))) {
							if(String.valueOf(pwdFieldNewPassword.getText()).length() < 40) {
								String sql = "UPDATE fast_food_delivered_managerment.user "+
											 "SET UserPassword = '"+String.valueOf(pwdFieldNewPassword.getText())+"' "+
											 "WHERE UserID = '"+USERID+"' ";
								DBC.getStatement().executeUpdate(sql);
								JOptionPane.showConfirmDialog(null, "成功更改", "訊息", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
								
								/* back profile */
								query = "SELECT   UserName, UserBirthday, UserPhone, UserEmail, DeliveryAddress, UserStatement " + 
											   "FROM     fast_food_delivered_managerment.user    AS FU, " +
											   "         fast_food_delivered_managerment.address AS FA " +
											   "WHERE    FU.UserID = "+USERID+" AND " +
											   "         FA.UserID = FU.UserID " + 
											   "GROUP BY FU.UserID ";
								try {
									resultset = DBC.getStatement().executeQuery(query);
									while(resultset.next()) {
										lblProfileUserNameData.setText(resultset.getString("UserName"));
										lblProfileUserBirthdayData.setText(String.format("%tF", resultset.getDate("UserBirthday")));
										lblProfileUserPhoneData.setText(resultset.getString("UserPhone"));
										lblProfileUserEmailData.setText(resultset.getString("UserEmail"));
										lblProfileUserAddressData.setText(resultset.getString("DeliveryAddress"));
										if(resultset.getString("UserStatement").equals("NotCertified")) lblProfileUserStatementData.setText("尚未驗證信箱");
										else if(resultset.getString("UserStatement").equals("Suspension")) lblProfileUserStatementData.setText("已停止");
										else lblProfileUserStatementData.setText("帳號已驗證");
									}
								} catch (SQLException e1) {
									e1.printStackTrace();
									System.out.println("系統錯誤 29");
								}
								/* back finish */
							}
							else {
								JOptionPane.showConfirmDialog(null, "密碼長度過長", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showConfirmDialog(null, "第二次密碼錯誤", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						 JOptionPane.showConfirmDialog(null, "舊密碼錯誤", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 18");
				}
				
				pwdFieldOldPassword.setText("");
				pwdFieldNewPassword.setText("");
				pwdFieldNewPasswordAgain.setText("");
				
			}
		});
		btnChangePasswordChange.setBounds(294, 578, 99, 34);
		panel_pageProfileChangePassword.add(btnChangePasswordChange);
		
		
		
		/* change phone number */
		JPanel panel_pageProfileChangePhone = new JPanel();
		panel_pagesBase.add(panel_pageProfileChangePhone, "pageProfile_changePhone");
		panel_pageProfileChangePhone.setLayout(null);
		
		JButton btnChangePhoneNumberBack2Profile = new JButton("返回");
		btnChangePhoneNumberBack2Profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect DBC = new DBConnect();
				String query = "SELECT   UserName, UserBirthday, UserPhone, UserEmail, DeliveryAddress, UserStatement " + 
							   "FROM     fast_food_delivered_managerment.user    AS FU, " +
							   "         fast_food_delivered_managerment.address AS FA " +
							   "WHERE    FU.UserID = "+USERID+" AND " +
							   "         FA.UserID = FU.UserID " + 
							   "GROUP BY FU.UserID ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						lblProfileUserNameData.setText(resultset.getString("UserName"));
						lblProfileUserBirthdayData.setText(String.format("%tF", resultset.getDate("UserBirthday")));
						lblProfileUserPhoneData.setText(resultset.getString("UserPhone"));
						lblProfileUserEmailData.setText(resultset.getString("UserEmail"));
						lblProfileUserAddressData.setText(resultset.getString("DeliveryAddress"));
						if(resultset.getString("UserStatement").equals("NotCertified")) lblProfileUserStatementData.setText("尚未驗證信箱");
						else if(resultset.getString("UserStatement").equals("Suspension")) lblProfileUserStatementData.setText("已停止");
						else lblProfileUserStatementData.setText("帳號已驗證");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 19");
				}
				pagesCard.show(panel_pagesBase, "pageProfile");
			}
		});
		btnChangePhoneNumberBack2Profile.setFont(textFont);
		btnChangePhoneNumberBack2Profile.setBounds(14, 13, 99, 34);
		panel_pageProfileChangePhone.add(btnChangePhoneNumberBack2Profile);
		
		JLabel lblOldPhone = new JLabel("舊電話號碼");
		lblOldPhone.setFont(textFont);
		lblOldPhone.setFont(textFont);
		lblOldPhone.setBounds(14, 100, 99, 27);
		panel_pageProfileChangePhone.add(lblOldPhone);
		
		textFieldOldPhone = new JTextField();
		textFieldOldPhone.setFont(textFont);
		textFieldOldPhone.setBounds(127, 103, 267, 27);
		panel_pageProfileChangePhone.add(textFieldOldPhone);
		textFieldOldPhone.setColumns(10);
		
		JLabel lblNewPhone = new JLabel("新電話號碼");
		lblNewPhone.setFont(textFont);
		lblNewPhone.setBounds(14, 170, 99, 27);
		panel_pageProfileChangePhone.add(lblNewPhone);
		
		textFieldNewPhone = new JTextField();
		textFieldNewPhone.setFont(textFont);
		textFieldNewPhone.setColumns(10);
		textFieldNewPhone.setBounds(127, 173, 267, 27);
		panel_pageProfileChangePhone.add(textFieldNewPhone);
		
		JButton btnChangePhoneChange = new JButton("更改");
		btnChangePhoneChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect DBC = new DBConnect();
				String query = "SELECT FU.UserPhone "+
							   "FROM   fast_food_delivered_managerment.user AS FU "+
							   "WHERE  FU.UserID = "+USERID+" ";
				String currentPhone = "";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) currentPhone = resultset.getString("FU.UserPhone");
					if(textFieldOldPhone.getText().toString().equals(currentPhone)) {
						boolean isDigit = true;
						for(int i=0; i<textFieldNewPhone.getText().length(); i++) if(!Character.isDigit(textFieldNewPhone.getText().charAt(i))) isDigit = false;
						if(textFieldNewPhone.getText().length() != 10) isDigit = false;
						if(isDigit) {
							String sql = "UPDATE fast_food_delivered_managerment.user SET UserPhone = '"+textFieldNewPhone.getText()+"'  WHERE UserID = "+USERID+" ";
							DBC.getStatement().executeUpdate(sql);
							JOptionPane.showConfirmDialog(null, "成功更改", "訊息", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
							
							/* back 2 profile page */
							textFieldOldPhone.setText("");
							textFieldNewPhone.setText("");
							query = "SELECT   UserName, UserBirthday, UserPhone, UserEmail, DeliveryAddress, UserStatement " + 
										   "FROM     fast_food_delivered_managerment.user    AS FU, " +
										   "         fast_food_delivered_managerment.address AS FA " +
										   "WHERE    FU.UserID = "+USERID+" AND " +
										   "         FA.UserID = FU.UserID " + 
										   "GROUP BY FU.UserID ";
							try {
								resultset = DBC.getStatement().executeQuery(query);
								while(resultset.next()) {
									lblProfileUserNameData.setText(resultset.getString("UserName"));
									lblProfileUserBirthdayData.setText(String.format("%tF", resultset.getDate("UserBirthday")));
									lblProfileUserPhoneData.setText(resultset.getString("UserPhone"));
									lblProfileUserEmailData.setText(resultset.getString("UserEmail"));
									lblProfileUserAddressData.setText(resultset.getString("DeliveryAddress"));
									if(resultset.getString("UserStatement").equals("NotCertified")) lblProfileUserStatementData.setText("尚未驗證信箱");
									else if(resultset.getString("UserStatement").equals("Suspension")) lblProfileUserStatementData.setText("已停止");
									else lblProfileUserStatementData.setText("帳號已驗證");
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
								System.out.println("系統錯誤 28");
							}							
							pagesCard.show(panel_pagesBase, "pageProfile");
							/* back finish */
						}
						else {
							JOptionPane.showConfirmDialog(null, "請輸入正確的新電話", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
							textFieldNewPhone.setText("");
						}
					}
					else {
						JOptionPane.showConfirmDialog(null, "請輸入正確的舊電話", "錯誤", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						textFieldOldPhone.setText("");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 20");
				}				
			}
		});
		btnChangePhoneChange.setFont(textFont);
		btnChangePhoneChange.setBounds(295, 578, 99, 34);
		panel_pageProfileChangePhone.add(btnChangePhoneChange);
		
		
		
		/* change address */
		JPanel panel_pageProfileChangeAddress = new JPanel();
		panel_pagesBase.add(panel_pageProfileChangeAddress, "pageProfile_changeAddress");
		panel_pageProfileChangeAddress.setLayout(null);
		
		JButton btnChangeAddressBack2Profile = new JButton("返回");
		btnChangeAddressBack2Profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBConnect DBC = new DBConnect();
				String query = "SELECT   UserName, UserBirthday, UserPhone, UserEmail, DeliveryAddress, UserStatement " + 
							   "FROM     fast_food_delivered_managerment.user    AS FU, " +
							   "         fast_food_delivered_managerment.address AS FA " +
							   "WHERE    FU.UserID = "+USERID+" AND " +
							   "         FA.UserID = FU.UserID " + 
							   "GROUP BY FU.UserID ";
				try {
					ResultSet resultset = DBC.getStatement().executeQuery(query);
					while(resultset.next()) {
						lblProfileUserNameData.setText(resultset.getString("UserName"));
						lblProfileUserBirthdayData.setText(String.format("%tF", resultset.getDate("UserBirthday")));
						lblProfileUserPhoneData.setText(resultset.getString("UserPhone"));
						lblProfileUserEmailData.setText(resultset.getString("UserEmail"));
						lblProfileUserAddressData.setText(resultset.getString("DeliveryAddress"));
						if(resultset.getString("UserStatement").equals("NotCertified")) lblProfileUserStatementData.setText("尚未驗證信箱");
						else if(resultset.getString("UserStatement").equals("Suspension")) lblProfileUserStatementData.setText("已停止");
						else lblProfileUserStatementData.setText("帳號已驗證");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("系統錯誤 21");
				}
				textFieldNewAddress.setText("");
				
				pagesCard.show(panel_pagesBase, "pageProfile");
			}
		});
		btnChangeAddressBack2Profile.setFont(textFont);
		btnChangeAddressBack2Profile.setBounds(14, 13, 99, 34);
		panel_pageProfileChangeAddress.add(btnChangeAddressBack2Profile);
		
		JLabel lblDeliveryAddress = new JLabel("送達地址", SwingConstants.CENTER);
		lblDeliveryAddress.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 40) );
		lblDeliveryAddress.setBounds(14, 60, 380, 45);
		panel_pageProfileChangeAddress.add(lblDeliveryAddress);
		
		JScrollPane scrollPane_addressList = new JScrollPane();
		scrollPane_addressList.setBounds(14, 118, 380, 364);
		panel_pageProfileChangeAddress.add(scrollPane_addressList);
		
		JList<String> listAddressList = new JList<String>();
		scrollPane_addressList.setViewportView(listAddressList);
		listAddressList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String selectedAddress = listAddressList.getSelectedValue();
				int opt = JOptionPane.showConfirmDialog(null,
														"是否刪除地址:\n"+selectedAddress, 
														"刪除選取地址", 
														JOptionPane.YES_NO_OPTION, 
														JOptionPane.INFORMATION_MESSAGE);
				if(opt == 0) {
					String sql = "DELETE FROM address " +
								 "WHERE       UserID = "+USERID+" AND "+
								 "            DeliveryAddress = '"+selectedAddress+"'";
					String query = "SELECT DeliveryAddress "+
								   "FROM   fast_food_delivered_managerment.address "+
								   "WHERE  UserID = "+USERID+" ";
					DBConnect DBC = new DBConnect();
					try {
						DBC.getStatement().executeUpdate(sql);
						textFieldNewAddress.setText("");
						listModelProfileAddress.clear();
						ResultSet resultset = DBC.getStatement().executeQuery(query);
						while(resultset.next()) {
							listModelProfileAddress.addElement(resultset.getString("DeliveryAddress"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("系統錯誤 26");
					}
				}
			}
		});
		listAddressList.setModel(listModelProfileAddress);
		listAddressList.setFont(textFont);
		
		textFieldNewAddress = new JTextField();
		textFieldNewAddress.setFont(textFont);
		textFieldNewAddress.setBounds(14, 537, 267, 27);
		panel_pageProfileChangeAddress.add(textFieldNewAddress);
		textFieldNewAddress.setColumns(10);
		
		JButton btnAddNewAddress = new JButton("新增");
		btnAddNewAddress.setFont(textFont);
		btnAddNewAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldNewAddress.getText().equals("")) {
					DBConnect DBC = new DBConnect();
					String sql = "INSERT INTO fast_food_delivered_managerment.address(UserID, DeliveryAddress) " +
								 "VALUES('"+USERID+"', '"+textFieldNewAddress.getText()+"')";
					String query = "SELECT DeliveryAddress "+
								   "FROM   fast_food_delivered_managerment.address "+
								   "WHERE  UserID = "+USERID+" ";
					try {
						DBC.getStatement().executeUpdate(sql);
						textFieldNewAddress.setText("");
						listModelProfileAddress.clear();
						ResultSet resultset = DBC.getStatement().executeQuery(query);
						while(resultset.next()) {
							listModelProfileAddress.addElement(resultset.getString("DeliveryAddress"));
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("系統錯誤 22");
					}
				}
			}
		});
		btnAddNewAddress.setBounds(295, 533, 99, 34);
		panel_pageProfileChangeAddress.add(btnAddNewAddress);
	}
	
	class SpinnerRenderer extends JSpinner implements TableCellRenderer {
		public SpinnerRenderer() {
			setOpaque(true);
		}
		   
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			setModel((SpinnerModel) value);
			return this;
		}
	}
		   
	class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
		protected JSpinner spinner;
		
		public SpinnerEditor() {
			spinner = new JSpinner();
		}
		  
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			spinner.setModel((SpinnerModel) value);
			return spinner;
		}
		  
		public Object getCellEditorValue() {
			SpinnerModel sm = spinner.getModel();
			return sm;
		}
	}
}
