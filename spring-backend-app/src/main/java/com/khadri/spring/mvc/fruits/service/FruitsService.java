package com.khadri.spring.mvc.fruits.service;

import java.util.List;

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

	public int addFruitsItem(FruitBO fruitBO) {
		System.out.println("Entered into Fruits Service");
		FruitDto dto = mapper.map(fruitBO);
		return dao.insertFruits(dto);
	}

	public List<FruitBO> searchFruitItem(String searchName) {
		System.out.println("Entered into Fruit Service");
		List<FruitBO> searchFruitBos = dao.searchFruit(searchName);
		return searchFruitBos;
	}
	public List<FruitBO> searchFruit(String searchName) {
		System.out.println("Entered into Fruits Service");
		List<FruitBO> searchFruitBos = dao.searchFruit(searchName);
		return searchFruitBos;

	}

	public FruitBO getItemByName(String fruitsName) {
		System.out.println("entered into  getItemByName in FruitsService");
		List<FruitBO> list = dao.searchFruit(fruitsName);

		for (FruitBO item : list) {
			if (item.getFruitName().equalsIgnoreCase(fruitsName)) {
				return item;
			}

		}
		return null;
	}

	public int updateFruitItem(FruitBO bo) {

		System.out.println("update fruitsItem");
		return dao.updateFruit(bo);
	}

	public List<FruitBO> viewAllFruits() {
		return dao.selectAllFruits();
	}

	public int deleteFruitsItem(String name) {
		return dao.deleteFruit(name);

	}

}
