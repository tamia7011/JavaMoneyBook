package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.util.Calendar;

public class sql {
	public static void Select(Connection con, String dbName) throws SQLException {
		Statement stmt = null;
		String query = "select NAME, DATE, PRICE, TYPE" +
				"from " + dbName + ".EXPENSES";
		try {
			//get data from dataBase
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("NAME");
				int date = rs.getInt("DATE");
				float price = rs.getInt("PRICE");
				String type = rs.getString("TYPE");
				
				//TODO: deal with data
				
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			if (stmt != null) { stmt.close(); }
		}
	}

}
