package com.khadri.spring.mvc.fruit.dao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.fruits.dao.dto.FruitDto;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

@Component
public class FruitsDtoToFruitsBO {

	public List<FruitBO> map(List<FruitDto> dots) {
		List<FruitBO> listOfBos = dots.stream().map(eachDto -> {
			FruitBO bo = new FruitBO();
			bo.setFruitName(eachDto.getName());
			bo.setFruitPrice(eachDto.getPrice());
			bo.setFruitQty(eachDto.getQty());
			return bo;
		}).collect(Collectors.toList());

		return listOfBos;

	}
}
