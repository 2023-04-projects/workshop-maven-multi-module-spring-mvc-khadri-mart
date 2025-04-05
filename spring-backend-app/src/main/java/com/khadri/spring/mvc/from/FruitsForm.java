package com.khadri.spring.mvc.from;

import jakarta.servlet.ServletContext;
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
public class FruitsForm {
	public FruitsForm(ServletContext context) {
		  
	}
	private String itemName;
	private int itemQty;
	private Double itemPrice;

}