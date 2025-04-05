package com.khadri.spring.mvc.fruits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.fruits.dao.FruitsDao;
import com.khadri.spring.mvc.fruits.dao.dto.FruitDto;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;
import com.khadri.spring.mvc.fruits.service.mapper.FruitBOToFruitDto;

@Service
public class FruitsService {

	private FruitsDao dao;

	private FruitBOToFruitDto mapper;

	@Autowired
	public FruitsService(FruitsDao dao, FruitBOToFruitDto mapper) {
		System.out.println("FruitsService constructor");
		this.dao = dao;
		this.mapper = mapper;
	}

	public int addFruitItem(FruitBO fruitBO) {
		System.out.println("Entered into Fruits Service");
		FruitDto dto = mapper.map(fruitBO);

		// write some business logic
 
		return dao.insertFruits(dto);
	}

}
