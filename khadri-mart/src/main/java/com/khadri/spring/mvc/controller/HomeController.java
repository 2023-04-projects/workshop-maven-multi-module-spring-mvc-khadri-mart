package com.khadri.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@RequestMapping("/top")
	public String topPage() {
		return "top";
	}

	@RequestMapping("/bottom-right")
	public String bottomRight() {
		return "bottom-right";
	}

	@RequestMapping("/bottom-left-gro")
	public String bottomGrosary() {
		return "bottom-left-gro";
	}

	@RequestMapping("/bottom-left-clo")
	public String bottomClothes() {
		return "bottom-left-clo";
	}

	@RequestMapping("/bottom-left-fruits")
	public String bottomFruits() {
		return "bottom-left-fruits";
	}

	@RequestMapping("/bottom-left-veg")
	public String bottomVeg() {
		return "bottom-left-veg";
	}
}
