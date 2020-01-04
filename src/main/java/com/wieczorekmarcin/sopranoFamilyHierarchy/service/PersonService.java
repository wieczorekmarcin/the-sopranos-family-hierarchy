package com.wieczorekmarcin.sopranoFamilyHierarchy.service;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.BestKiller;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.BestVictim;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.Person;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonRepository;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public List<Person> getPersons() {
		return repository.findAll();
	}

	public Person getPerson(Long id) {
		Optional<Person> optById = repository.findById(id);
		return optById.orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
	}

	public Person createPerson(Person person) {
		return repository.save(person);
	}

	public Person updatePerson(long id, Person person) {
		Person updatedPerson = getPerson(id);
		updatedPerson.setFirstName(person.getFirstName());
		updatedPerson.setLastName(person.getLastName());
		return repository.save(person);
	}

	public List<BestKiller> getBestKillers(Session session, String limit, String sort) {
		String queryLimit = limit != null ? " LIMIT " + limit : "";
		String querySort = sort != null ? sort.toUpperCase() : "DESC";
		return repository.getBestKillers(session, queryLimit, querySort);
	}

	public List<BestVictim> getBestVictims(Session session, String limit, String sort) {
		String queryLimit = limit != null ? " LIMIT " + limit : "";
		String querySort = sort != null ? sort.toUpperCase() : "DESC";
		return repository.getBestVictims(session, queryLimit, querySort);
	}
}
