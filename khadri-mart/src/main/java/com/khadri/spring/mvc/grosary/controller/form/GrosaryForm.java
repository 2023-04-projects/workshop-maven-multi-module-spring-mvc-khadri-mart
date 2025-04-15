package com.khadri.spring.mvc.grosary.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrosaryForm {

	private String grosaryName;
	private int grosaryQty;
	private Double grosaryPrice;

}
