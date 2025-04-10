package com.khadri.spring.mvc.fruits.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.fruits.controller.form.FruitsForm;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

@Component
public class FruitBOToFruitsForm {
	public List<FruitsForm> map(List<FruitBO> bos) {

		List<FruitsForm> listOfForms = bos.stream().map(eachBo -> {
			return new FruitsForm(eachBo.getFruitName(), eachBo.getFruitQty(), eachBo.getFruitPrice());
		}).collect(Collectors.toList());
		return listOfForms;

	}

	public FruitsForm map(FruitBO bo) {

		if (bo == null)
			return null;
		return new FruitsForm(bo.getFruitName(), bo.getFruitQty(), bo.getFruitPrice());

	}

}
