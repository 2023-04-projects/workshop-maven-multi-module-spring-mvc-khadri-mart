package com.khadri.spring.mvc.fruits.controller.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.fruits.controller.form.FruitsForm;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

@Component
public class FruitFormToFruitBO {

	public FruitBO map(FruitsForm fruitsForm) {
		FruitBO fruitBO = new FruitBO();
		fruitBO.setFruitName(fruitsForm.getFruitsName());
		fruitBO.setFruitPrice(fruitsForm.getFruitsPrice());
		fruitBO.setFruitQty(fruitsForm.getFruiytsQty());
		return fruitBO;
	}

}
