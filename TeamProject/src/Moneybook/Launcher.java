package Moneybook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;

public class Launcher {
	
	
	public static void main(String[] args) throws SQLException {
		
		
		
		//start main frame
		MainFrame frame = MainFrame.getInstance();
		frame.start(); 
	}

}
