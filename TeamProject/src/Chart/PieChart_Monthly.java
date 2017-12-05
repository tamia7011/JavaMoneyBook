package Chart;

import java.util.ArrayList;

import javax.swing.JPanel;
import Database.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Constants.Constants;

public class PieChart_Monthly extends ApplicationFrame {

	static MonthAccount monthAccount = MonthAccount.getInstance();

	public PieChart_Monthly(String title, ArrayList<Account> accountData) {
		super(title);
		setContentPane(createDemoPanel(accountData));
	}

	private static PieDataset createDataset(ArrayList<Account> accountData) {

		int FixedExpenses = 0;
		int FlexibleExpenses = 0;
		int WasteExpenses = 0;
		int DefaultExpenses = 0;

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Fixed", new Double(monthAccount.getFixedExpenses()));
		dataset.setValue("Flexible", new Double(monthAccount.getFlexibleExpenses()));
		dataset.setValue("Waste", new Double(monthAccount.getDiscretionaryExpenses()));
		dataset.setValue("Default", new Double(DefaultExpenses));
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Monthly Expenses Statics", // chart title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel(ArrayList<Account> accountData) {
		JFreeChart chart = createChart(createDataset(accountData));
		return new ChartPanel(chart);
	}
}
