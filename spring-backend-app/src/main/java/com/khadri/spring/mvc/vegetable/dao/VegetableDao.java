package com.khadri.spring.mvc.vegetable.dao;

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
import com.khadri.spring.mvc.vegetable.dao.dto.VegetableDto;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;
import com.khadri.spring.mvc.vegetable.service.mapper.VegetableDtoToVegetableBO;

@Component
public class VegetableDao {

	private DaoUtil daoUtil;
	private Connection con;
	private PreparedStatement pstmt;
	private VegetableDtoToVegetableBO mapper;
	private Statement stmt;

	@Autowired
	public VegetableDao(DaoUtil daoUtil, VegetableDtoToVegetableBO mapper) {
		System.out.println("VegetableDao constructor");
		this.daoUtil = daoUtil;
		this.mapper = mapper;
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
		return result;
	}

	public List<VegetableBO> selectVegetables(String searchName) {
		System.out.println("VegetableDao selectAllVegetables(-)");
		List<VegetableDto> listOfvegetables = new ArrayList<>();
		try {
			con = daoUtil.getNewConnection();

			pstmt = con.prepareStatement("select * from vegetable where name=?");
			pstmt.setString(1, searchName);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				VegetableDto form = new VegetableDto();
				form.setName(resultSet.getString(1));
				form.setQty(resultSet.getInt(2));
				form.setPrice(resultSet.getDouble(3));
				listOfvegetables.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		} finally {
			System.out.println("Executed finally block");

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
		return mapper.map(listOfvegetables);
	}

	public int updateVegetables(VegetableBO vegBo) {
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("UPDATE vegetable SET qty = ?, price = ? WHERE name = ?");
			pstmt.setInt(1, vegBo.getVegQty());
			pstmt.setDouble(2, vegBo.getVegPrice());
			pstmt.setString(3, vegBo.getVegName());

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

	public List<VegetableBO> selectAllVegetables() {
		System.out.println("VegetableDao selectAllVegetables()");
		List<VegetableDto> listOfVegetables = new ArrayList<>();

		try {
			con = daoUtil.getNewConnection();
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from vegetable");

			while (resultSet.next()) {
				VegetableDto vegDto = new VegetableDto();
				vegDto.setName(resultSet.getString(1));
				vegDto.setQty(resultSet.getInt(2));
				vegDto.setPrice(resultSet.getDouble(3));
				listOfVegetables.add(vegDto);
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

		return mapper.map(listOfVegetables);
	}

	public int deleteVegetables(String name) {
		int result = 0;
		try {
			con = daoUtil.getNewConnection();
			pstmt = con.prepareStatement("delete from vegetable where name=?");
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
