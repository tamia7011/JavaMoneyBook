package Database;

import java.sql.*;
import java.util.TreeMap;
import java.util.Calendar;
import Constants.Constants;

public class MoneyData {

	public int price;
	//public int date;
	public String name;
	//public String expense;
	public String type;
	public String date;//yyyy-mm-dd
	
	public MoneyData () {
		price = 0; 
		//date = ;
		name = null;
		//expense = null;
		type = null;
	}
	
	
	public MoneyData (String in_name, int in_price, int in_date, String in_type) {
		price = in_price;
		//date = in_date;
		type = in_type;
		name = in_name;
	}
	

	
	//for Insert query
	public String toStringInsertQuery(String dbName) {
		//String Qtype = type.toString(); //to load type to dataBase
		String query = "INSERT INTO " + dbName + " (name, date_, price, type)" + " VALUES ('" + name + "', "+ date + ", "+ price + ", '"+ type + "')";
		return query;
	}
	
}

