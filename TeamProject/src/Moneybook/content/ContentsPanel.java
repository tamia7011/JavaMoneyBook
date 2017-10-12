package Moneybook.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Moneybook.MainFrame;

public class ContentsPanel extends JPanel{
	
	private static ContentsPanel instance;
	boolean status = false;
	
	
	
	
	public static ContentsPanel getInstance() {
		if(instance == null) {
			instance = new ContentsPanel();
			return instance;
		}
		
		return instance;
	}
	private ContentsPanel() { 
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//JFrame budgetPopup = new JFrame();
				DataEntry dataEntry =  new DataEntry();
				dataEntry.setVisible(true);
				//String name = JOptionPane.showInputDialog(dataEntry, "How much is your budget?", null);
			}
			
		});
		
		add(btnNewButton);
		
		JLabel lblContent = new JLabel("Content");
		add(lblContent);
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
//	      
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
