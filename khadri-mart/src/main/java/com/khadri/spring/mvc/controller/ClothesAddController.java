package com.khadri.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.clothes.form.ClothesForm;

@Controller
@RequestMapping("/clothes")
public class ClothesAddController {

	@GetMapping("/add")
	public String addClothes() {
		return "clothes-add";
	}
	@ResponseBody
	@PostMapping("/adding")
	public String addingClothes(@ModelAttribute ClothesForm clothesForm) {
		System.out.println("Name: " + clothesForm.getItemName());
		System.out.println("Quantity: " + clothesForm.getItemQty());
		System.out.println("Price: " + clothesForm.getItemPrice());
		return "clothes added sucessfully";

	}
	
	@GetMapping("/modify")
	public String modifyClothes() {
		return "clothes-modify";
	}

	@GetMapping("/view")
	public String viewClothes() {
		return "clothes-view";
	}

	@GetMapping("/viewall")
	public String viewAllClothes() {
		return "clothes-viewAll";
	}

	@GetMapping("/delete")
	public String deleteClothes() {
		return "clothes-delete";
	}

}
