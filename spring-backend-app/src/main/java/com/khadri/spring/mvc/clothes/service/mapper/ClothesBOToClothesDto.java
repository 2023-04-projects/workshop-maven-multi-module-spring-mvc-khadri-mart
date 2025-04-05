package com.khadri.spring.mvc.clothes.service.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.clothes.dao.dto.ClothesDto;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;

@Component
public class ClothesBOToClothesDto {
	public ClothesDto map(ClothesBO clothesBO) {
		ClothesDto dto = new ClothesDto();
		dto.setName(clothesBO.getClothesName());
		dto.setPrice(clothesBO.getClothesPrice());
		dto.setQty(clothesBO.getClothesQty());
		return dto;
	}
}
