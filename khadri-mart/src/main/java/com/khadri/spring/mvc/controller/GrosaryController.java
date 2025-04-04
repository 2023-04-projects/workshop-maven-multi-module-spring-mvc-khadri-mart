package com.khadri.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.form.GrosaryForm;

@Controller
@RequestMapping("/grosary")
public class GrosaryController {

	@GetMapping("/add")
	public String addGrosary() {
		return "grosary-add";
	}

	@ResponseBody
	@PostMapping("/adding")
	public String addingGrosary(@ModelAttribute GrosaryForm grosaryForm) {
		System.out.println("Name: " + grosaryForm.getGrosaryName());
		System.out.println("Quantity: " + grosaryForm.getGrosaryQty());
		System.out.println("Price: " + grosaryForm.getGrosaryPrice());
		return "grosary added successfully";
	}

	@GetMapping("/view")
	public String viewGrosary() {
		return "grosary-view";
	}

	@GetMapping("/viewall")
	public String viewAllGrosary() {
		return "grosary-viewAll";
	}

	@GetMapping("/modify")
	public String modifyGrosary() {
		return "grosary-modify";

	}

	@GetMapping("/delete")
	public String deletGrosary() {
		return "grosary-delete";
	}
}
