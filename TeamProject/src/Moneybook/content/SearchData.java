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

public class SearchData extends JFrame{
	public JTextField SearchedNameField;
	public JTable table;
	public ContentsPanel Contents;
	public static SearchData thisFrame;
	public SearchedData SearchedData;
	
	public static SearchData getInstance() {
		if (thisFrame == null) {
			thisFrame = new SearchData();
			return thisFrame;
		}
		return thisFrame;
	}
	
	public SearchData() {
		setBounds(100, 100, 450, 350);
		setTitle("Search Data");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insert data name for search");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel.setBounds(69, 57, 291, 51);
		getContentPane().add(lblNewLabel);
		
		SearchedNameField = new JTextField();
		SearchedNameField.setBounds(58, 123, 180, 27);
		getContentPane().add(SearchedNameField);
		SearchedNameField.setColumns(10);
		
		JButton SearchBtn = new JButton("Search");
		SearchBtn.setBounds(255, 123, 91, 29);
		getContentPane().add(SearchBtn);
			
		SearchBtn.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchedData frame = new SearchedData();
				frame.setSize(1000, 600);
				frame.setVisible(true);
				
			}
			
		});
	}

}
