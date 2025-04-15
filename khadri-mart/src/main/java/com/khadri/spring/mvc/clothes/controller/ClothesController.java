package com.khadri.spring.mvc.clothes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.khadri.spring.mvc.clothes.controller.form.ClothesForm;
import com.khadri.spring.mvc.clothes.controller.form.ClothesSearchForm;
import com.khadri.spring.mvc.clothes.controller.mapper.ClothesBOToClothesForm;
import com.khadri.spring.mvc.clothes.controller.mapper.ClothesFormToClothesBO;
import com.khadri.spring.mvc.clothes.service.ClothesService;
import com.khadri.spring.mvc.clothes.service.bo.ClothesBO;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

	private ClothesService service;

	private ClothesFormToClothesBO formToMapper;

	private ClothesBOToClothesForm boToFormMapper;

	@Autowired
	public ClothesController(ClothesService service, ClothesFormToClothesBO formToMapper,
			ClothesBOToClothesForm boToFormMapper) {

		System.out.println("ClothesController constructor");
		this.service = service;
		this.formToMapper = formToMapper;
		this.boToFormMapper = boToFormMapper;

	}

	@GetMapping("/add/page")
	public String addClothes(Model model) {
		model.addAttribute("clothesForm", new ClothesForm());
		return "clothes-add";
	}

	@PostMapping("/add")
	public String addingClothes(@Validated @ModelAttribute ClothesForm clothesForm, BindingResult bindingResult,
			Model model) {
		System.out.println("Entered into Clothes Add Controller");

		if (bindingResult.hasErrors()) {
			return "clothes-add";
		}
		ClothesBO clothesBO = formToMapper.map(clothesForm);

		service.addClothesItems(clothesBO);
		model.addAttribute("message", "Clothes Added Successfully!");
		return "success";

	}

	@GetMapping("/modify/page")
	public String modifyClothes(Model model) {
		model.addAttribute("searchForm", new ClothesSearchForm());
		return "clothes-modify-search";
	}

	@PostMapping("/search")
	public String searchClothes(@Validated @ModelAttribute("searchForm") ClothesSearchForm searchForm,
			BindingResult bindingResult, Model model) {

		System.out.println("Search called for: " + searchForm.getSearchClothes());

		if (bindingResult.hasErrors()) {
			return "clothes-modify-search";
		}

		List<ClothesBO> listOfBo = service.searchClothesItem(searchForm.getSearchClothes());
		List<ClothesForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		model.addAttribute("listOfSearchItemForms", listOfSearchItemForms);
		return "clothes-modify-search";
	}

	@GetMapping("/modify")
	public ModelAndView modifyItem(@RequestParam String clothesName) {
		System.out.println("Modify request for: " + clothesName);

		ClothesBO bo = service.getItemByName(clothesName);
		ClothesForm form = boToFormMapper.map(bo);
		ModelAndView model = new ModelAndView("clothes-modify-page");
		model.addObject("clothesForm", form);
		return model;
	}

	@PostMapping("/modify")
	public String updateClothes(@ModelAttribute("searchForm") ClothesForm form, Model model) {
		System.out.println("Updating item: " + form.getItemName());

		ClothesBO bo = formToMapper.map(form);
		service.addClothesItems(bo);

		model.addAttribute("updatedName", form.getItemName());
		model.addAttribute("message", "Clothes Modified Successfully!");
		return "success";
	}

	@GetMapping("/view/page")
	public String viewClothes(Model model) {
		model.addAttribute("searchForm", new ClothesSearchForm());
		return "clothes-view";
	}

	@PostMapping("/view")
	public String viewClothes(@Validated @ModelAttribute("searchForm") ClothesSearchForm searchForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "clothes-view";
		}
		System.out.println("Searching for item: " + searchForm.getSearchClothes());

		List<ClothesBO> listOfBo = service.searchClothesItem(searchForm.getSearchClothes());
		List<ClothesForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		model.addAttribute("searchListOfItem", listOfSearchItemForms);
		return "clothes-view";
	}

	@GetMapping("/viewAll")
	public ModelAndView viewAllClothes() {
		List<ClothesBO> listOfBo = service.viewAllClothes();
		List<ClothesForm> listOfForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("clothes-viewAll");
		model.addObject("listOfClothes", listOfForms);
		return model;
	}

	@GetMapping("/delete/page")
	public String deleteClothes(Model model) {
		model.addAttribute("searchForm", new ClothesSearchForm());
		return "clothes-delete";
	}

	@PostMapping("/delete/search")
	public String Searchtodelete(@Validated @ModelAttribute("searchForm") ClothesSearchForm form, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "clothes-delete";
		}

		ClothesBO bo = service.getItemByName(form.getSearchClothes());

		if (bo == null) {
			model.addAttribute("message", "Item not found");
			return "clothes-delete";
		}

		ClothesForm itemForm = boToFormMapper.map(bo);
		model.addAttribute("ClothesForm", itemForm);
		return "clothes-delete";
	}

	@PostMapping("/delete")
	public String deleteClothes(@RequestParam String ClothesName, Model model) {
		service.deleteClothesItem(ClothesName);

		model.addAttribute("searchForm", new ClothesSearchForm());
		model.addAttribute("message", "Clothes deleted successfully");

		return "success";
	}

}
