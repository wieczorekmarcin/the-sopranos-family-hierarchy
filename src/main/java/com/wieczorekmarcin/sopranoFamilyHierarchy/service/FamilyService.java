package com.wieczorekmarcin.sopranoFamilyHierarchy.service;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.Family;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.FamilyWar;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.MostButalFamily;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.MostEffectiveFamily;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.FamilyRepository;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonRepository;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class FamilyService {

	@Autowired
	private FamilyRepository repository;

	@Autowired
	private PersonRepository personRepository;

	public List<Family> getFamilies() {
		return repository.findAll();
	}

	public Family getFamily(Long id) {
		Optional<Family> optById = repository.findById(id);
		return optById.orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
	}

	public Family createFamily(Family family) {
		return repository.save(family);
	}

	public Family updateFamily(long id, Family family) {
		Family updatedFamily = getFamily(id);
		updatedFamily.setName(family.getName());
		return repository.save(family);
	}

	public List<FamilyWar> getFamilyWars(Session session) {
		return repository.getFamilyWars(session, personRepository);
	}

	public List<MostButalFamily> getMostButalFamilies(Session session) {
		return repository.getMostButalFamilies(session, repository);
	}

	public List<MostEffectiveFamily> getMostEffectiveFamilies(Session session) {
		return repository.getMostEffectiveFamilies(session, repository);
	}
}
