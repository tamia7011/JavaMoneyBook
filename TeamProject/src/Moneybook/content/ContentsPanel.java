package Moneybook.content;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.RefineryUtilities;

import Database.*;
import Moneybook.calendar.CalendarManager;
import Chart.PieChart_AWT;

import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import Chart.PiChartManager;

public class ContentsPanel extends JPanel{
	private static ContentsPanel instance;
	boolean status = false;
	public JTable table;
	
	public static ContentsPanel getInstance() {
		if(instance == null) {
			instance = new ContentsPanel();
			return instance;
		}
		return instance;
	} 
	
	private ContentsPanel() {
		this.setLayout(new BorderLayout());

		
		table = new JTable(); 
		
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		Dimension dim = new Dimension(20,1);
		table.setIntercellSpacing(new Dimension(dim));
		int height = table.getRowHeight();
		table.setRowHeight(height+10);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"type", "name", "price"},
			},
			new String[] {
				"type", "name", "price"
			}
		));
		
		add(table,BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("insert data");
		toolBar.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DataEntry dataEntry =  DataEntry.getInstance();
				dataEntry.setVisible(true);
			}
			
		}); 
		
		JButton btnNewButton_2 = new JButton("delete data");
		toolBar.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteData delData = new DeleteData();
				delData.setVisible(true);
			}
			
		});
		
		JButton btnNewButton = new JButton("edit data");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("statistic");
		toolBar.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showStatics();
			}
			
		}); 
		
		setVisible(status);
	}
	
	public void show(Calendar cal) { 
		if(status) {
			status = false;
		}else {
			status = true;
		}
		setVisible(status); 
		showTable();
		
	}
	
	public void showStatics() {
		AccountDAO accountDAO = AccountDAO.getInstance();
		String date = CalendarManager.getDate();
		ArrayList<Account> list = accountDAO.selectByDate(date);
		
		Chart.PieChart_AWT demo = new Chart.PieChart_AWT( "Expenses" , list  );  
	    demo.setSize( 560 , 367 );    
	    RefineryUtilities.centerFrameOnScreen( demo );    
	    demo.setVisible( true );
	}
	
	public void showTable() { 
		
		AccountDAO accountDAO = AccountDAO.getInstance();
		String date = CalendarManager.getDate();
		ArrayList<Account> list = accountDAO.selectByDate(date);
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		model.setNumRows(1); 
		for(Account account:list) {
			Object[] row = { account.getType(), account.getName(), account.getPrice() };
			model.addRow(row);
		}  
	}
}
