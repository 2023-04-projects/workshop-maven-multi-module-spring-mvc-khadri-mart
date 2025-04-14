package com.khadri.spring.mvc.grosary.controller.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrosarySearchForm {
	@NotBlank(message = "Grosary name is mandatory")
	private String grosaryName;

}
