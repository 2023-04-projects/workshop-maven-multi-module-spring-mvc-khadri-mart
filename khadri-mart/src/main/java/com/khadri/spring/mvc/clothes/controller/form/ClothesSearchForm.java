package com.khadri.spring.mvc.clothes.controller.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClothesSearchForm {

	@NotBlank(message = "ItemName is mandatory")
	private String searchClothes;

	
}
