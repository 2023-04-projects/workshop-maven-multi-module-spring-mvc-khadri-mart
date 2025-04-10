package com.khadri.spring.mvc.fruits.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.khadri.spring.mvc.fruits.controller.form.FruitsForm;
import com.khadri.spring.mvc.fruits.controller.mapper.FruitBOToFruitsForm;
import com.khadri.spring.mvc.fruits.controller.mapper.FruitFormToFruitBO;
import com.khadri.spring.mvc.fruits.service.FruitsService;
import com.khadri.spring.mvc.fruits.service.bo.FruitBO;

@Controller
@RequestMapping("/fruits")
public class FruitsController {

	private FruitsService service;

	private FruitFormToFruitBO mapper;

	private FruitBOToFruitsForm boToFormMapper;

	@Autowired
	public FruitsController(FruitsService service, FruitFormToFruitBO mapper, FruitBOToFruitsForm boToFormMapper) {
		System.out.println("FruitsController constructor");
		this.service = service;
		this.mapper = mapper;
		this.boToFormMapper = boToFormMapper;
	}

	@GetMapping("/add/page")
	public String addFruits() {
		return "fruits-add";
	}

	@ResponseBody
	@PostMapping("/add")
	public String addFruit(@ModelAttribute FruitsForm fruitsForm) {
		System.out.println("Entered into Fruits Add Controller");

		FruitBO fruitBO = mapper.map(fruitsForm);

		int result = service.addFruitsItem(fruitBO);

		return result + " Fruits added sucessfully";
	}

	@GetMapping("/modify/page")
	public String modifyFruit() {
		return "fruits-modify-search";
	}

	@PostMapping("/search/page")
	public ModelAndView searchFruits(@RequestParam String searchFruits) {
		System.out.println("Entered into Fruits Add Controller");

		List<FruitBO> listOfBo = service.searchFruitItem(searchFruits);
		List<FruitsForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("searchListOfItem", listOfSearchItemForms);
		ModelAndView modelAndView = new ModelAndView("fruits-modify-search", modelMap);
		return modelAndView;
	}

	@GetMapping("/modify")
	public ModelAndView modifyItem(@RequestParam String fruitsName) {
		System.out.println("Modify request for: " + fruitsName);

		FruitBO bo = service.getItemByName(fruitsName);
		FruitsForm form = boToFormMapper.map(bo);
		ModelAndView model = new ModelAndView("fruits-modify-page");
		model.addObject("fruitsForm", form);
		return model;
	}

	@PostMapping("/modify")
	@ResponseBody
	public String updateFruits(@ModelAttribute FruitsForm fruitsForm) {
		System.out.println("Updating item: " + fruitsForm.getFruitsName());

		FruitBO bo = mapper.map(fruitsForm);
		int count = service.updateFruitItem(bo);
		return count + "Fruits Modified Successfully";
	}

	@GetMapping("/view")
	public ModelAndView viewItem(@RequestParam(name = "fruitsName", required = false) String fruitsName) {
		List<FruitBO> listOfBo = service.searchFruitItem(fruitsName);
		List<FruitsForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("fruits-view");
		model.addObject("listOfFruits", listOfSearchItemForms);
		model.addObject("searchName", fruitsName);
		return model;
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllFruirs() {
		List<FruitBO> listOfBo = service.viewAllFruits();
		List<FruitsForm> listOfForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("fruits-viewall");
		model.addObject("listOfFruits", listOfForms);
		return model;
	}

	@PostMapping("/delete/search")
	public ModelAndView searchForDelete(@RequestParam String fruitsName) {
		FruitBO bo = service.getItemByName(fruitsName);

		if (bo == null) {
			ModelAndView mv = new ModelAndView("fruits-delete");
			mv.addObject("message", "Item not found");
			return mv;
		}

		FruitsForm form = boToFormMapper.map(bo);
		ModelAndView mv = new ModelAndView("fruits-delete");
		mv.addObject("FruitsForm", form);
		return mv;
	}

	@GetMapping("/delete/page")
	public String deletePage() {
		return "fruits-delete";
	}

	@PostMapping("/delete")
	public String deleteFruits(@RequestParam String fruitsName, Model model) {
		int result = service.deleteFruitsItem(fruitsName);
		String message = result > 0 ? "Deleted successfully" : "Deletion failed";
		model.addAttribute("message", message);
		return "fruits-delete";
	}

}
