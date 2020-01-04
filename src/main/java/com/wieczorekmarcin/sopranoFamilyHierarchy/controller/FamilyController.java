package com.wieczorekmarcin.sopranoFamilyHierarchy.controller;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.Family;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.FamilyWar;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.MostButalFamily;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.MostEffectiveFamily;
import com.wieczorekmarcin.sopranoFamilyHierarchy.service.FamilyService;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class FamilyController {

	private final Driver driver;

	@Autowired
	private FamilyService service;

	public FamilyController(Driver driver) {
		this.driver = driver;
	}

	@RequestMapping(path = "/families", method = RequestMethod.GET)
	public @ResponseBody List<Family> getFamilies() {
		return service.getFamilies();
	}

	@RequestMapping(path = "/families/{id}", method = RequestMethod.GET)
	public @ResponseBody Family getFamily(@PathVariable long id) {
		return service.getFamily(id);
	}

	@RequestMapping(path = "/families", method = RequestMethod.POST)
	public @ResponseBody Family createFamily(@RequestBody Family person) {
		return service.createFamily(person);
	}

	@RequestMapping(path = "/families/{id}", method = RequestMethod.PUT)
	public @ResponseBody Family updateFamily(@PathVariable long id,
											 @RequestBody Family person) {
		return service.updateFamily(id, person);
	}

	@RequestMapping(path = "/families/rank/wars", method = RequestMethod.GET)
	public @ResponseBody List<FamilyWar> getFamilyWars() {
		return service.getFamilyWars(driver.session());
	}

	@RequestMapping(path = "/families/rank/mostBrutal", method = RequestMethod.GET)
	public @ResponseBody List<MostButalFamily> getMostButalFamilies() {
		return service.getMostButalFamilies(driver.session());
	}

	@RequestMapping(path = "/families/rank/mostEffective", method = RequestMethod.GET)
	public @ResponseBody List<MostEffectiveFamily> getMostEffectiveFamily() {
		return service.getMostEffectiveFamilies(driver.session());
	}
}
