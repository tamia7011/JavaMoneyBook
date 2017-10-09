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
		sql jdbc = sql.getInstance();
		
		// Data data = new Data("name", 1000, 1027, Constants.expenseType.Fixed);
		Data data = new Data("chang", 1000, 1027, "he");
		
		jdbc.Insert("expenses", data);
		System.out.println(jdbc.Select("expenses").toString());
		
		//start main frame
		MainFrame frame = MainFrame.getInstance();
		frame.start(); 
	}
}