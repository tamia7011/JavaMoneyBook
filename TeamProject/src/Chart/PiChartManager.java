package Chart;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Database.Account;
import Database.MonthAccount;

public class PiChartManager {

	public ChartPanel getChart(MonthAccount budgetdata) {

		DefaultPieDataset dataset = new DefaultPieDataset();

		dataset.setValue("Fixed", new Double(budgetdata.getFixedExpenses()));
		dataset.setValue("Flexible", new Double(budgetdata.getFlexibleExpenses()));
		dataset.setValue("Discretionary", new Double(budgetdata.getDiscretionaryExpenses()));

		JFreeChart chart = ChartFactory.createPieChart("Mobile Sales", // chart title
				dataset, // data
				true, // include legend
				true, false);

		return new ChartPanel(chart);
	}

}
