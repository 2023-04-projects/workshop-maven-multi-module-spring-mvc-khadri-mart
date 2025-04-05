package com.khadri.spring.mvc.clothes.service;

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

}
