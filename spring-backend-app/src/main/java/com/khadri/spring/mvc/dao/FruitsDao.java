package com.khadri.spring.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khadri.spring.mvc.from.FruitsForm;

import jakarta.servlet.ServletContext;

public class FruitsDao {
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private String Url;
	private String User;
	private String Password;

	public FruitsDao(ServletContext context) {
		this.Url = context.getInitParameter("Url");
		this.User = context.getInitParameter("User");
		this.Password = context.getInitParameter("Password");
	}

	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(Url, User, Password);
	}

	public int insertFruits(com.khadri.spring.mvc.from.FruitsForm form) {
		System.out.println("FruitsDao insertFruits(-)");
		int result = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("insert into fruits values(?,?,?)");
			pstmt.setString(1, form.getItemName());
			pstmt.setInt(2, form.getItemQty());
			pstmt.setDouble(3, form.getItemPrice());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public int updateFruits(com.khadri.spring.mvc.from.FruitsForm form) {
		int result = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE fruits SET qty = ?, price = ? WHERE name = ?");
			pstmt.setInt(1, form.getItemQty());
			pstmt.setDouble(2, form.getItemPrice());
			pstmt.setString(3, form.getItemName());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Executed finally block");
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<com.khadri.spring.mvc.from.FruitsForm> selectFruits(String Item_name) {
		System.out.println("fruitsDao selectFruits(-)");
		List<com.khadri.spring.mvc.from.FruitsForm> listOfData = new ArrayList<>();
		try {
			con = getConnection();

			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from fruits where name='" + Item_name + "'");

			while (resultSet.next()) {
				FruitsForm form = new FruitsForm(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
				listOfData.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
			try {
				stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfData;

	}

	public List<FruitsForm> selectAllFruits() {
		System.out.println("fruitsDao selectAllFruits(-)");
		List<FruitsForm> listOfFruits = new ArrayList<>();
		try {
			con = getConnection();

			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from fruits");

			while (resultSet.next()) {
				FruitsForm form = new com.khadri.spring.mvc.from.FruitsForm(resultSet.getString(1), resultSet.getInt(2), resultSet.getDouble(3));
				listOfFruits.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
			try {
				stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfFruits;

	}

	public int deleteFruits(String name) {
		int result = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("delete from fruits where name=?");
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Executed finally block");
			try {
				pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
