package Moneybook.content;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.Account;
import Database.AccountDAO;
import Moneybook.calendar.CalendarManager;

public class SearchedData extends JFrame {
	private JTable table;
	SearchData searchData;

	public SearchedData() {
		setTitle("Searched Data");
		searchData = SearchData.thisFrame;
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		Dimension dim = new Dimension(20,1);
		table.setIntercellSpacing(new Dimension(dim));
		int height = table.getRowHeight();
		table.setRowHeight(height+10);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"type", "name", "price", "date"},
			},
			new String[] {
				"type", "name", "price", "date"
			}
		));
		getContentPane().add(table, BorderLayout.CENTER);
		AccountDAO accountDAO = AccountDAO.getInstance();
		System.out.println(searchData.SearchedNameField.getText());
		ArrayList<Account> list = accountDAO.selectName(searchData.SearchedNameField.getText());
		
		if(list.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "No data of that name exist!!", "warning", JOptionPane.WARNING_MESSAGE);
		} else {
			DefaultTableModel model = (DefaultTableModel) table.getModel(); 
			model.setNumRows(1); 
			for(Account account:list) {
				Object[] row = { account.getType(), account.getName(), account.getPrice(), account.getDate() };
				model.addRow(row);
			}
		}
		
	}
}
