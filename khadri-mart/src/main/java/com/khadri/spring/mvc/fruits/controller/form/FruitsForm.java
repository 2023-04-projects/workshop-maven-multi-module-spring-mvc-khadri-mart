package com.khadri.spring.mvc.fruits.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FruitsForm {

	private String fruitsName;
	private int fruiytsQty;
	private Double fruitsPrice;
}