package Moneybook.content;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Database.*;

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
		JButton btnNewButton = new JButton("insert information"); 
		add(btnNewButton,BorderLayout.NORTH);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DataEntry dataEntry =  DataEntry.getInstance();
				dataEntry.setVisible(true);
			}
			
		}); 
		
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
