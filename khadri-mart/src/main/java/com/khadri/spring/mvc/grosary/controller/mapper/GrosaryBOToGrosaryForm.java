package com.khadri.spring.mvc.grosary.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.grosary.controller.form.GrosaryForm;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Component
public class GrosaryBOToGrosaryForm {

	public List<GrosaryForm> map(List<GrosaryBO> bos) {

		List<GrosaryForm> listOfForms = bos.stream().map(eachBo -> {
			return new GrosaryForm(eachBo.getGrosaryName(), eachBo.getGrosaryQty(), eachBo.getGrosaryPrice());
		}).collect(Collectors.toList());
		return listOfForms;

	}

	public GrosaryForm map(GrosaryBO bo) {

		if (bo == null)
			return null;
		return new GrosaryForm(bo.getGrosaryName(), bo.getGrosaryQty(), bo.getGrosaryPrice());

	}

	

}
