package com.khadri.spring.mvc.grosary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.mvc.grosary.controller.mapper.GrosaryFormToGrosaryBO;
import com.khadri.spring.mvc.grosary.form.GrosaryForm;
import com.khadri.spring.mvc.grosary.service.GrosaryService;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Controller
@RequestMapping("/grosary")
public class GrosaryController {

	private GrosaryService service;

	private GrosaryFormToGrosaryBO mapper;

	@Autowired
	public GrosaryController(GrosaryService service, GrosaryFormToGrosaryBO mapper) {
		System.out.println("GrosaryController constructor");
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/add/page")
	public String addGrosary() {
		return "grosary-add";
	}

	@ResponseBody
	@PostMapping("/add")
	public String addGrosary(@ModelAttribute GrosaryForm grosaryForm) {
		System.out.println("Entered into Grosary Add Controller");

		GrosaryBO grosaryBO = mapper.map(grosaryForm);

		int result = service.addGrosaryItem(grosaryBO);

		return result + " Grosary added sucessfully";
	}

}
