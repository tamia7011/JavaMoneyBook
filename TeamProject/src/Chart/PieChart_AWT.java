package Chart;

import javax.swing.JPanel;
import Database.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChart_AWT extends ApplicationFrame {
	   private static MonthAccount budgetdata;
	
	   public PieChart_AWT( String title ) {
	      super( title ); 
	      budgetdata = MonthAccount.getInstance();
	      setContentPane(createDemoPanel( ));
	   }
	   
	   private static PieDataset createDataset() {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue( "Fixed" , new Double( budgetdata.getFixedExpenses() ) );  
	      dataset.setValue( "Flexible" , new Double( budgetdata.getFlexibleExpenses() ) );   
	      dataset.setValue( "Discretionary" , new Double( budgetdata.getDiscretionaryExpenses() ) );
	      return dataset;         
	   }
	   
	   private static JFreeChart createChart( PieDataset dataset ) {
	      JFreeChart chart = ChartFactory.createPieChart(      
	         "Mobile Sales",   // chart title 
	         dataset,          // data    
	         true,             // include legend   
	         true, 
	         false);

	      return chart;
	   }
	   
	   public static JPanel createDemoPanel( ) {
	      JFreeChart chart = createChart(createDataset( ) );  
	      return new ChartPanel( chart ); 
	   }
	}
