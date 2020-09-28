import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WindowOfApplication extends JFrame {

	private static final long serialVersionUID = -8379324835760274831L;
	
	/* base */ 
	private JPanel contentPane;
	private JPanel panel_base;
	private CardLayout card = new CardLayout();
	
	/* login */
	private JPanel panel_login;
	
	/* main */
	private JPanel panel_main;
	
	
	/* histor */
	private JPanel panel_history;
	
	
	/* sign up */
	private JPanel panel_signUp4User;
	
	/*  */
	private JPanel panel_page1;
	
	/* info */
	private JPanel panel_page2;
	
	/* else */
	private Font textFont = new Font("微軟正黑體", Font.CENTER_BASELINE, 18);
	private JTextField tFieldLoginAccount;
	private JTextField tFieldLoginPassword;
	private JTextField textFieldSignUpDmanName;
	private JTextField textFieldSignUpDmanBirthday;
	private JTextField textFieldSignUpDmanPhone;
	private JTextField textFieldSignUpDmanEmail;
	private JTextField textFieldSignUpDmanAddress;
	private JTextField textFieldSignUpDmanPassword;
	private JTextField textFieldSignUpDmanPwdAgain;
	private JTextField textFieldSignUpUserName;
	private JTextField textFieldSignUpUserBirthday;
	private JTextField textFieldSignUpUserPhone;
	private JTextField textFieldSignUpUserEmail;
	private JTextField textFieldSignUpUserPassword;
	private JTextField textFieldSignUpUserPwdAgain;
	private JTextField textFieldSignUpDmanIdentity;
	private JTextField textFieldSignUpDmanBankAccount;
	
	

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/* run window application */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowOfApplication window = new WindowOfApplication();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowOfApplication() {
		super("Project Name");
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		/* base panel */
		panel_base = new JPanel();
		contentPane.add(panel_base, "basePanel");
		panel_base.setLayout(card);
		
		
		/* login page */
		panel_login = new JPanel();
		panel_base.add(panel_login, "loginPage");
		panel_login.setLayout(null);
		
		JLabel labelLoginAccount = new JLabel("帳號", SwingConstants.CENTER);
		labelLoginAccount.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		labelLoginAccount.setBounds(10, 213, 99, 62);
		panel_login.add(labelLoginAccount);
		
		tFieldLoginAccount = new JTextField();
		tFieldLoginAccount.setBounds(123, 231, 261, 32);
		panel_login.add(tFieldLoginAccount);
		tFieldLoginAccount.setColumns(10);
		
		JLabel labelLoginPassword = new JLabel("密碼", SwingConstants.CENTER);
		labelLoginPassword.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		labelLoginPassword.setBounds(10, 336, 99, 62);
		panel_login.add(labelLoginPassword);
		
		tFieldLoginPassword = new JTextField();
		tFieldLoginPassword.setBounds(123, 354, 261, 32);
		panel_login.add(tFieldLoginPassword);
		tFieldLoginPassword.setColumns(10);
		
		JLabel lblProjectName = new JLabel("Project Name", SwingConstants.CENTER);
		lblProjectName.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 50));
		lblProjectName.setBounds(0, 0, 398, 205);
		panel_login.add(lblProjectName);
		
		JButton btnLogin = new JButton("登入");
		btnLogin.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_base, "loginPage");
				System.out.println("change");
			}
		});
		btnLogin.setBounds(10, 486, 374, 73);
		panel_login.add(btnLogin);
		
		JButton btnSignUp = new JButton("註冊");
		btnSignUp.setFont(new Font("微軟正黑體", Font.CENTER_BASELINE, 33));
		btnSignUp.setBounds(10, 572, 374, 73);
		panel_login.add(btnSignUp);
		
		
		/* user sign up page */
		panel_signUp4User = new JPanel();
		panel_base.add(panel_signUp4User, "userSignUpPage");
		panel_signUp4User.setLayout(null);
		
		JButton btnSignUpUserBack2Login = new JButton("返回");
		btnSignUpUserBack2Login.setBounds(14, 13, 99, 27);
		panel_signUp4User.add(btnSignUpUserBack2Login);
		
		JButton btnSignUp2Dman = new JButton("外送員註冊");
		btnSignUp2Dman.setBounds(204, 53, 180, 27);
		panel_signUp4User.add(btnSignUp2Dman);
		
		JLabel lblSignUpUser = new JLabel("使用者註冊");
		lblSignUpUser.setBounds(14, 53, 180, 27);
		panel_signUp4User.add(lblSignUpUser);
		
		JButton btnSignUpUser = new JButton("註冊");
		btnSignUpUser.setBounds(285, 651, 99, 27);
		panel_signUp4User.add(btnSignUpUser);
		
		JLabel lblSignUpUserName = new JLabel("name");
		lblSignUpUserName.setBounds(14, 93, 99, 27);
		panel_signUp4User.add(lblSignUpUserName);
		
		textFieldSignUpUserName = new JTextField();
		textFieldSignUpUserName.setBounds(127, 93, 257, 25);
		panel_signUp4User.add(textFieldSignUpUserName);
		textFieldSignUpUserName.setColumns(10);
		
		JLabel lblSignUpUserBirthday = new JLabel("birthday");
		lblSignUpUserBirthday.setBounds(14, 133, 99, 27);
		panel_signUp4User.add(lblSignUpUserBirthday);
		
		textFieldSignUpUserBirthday = new JTextField();
		textFieldSignUpUserBirthday.setBounds(127, 134, 257, 25);
		panel_signUp4User.add(textFieldSignUpUserBirthday);
		textFieldSignUpUserBirthday.setColumns(10);
		
		JLabel lblSignUpUserPhone = new JLabel("phone number");
		lblSignUpUserPhone.setBounds(14, 173, 99, 27);
		panel_signUp4User.add(lblSignUpUserPhone);
		
		textFieldSignUpUserPhone = new JTextField();
		textFieldSignUpUserPhone.setColumns(10);
		textFieldSignUpUserPhone.setBounds(127, 174, 257, 25);
		panel_signUp4User.add(textFieldSignUpUserPhone);
		
		JLabel lblSignUpUserEmail = new JLabel("email");
		lblSignUpUserEmail.setBounds(14, 213, 99, 27);
		panel_signUp4User.add(lblSignUpUserEmail);
		
		textFieldSignUpUserEmail = new JTextField();
		textFieldSignUpUserEmail.setColumns(10);
		textFieldSignUpUserEmail.setBounds(127, 214, 257, 25);
		panel_signUp4User.add(textFieldSignUpUserEmail);
		
		JLabel lblSignUpUserPassword = new JLabel("password");
		lblSignUpUserPassword.setBounds(14, 253, 99, 27);
		panel_signUp4User.add(lblSignUpUserPassword);
		
		textFieldSignUpUserPassword = new JTextField();
		textFieldSignUpUserPassword.setColumns(10);
		textFieldSignUpUserPassword.setBounds(127, 254, 257, 25);
		panel_signUp4User.add(textFieldSignUpUserPassword);
		
		JLabel lblSignUpUserPwdAgain = new JLabel("password again");
		lblSignUpUserPwdAgain.setBounds(14, 293, 99, 27);
		panel_signUp4User.add(lblSignUpUserPwdAgain);
		
		textFieldSignUpUserPwdAgain = new JTextField();
		textFieldSignUpUserPwdAgain.setColumns(10);
		textFieldSignUpUserPwdAgain.setBounds(127, 294, 257, 25);
		panel_signUp4User.add(textFieldSignUpUserPwdAgain);
		
		JLabel lblSignUpUserErrorMessage = new JLabel("Error 註冊資料錯誤");
		lblSignUpUserErrorMessage.setBounds(14, 515, 370, 27);
		panel_signUp4User.add(lblSignUpUserErrorMessage);
		
		JButton btnSignUpUserReset = new JButton("reset");
		btnSignUpUserReset.setBounds(14, 651, 99, 27);
		panel_signUp4User.add(btnSignUpUserReset);
		
		
		/* Dman sign up page */
		JPanel panel_SignUp4Dman = new JPanel();
		panel_base.add(panel_SignUp4Dman, "dmanSignUpPage");
		panel_SignUp4Dman.setLayout(null);
		
		JButton btnSignUpDmanBack2Login = new JButton("返回");
		btnSignUpDmanBack2Login.setBounds(14, 13, 99, 27);
		panel_SignUp4Dman.add(btnSignUpDmanBack2Login);
		
		JButton btnSignUp4User = new JButton("使用者註冊");
		btnSignUp4User.setBounds(14, 53, 180, 27);
		panel_SignUp4Dman.add(btnSignUp4User);
		
		JLabel lblSignUpDman = new JLabel("外送員註冊");
		lblSignUpDman.setBounds(204, 53, 180, 27);
		panel_SignUp4Dman.add(lblSignUpDman);
		
		JButton btnSignUpDman = new JButton("註冊");
		btnSignUpDman.setBounds(14, 651, 99, 27);
		panel_SignUp4Dman.add(btnSignUpDman);
		
		JLabel lblSignUpDmanName = new JLabel("姓名");
		lblSignUpDmanName.setBounds(14, 115, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanName);
		
		textFieldSignUpDmanName = new JTextField();
		textFieldSignUpDmanName.setBounds(128, 116, 256, 27);
		panel_SignUp4Dman.add(textFieldSignUpDmanName);
		textFieldSignUpDmanName.setColumns(10);
		
		JLabel lblSignUpDmanBirthday = new JLabel("birthday");
		lblSignUpDmanBirthday.setBounds(14, 155, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanBirthday);
		
		textFieldSignUpDmanBirthday = new JTextField();
		textFieldSignUpDmanBirthday.setBounds(128, 156, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanBirthday);
		textFieldSignUpDmanBirthday.setColumns(10);
		
		JLabel lblSignUpDmanPhoneNumber = new JLabel("phone number");
		lblSignUpDmanPhoneNumber.setBounds(14, 195, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanPhoneNumber);
		
		textFieldSignUpDmanPhone = new JTextField();
		textFieldSignUpDmanPhone.setBounds(128, 196, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanPhone);
		textFieldSignUpDmanPhone.setColumns(10);
		
		JLabel lblSignUpDmanEmail = new JLabel("email");
		lblSignUpDmanEmail.setBounds(14, 235, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanEmail);
		
		textFieldSignUpDmanEmail = new JTextField();
		textFieldSignUpDmanEmail.setBounds(128, 236, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanEmail);
		textFieldSignUpDmanEmail.setColumns(10);
		
		JLabel lblSignUpDmanAddress = new JLabel("addr");
		lblSignUpDmanAddress.setBounds(14, 275, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanAddress);
		
		textFieldSignUpDmanAddress = new JTextField();
		textFieldSignUpDmanAddress.setBounds(128, 276, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanAddress);
		textFieldSignUpDmanAddress.setColumns(10);
		
		JLabel lblSignUpDmanIdentity = new JLabel("identity");
		lblSignUpDmanIdentity.setBounds(14, 315, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanIdentity);
		
		textFieldSignUpDmanIdentity = new JTextField();
		textFieldSignUpDmanIdentity.setColumns(10);
		textFieldSignUpDmanIdentity.setBounds(128, 316, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanIdentity);
		
		JLabel lblSignUpDmanBankAccount = new JLabel("bank account");
		lblSignUpDmanBankAccount.setBounds(14, 355, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanBankAccount);
		
		textFieldSignUpDmanBankAccount = new JTextField();
		textFieldSignUpDmanBankAccount.setColumns(10);
		textFieldSignUpDmanBankAccount.setBounds(128, 356, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanBankAccount);
		
		JLabel lblSignUpDmanPassword = new JLabel("password");
		lblSignUpDmanPassword.setBounds(14, 395, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanPassword);
		
		textFieldSignUpDmanPassword = new JTextField();
		textFieldSignUpDmanPassword.setBounds(128, 396, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanPassword);
		textFieldSignUpDmanPassword.setColumns(10);
		
		JLabel lblSignUpDmanPwdAgin = new JLabel("pwd again");
		lblSignUpDmanPwdAgin.setBounds(14, 433, 99, 27);
		panel_SignUp4Dman.add(lblSignUpDmanPwdAgin);
		
		textFieldSignUpDmanPwdAgain = new JTextField();
		textFieldSignUpDmanPwdAgain.setBounds(128, 434, 256, 25);
		panel_SignUp4Dman.add(textFieldSignUpDmanPwdAgain);
		textFieldSignUpDmanPwdAgain.setColumns(10);
		
		JLabel lblSignUpDmanErrorMessage = new JLabel("Error 註冊資料錯誤");
		lblSignUpDmanErrorMessage.setBounds(14, 542, 370, 27);
		panel_SignUp4Dman.add(lblSignUpDmanErrorMessage);
		
		JButton btnSignUpDmanReset = new JButton("reset");
		btnSignUpDmanReset.setBounds(285, 651, 99, 27);
		panel_SignUp4Dman.add(btnSignUpDmanReset);
		
		/* main page */
		panel_main = new JPanel();
		panel_base.add(panel_main, "mainPage");
		panel_main.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 637, 398, 54);
		panel_main.add(panel);
		//panel_main.setLayout(new GridLayout(1, 4));
		
		JButton btnMainHome = new JButton("home");
		btnMainHome.setBounds(0, 0, 99, 61);
		btnMainHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(btnMainHome);
		
		JButton btnMainSearch = new JButton("search");
		btnMainSearch.setBounds(99, 0, 99, 61);
		panel.add(btnMainSearch);
		
		JButton btnMainHistory = new JButton("history");
		btnMainHistory.setBounds(198, 0, 99, 61);
		btnMainHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnMainHistory);
		
		JButton btnMainMember = new JButton("member");
		btnMainMember.setBounds(297, 0, 99, 61);
		panel.add(btnMainMember);
		
		JLabel lblProjectName_1 = new JLabel("project name");
		lblProjectName_1.setBounds(173, 13, 57, 19);
		panel_main.add(lblProjectName_1);
		btnMainSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		/* * page */
		panel_history = new JPanel();
		panel_base.add(panel_history, "*Page");
		panel_history.setLayout(null); 
		
		
		
		/* ** page */
		panel_page1 = new JPanel();
		panel_base.add(panel_page2, "**Page");
		panel_page2.setLayout(null);

		
		
		/* *** page */
		panel_page2 = new JPanel();
		panel_base.add(panel_page2, "***Page");
		panel_page2.setLayout(null);
		
	}
}
