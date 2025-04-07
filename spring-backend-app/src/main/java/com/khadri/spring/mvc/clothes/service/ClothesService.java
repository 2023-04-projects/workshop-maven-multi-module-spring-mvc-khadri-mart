package com.khadri.spring.mvc.clothes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.clothes.dao.ClothesDao;
import com.khadri.spring.mvc.clothes.dao.dto.ClothesDto;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;
import com.khadri.spring.mvc.clothes.service.mapper.ClothesBOToClothesDto;

@Service
public class ClothesService {
	private ClothesDao dao;

	private ClothesBOToClothesDto mapper;

	@Autowired
	public ClothesService(ClothesDao dao, ClothesBOToClothesDto mapper) {
		System.out.println("Clothesservice constructor");
		this.dao = dao;
		this.mapper = mapper;
	}

	public int addClothesItems(ClothesBO clothesBO) {
		System.out.println("Entered into Clothes Service");
		ClothesDto dto = mapper.map(clothesBO);

		return dao.insertClothes(dto);
	}

	public List<ClothesBO> searchClothesItem(String searchName) {
		System.out.println("Entered into Clothes Service");
		List<ClothesBO> searchClothesBos = dao.selectClothes(searchName);
		return searchClothesBos;

	}

	public ClothesBO getItemByName(String clothesName) {
		System.out.println("entered into  getItemByName in ClothesService");
		List<ClothesBO> list = dao.selectClothes(clothesName);

		return list.isEmpty() ? null : list.get(0);

	}

	public void updateClothesItem(ClothesBO bo) {

		System.out.println("update clothesItem");
		dao.updateClothes(bo);
	}

	public List<ClothesBO> viewAllClothes() {
		return dao.selectAllClothes();
	}

	public int deleteClothesItem(String name) {
		return dao.deleteClothes(name);
	}
}
