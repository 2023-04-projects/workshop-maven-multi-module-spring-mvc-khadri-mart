package com.khadri.spring.mvc.clothes.controller.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.clothes.controller.form.ClothesForm;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;

@Component
public class ClothesFormToClothesBO {
	public ClothesBO map(ClothesForm clothesForm) {
		ClothesBO clothesBO = new ClothesBO();
		clothesBO.setClothesName(clothesForm.getItemName());
		clothesBO.setClothesQty(clothesForm.getItemQty());
		clothesBO.setClothesPrice(clothesForm.getItemPrice());
		return clothesBO;
	}
}
