package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Moneybook.content.DataEntry;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	//using EventQueue to run this at last
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
		
		JButton btnNewButton_1 = new JButton("\uC608\uC0B0\uC124\uC815");
		menuBar.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//JFrame budgetPopup = new JFrame();
				DataEntry dataEntry =  DataEntry.getInstance();
				dataEntry.setVisible(true);
				//String name = JOptionPane.showInputDialog(dataEntry, "How much is your budget?", null);
			}
			
		});
		
		
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
