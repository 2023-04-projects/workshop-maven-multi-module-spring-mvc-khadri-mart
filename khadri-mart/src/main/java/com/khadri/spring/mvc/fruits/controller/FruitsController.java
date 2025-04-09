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

		int result = service.addFruitItem(fruitBO);

		return result + " Fruits added sucessfully";
	}

	@GetMapping("/modify/page")
	public String searchFruit() {
		return "fruits-modify-search";
	}

	@PostMapping("/search")
	public ModelAndView searchFruit(@RequestParam String searchFruit) {
		System.out.println("Entered into Fruits Add Controller");

		List<FruitBO> listOfBo = service.searchFruitItem(searchFruit);
		List<FruitsForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("searchListOfItem", listOfSearchItemForms);
		ModelAndView modelAndView = new ModelAndView("fruits-modify-search", modelMap);
		return modelAndView;
	}

	@GetMapping("/modify")
	public ModelAndView modifyItem(@RequestParam String fruitName) {
		System.out.println("Modify request for: " + fruitName);

		FruitBO bo = service.getItemByName(fruitName);
		FruitsForm form = boToFormMapper.map(bo);
		ModelAndView model = new ModelAndView("fruits-modify-page");
		model.addObject("fruitsForm", form);
		return model;
	}

	@PostMapping("/modify")
	@ResponseBody
	public String updateFruit(@ModelAttribute FruitsForm fruitsForm) {
		System.out.println("Updating item: " + fruitsForm.getItemName());

		FruitBO bo = mapper.map(fruitsForm);
		int count = service.updateFruitItem(bo);
		return count + "Fruits Modified Successfully";
	}

	@GetMapping("/view")
	public ModelAndView viewItem(@RequestParam(name = "fruitName", required = false) String fruitName) {
		List<FruitBO> listOfBo = service.searchFruitItem(fruitName);
		List<FruitsForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("fruit-view");
		model.addObject("listOfFruits", listOfSearchItemForms);
		model.addObject("searchName", fruitName);
		return model;
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllfruits() {
		List<FruitBO> listOfBo = service.viewAllFruits();
		List<FruitsForm> listOfForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("fruits-viewAll");
		model.addObject("listOfFruits", listOfForms);
		return model;
	}

	@PostMapping("/delete/search")
	public ModelAndView searchForDelete(@RequestParam String searchFruit) {
		FruitBO bo = service.getItemByName(searchFruit);

		if (bo == null) {
			ModelAndView mv = new ModelAndView("fruit-delete");
			mv.addObject("message", "Item not found");
			return mv;
		}

		FruitsForm form = boToFormMapper.map(bo);
		ModelAndView mv = new ModelAndView("fruits-delete");
		mv.addObject("fruitsForm", form);
		return mv;
	}

	@GetMapping("/delete/page")
	public String deletePage() {
		return "fruits-delete";
	}

	@PostMapping("/delete")
	public String deleteFruit(@RequestParam String itemName, Model model) {
		int result = service.deleteFruitItem(itemName);
		String message = result > 0 ? "Deleted successfully" : "Deletion failed";
		model.addAttribute("message", message);
		return "fruits-delete";
	}

}
