import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class testLoginPage {
	
	public testLoginPage(JPanel panel_base, CardLayout baseCard) {
		JPanel panel_login = new JPanel();
		panel_base.add(panel_login, "loginpage");
		panel_login.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("login page");
		lblLoginPage.setBounds(99, 118, 203, 19);
		panel_login.add(lblLoginPage);
		
		JButton btnShowPmain = new JButton("go 2 main");
		btnShowPmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseCard.show(panel_base, "panel_pageBase");
			}
		});
		btnShowPmain.setBounds(116, 387, 153, 27);
		panel_login.add(btnShowPmain);
	}
	
}
