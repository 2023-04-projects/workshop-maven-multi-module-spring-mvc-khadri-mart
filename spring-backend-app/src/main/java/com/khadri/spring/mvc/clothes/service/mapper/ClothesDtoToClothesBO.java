package com.khadri.spring.mvc.clothes.service.mapper;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.clothes.dao.dto.ClothesDto;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;

@Component
public class ClothesDtoToClothesBO {
	public List<ClothesBO> map(List<ClothesDto> listOfData) {

		List<ClothesBO> listOfBos = listOfData.stream().map(eachDto -> {
			ClothesBO bo = new ClothesBO();
			bo.setClothesName(eachDto.getName());
			bo.setClothesPrice(eachDto.getPrice());
			bo.setClothesQty(eachDto.getQty());
			return bo;

		}).collect(Collectors.toList());
		return listOfBos;

	}

}
