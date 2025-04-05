package com.khadri.spring.mvc.clothes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.clothes.controller.form.ClothesForm;
import com.khadri.spring.mvc.clothes.controller.mapper.ClothesFormToClothesBO;
import com.khadri.spring.mvc.clothes.service.ClothesService;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

	private ClothesService service;

	private ClothesFormToClothesBO mapper;
	
	@Autowired
	public ClothesController(ClothesService service, ClothesFormToClothesBO mapper) {
		System.out.println("ClothesController constructor");
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/add/page")
	public String addClothes() {
		return "clothes-add";
	}

	@ResponseBody
	@PostMapping("/add")
	public String addingClothes(@ModelAttribute ClothesForm clothesForm) {
		System.out.println("Entered into Clothes Add Controller");

		ClothesBO clothesBO = mapper.map(clothesForm);

		int result = service.addClothesItems(clothesBO);

		return result + " Clothes added sucessfully";

	}

}
