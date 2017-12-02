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
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("±¼¸²", Font.PLAIN, 26));
		lblState.setBounds(389, 31, 76, 80);
		contentPane.add(lblState);
		
		JLabel lblMyBudget = new JLabel("My budget");
		lblMyBudget.setBounds(293, 137, 115, 21);
		contentPane.add(lblMyBudget);
		
		JLabel lblTotexp = new JLabel("Total expenses");
		lblTotexp.setBounds(253, 186, 145, 21);
		contentPane.add(lblTotexp);
		
		JLabel lblFixedexp = new JLabel("Fixed expenses");
		lblFixedexp.setBounds(253, 237, 155, 21);
		contentPane.add(lblFixedexp);
		
		JLabel lblFlexexp = new JLabel("Flexible expenses");
		lblFlexexp.setBounds(239, 289, 145, 21);
		contentPane.add(lblFlexexp);
		
		JLabel lblDiscexp = new JLabel("Discretionary expenses");
		lblDiscexp.setBounds(193, 336, 191, 21);
		contentPane.add(lblDiscexp);
		
		JLabel lblBudget = new JLabel("New label");
		lblBudget.setBounds(460, 137, 223, 21);
		contentPane.add(lblBudget);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(458, 186, 225, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(458, 237, 225, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(458, 289, 225, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(458, 336, 225, 21);
		contentPane.add(lblNewLabel_3);
	}
}
