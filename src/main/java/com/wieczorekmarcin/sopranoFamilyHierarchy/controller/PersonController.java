package com.wieczorekmarcin.sopranoFamilyHierarchy.controller;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.BestKiller;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.BestVictim;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.Person;
import com.wieczorekmarcin.sopranoFamilyHierarchy.service.PersonService;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PersonController {

	private final Driver driver;

	@Autowired
	private PersonService service;

	public PersonController(Driver driver) {
		this.driver = driver;
	}

	@RequestMapping(path = "/persons", method = RequestMethod.GET)
	public @ResponseBody List<Person> getPersons() {
		return service.getPersons();
	}

	@RequestMapping(path = "/persons/{id}", method = RequestMethod.GET)
	public @ResponseBody Person getPerson(@PathVariable long id) {
		return service.getPerson(id);
	}

	@RequestMapping(path = "/persons", method = RequestMethod.POST)
	public @ResponseBody Person createPerson(@RequestBody Person person) {
		return service.createPerson(person);
	}

	@RequestMapping(path = "/persons/{id}", method = RequestMethod.PUT)
	public @ResponseBody Person updatePerson(@PathVariable long id,
											 @RequestBody Person person) {
		return service.updatePerson(id, person);
	}

	@RequestMapping(path = "/persons/rank/bestKillers", method = RequestMethod.GET)
	public @ResponseBody List<BestKiller> getBestKillers(@RequestParam(name = "limit", required=false) String limit,
														 @RequestParam(name = "sort", required=false) String sort) {
		return service.getBestKillers(driver.session(), limit, sort);
	}

	@RequestMapping(path = "/persons/rank/bestVictims", method = RequestMethod.GET)
	public @ResponseBody List<BestVictim> getBestVictims(@RequestParam(name = "limit", required=false) String limit,
														 @RequestParam(name = "sort", required=false) String sort) {
		return service.getBestVictims(driver.session(), limit, sort);
	}
}
