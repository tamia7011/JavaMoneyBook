package Moneybook.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.*;
import Moneybook.content.*;

public class PriorityData extends JFrame{
	public JTextField PriorityNumField;
	public JTable table;
	public ContentsPanel Contents;
	public static PriorityData thisFrame;
	public PriorityDataTable priorityDataTable;
	public JLabel lblNewLabel;
	public JButton PriorityBtn;
	
	public static PriorityData getInstance() {
		if (thisFrame == null) {
			thisFrame = new PriorityData();
			return thisFrame;
		}
		return thisFrame;
	}
	
	public PriorityData() {
		setBounds(100, 100, 450, 350);
		setTitle("Priority Data");
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("The number to check");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 24));
		lblNewLabel.setBounds(69, 57, 291, 51);
		getContentPane().add(lblNewLabel);
		
		PriorityNumField = new JTextField();
		PriorityNumField.setBounds(58, 123, 180, 27);
		getContentPane().add(PriorityNumField);
		PriorityNumField.setColumns(10);
		
		PriorityBtn = new JButton("Search");
		PriorityBtn.setBounds(255, 123, 91, 29);
		getContentPane().add(PriorityBtn);
			
		PriorityBtn.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PriorityDataTable frame = new PriorityDataTable();
				frame.setSize(1000, 600);
				frame.setVisible(true);
			}
			
		});
	}

}
