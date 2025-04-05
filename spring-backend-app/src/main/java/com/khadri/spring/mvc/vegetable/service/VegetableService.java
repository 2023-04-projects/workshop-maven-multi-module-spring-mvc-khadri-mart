package com.khadri.spring.mvc.vegetable.service;

import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.vegetable.dao.VegetableDao;
import com.khadri.spring.mvc.vegetable.dao.dto.VegetableDto;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;
import com.khadri.spring.mvc.vegetable.service.mapper.VegetableBOToVegetableDto;

@Service
public class VegetableService {

	private VegetableDao dao;

	private VegetableBOToVegetableDto mapper;

	public VegetableService(VegetableDao dao, VegetableBOToVegetableDto mapper) {
		System.out.println("VegetableService Constructor");
		this.dao = dao;
		this.mapper = mapper;
	}

	public int addVegetables(VegetableBO vegBo) {
		System.out.println("Entered into Vegetable Service");
		VegetableDto dto = mapper.map(vegBo);

		return dao.insertVegetables(dto);

	}

}
