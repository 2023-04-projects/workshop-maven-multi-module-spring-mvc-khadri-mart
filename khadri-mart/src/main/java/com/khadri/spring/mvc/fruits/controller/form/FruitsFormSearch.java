package com.khadri.spring.mvc.fruits.controller.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitsFormSearch {

	@NotBlank(message = "fruitsName is mandatory")
	private String fruitsName;

}
