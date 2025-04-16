package com.khadri.spring.mvc.fruits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khadri.spring.mvc.fruits.controller.form.FruitsForm;
import com.khadri.spring.mvc.fruits.controller.form.FruitsFormSearch;
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

	public void initBinder(org.springframework.web.bind.WebDataBinder binder) {
		// Allow empty values for Integer and Double fields
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
		binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
	}

	@GetMapping("/add/page")
	public String addFruits(Model model) {
		model.addAttribute("fruitsForm", new FruitsForm());
		return "fruits-add";
	}

	@PostMapping("/add")
	public String addFruit(@Validated @ModelAttribute FruitsForm fruitsForm, BindingResult result, Model model) {
		System.out.println("Entered into Fruits Add Controller");
		if (result.hasErrors()) {
			System.out.println("if statement");
			return "fruits-add";
		}

		FruitBO fruitBO = mapper.map(fruitsForm);

		service.addFruitsItem(fruitBO);
		model.addAttribute("message", "Fruits Added Successfully");

		return "success";
	}

	@GetMapping("/modify/page")
	public String modifyFruit(Model model) {
		model.addAttribute("searchForm", new FruitsFormSearch());
		return "fruits-modify-search";
	}

	@PostMapping("/search")
	public String searchFruits(@Validated @ModelAttribute("searchForm") FruitsFormSearch searchForm,
			BindingResult result, Model model) {
		System.out.println("Entered into Fruits Add Controller");

		if (result.hasErrors()) {
			return "fruits-modify-search";

		}

		List<FruitBO> listOfBo = service.searchFruitItem(searchForm.getFruitsName());
		List<FruitsForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		model.addAttribute("searchListOfItem", listOfSearchItemForms);
		return "fruits-modify-search";
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
	public String updateFruits(@ModelAttribute("fruitsForm") FruitsForm fruitsForm, Model model) {
		System.out.println("Updating item: " + fruitsForm.getFruitsName());

		FruitBO bo = mapper.map(fruitsForm);
		service.updateFruitItem(bo);

		model.addAttribute("updatedName", fruitsForm.getFruitsName());
		model.addAttribute("message", "Fruits Modified Successfully");

		return "success";
	}

	@GetMapping("/view/page")
	public String viewFruit(Model model) {
		model.addAttribute("searchForm", new FruitsFormSearch());
		return "fruits-view";
	}

	@PostMapping("/view")
	public String viewFruits(@Validated @ModelAttribute("searchForm") FruitsFormSearch serachForm, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "fruits-view";
		}
		System.out.println("Searching for Fruit :" + serachForm.getFruitsName());
		List<FruitBO> bos = service.searchFruit(serachForm.getFruitsName());
		List<FruitsForm> forms = boToFormMapper.map(bos);
		model.addAttribute("searchListOfItem", forms);
		return "fruits-view";
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllFruirs() {
		List<FruitBO> listOfBo = service.viewAllFruits();
		List<FruitsForm> listOfForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("fruits-viewall");
		model.addObject("listOfFruits", listOfForms);
		return model;
	}

	@GetMapping("/delete/page")
	public String deleteFruits(Model model) {
		model.addAttribute("searchForm", new FruitsFormSearch());
		return "fruits-delete";
	}

	@PostMapping("/delete/search")
	public String searchForFruits(@Validated @ModelAttribute("searchForm") FruitsFormSearch search,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "fruits-delete";
		}
		FruitBO bo = service.getItemByName(search.getFruitsName());

		if (bo == null) {
			model.addAttribute("message", "Fruit Not Found");
			return "fruits-delete";
		}
		FruitsForm form = boToFormMapper.map(bo);
		model.addAttribute("FruitsForm", form);
		return "fruits-delete";
	}

	@PostMapping("/delete")
	public String deleteFruits(@RequestParam String fruitsName, Model model) {
		service.deleteFruitsItem(fruitsName);
		model.addAttribute("searchForm", new FruitsFormSearch());
		model.addAttribute("message", "Fruits Deleteed Successfully ");
		return "success";
	}

}
