package Database;

import java.sql.SQLException;

import Moneybook.MainFrame;

public class budgetData {
	private static budgetData instance;
	public int salary;
	private int totalExpenses;
	private int fixedExpenses;
	private int flexibleExpenses;
	private int discretionaryExpenses;
	
	public static budgetData getInstance() {
		if(instance == null) {
			instance = new budgetData();
			return instance;
		}
		return instance;
	}
	

	private void init() {
		totalExpenses = 0;
		fixedExpenses = 0;
		flexibleExpenses = 0;
		discretionaryExpenses = 0;
	}
	
	private budgetData() {
		init();
	}
	
	public void calculateDataset(MoneyData moneydata) {
		if (moneydata.type.equals("Fixed")) {
			fixedExpenses += moneydata.price;
		}
		
		else if (moneydata.type.equals("Flexible")) {
			flexibleExpenses += moneydata.price;
		}
		
		else {
			discretionaryExpenses += moneydata.price;
		}
		
		totalExpenses += moneydata.price;
	}
	public int getFixedExpenses() {
		return fixedExpenses;
	}
	
	public int getFlexibleExpenses() {
		return flexibleExpenses;
	}
	
	public int getDiscretionaryExpenses() {
		return discretionaryExpenses;
	}

	public int getTotalExpenses() {
		return totalExpenses;
	}

	
}
