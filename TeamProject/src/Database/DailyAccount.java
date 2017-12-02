package Database;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Constants.Constants;
import Moneybook.MainFrame;
import Database.AccountDAO;

public class DailyAccount {
	private static DailyAccount instance;
	
	private static String DEFAULT_MONTH = "0000-00";
	public String month = DEFAULT_MONTH;//YYYY-MM
	private int salary;
	private String name = "jihoson94@gmail.com";
	private AccountDAO DAO;
	private ArrayList<Account> todayDataArray;
	private int totalPrice;
	private Date date;

	public DailyAccount(Date in_date) {
		DAO = AccountDAO.getInstance();
		todayDataArray = new ArrayList<Account>();
		totalPrice = 0;
		date = in_date;
		name = "user";
	}
	
	
	public void calculateDataset() {
		todayDataArray = DAO.selectByDate(date);
		for (Account tempData : todayDataArray) {
			totalPrice += tempData.getPrice();
		}
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
}
