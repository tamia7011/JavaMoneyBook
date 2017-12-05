package Database;

import java.sql.Connection;
import java.sql.Date;
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

import Constants.Constants;

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

	public ArrayList<Account> selectName(String values) {
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT name,price,type,date FROM expense WHERE email=" + Constants.Email;
		bsals = new BinarySearchArrayList();
		ArrayList<Account> dataArray = new ArrayList<Account>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> positions = new ArrayList<Integer>();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Account data = new Account();
				data.setName(rs.getString("name"));
				data.setPrice(rs.getInt("price"));
				data.setType(rs.getString("type"));
				data.setDate(rs.getDate("date"));
				dataArray.add(data);
				name.add(rs.getString("name"));
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

		Collections.sort(name, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		int findIndex = bsals.binarySearch(name, values);
		positions.add(findIndex);
		Collections.sort(dataArray, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				return a1.getName().compareToIgnoreCase(a2.getName());
			}
		});

		ArrayList<Account> findAccounts = new ArrayList<Account>();
		for (int i : positions) {
			if (name.get(i).equalsIgnoreCase(values))
				findAccounts.add(dataArray.get(i));
		}

		return findAccounts;
	}

	public ArrayList<Account> selectAll() {
		// TODO: Statement -> PreparedStatement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT name,price,type,date FROM expense WHERE email='" + Constants.Email + "'";

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
				data.setDate(rs.getDate("date"));
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

	public ArrayList<Account> selectByDate(Date date) {

		ArrayList<Account> dataArray = new ArrayList<Account>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT id,name,price,type,date FROM expense WHERE date='" + date + "'and email='"
				+ Constants.Email + "'";
		try {

			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Account data = new Account();
				data.setId(rs.getInt("id"));
				data.setName(rs.getString("name"));
				data.setPrice(rs.getInt("price"));
				data.setType(rs.getString("type"));
				data.setDate(rs.getDate("date"));

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

	public Account selectinsertName(String name) {
		// TODO: Statement -> PreparedStatement
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(Constants.Email);
		String query = "SELECT id,name,price,type,date FROM expense WHERE name='" + name + "'and email='"
				+ Constants.Email + "'";
		Account data = new Account();

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.setId(rs.getInt("id"));
				data.setName(rs.getString("name"));
				data.setPrice(rs.getInt("price"));
				data.setType(rs.getString("type"));
				data.setDate(rs.getDate("date"));
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
		return data;
	}

	public void Insert(Account data) {
		String query = "INSERT INTO expense(name,price,type,date,email) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, data.getName());
			pstmt.setInt(2, data.getPrice());
			pstmt.setString(3, data.getType());
			pstmt.setDate(4, data.getDate());
			pstmt.setString(5, Constants.Email);
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
		String query = "DELETE FROM expense WHERE name='" + name + "'" + "and email = '" + Constants.Email + "'";
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
				query = "UPDATE expense SET type= '" + value.toString() + "' WHERE id=" + id + "and email='"
						+ Constants.Email + "'";
				break;
			case 2:
				query = "UPDATE expense SET name= '" + value.toString() + "' WHERE id=" + id + "and email='"
						+ Constants.Email + "'";
				break;
			case 3:
				query = "UPDATE expense SET price= " + Integer.valueOf((String) value) + " WHERE id=" + id
						+ "and email='" + Constants.Email + "'";
				break;
			default:
				query = "";
				break;
			}

			pstmt = con.prepareStatement(query);

			// pstmt.setString(1, data.getName());
			// pstmt.setInt(2, data.getPrice());
			// pstmt.setString(3, data.getType());
			// pstmt.setString(4, data.getDate());
			// System.out.println(data.getDate());
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

	public void updateTotalBudget(MonthAccount budget) {
		String query;
		PreparedStatement pstmt = null;
		try {

			query = "UPDATE total SET fixed=" + Integer.toString(budget.getFixedExpenses()) + ", flexible="
					+ Integer.toString(budget.getFlexibleExpenses()) + ", discretionary="
					+ Integer.toString(budget.getDiscretionaryExpenses()) + ", total="
					+ Integer.toString(budget.getTotalExpenses()) + ", budget=" + Integer.toString(budget.getBudget())
					+ ", salary=" + Integer.toString(budget.getSalary()) + " WHERE email='" + Constants.Email + "'";

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

	public void UPDATEMileage(int mileage) {
		String query;
		PreparedStatement pstmt = null;
		System.out.println(Integer.toString(mileage));
		try {

			query = "UPDATE total SET mileage='" + Integer.toString(mileage) + "' WHERE email='" + Constants.Email
					+ "'";

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

	public tempRepository setBudget() {

		tempRepository data = new tempRepository();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT fixed,flexible,discretionary,salary,total,budget,mileage FROM total WHERE email=?";

		try {

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, Constants.Email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.setFixedExpenses(rs.getInt("fixed"));
				data.setFlexibleExpenses(rs.getInt("flexible"));
				data.setDiscretionaryExpenses(rs.getInt("discretionary"));
				data.setTotalExpenses(rs.getInt("total"));
				data.setSalary(rs.getInt("salary"));
				data.setBudget(rs.getInt("budget"));
				data.setMileage(rs.getInt("mileage"));

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
		return data;
	}

}
