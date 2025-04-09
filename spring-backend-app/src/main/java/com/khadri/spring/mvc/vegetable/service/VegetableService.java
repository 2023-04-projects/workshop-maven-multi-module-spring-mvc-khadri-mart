package com.khadri.spring.mvc.vegetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.vegetable.dao.VegetableDao;
import com.khadri.spring.mvc.vegetable.dao.dto.VegetableDto;
import com.khadri.spring.mvc.vegetable.service.bo.VegetableBO;
import com.khadri.spring.mvc.vegetable.service.mapper.VegetableBOToVegetableDto;

@Service
public class VegetableService {

	private VegetableDao dao;

	private VegetableBOToVegetableDto mapper;

	@Autowired
	public VegetableService(VegetableDao dao, VegetableBOToVegetableDto mapper) {
		System.out.println("VegetableService Constructor");
		this.dao = dao;
		this.mapper = mapper;
	}

	public int addVegetables(VegetableBO vegBo) {
		System.out.println("Entered into Vegetable Service");
		VegetableDto dto = mapper.map(vegBo);

		return dao.insertVegetables(dto);

	}

	public List<VegetableBO> searchVegetables(String searchName) {
		System.out.println("Entered into Vegetable Service");

		List<VegetableBO> searchVegetables = dao.selectVegetables(searchName);

		return searchVegetables;

	}

	public VegetableBO getItemByName(String vegName) {
		System.out.println("entered into getItemByName VegetableService");
		List<VegetableBO> list = dao.selectVegetables(vegName);

		return list.isEmpty() ? null : list.get(0);

	}

	public int updateVegetables(VegetableBO vegBo) {

		System.out.println("vegetables updated");
		return dao.updateVegetables(vegBo);
	}

	public List<VegetableBO> viewAllVegetables() {
		return dao.selectAllVegetables();
	}

	public int deleteVegetables(String name) {
		return dao.deleteVegetables(name);
	}

}
