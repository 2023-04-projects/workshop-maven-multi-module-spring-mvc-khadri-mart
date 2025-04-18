package com.khadri.spring.mvc.fruits.controller.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FruitsForm {

	@NotBlank(message = "fruitsName is mandatory")
	private String fruitsName;

	@NotNull(message = "fruitsQty is mandatory")
	private Integer fruitsQty;
	@NotNull(message = "fruitsPrice is mandatory")
	private Double fruitsPrice;
}