package com.khadri.spring.mvc.grosary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.dao.util.DaoUtil;
import com.khadri.spring.mvc.grosary.dao.dto.GrosaryDto;

@Component
public class GrosaryDao {
	private Connection con;
	PreparedStatement pstmt;
	private DaoUtil daoUtil;

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

	

	}

	