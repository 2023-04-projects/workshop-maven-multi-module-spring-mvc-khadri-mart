package com.khadri.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@RequestMapping("/top/page")
	public String topPage() {
		return "top";
	}
}
