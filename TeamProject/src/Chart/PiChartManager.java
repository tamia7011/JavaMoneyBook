package Chart;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Database.MoneyData;

public class PiChartManager {

	
	public ChartPanel getChart(ArrayList<MoneyData> list){
		//
		
		 DefaultPieDataset dataset = new DefaultPieDataset( );
		 
		 for(MoneyData d:list){
			 //d.price;
		 }
		 
	      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
	      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
	      dataset.setValue( "MotoG" , new Double( 40 ) );    
	      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );
	      
	
	      JFreeChart chart = ChartFactory.createPieChart(      
	    	         "Mobile Sales",   // chart title 
	    	         dataset,          // data    
	    	         true,             // include legend   
	    	         true, 
	    	         false);
		
		
		return new ChartPanel(chart);
	}
	
}
