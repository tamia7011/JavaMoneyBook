package Database;

import java.sql.*;
import java.util.TreeMap;
import java.util.Calendar;
import Constants.Constants;

public class Data {
	
	//created TreeMap for date and price
	//TreeMap<Date,Double> dates = new TreeMap<Date, Double>();
	int price;
	int score;
	Calendar date;
	String name;
	String expense;
	Constants.expenseType type;
	
	Data (String in_name, int in_price, Calendar in_date, String in_expense, Constants.expenseType in_type) {
		price = in_price;
		date = in_date;
		expense = in_expense;
		type = in_type;
		name = in_name;
	}
	
	public void DoCalculate(){
		//calculate the score of data
		score = 10;
	}
	
	public int getScore() {
		int priceScore = price / 1000;
		int typeScore;
		
		if (type == Constants.expenseType.Fixed) {
			typeScore = 1000;
		}
		else if (type == Constants.expenseType.Flexible) {
			typeScore = 700;
		}
		else {
			typeScore = 0;
		}		
		score = typeScore + priceScore;
		return score; 
	}
	
}

