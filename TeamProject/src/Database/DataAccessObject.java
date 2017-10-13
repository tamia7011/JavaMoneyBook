package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class DataAccessObject {
	
	private static DataAccessObject sqlInstance = null;
	static Connection con = null;
	Statement stmt = null;
	ArrayList<MoneyData> dataArray = new ArrayList<MoneyData>(); 
	
	public void Init() throws SQLException {
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(dburl, "system", "team1");
		Statement stmt = null;
	}
	
	private DataAccessObject() throws SQLException {
		Init();
	}
	
	public static DataAccessObject getInstance() throws SQLException {
		if (sqlInstance == null) {
			sqlInstance = new DataAccessObject();
		}
		return sqlInstance;
	}
	
	public ArrayList<MoneyData> Select(String dbName) throws SQLException {
		Statement stmt = null; 
		ResultSet rs = null;
		String query = "SELECT * " +
				"FROM " + dbName;
		System.out.println(query);
		try {
			//get data from dataBase
			stmt = con.createStatement();
			rs = stmt.executeQuery(query); 
			while (rs.next()) {
				MoneyData data = new MoneyData();	
				data.name = rs.getString("NAME");
				data.price = rs.getInt("PRICE");
				data.type = rs.getString("TYPE");
				//data.date
				
				dataArray.add(data);
				return dataArray;
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
			if (rs != null) {rs.close();}
		}
		return dataArray;
	}

	public void Insert(String dbName, MoneyData data) throws SQLException {
		Statement stmt = null;
		String query = data.toStringInsertQuery(dbName);
		try {
			//check insert command
			System.out.println(query);
			//put data to dataBase
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}
	}

}
