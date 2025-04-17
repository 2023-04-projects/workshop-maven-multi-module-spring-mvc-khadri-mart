package com.khadri.spring.mvc.grosary.controller;

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

import com.khadri.spring.mvc.grosary.controller.form.GrosaryForm;
import com.khadri.spring.mvc.grosary.controller.form.GrosarySearchForm;
import com.khadri.spring.mvc.grosary.controller.mapper.GrosaryBOToGrosaryForm;
import com.khadri.spring.mvc.grosary.controller.mapper.GrosaryFormToGrosaryBO;
import com.khadri.spring.mvc.grosary.service.GrosaryService;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Controller
@RequestMapping("grosary")
public class GrosaryController {

	private GrosaryService service;

	private GrosaryFormToGrosaryBO formToMapper;

	private GrosaryBOToGrosaryForm boToFormMapper;

	@Autowired
	public GrosaryController(GrosaryService service, GrosaryFormToGrosaryBO formToMapper,
			GrosaryBOToGrosaryForm boToFormMapper) {
		System.out.println("GrosaryController constructor");
		this.service = service;
		this.formToMapper = formToMapper;
		this.boToFormMapper = boToFormMapper;
	}

	@GetMapping("/add/page")
	public String addGrosary(Model model) {
		model.addAttribute("grosaryForm", new GrosaryForm());
		return "grosary-add";
	}

	@PostMapping("/add")
	public String addGrosary(@Validated @ModelAttribute GrosaryForm grosaryForm, BindingResult bindingResult,
			Model model) {
		System.out.println("Entered into Grosary Add Controller");

		if (bindingResult.hasErrors()) {
			return "grosary-add";
		}

		GrosaryBO grosaryBO = formToMapper.map(grosaryForm);
		service.addGrosaryItem(grosaryBO);

		model.addAttribute("message", "Grosary Added Successfully!");

		return "success";
	}

	@GetMapping("/modify/page")
	public String modifyGrosary(Model model) {
		model.addAttribute("searchForm", new GrosarySearchForm());
		return "grosary-modify-search";
	}

	@PostMapping("/search")
	public String searchGrosary(@Validated @ModelAttribute("searchForm") GrosarySearchForm searchForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "grosary-modify-search";
		}
		System.out.println("Searching for item: " + searchForm.getGrosaryName());

		List<GrosaryBO> listOfBo = service.searchGrosaryItem(searchForm.getGrosaryName());
		List<GrosaryForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		model.addAttribute("searchListOfItem", listOfSearchItemForms);
		return "grosary-modify-search";
	}

	@GetMapping("/modify")
	public ModelAndView modifyItem(@RequestParam String grosaryName) {
		System.out.println("Modify request for: " + grosaryName);

		GrosaryBO bo = service.getItemByName(grosaryName);
		GrosaryForm form = boToFormMapper.map(bo);
		ModelAndView model = new ModelAndView("grosary-modify-page");
		model.addObject("grosaryForm", form);
		return model;
	}

	@PostMapping("/modify")
	public String updateGrosary(@ModelAttribute("grosaryForm") GrosaryForm form, Model model) {
		System.out.println("Updating item: " + form.getGrosaryName());

		GrosaryBO bo = formToMapper.map(form);
		service.updateGrosaryItem(bo);

		model.addAttribute("updatedName", form.getGrosaryName());
		model.addAttribute("message", "Grosary Modified Successfully!");

		return "success";
	}

	@GetMapping("/view/page")
	public String showViewPage(Model model) {
		model.addAttribute("searchForm", new GrosarySearchForm());
		return "grosary-view";
	}

	@PostMapping("/view")
	public String viewGrosary(@Validated @ModelAttribute("searchForm") GrosarySearchForm searchForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "grosary-view";
		}
		System.out.println("Searching for item: " + searchForm.getGrosaryName());

		List<GrosaryBO> listOfBo = service.searchGrosaryItem(searchForm.getGrosaryName());
		List<GrosaryForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		model.addAttribute("searchListOfItem", listOfSearchItemForms);

		return "grosary-view";
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllGrosary() {
		List<GrosaryBO> listOfBo = service.viewAllGrosary();
		List<GrosaryForm> listOfForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("grosary-viewall");
		model.addObject("listOfGrosary", listOfForms);
		return model;
	}

	@GetMapping("/delete/page")
	public String deleteGrosary(Model model) {
		model.addAttribute("searchForm", new GrosarySearchForm());
		return "grosary-delete";
	}

	@PostMapping("/delete/search")
	public String searchForDelete(@Validated @ModelAttribute("searchForm") GrosarySearchForm form, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "grosary-delete";
		}

		GrosaryBO bo = service.getItemByName(form.getGrosaryName());

		if (bo == null) {
			model.addAttribute("message", "Item not found");
			return "grosary-delete";
		}

		GrosaryForm itemForm = boToFormMapper.map(bo);
		model.addAttribute("GrosaryForm", itemForm);
		return "grosary-delete";
	}

	@PostMapping("/delete")
	public String deleteGrosary(@RequestParam String grosaryName, Model model) {
		int result = service.deleteGrosaryItem(grosaryName);

		model.addAttribute("searchForm", new GrosarySearchForm());
		model.addAttribute("message", "Grosary Deleted Successfully!");

		return "success";
	}

}
