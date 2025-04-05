package com.khadri.spring.mvc.fruits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.fruits.controller.form.FruitsForm;
import com.khadri.spring.mvc.fruits.controller.mapper.FruitFormToFruitBO;
import com.khadri.spring.mvc.fruits.service.FruitsService;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

@Controller
@RequestMapping("/fruits")
public class FruitsController {

	private FruitsService service;

	private FruitFormToFruitBO mapper;

	@Autowired
	public FruitsController(FruitsService service, FruitFormToFruitBO mapper) {
		System.out.println("FruitsController constructor");
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/add/page")
	public String addClothes() {
		return "fruits-add";
	}

	@ResponseBody
	@PostMapping("/add")
	public String addFruit(@ModelAttribute FruitsForm fruitsForm) {
		System.out.println("Entered into Fruits Add Controller");

		FruitBO fruitBO = mapper.map(fruitsForm);

		service.addFruitItem(fruitBO);

		return "Fruits added sucessfully";
	}

}
