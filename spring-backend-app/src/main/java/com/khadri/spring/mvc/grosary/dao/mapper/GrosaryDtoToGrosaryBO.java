package com.khadri.spring.mvc.grosary.dao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.grosary.dao.dto.GrosaryDto;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Component
public class GrosaryDtoToGrosaryBO {
	public List<GrosaryBO> map(List<GrosaryDto> dtos) {

		List<GrosaryBO> listOfBos = dtos.stream().map(eachDto -> {
			GrosaryBO bo = new GrosaryBO();
			bo.setGrosaryName(eachDto.getName());
			bo.setGrosaryPrice(eachDto.getPrice());
			bo.setGrosaryQty(eachDto.getQty());
			return bo;

		}).collect(Collectors.toList());
		return listOfBos;

	}

}
