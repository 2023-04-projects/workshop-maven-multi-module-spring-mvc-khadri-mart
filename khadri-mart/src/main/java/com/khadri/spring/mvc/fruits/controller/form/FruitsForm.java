package com.khadri.spring.mvc.fruits.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FruitsForm {

	private String itemName;
	private int itemQty;
	private Double itemPrice;
}