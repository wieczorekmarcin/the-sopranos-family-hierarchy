package com.wieczorekmarcin.sopranoFamilyHierarchy.controller;

import com.wieczorekmarcin.sopranoFamilyHierarchy.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	private MainService service;

	@RequestMapping(path = "/deleteAll", method = RequestMethod.POST)
	public @ResponseBody void deleteAll() {
		service.deleteAll();
	}
}
