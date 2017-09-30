package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class windowMaker extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowMaker frame = new windowMaker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public windowMaker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.RED);
		contentPane.add(menuPanel, BorderLayout.NORTH);
		FlowLayout fl_menuPanel = new FlowLayout(FlowLayout.LEFT, 0, 0);
		menuPanel.setLayout(fl_menuPanel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.CYAN);
		menuPanel.add(menuBar);
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		menuBar.add(editMenu);
		
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		menuBar.add(fileMenu);
		
		JPanel calenderPanel = new JPanel();
		calenderPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(calenderPanel, BorderLayout.CENTER);
		calenderPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		calenderPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		calenderPanel.add(panel);
		panel.setLayout(new GridLayout(10, 0, 0, 0));
		
		JPanel contentsPanel = new JPanel();
		contentsPanel.setBackground(Color.GREEN);
		contentPane.add(contentsPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		contentsPanel.add(btnNewButton);
		
		JLabel lblContent = new JLabel("Content");
		contentsPanel.add(lblContent);
	}

}
