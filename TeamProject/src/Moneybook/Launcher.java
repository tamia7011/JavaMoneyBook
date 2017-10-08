package Moneybook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;

public class Launcher {
	
	//for sql
	static {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		
		//for sql
		String dburl = "jdbc:oracle:thin:@localhost:1521:OID";
		Connection con = DriverManager.getConnection(dburl, "system", "team1");
		Statement stmt = con.createStatement();
		
		
		//start main frame
		MainFrame frame = MainFrame.getInstance();
		frame.start(); 
	}

}
