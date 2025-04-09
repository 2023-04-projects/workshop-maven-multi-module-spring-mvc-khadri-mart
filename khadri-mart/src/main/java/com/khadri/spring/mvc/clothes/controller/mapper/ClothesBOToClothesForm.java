package com.khadri.spring.mvc.clothes.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.clothes.controller.form.ClothesForm;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;

@Component
public class ClothesBOToClothesForm {
	public List<ClothesForm> map(List<ClothesBO> bos) {

		List<ClothesForm> listOfForms = bos.stream().map(eachBo -> {
			return new ClothesForm(eachBo.getClothesName(), eachBo.getClothesQty(), eachBo.getClothesPrice());
		}).collect(Collectors.toList());
		return listOfForms;

	}
	public ClothesForm map(ClothesBO bo) {

		if (bo == null)
			return null;
		return new ClothesForm(bo.getClothesName(), bo.getClothesQty(), bo.getClothesPrice());

	}


}
