package com.khadri.spring.mvc.vegetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.vegetable.controller.form.VegetableForm;
import com.khadri.spring.mvc.vegetable.controller.mapper.VegetableFormToVegetableBO;
import com.khadri.spring.mvc.vegetable.service.VegetableService;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;

@Controller
@RequestMapping("/veg")
public class VegetableController {

	private VegetableService service;

	private VegetableFormToVegetableBO mapper;

	@Autowired
	public VegetableController(VegetableService service, VegetableFormToVegetableBO mapper) {
		System.out.println("VegetableService Controller");
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/add/page")
	public String addVegetable() {
		return "veg-add";
	}

	@ResponseBody
	@PostMapping("/add")
	public String addVegetable(@ModelAttribute VegetableForm vegForm) {
		System.out.println("Entered into Vegetable Add Controller");

		VegetableBO vegBo = mapper.map(vegForm);
		int result = service.addVegetables(vegBo);
		return result + "Vegetable Added Successfully";

	}

}
