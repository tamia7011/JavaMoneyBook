package Moneybook.content;

import java.awt.BorderLayout;
import java.awt.Container;
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
import ui.PieChart_AWT;

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
		
		JButton btnNewButton = new JButton("edit data");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("statistic");
		toolBar.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );  
			    demo.setSize( 560 , 367 );    
			    RefineryUtilities.centerFrameOnScreen( demo );    
			    demo.setVisible( true ); 
			}
			
		}); 
		
		setVisible(status);
	}
	
	public void show(Calendar cal) {
//		 DefaultPieDataset dataset = new DefaultPieDataset( );
//	      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//	      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//	      dataset.setValue( "MotoG" , new Double( 40 ) );    
//	      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );
//	      JFreeChart chart = ChartFactory.createPieChart(      
//	    	         "Mobile Sales",   // chart title 
//	    	         dataset,          // data    
//	    	         true,             // include legend   
//	    	         true, 
//	    	         false);
//	      
//	      add(new ChartPanel( chart ));
	      
		//Panel up
		if(status) {
			status = false;
		}else {
			status = true;
		}
		setVisible(status);
		//content 
		System.out.println("Calender - "+ cal.get(Calendar.MONTH)+"-"+ cal.get(Calendar.DAY_OF_MONTH));
	}
}
