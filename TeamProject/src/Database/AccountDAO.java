package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class AccountDAO {
	private static String DBURL = "jdbc:mysql://125.130.223.88:3306/moneybook";
	private static AccountDAO Instance = null;
	private static Connection con = null;

	public void Init() throws SQLException {
		con = DriverManager.getConnection(DBURL, "root", "password");
	}

	private AccountDAO() throws SQLException {
		Init();
	}

	public static AccountDAO getInstance() {
		if (Instance == null) {
			try {
				Instance = new AccountDAO();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		return Instance;
	}

	public ArrayList<Account> selectAll() {
		// TODO: Statement -> PreparedStatement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT name,price,type,date FROM expense";

		ArrayList<Account> dataArray = new ArrayList<Account>();

		try {
			// get data from dataBase
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Account data = new Account();
				data.setName(rs.getString("name"));
				data.setPrice(rs.getInt("price"));
				data.setType(rs.getString("type"));
				data.setDate(rs.getString("date"));
				dataArray.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		return dataArray;
	}
	public ArrayList<Account> selectByDate(String date) {

		ArrayList<Account> dataArray = new ArrayList<Account>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT name,price,type,date FROM expense WHERE date=?";
		
		

		try { 

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Account data = new Account();
				data.setName(rs.getString("name"));
				data.setPrice(rs.getInt("price"));
				data.setType(rs.getString("type"));
				data.setDate(rs.getDate("date").toString());

				System.out.println(data.getDate());
				dataArray.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		return dataArray;
	}
	public void Insert(Account data) {
		String query = "INSERT INTO expense(name,price,type,date) VALUES (?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, data.getName());
			pstmt.setInt(2, data.getPrice());
			pstmt.setString(3, data.getType());
			pstmt.setString(4, data.getDate());
			System.out.println(data.getDate());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
