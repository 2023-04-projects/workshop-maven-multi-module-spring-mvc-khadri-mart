package com.khadri.spring.mvc.clothes.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClothesForm {
	private String itemName;
	private int itemQty;
	private Double itemPrice;

}
