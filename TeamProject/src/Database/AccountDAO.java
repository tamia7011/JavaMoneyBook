package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Container;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;


public class AccountDAO {
	private static String DBURL = "jdbc:mysql://125.130.223.88:3306/moneybook";
	private static AccountDAO Instance = null;
	private static Connection con = null;
	public JTable table;
	public BinarySearchArrayList bsals;
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
	
	public ArrayList<Account> selectName(String values){
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT name,price,type,date FROM expense";
		bsals = new BinarySearchArrayList();
		ArrayList<Account> dataArray = new ArrayList<Account>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> name2 = new ArrayList<String>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		while (rs.next()) {
			Account data = new Account();
			data.setName(rs.getString("name"));
			data.setPrice(rs.getInt("price"));
			data.setType(rs.getString("type"));
			data.setDate(rs.getString("date"));
			dataArray.add(data);
			
			name.add(rs.getString("name"));
			name2.add(rs.getString("name").substring(0 ,1));
			
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
		
		Collections.sort(name2, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s1.compareToIgnoreCase(s2);
		    }
		});
		
		ArrayList<String> name3 = name2;

		int findIndex = bsals.binarySearch(name3, values.substring(0,1));
		while (findIndex != -1) {
			positions.add(findIndex);
			name3.remove(findIndex);
			findIndex = bsals.binarySearch(name3, values.substring(0,1));
			if (findIndex != -1)
				findIndex += name2.size() - name3.size();
		}
		
		Collections.sort(name, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s1.compareToIgnoreCase(s2);
		    }
		});
		
		Collections.sort(dataArray, new Comparator<Account>() {
		    @Override
		    public int compare(Account a1, Account a2) {
		        return a1.getName().compareToIgnoreCase(a2.getName());
		    }
		});
		
		ArrayList<Account> findAccounts = new ArrayList<Account>();
		for(int i : positions) {
			if (name.get(i).equalsIgnoreCase(values))
				findAccounts.add(dataArray.get(i));
		}
		
		return findAccounts;
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
		String query = "SELECT id,name,price,type,date FROM expense WHERE date=?";

		try { 

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Account data = new Account();
				data.setId(rs.getInt("id"));
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

	public void Delete(String name) {
		String query = "DELETE FROM expense WHERE name='" + name + "'";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);

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
	
	public void Update(int id, int column, Object value) {
		String query;
		PreparedStatement pstmt = null;
		System.out.println(column);
		try {
		
			switch (column) {
			case 1:
				query = "UPDATE expense SET type= '" + value.toString() + "' WHERE id=" + id;
				break;
			case 2:
				query = "UPDATE expense SET name= '" + value.toString() + "' WHERE id=" + id;
				break;
			case 3:
				query = "UPDATE expense SET price= " + Integer.valueOf((String) value) + " WHERE id=" + id;
				break;
			default:
				query = "";
				break;
			}
			
			pstmt = con.prepareStatement(query);
			
//			pstmt.setString(1, data.getName());
//			pstmt.setInt(2, data.getPrice());
//			pstmt.setString(3, data.getType());
//			pstmt.setString(4, data.getDate());
//			System.out.println(data.getDate());
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
