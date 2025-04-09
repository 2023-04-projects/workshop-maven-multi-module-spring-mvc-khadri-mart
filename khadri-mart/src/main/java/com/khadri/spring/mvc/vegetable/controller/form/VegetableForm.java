package com.khadri.spring.mvc.vegetable.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VegetableForm {

	private String VegName;
	private int vegQty;
	private double vegPrice;

}
