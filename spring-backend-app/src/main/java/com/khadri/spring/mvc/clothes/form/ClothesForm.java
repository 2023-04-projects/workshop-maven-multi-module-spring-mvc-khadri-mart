package com.khadri.spring.mvc.clothes.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClothesForm {
	private String itemName;
	private int itemQty;
	private Double itemPrice;

}
