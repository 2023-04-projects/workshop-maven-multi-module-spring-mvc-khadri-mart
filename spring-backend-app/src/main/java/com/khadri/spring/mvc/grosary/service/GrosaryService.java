package com.khadri.spring.mvc.grosary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.grosary.dao.GrosaryDao;
import com.khadri.spring.mvc.grosary.dao.dto.GrosaryDto;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;
import com.khadri.spring.mvc.grosary.service.mapper.GrosaryBOToGrosaryDto;

@Service
public class GrosaryService {

	private GrosaryDao dao;

	private GrosaryBOToGrosaryDto mapper;

	@Autowired
	public GrosaryService(GrosaryDao dao, GrosaryBOToGrosaryDto mapper) {
		System.out.println("GrosaryService constructor");
		this.dao = dao;
		this.mapper = mapper;
	}

	public int addGrosaryItem(GrosaryBO grosaryBO) {
		System.out.println("Entered into Grosary Service");
		GrosaryDto dto = mapper.map(grosaryBO);

		return dao.insertGrosary(dto);
	}

	public List<GrosaryBO> searchGrosaryItem(String searchName) {
		System.out.println("Entered into Grosary Service");
		List<GrosaryBO> searchGrosaryBos = dao.selectGrosary(searchName);
		return searchGrosaryBos;

	}

	public GrosaryBO getItemByName(String grosaryName) {
		System.out.println("entered into  getItemByName in GrosaryService");
		List<GrosaryBO> list = dao.selectGrosary(grosaryName);

	
		for (GrosaryBO item : list) {
	        if (item.getGrosaryName().equalsIgnoreCase(grosaryName)) {
	            return item;
	        }

	}
		return null;
	}

	public int updateGrosaryItem(GrosaryBO bo) {

		System.out.println("update grosaryItem");
		return dao.updateGrosary(bo);
	}

	public List<GrosaryBO> viewAllGrosary() {
		return dao.selectAllGrosary();
	}

	public int deleteGrosaryItem(String name) {
		return dao.deleteGrosary(name);

	}

	
}
