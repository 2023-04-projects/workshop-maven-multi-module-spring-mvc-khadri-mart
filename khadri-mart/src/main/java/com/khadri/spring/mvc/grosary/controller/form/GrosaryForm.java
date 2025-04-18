package com.khadri.spring.mvc.grosary.controller.form;

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
public class GrosaryForm {
	@NotBlank(message = "Grosary name is mandatory")
	private String grosaryName;

	@NotNull(message = "GrosaryQty is mandatory")
	private Integer grosaryQty;

	@NotNull(message = "GrosaryPrice is mandatory")
	private Double grosaryPrice;

}
