package com.khadri.spring.mvc.vegetable.service.mapper;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.clothes.dao.dto.ClothesDto;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;
import com.khadri.spring.mvc.vegetable.dao.dto.VegetableDto;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;

@Component
public class VegetableDtoToVegetableBO {
	public List<VegetableBO> map(List<VegetableDto> listDto) {

		List<VegetableBO> listOfBos = listDto.stream().map(eachDto -> {
			VegetableBO vegBo = new VegetableBO();
			vegBo.setVegName(eachDto.getName());
			vegBo.setVegQty(eachDto.getQty());
			vegBo.setVegPrice(eachDto.getPrice());
			return vegBo;

		}).collect(Collectors.toList());
		return listOfBos;

	}

}
