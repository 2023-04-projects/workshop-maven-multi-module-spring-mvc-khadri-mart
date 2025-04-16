package com.khadri.spring.mvc.fruits.service.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.fruits.dao.dto.FruitDto;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

@Component
public class FruitBOToFruitDto {

	public FruitDto map(FruitBO fruitBO) {
		FruitDto dto = new FruitDto();
		dto.setName(fruitBO.getFruitName());
		dto.setPrice(fruitBO.getFruitPrice());
		dto.setQty(fruitBO.getFruitQty() != null ? fruitBO.getFruitQty() : 0);
		return dto;
	}

}
