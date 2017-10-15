package Moneybook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.budgetData;
import Moneybook.calendar.CalenderPanel;
import Moneybook.content.ContentsPanel;

public class MainFrame extends JFrame {

	private static MainFrame instance;
	
	private JPanel mainPanel; 
	public CalenderPanel calenderPanel;
	public ContentsPanel contentsPanel;
	
	
	//Data list
	public Map data = new HashMap();
	
	//(key,value);
	//insert "占쎈쐻占쎈뼦獄�袁⑹굲", student object)
	
	//singleton constructor for MainFrame
	public static MainFrame getInstance() throws SQLException {
		if(instance == null) {
			instance = new MainFrame();
			return instance;
		}
		return instance;
	}
	
	private MainFrame() throws SQLException {
		init(); 
	}

	private void init() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 545);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
 
		
		//Menu Panel Layout
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.RED);
		mainPanel.add(menuPanel, BorderLayout.NORTH);
		FlowLayout fl_menuPanel = new FlowLayout(FlowLayout.LEFT, 0, 0);
		menuPanel.setLayout(fl_menuPanel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.CYAN);
		menuPanel.add(menuBar);
		
		JButton btnNewButton_1 = new JButton("set budget");
		menuBar.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame budgetPopup = new JFrame();
				int salary = Integer.parseInt(JOptionPane.showInputDialog(budgetPopup, "How much is your income?", null));
				budgetData budget = budgetData.getInstance();
				budget.salary = salary;
				budgetPopup.dispose();
			}
			
		});

		
		calenderPanel = CalenderPanel.getInstance();
		mainPanel.add(calenderPanel, BorderLayout.CENTER);

		contentsPanel = ContentsPanel.getInstance();
		contentsPanel.setBackground(Color.GREEN);
		mainPanel.add(contentsPanel, BorderLayout.SOUTH);

	}

	public void start() {
		setVisible(true);
	} 
	
	public void ClickDate(int year,int month,int day) {
		//get info at DB
		
		//ContentPane show!
		
	}
	

	
 
}
