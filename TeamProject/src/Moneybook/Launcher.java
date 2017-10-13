package Moneybook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Constants.Constants;
import Database.*;

import java.io.IOException;

public class Launcher {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//for sql testing 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		DataAccessObject jdbc = DataAccessObject.getInstance();
		
		// Data data = new Data("name", 1000, 1027, Constants.expenseType.Fixed);
		MoneyData data = new MoneyData("chang", 1000, 1027, "he");
		
		jdbc.Insert("expenses", data);
		MoneyData[] dataArray = new MoneyData[10];
		int index = 0;
		//dataArray = jdbc.Select("expenses");
		//while (dataArray[index] != null) {
		//	System.out.println(dataArray[index].name);
		//	index++;
		//}
		
		//start main frame
		MainFrame frame = MainFrame.getInstance();
		frame.start(); 
	}
}