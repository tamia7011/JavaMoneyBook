package Chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PiChartManager {

	
	public ChartPanel getChart(){
		
		 DefaultPieDataset dataset = new DefaultPieDataset( );
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
