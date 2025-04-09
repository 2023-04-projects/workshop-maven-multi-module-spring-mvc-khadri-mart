package com.khadri.spring.mvc.vegetable.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.vegetable.controller.form.VegetableForm;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;

@Component
public class VegetableBOToVegetableForm {

	public List<VegetableForm> map(List<VegetableBO> boList) {
		List<VegetableForm> listOfForm = boList.stream().map(eachbo -> {
			return new VegetableForm(eachbo.getVegName(), eachbo.getVegQty(), eachbo.getVegPrice());
		}).collect(Collectors.toList());

		return listOfForm;

	}

	public VegetableForm map(VegetableBO vegBo) {

		if (vegBo == null)
			return null;
		return new VegetableForm(vegBo.getVegName(), vegBo.getVegQty(), vegBo.getVegPrice());

	}

}
