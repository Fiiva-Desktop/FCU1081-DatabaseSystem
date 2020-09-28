import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class DB_GUI_Test extends JFrame{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB_GUI_Test window = new DB_GUI_Test();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DB_GUI_Test() {
		initialize();
	}
	private CardLayout baseCard = new CardLayout();
	private CardLayout pagesCard = new CardLayout();
	private JPanel panel_pages ;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTextField tf;
	private Object[][] tablelines;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void loginPage(JPanel panel_base) {
		JPanel panel_login = new JPanel();
		panel_base.add(panel_login, "loginpage");
		panel_login.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("login page");
		lblLoginPage.setBounds(99, 118, 203, 19);
		panel_login.add(lblLoginPage);
		
		JButton btnShowPmain = new JButton("go 2 main");
		btnShowPmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("_________" + table.getModel().getValueAt(0, 0));
				baseCard.show(panel_base, "panel_pageBase");
			}
		});
		btnShowPmain.setBounds(208, 620, 153, 27);
		panel_login.add(btnShowPmain);
		
		tablelines = null;
		int rowCount = 10;
		SpinnerNumberModel[] spinnerArray = new SpinnerNumberModel[rowCount];
		
		
		for(int i=0; i<rowCount; i++) {
			spinnerArray[i] = new SpinnerNumberModel(0, 0, 1000, 1);
			//spinnerArray[i].setStepSize(20);
		}
		
		DefaultTableModel dataModel = new DefaultTableModel();
		String title[] = {"name", "age", "weight"};
		dataModel.setColumnIdentifiers(title);
		for(int i=0; i<rowCount; i++) {
			Object line[] = {spinnerArray[i], "Step"+i, "60"};
			dataModel.addRow(line);
		}
	    
		JButton btnGetValue = new JButton("get value");
		btnGetValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i< rowCount; i++)
					System.out.println("sp: "+spinnerArray[i].getValue());
			}
		});
		btnGetValue.setBounds(145, 196, 99, 27);
		panel_login.add(btnGetValue);
		/*
		//String tableTitle[] = {"name", "age", "weight"};
		//dataModel.setColumnIdentifiers(tableTitle);
		Object tableline1[] = {null, "10", "30"};
		dataModel.addRow(tableline1);
		Object tableline2[] = {null, "11", "40"};
		dataModel.addRow(tableline2);
		Object tableline3[] = {null, "12", "50"};
		dataModel.addRow(tableline3);*/
		//c1.setPreferredWidth(200);
		//c2.setPreferredWidth(100);
		//c3.setPreferredWidth(100);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 236, 368, 293);
		panel_login.add(scrollPane_1);
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(dataModel);
		table.setRowHeight(30);
		table.setFont(new Font("·L³n¥¿¶ÂÅé", Font.CENTER_BASELINE, 20));
		
		table.getColumn("name").setCellRenderer(new SpinnerRenderer());
		table.getColumn("name").setCellEditor(new SpinnerEditor());
		
		//table.getModel().getValueAt(0, 0);
		table.getColumn("name").setPreferredWidth(200);
		//TableColumn c2 = table.getColumn("age");
		//TableColumn c3 = table.getColumn("weight");
		
		//System.out.println(Integer.parseInt("12"));
		
		Date data = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
		System.out.println(ft.format(data));
		
	}
	
	private void initialize() {
		this.setBounds(100, 100, 414, 736);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		
		/* base */
		JPanel panel_base = new JPanel();
		this.getContentPane().add(panel_base, "panel_appBase");
		panel_base.setLayout(baseCard);
		
		
		/* login */
		loginPage(panel_base);
		//new testLoginPage(panel_base, baseCard);
		
		/* pages base */
		JPanel panel_pbase = new JPanel();
		panel_base.add(panel_pbase, "panel_pageBase");
		panel_pbase.setLayout(null);
		
		
		/* bar */
		JPanel panel_bar = new JPanel();
		panel_bar.setLocation(0, 624);
		panel_bar.setSize(new Dimension(396, 65));
		panel_pbase.add(panel_bar);
		panel_bar.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("first");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagesCard.show(panel_pages, "page1");
			}
		});
		panel_bar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("second");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagesCard.show(panel_pages, "page2");
			}
		});
		panel_bar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("thired");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagesCard.show(panel_pages, "page3");
			}
		});
		panel_bar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("four");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagesCard.show(panel_pages, "page4");
			}
		});
		panel_bar.add(btnNewButton_3);
		
		
		/* pages base */
		panel_pages = new JPanel();
		panel_pages.setBounds(0, 0, 396, 625);
		panel_pbase.add(panel_pages);
		panel_pages.setLayout(pagesCard);
		
		JPanel panel_1 = new JPanel();
		panel_pages.add(panel_1, "page1");
		panel_1.setLayout(null);
		
		JLabel lblPage = new JLabel("page 1");
		lblPage.setBounds(186, 73, 57, 19);
		panel_1.add(lblPage);
		
		JPanel panel_2 = new JPanel();
		panel_pages.add(panel_2, "page2");
		panel_2.setLayout(null);
		
		JLabel lblPage_1 = new JLabel("page2");
		lblPage_1.setBounds(166, 130, 57, 19);
		panel_2.add(lblPage_1);
		
		JPanel panel_3 = new JPanel();
		panel_pages.add(panel_3, "page3");
		panel_3.setLayout(null);
		
		JLabel lblPage_2 = new JLabel("page3");
		lblPage_2.setBounds(190, 117, 57, 19);
		panel_3.add(lblPage_2);
		scrollPane.setBounds(14, 149, 368, 338);
		panel_3.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		panel_pages.add(panel_4, "page4");
		panel_4.setLayout(null);
		
		JLabel lblPage_3 = new JLabel("page 4");
		lblPage_3.setBounds(187, 140, 57, 19);
		panel_4.add(lblPage_3);
	}
	
	
	class SpinnerRenderer extends JSpinner implements TableCellRenderer {
		   public SpinnerRenderer() {
		      setOpaque(true);
		   }
		   
		   public Component getTableCellRendererComponent(JTable table, Object value,
		                    boolean isSelected, boolean hasFocus, int row, int column) {
		      setModel((SpinnerModel) value);
		   
		      return this;
		   }
		}
		   
		class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
		   protected JSpinner spinner;
		   
		   public SpinnerEditor() {
		      spinner = new JSpinner();
		   }
		  
		   public Component getTableCellEditorComponent(JTable table, Object value,
		                    boolean isSelected, int row, int column) {
		      spinner.setModel((SpinnerModel) value);
		  
		      return spinner;
		   }
		  
		   public Object getCellEditorValue() {
		      SpinnerModel sm = spinner.getModel();
		      return sm;
		   }
		}
}
