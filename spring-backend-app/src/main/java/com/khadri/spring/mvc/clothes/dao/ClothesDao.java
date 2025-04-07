package com.khadri.spring.mvc.clothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.clothes.dao.dto.ClothesDto;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;
import com.khadri.spring.mvc.clothes.service.mapper.ClothesDtoToClothesBO;
import com.khadri.spring.mvc.dao.util.DaoUtil;

@Component
public class ClothesDao {
	private Connection con;
	private PreparedStatement pstmt;
	private DaoUtil daoUtil;
	private ClothesDtoToClothesBO mapper;
	private Statement stmt;

	@Autowired
	public ClothesDao(DaoUtil daoUtil, ClothesDtoToClothesBO mapper) {
		System.out.println("ClothesDao constructor");
		this.daoUtil = daoUtil;
		this.mapper = mapper;
	}

	public int insertClothes(ClothesDto dto) {
		System.out.println("ClothesDao insertClothes(-)");
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("insert into clothes values(?,?,?)");
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

	public List<ClothesBO> selectClothes(String searchName) {
		System.out.println("ClothesDao selectClothes(-)");
		List<ClothesDto> listOfData = new ArrayList<>();
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("select * from clothes where name=?");
			pstmt.setString(1, searchName);
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ClothesDto form = new ClothesDto();
				form.setName(resultSet.getString(1));
				form.setQty(resultSet.getInt(2));
				form.setPrice(resultSet.getDouble(3));

				listOfData.add(form);
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

	public int updateClothes(ClothesBO bo) {
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("UPDATE clothes SET qty = ?, price = ? WHERE name = ?");
			pstmt.setInt(1, bo.getClothesQty());
			pstmt.setDouble(2, bo.getClothesPrice());
			pstmt.setString(3, bo.getClothesName());

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

	public List<ClothesBO> selectAllClothes() {
		System.out.println("ClothesDao selectAllClothes()");
		List<ClothesDto> listOfClothes = new ArrayList<>();
		
		try {
			con = daoUtil.getNewConnection();
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from clothes");

			while (resultSet.next()) {
				ClothesDto dto = new ClothesDto();
				dto.setName(resultSet.getString(1));
				dto.setQty(resultSet.getInt(2));
				dto.setPrice(resultSet.getDouble(3));
				listOfClothes.add(dto);
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

		return mapper.map(listOfClothes); 
	}
	public int deleteClothes(String name) {
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("delete from clothes where name=?");
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
