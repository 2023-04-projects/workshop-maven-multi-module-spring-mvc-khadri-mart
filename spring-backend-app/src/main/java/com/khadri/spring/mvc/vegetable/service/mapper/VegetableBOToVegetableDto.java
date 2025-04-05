package com.khadri.spring.mvc.vegetable.service.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.vegetable.dao.dto.VegetableDto;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;


@Component
public class VegetableBOToVegetableDto {

	public VegetableDto map(VegetableBO vegBo) {
		VegetableDto dto = new VegetableDto();
		dto.setName(vegBo.getVegName());
		dto.setQty(vegBo.getVegQty());
		dto.setPrice(vegBo.getVegPrice());
		return dto;

	}

}
