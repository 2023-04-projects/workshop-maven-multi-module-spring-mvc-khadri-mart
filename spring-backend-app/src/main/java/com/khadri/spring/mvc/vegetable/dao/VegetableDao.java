package com.khadri.spring.mvc.vegetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.fruits.dao.util.DaoUtil;
import com.khadri.spring.mvc.vegetable.dao.dto.VegetableDto;

@Component
public class VegetableDao {

	private DaoUtil daoUtil;

	private Connection con;

	private PreparedStatement pstmt;

	@Autowired
	public VegetableDao(DaoUtil daoUtil) {
		System.out.println("FruitsDao constructor");
		this.daoUtil = daoUtil;
	}

	public int insertVegetables(VegetableDto dto) {
		System.out.println("VegetableDao insertVegetables(-)");
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("insert into vegetable values(?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getQty());
			pstmt.setDouble(3, dto.getPrice());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println("Executed finally block");
			closeResources();
		}
		return result;
	}

	private void closeResources() {
		try {

			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
