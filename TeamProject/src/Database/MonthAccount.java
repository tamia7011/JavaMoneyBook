package Database;

import java.sql.SQLException;

import Constants.Constants;
import Moneybook.MainFrame;

public class MonthAccount {
	private static MonthAccount instance;
	
	private static String DEFAULT_MONTH = "0000-00";
	public String month = DEFAULT_MONTH;//YYYY-MM
	public int salary;
	 
	
	private int totalExpense;
	private int fixedExpense;
	private int flexibleExpense;
	private int discretionaryExpense;
	
	public static MonthAccount getInstance() {
		if(instance == null) {
			instance = new MonthAccount();
			return instance;
		}
		return instance;
	}
	

	private void init() {
		totalExpense = 0;
		fixedExpense = 0;
		flexibleExpense = 0;
		discretionaryExpense = 0;
	}
	
	private MonthAccount() {
		init();
	}
	
	public void calculateDataset(Account moneydata) {
		String type = moneydata.getType();
		if (type == Constants.expenseType.Fixed.toString()) {
			fixedExpense += moneydata.getPrice();
		}
		
		else if (type == Constants.expenseType.Flexible.toString()) {
			flexibleExpense += moneydata.getPrice();
		}
		
		else {
			discretionaryExpense += moneydata.getPrice();
		}
		
		totalExpense += moneydata.getPrice();
	}
	public int getFixedExpenses() {
		return fixedExpense;
	}
	
	public int getFlexibleExpenses() {
		return flexibleExpense;
	}
	
	public int getDiscretionaryExpenses() {
		return discretionaryExpense;
	}

	public int getTotalExpenses() {
		return totalExpense;
	}
	public int getSalary() {
		return salary-totalExpense;
	}
	
}
