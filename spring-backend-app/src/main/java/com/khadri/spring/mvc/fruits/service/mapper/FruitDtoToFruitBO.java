package com.khadri.spring.mvc.fruits.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.khadri.spring.mvc.fruits.dao.dto.FruitDto;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

public class FruitDtoToFruitBO {

	public List<FruitBO> map(List<FruitDto> listOfData) {

		List<FruitBO> listOfBos = listOfData.stream().map(eachDto -> {
			FruitBO bo = new FruitBO();
			bo.setFruitName(eachDto.getName());
			bo.setFruitPrice(eachDto.getPrice());
			bo.setFruitQty(eachDto.getQty());
			  
			return bo;

		}).collect(Collectors.toList());
		return listOfBos;

	}
}
