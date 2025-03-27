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

	@RequestMapping("/bottom_left_gro")
	public String bottomGrosary() {
		return "bottom_left_gro";
	}

	@RequestMapping("/bottom_right")
	public String bottomRight() {
		return "bottom_right";
	}
	@RequestMapping("/bottom_left_clo")
	public String bottomClothes() {
		return "bottom_left_clo";
	}
	@RequestMapping("/bottom_left_fruits")
	public String bottomFruits() {
		return "bottom_left_fruits";
	}
	@RequestMapping("/bottom_left_veg")
	public String bottomVeg() {
		return "bottom_left_veg";
	}
}
