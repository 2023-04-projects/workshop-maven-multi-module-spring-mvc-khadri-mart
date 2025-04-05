package com.khadri.spring.mvc.grosary.service;

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

		// write some business logic
 
		return dao.insertGrosary(dto);
	}

}
