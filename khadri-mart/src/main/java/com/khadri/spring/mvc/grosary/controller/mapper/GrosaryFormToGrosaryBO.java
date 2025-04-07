package com.khadri.spring.mvc.grosary.controller.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.grosary.controller.form.GrosaryForm;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Component
public class GrosaryFormToGrosaryBO {

	public GrosaryBO map(GrosaryForm GrosaryForm) {
		GrosaryBO grosaryBO = new GrosaryBO();
		grosaryBO.setGrosaryName(GrosaryForm.getGrosaryName());
		grosaryBO.setGrosaryPrice(GrosaryForm.getGrosaryPrice());
		grosaryBO.setGrosaryQty(GrosaryForm.getGrosaryQty());
		return grosaryBO;

}
}
