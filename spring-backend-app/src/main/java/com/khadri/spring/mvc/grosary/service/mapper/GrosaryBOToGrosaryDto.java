package com.khadri.spring.mvc.grosary.service.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.grosary.dao.dto.GrosaryDto;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Component
public class GrosaryBOToGrosaryDto {

	public GrosaryDto map(GrosaryBO GrosaryBO) {
		GrosaryDto dto = new GrosaryDto();
		dto.setName(GrosaryBO.getGrosaryName());
		dto.setPrice(GrosaryBO.getGrosaryPrice());
		dto.setQty(GrosaryBO.getGrosaryQty());
		return dto;
	}
}
