package com.khadri.spring.mvc.clothes.controller;

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

import com.khadri.spring.mvc.clothes.controller.form.ClothesForm;
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
	public String addClothes() {
		return "clothes-add";
	}

	@ResponseBody
	@PostMapping("/add")
	public String addingClothes(@ModelAttribute ClothesForm clothesForm) {
		System.out.println("Entered into Clothes Add Controller");

		ClothesBO clothesBO = formToMapper.map(clothesForm);

		int result = service.addClothesItems(clothesBO);

		return result + " Clothes added sucessfully";

	}

	@GetMapping("/search/page")
	public String searchGrosary() {
		return "clothes-modify-search";
	}

	@PostMapping("/search")
	public ModelAndView searchGrosary(@RequestParam String searchClothes) {
		System.out.println("Entered into Clothes Add Controller");

		List<ClothesBO> listOfBo = service.searchClothesItem(searchClothes);
		List<ClothesForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("searchListOfItem", listOfSearchItemForms);
		ModelAndView modelAndView = new ModelAndView("clothes-modify-search", modelMap);
		return modelAndView;
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
	@ResponseBody
	public String updateClothes(@ModelAttribute ClothesForm clothesForm) {
		System.out.println("Updating item: " + clothesForm.getItemName());

		ClothesBO bo = formToMapper.map(clothesForm);
		int count = service.updateClothesItem(bo);
		return count + "Clothes Modified Successfully";
	}

	@GetMapping("/view")
	public ModelAndView viewItem(@RequestParam(name = "clothesName", required = false) String clothesName) {
		List<ClothesBO> listOfBo = service.searchClothesItem(clothesName);
		List<ClothesForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("clothes-view");
		model.addObject("listOfClothes", listOfSearchItemForms);
		model.addObject("searchName", clothesName);
		return model;
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
	public String deletePage() {
		return "clothes-delete";
	}

	@PostMapping("/delete/search")
	public ModelAndView searchForDelete(@RequestParam String searchClothes) {
		ClothesBO bo = service.getItemByName(searchClothes);

		if (bo == null) {
			ModelAndView mv = new ModelAndView("clothes-delete");
			mv.addObject("message", "Item not found");
			return mv;
		}

		ClothesForm form = boToFormMapper.map(bo);
		ModelAndView mv = new ModelAndView("clothes-delete");
		mv.addObject("clothesForm", form);
		return mv;
	}

	@PostMapping("/delete")
	public String deleteClothes(@RequestParam String itemName, Model model) {
	    int count = service.deleteClothesItem(itemName);

	    String message;
	    if (count > 0) {
	        message = count + (count == 1 
	            ? " item deleted successfully." 
	            : " items  deleted successfully.");
	    } else {
	        message = "No items  deleted. Please check the item name.";
	    }

	    model.addAttribute("message", message);
	    model.addAttribute("count", count);

	    return "clothes-delete";
	}

}
