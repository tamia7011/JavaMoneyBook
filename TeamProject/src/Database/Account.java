package Database;

import java.sql.*;
import java.util.TreeMap;
import java.util.Calendar;
import Constants.Constants;
import Constants.Constants.expenseType;

public class Account {

	private int price; 
	private int id;
	private String name; 
	private String type;//Fixed,Flexible,Waste,Default
	private Date date; /*yyyy-mm-dd*/
	
	public Account () {
		price = 0;  
		id = 0;
		name = ""; 
		type = expenseType.Default.toString();
		date = null;
	} 
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
}

