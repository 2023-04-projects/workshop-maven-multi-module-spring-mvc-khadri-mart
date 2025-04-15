package com.khadri.spring.mvc.fruits.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.dao.util.DaoUtil;
import com.khadri.spring.mvc.fruit.dao.mapper.FruitsDtoToFruitsBO;
import com.khadri.spring.mvc.fruits.dao.dto.FruitDto;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

@Component
public class FruitsDao {

	private DaoUtil daoUtil;

	private Connection con;

	private PreparedStatement pstmt;

	private Statement stmt;

	@Autowired
	public FruitsDao(DaoUtil daoUtil) {
		System.out.println("FruitsDao constructor");
		this.daoUtil = daoUtil;
	}

	@Autowired
	private FruitsDtoToFruitsBO mapper;

	public int insertFruits(FruitDto dto) {
		System.out.println("FruitsDao insertFruits(-)");
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("insert into fruits values(?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getQty());
			pstmt.setDouble(3, dto.getPrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
		}
		return result;
	}

	public List<FruitBO> searchFruit(String searchName) {
		System.out.println("FruitsDao selectFruit(-)");
		List<FruitDto> listOfData = new ArrayList<>();
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("select * from fruits where  name=?");
			pstmt.setString(1, searchName);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				FruitDto dto = new FruitDto();
				dto.setName(resultSet.getString(1));
				dto.setQty(resultSet.getInt(2));
				dto.setPrice(resultSet.getDouble(3));
				listOfData.add(dto);
			}
		} catch (Exception e) {
			System.out.println("exception occured in searchFruit :" + e.getMessage());
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
		return mapper.map(listOfData);

	}

	public int updateFruit(FruitBO bo) {
		System.out.println("Entered into updateFruit(-)");
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("UPDATE fruits SET qty = ?, price = ? WHERE name = ?");
			pstmt.setInt(1, bo.getFruitQty());
			pstmt.setDouble(2, bo.getFruitPrice());
			pstmt.setString(3, bo.getFruitName());

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

	public List<FruitBO> selectAllFruits() {
		System.out.println("FruitsDao selectAllFruits()");
		List<FruitDto> listOfFruits = new ArrayList<>();

		try {
			con = daoUtil.getNewConnection();
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from fruits");

			while (resultSet.next()) {
				FruitDto dto = new FruitDto();
				dto.setName(resultSet.getString(1));
				dto.setQty(resultSet.getInt(2));
				dto.setPrice(resultSet.getDouble(3));
				listOfFruits.add(dto);
			}

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mapper.map(listOfFruits);
	}

	public int deleteFruit(String name) {
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
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
