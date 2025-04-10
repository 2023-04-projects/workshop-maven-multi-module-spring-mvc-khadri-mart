package com.khadri.spring.mvc.grosary.controller;

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

import com.khadri.spring.mvc.grosary.controller.form.GrosaryForm;
import com.khadri.spring.mvc.grosary.controller.mapper.GrosaryBOToGrosaryForm;
import com.khadri.spring.mvc.grosary.controller.mapper.GrosaryFormToGrosaryBO;
import com.khadri.spring.mvc.grosary.service.GrosaryService;
import com.khadri.spring.mvc.grosary.service.bo.GrosaryBO;

@Controller
@RequestMapping("/grosary")
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

	@ResponseBody
	@PostMapping("/add")
	public String addGrosary(@ModelAttribute GrosaryForm grosaryForm) {
		System.out.println("Entered into Grosary Add Controller");

		GrosaryBO grosaryBO = formToMapper.map(grosaryForm);

		int result = service.addGrosaryItem(grosaryBO);

		return result + " Grosary added sucessfully";
	}

	@PostMapping("/search")
	public ModelAndView searchGrosary(@RequestParam String searchGrosary) {
		System.out.println("Entered into Grosary Add Controller");

		List<GrosaryBO> listOfBo = service.searchGrosaryItem(searchGrosary);
		List<GrosaryForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("searchListOfItem", listOfSearchItemForms);
		ModelAndView modelAndView = new ModelAndView("grosary-modify-search", modelMap);
		return modelAndView;
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
	@ResponseBody
	public String updateGrosary(@ModelAttribute GrosaryForm grosaryForm) {
		System.out.println("Updating item: " + grosaryForm.getGrosaryName());

		GrosaryBO bo = formToMapper.map(grosaryForm);
		int count = service.updateGrosaryItem(bo);
		return count + "Grosary Modified Successfully";
	}

	@GetMapping("/view")
	public ModelAndView viewItem(@RequestParam(name = "grosaryName", required = false) String grosaryName) {
		List<GrosaryBO> listOfBo = service.searchGrosaryItem(grosaryName);
		List<GrosaryForm> listOfSearchItemForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("grosary-view");
		model.addObject("listOfGrosary", listOfSearchItemForms);
		model.addObject("searchName", grosaryName);
		return model;
	}

	@GetMapping("/viewall")
	public ModelAndView viewAllGrosary() {
		List<GrosaryBO> listOfBo = service.viewAllGrosary();
		List<GrosaryForm> listOfForms = boToFormMapper.map(listOfBo);

		ModelAndView model = new ModelAndView("grosary-viewall");
		model.addObject("listOfGrosary", listOfForms);
		return model;
	}

	@PostMapping("/delete/search")
	public ModelAndView searchForDelete(@RequestParam String grosaryName) {
		GrosaryBO bo = service.getItemByName(grosaryName);

		if (bo == null) {
			ModelAndView mv = new ModelAndView("grosary-delete");
			mv.addObject("message", "Item not found");
			return mv;
		}

		GrosaryForm form = boToFormMapper.map(bo);
		ModelAndView mv = new ModelAndView("grosary-delete");
		mv.addObject("GrosaryForm", form);
		return mv;
	}

	@PostMapping("/delete")
	public String deleteGrosary(@RequestParam String grosaryName, Model model) {
		int result = service.deleteGrosaryItem(grosaryName);
		String message = result > 0 ? "Deleted successfully" : "Deletion failed";
		model.addAttribute("message", message);
		return "grosary-delete";
	}

}
