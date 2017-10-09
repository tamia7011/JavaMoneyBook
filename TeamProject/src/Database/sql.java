package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.util.Calendar;

public class sql {
	
	private static sql sqlInstance = null;
	static Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Data[] dataArray;
	
	public void Init() throws SQLException {
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(dburl, "system", "team1");
		Statement stmt = null;
	}
	
	private sql() throws SQLException {
		Init();
	}
	
	public static sql getInstance() throws SQLException {
		if (sqlInstance == null) {
			sqlInstance = new sql();
		}
		return sqlInstance;
	}
	
	public Data[] Select(String dbName) throws SQLException {
		Statement stmt = null;
		int index = 0;
		String query = "SELECT * " +
				"FROM " + dbName;
		System.out.println(query);
		try {
			//get data from dataBase
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			dataArray = new Data[100];
			while (rs.next()) {
				dataArray[index] = new Data();
				String name = rs.getString("NAME");
				int date = rs.getInt("DATE_");
				int price = rs.getInt("PRICE");
				String type = rs.getString("TYPE");

				dataArray[index].name = name;
				dataArray[index].date = date;
				dataArray[index].price = price;
				//data[index].type = Constants.Constants.expenseType.valueOf(type);
				dataArray[index].type = type;
				
				index++;
				//TODO: change int date into Calendar date
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
			if (rs != null) {rs.close();}
		}
		return dataArray;
	}

	public void Insert(String dbName, Data data) throws SQLException {
		Statement stmt = null;
		String query = data.toStringInsertQuery(dbName);
		try {
			//check insert command
			System.out.println(query);
			//put data to dataBase
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
			if (rs != null) {rs.close();}
		}
	}

}
