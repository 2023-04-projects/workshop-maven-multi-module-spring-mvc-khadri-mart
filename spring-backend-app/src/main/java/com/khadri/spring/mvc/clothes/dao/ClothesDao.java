package com.khadri.spring.mvc.clothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.clothes.dao.dto.ClothesDto;
import com.khadri.spring.mvc.dao.util.DaoUtil;
@Component
public class ClothesDao {
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private DaoUtil daoUtil;

	public ClothesDao(DaoUtil daoUtil) {
		System.out.println("ClothesDao constructor");
		this.daoUtil = daoUtil;
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

}
