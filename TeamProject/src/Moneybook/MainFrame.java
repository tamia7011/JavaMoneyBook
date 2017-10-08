package Moneybook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	//insert "占싻뱄옙", student object)
	
	//singleton constructor for MainFrame
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
			return instance;
		}
		return instance;
	}
	
	private MainFrame() {
		init(); 
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 545);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.RED);
		mainPanel.add(menuPanel, BorderLayout.NORTH);
		FlowLayout fl_menuPanel = new FlowLayout(FlowLayout.LEFT, 0, 0);
		menuPanel.setLayout(fl_menuPanel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.CYAN);
		menuPanel.add(menuBar);

		JMenu editMenu = new JMenu("Edit");
		editMenu.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 20));
		menuBar.add(editMenu);

		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 20));
		menuBar.add(fileMenu);


		
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
