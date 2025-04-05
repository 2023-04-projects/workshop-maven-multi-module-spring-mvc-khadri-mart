package com.khadri.spring.mvc.cloths.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clothes")
public class ClothesAddController {
	
	@GetMapping("/add")
	public String addClothes() {
		return "clothes-add";
	}

	@GetMapping("/modify")
	public String modifyClothes() {
		return "clothes-modify-page";
	}
}
