package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.util.Calendar;

public class sql {
	
	static Connection con = null;
	String dburl;
	Statement stmt = null;
	
	public sql() throws SQLException {
		
		String dburl = "jdbc:oracle:thin:@localhost:1521:OID";
		Connection con = DriverManager.getConnection(dburl, "system", "team1");
		Statement stmt = null;
		
	}
	
	public Data[] Select(String dbName) throws SQLException {
		Statement stmt = null;
		Data[] data = null;
		int index = 0;
		String query = "SELECT NAME, DATE, PRICE, TYPE" +
				"from " + dbName;
		try {
			//get data from dataBase
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				String name = rs.getString("NAME");
				int date = rs.getInt("DATE");
				int price = rs.getInt("PRICE");
				String type = rs.getString("TYPE");
				
				data[index].name = name;
				data[index].date = date;
				data[index].price = price;
				data[index].type = Constants.Constants.expenseType.valueOf(type);
				
				index++;
				//TODO: change int date into Calendar date
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}
		return data;
	}

	public void Insert(String dbName, Data data) throws SQLException {
		Statement stmt = null;
		String query = data.toStringInsertQuery(dbName);
		try {
			//put data to dataBase
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			ResultSet rs = stmt.executeQuery(query);
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}
	}

}
