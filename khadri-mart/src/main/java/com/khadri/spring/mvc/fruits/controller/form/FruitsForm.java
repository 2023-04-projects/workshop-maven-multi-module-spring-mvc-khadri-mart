package com.khadri.spring.mvc.fruits.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FruitsForm {

	private String itemName;
	private int itemQty;
	private Double itemPrice;
}