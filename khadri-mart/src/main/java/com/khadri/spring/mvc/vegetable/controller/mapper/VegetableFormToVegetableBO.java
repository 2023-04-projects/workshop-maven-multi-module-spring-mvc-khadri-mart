package com.khadri.spring.mvc.vegetable.controller.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.vegetable.controller.form.VegetableForm;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;

@Component
public class VegetableFormToVegetableBO {

	public VegetableBO map(VegetableForm vegForm) {

		VegetableBO vegBo = new VegetableBO();
		vegBo.setVegName(vegForm.getItemName());
		vegBo.setVegQty(vegForm.getItemQty());
		vegBo.setVegPrice(vegForm.getItemPrice());
		return vegBo;

	}

}
