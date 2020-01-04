package com.wieczorekmarcin.sopranoFamilyHierarchy.service;


import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	@Autowired
	MainRepository repository;

	public void deleteAll() {
		repository.deleteAll();
	}

}
