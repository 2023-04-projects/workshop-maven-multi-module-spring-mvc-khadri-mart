package com.khadri.spring.mvc.grosary.dao;

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
import com.khadri.spring.mvc.grosary.dao.dto.GrosaryDto;
import com.khadri.spring.mvc.grosary.dao.mapper.GrosaryDtoToGrosaryBO;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Component
public class GrosaryDao {
	
	private Connection con;
	
	private PreparedStatement pstmt;
	
	private Statement stmt;

	
	private DaoUtil daoUtil;
	@Autowired
	private GrosaryDtoToGrosaryBO mapper;
	

	@Autowired
	public GrosaryDao(DaoUtil daoUtil) {
		System.out.println("GrosaryDao Constructor");
		this.daoUtil = daoUtil;
	}

	public int insertGrosary(GrosaryDto dto) {
		System.out.println("GrosaryDao insertGrosary(-)");
		int result = 0;
		try {
			con = daoUtil.getNewConnection();

			pstmt = con.prepareStatement("insert into grosary values(?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getQty());
			pstmt.setDouble(3, dto.getPrice());

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

	public List<GrosaryBO> selectGrosary(String searchName) {
		System.out.println("GrosaryDao selectGrosary(-)");
		List<GrosaryDto> listOfData = new ArrayList<>();
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("select * from grosary where name=?");
			pstmt.setString(1, searchName);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				GrosaryDto dto = new GrosaryDto();
				dto.setName(resultSet.getString(1));
				dto.setQty(resultSet.getInt(2));
				dto.setPrice(resultSet.getDouble(3));

				listOfData.add(dto);
			}

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
		return mapper.map(listOfData);

	}
	public int updateGrosary(GrosaryBO bo) {
		System.out.println("GrosaryDao updateGrosary(-)");
		int result = 0;

		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("UPDATE grosary SET qty=?, price=? WHERE name=?");

			pstmt.setInt(1, bo.getGrosaryQty());
			pstmt.setDouble(2, bo.getGrosaryPrice());
			pstmt.setString(3, bo.getGrosaryName());

			result = pstmt.executeUpdate();
			System.out.println(result + " record modified successfully!");

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
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
	public List<GrosaryBO> selectAllGrosary() {
		System.out.println("GrosaryDao selectAllGrosary()");
		List<GrosaryDto> listOfGrosary = new ArrayList<>();
		
		try {
			con = daoUtil.getNewConnection();
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from grosary");

			while (resultSet.next()) {
				GrosaryDto dto = new GrosaryDto();
				dto.setName(resultSet.getString(1));
				dto.setQty(resultSet.getInt(2));
				dto.setPrice(resultSet.getDouble(3));
				listOfGrosary.add(dto);
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

		return mapper.map(listOfGrosary); 
	}
	public int deleteGrosary(String name) {
		System.out.println("GrosaryDao deleteGrosary(-)");
		int result = 0;
		try {
			con = daoUtil.getNewConnection();

			pstmt = con.prepareStatement("DELETE FROM grosary WHERE name = ?");
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
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
