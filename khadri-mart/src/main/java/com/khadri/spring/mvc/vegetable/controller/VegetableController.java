package com.khadri.spring.mvc.vegetable.controller;

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

import com.khadri.spring.mvc.vegetable.controller.form.VegetableForm;
import com.khadri.spring.mvc.vegetable.controller.mapper.VegetableBOToVegetableForm;
import com.khadri.spring.mvc.vegetable.controller.mapper.VegetableFormToVegetableBO;
import com.khadri.spring.mvc.vegetable.service.VegetableService;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;

@Controller
@RequestMapping("/veg")
public class VegetableController {

	private VegetableService service;

	private VegetableFormToVegetableBO boMapper;

	private VegetableBOToVegetableForm formMapper;

	@Autowired
	public VegetableController(VegetableService service, VegetableFormToVegetableBO boMapper,
			VegetableBOToVegetableForm formMapper) {
		System.out.println("VegetableService Controller");
		this.service = service;
		this.boMapper = boMapper;
		this.formMapper = formMapper;
	}

	@GetMapping("/add/page")
	public String addVegetable() {
		return "veg-add";
	}

	@ResponseBody
	@PostMapping("/add")
	public String addVegetable(@ModelAttribute VegetableForm vegForm) {
		System.out.println("Entered into Vegetable Add Controller");

		VegetableBO vegBo = boMapper.map(vegForm);
		int result = service.addVegetables(vegBo);
		return result + "Vegetable Added Successfully";

	}

	@GetMapping("/search/page")
	public String searchVegetable() {
		return "veg-modify-search";
	}

	@PostMapping("/search")
	public ModelAndView searchVegetable(@RequestParam String searchVegetables) {
		System.out.println("Entered into modifySearch Controller");
		List<VegetableBO> listOfBo = service.searchVegetables(searchVegetables);
		List<VegetableForm> listOfVegetables = formMapper.map(listOfBo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchListOfVegetables", listOfVegetables);
		ModelAndView modelView = new ModelAndView("veg-modify-search", map);
		return modelView;

	}

	@GetMapping("/modify")
	public ModelAndView modifyVegetable(@RequestParam String vegName) {
		System.out.println("Modify request for: " + vegName);
		VegetableBO vegBo = service.getItemByName(vegName);
		VegetableForm vegForm = formMapper.map(vegBo);
		ModelAndView modelView = new ModelAndView("veg-modify-page");
		modelView.addObject("VegetableForm", vegForm);
		return modelView;
	}

	@PostMapping("/modify")
	@ResponseBody
	public String updateVegetables(@ModelAttribute VegetableForm vegForm) {
		System.out.println("Updating item: " + vegForm.getVegName());
		VegetableBO vegBo = boMapper.map(vegForm);
		int count = service.updateVegetables(vegBo);
		return count + "vegetable Modified Successfully";
	}

	@GetMapping("/view")
	public ModelAndView viewItem(@RequestParam(name = "vegName", required = false) String vegName) {
		List<VegetableBO> listOfBo = service.searchVegetables(vegName);
		List<VegetableForm> listOfForm = formMapper.map(listOfBo);
		ModelAndView model = new ModelAndView("veg-view");
		model.addObject("listOfVegetables", listOfForm);
		model.addObject("searchName", vegName);
		return model;
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllVegetables() {
		List<VegetableBO> listOfBo = service.viewAllVegetables();
		List<VegetableForm> listOfForm = formMapper.map(listOfBo);
		ModelAndView model = new ModelAndView("veg-viewall");
		model.addObject("listOfVegetables", listOfForm);
		return model;
	}

	@GetMapping("/delete/page")
	public String deletePage() {
		return "veg-delete";
	}

	@PostMapping("/delete/search")
	public ModelAndView searchForDelete(@RequestParam String searchVegetables) {
		VegetableBO vegBo = service.getItemByName(searchVegetables);
		if (vegBo == null) {
			ModelAndView modelView = new ModelAndView("veg-delete");
			modelView.addObject("Item not found");
			return modelView;
		}
		VegetableForm vegForm = formMapper.map(vegBo);
		ModelAndView modelView = new ModelAndView("veg-delete");
		modelView.addObject("VegetableForm", vegForm);
		return modelView;
	}

	@PostMapping("/delete")
	public String deleteVegetables(@RequestParam String vegName, Model model) {
		int count = service.deleteVegetables(vegName);

		String message;
		if (count > 0) {
			message = count + (count == 1 ? " item deleted successfully." : " items  deleted successfully.");
		} else {
			message = "No items  deleted. Please check name.";
		}

		model.addAttribute("message", message);
		model.addAttribute("count", count);

		return "veg-delete";
	}

}
