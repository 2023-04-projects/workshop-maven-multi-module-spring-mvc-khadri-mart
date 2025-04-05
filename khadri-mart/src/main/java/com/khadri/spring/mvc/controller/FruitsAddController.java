package com.khadri.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.from.FruitsForm;

@Controller
@RequestMapping("/fruits")
public class FruitsAddController {

	@GetMapping("/add")
	public String addClothes() {
		return "fruits-add";
	}
	@ResponseBody
	@PostMapping("/adding")
	public String addingClothes(@ModelAttribute FruitsForm fruitsForm) {
		System.out.println("Name: " + fruitsForm.getItemName());
		System.out.println("Quantity: " + fruitsForm.getItemQty());
		System.out.println("Price: " + fruitsForm.getItemPrice());
		return "Fruits added sucessfully";

	}

	@GetMapping("/modify")
	public String modifyClothes() {
		return "fruits-modify";
	}

	@GetMapping("/view")
	public String viewClothes() {
		return "fruits-view";
	}

	@GetMapping("/viewall")
	public String viewAllClothes() {
		return "fruits-viewAll";
	}

	@GetMapping("/delete")
	public String deleteClothes() {
		return "fruits-delete";
	}

}
