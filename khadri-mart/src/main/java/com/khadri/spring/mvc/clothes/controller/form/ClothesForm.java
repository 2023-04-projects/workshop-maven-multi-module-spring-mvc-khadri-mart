package com.khadri.spring.mvc.clothes.controller.form;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothesForm {

	@NotBlank(message = "ItemName name is mandatory")
	private String itemName;

	@NotNull(message = "ItemQty is mandatory")
	private Integer itemQty;

	@NotNull(message = "ItemPrice is mandatory ")
	private Double itemPrice;

}
