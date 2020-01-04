package com.wieczorekmarcin.sopranoFamilyHierarchy;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.*;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.FamilyPartOfFamilyRepository;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonFamilyRepository;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonKilledByRepository;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonRepository;

import java.util.Arrays;
import java.util.List;

public class InitialData {

	PersonFamilyRepository personFamilyRepository;
	PersonKilledByRepository personKilledByRepository;
	FamilyPartOfFamilyRepository familyPartOfFamilyRepository;
	PersonRepository personRepository;

	public InitialData(PersonFamilyRepository personFamilyRepository,
					   PersonKilledByRepository personKilledByRepository,
					   FamilyPartOfFamilyRepository familyPartOfFamilyRepository,
					   PersonRepository personRepository) {
		this.personFamilyRepository = personFamilyRepository;
		this.personKilledByRepository = personKilledByRepository;
		this.familyPartOfFamilyRepository = familyPartOfFamilyRepository;
		this.personRepository = personRepository;
	}

	protected void init() {
		List<Person> personsDiMeo = Arrays.asList(
				new Person("Anthony", "Soprano", "Male", "Tony", new Position(FamilyPosition.BOSS), new Status(PersonStatus.AT_LARGE)),
				new Person("Silvio", "Dante", "Male", new Position(FamilyPosition.CONSIGLIERE), new Status(PersonStatus.AT_LARGE)),
				new Person("Albert", "Barese", "Male", "Ally Boy", new Position(FamilyPosition.CAPOREGIME), new Status(PersonStatus.IN_PRISON)),
				new Person("Paul", "Gualtieri", "Male", "Paulie Walnuts", new Position(FamilyPosition.CAPOREGIME), new Status(PersonStatus.AT_LARGE)),
				new Person("Salvatore", "Bompensiero", "Male", "Bg Pussy", new Position(FamilyPosition.SOLDIER), new Status(PersonStatus.DEAD)),
				new Person("Ercole", "DiMeo", "Male", "Old Man", new Position(FamilyPosition.FOUNDER), new Status(PersonStatus.IN_PRISON)),
				new Person("Giacomo Michael", "Aprile", "Male", "Jackie", new Position(FamilyPosition.BOSS), new Status(PersonStatus.DEAD)),
				new Person("John", "Soprano", "Male", "Uncle Junio", new Position(FamilyPosition.BOSS), new Status(PersonStatus.AT_LARGE)),
				new Person("Robert", "Baccalieri", "Male", "Bobby Bacala", new Position(FamilyPosition.UNDERBOSS), new Status(PersonStatus.DEAD)),
				new Person("Michael", "Palmice", "Male", "Mikey Grab Bag", new Position(FamilyPosition.CONSIGLIERE), new Status(PersonStatus.DEAD)),
				new Person("Christopher", "Moltisanti", "Male", new Position(FamilyPosition.CAPOREGIME), new Status(PersonStatus.DEAD)),
				new Person("Michele", "La Manna", "Male", "Feech the King of Breadsticks", new Position(FamilyPosition.CAPOREGIME), new Status(PersonStatus.AT_LARGE)),
				new Person("Burt", "Gervasi", "Male", new Position(FamilyPosition.SOLDIER), new Status(PersonStatus.DEAD)),
				new Person("Brendan", "Filone", "Male", new Position(FamilyPosition.ASSOCIATE), new Status(PersonStatus.DEAD)),
				new Person("Sean", "Gismonte", "Male", new Position(FamilyPosition.ASSOCIATE), new Status(PersonStatus.DEAD)),
				new Person("Matthew", "Bavilaqua", "Male", new Position(FamilyPosition.ASSOCIATE), new Status(PersonStatus.DEAD)),
				new Person("Vito", "Spatafore", "Male", new Position(FamilyPosition.UNDERBOSS), new Status(PersonStatus.DEAD))
		);

		List<Person> personsBuscetta = Arrays.asList(
				new Person("Angelo", "Buscetta", "Male", new Position(FamilyPosition.FOUNDER), new Status(PersonStatus.AT_LARGE)),
				new Person("Mario", "Buscettaa", "Male", new Position(FamilyPosition.UNDERBOSS), new Status(PersonStatus.DEAD))
		);

		List<Person> personsLupertazzi = Arrays.asList(
				new Person("Carmine", "Lupertazzi", "Male", new Position(FamilyPosition.FOUNDER), new Status(PersonStatus.DEAD)),
				new Person("Angelo", "Garepe", "Male", new Position(FamilyPosition.CAPOREGIME), new Status(PersonStatus.AT_LARGE)),
				new Person("John", "Sacrimoni", "Male", new Position(FamilyPosition.UNDERBOSS), new Status(PersonStatus.DEAD)),
				new Person("Phil", "Leotardo", "Male", new Position(FamilyPosition.UNDERBOSS), new Status(PersonStatus.AT_LARGE)),
				new Person("Butch", "DeConcini", "Male", new Position(FamilyPosition.SOLDIER), new Status(PersonStatus.AT_LARGE)),
				new Person("Rusty", "Millio", "Male", new Position(FamilyPosition.SOLDIER), new Status(PersonStatus.AT_LARGE))
		);

		List<Person> personsVittorio = Arrays.asList(
				new Person("Annalisa", "Zucca", "Female", new Position(FamilyPosition.BOSS), new Status(PersonStatus.AT_LARGE)),
				new Person("Nino", "", "Male", new Position(FamilyPosition.UNDERBOSS), new Status(PersonStatus.AT_LARGE)),
				new Person("Camilio", "Pino", "Male", new Position(FamilyPosition.CAPOREGIME), new Status(PersonStatus.AT_LARGE))
		);

		Family familyDiMeo = new Family("DiMeo", "Northern New Jersey, Miami", 60);
		Family familyBuscetta = new Family("Buscetta", "Philadelphia", 350);
		Family familyLupertazzi = new Family("Lupertazzi", "Brooklyn, Long Island, Miami", 75);
		Family familyVittorio = new Family("Vittorio/Zucca Camorra", "Naples, Campania", 20);

		List<List<String>> killedPersonsList = Arrays.asList(
				Arrays.asList("Palmice", "Gualtieri"),
				Arrays.asList("Bompensiero", "Soprano"),
				Arrays.asList("Bompensiero", "Dante"),
				Arrays.asList("Bompensiero", "Gualtieri"),
				Arrays.asList("Filone", "Palmice"),
				Arrays.asList("Gismonte", "Moltisanti"),
				Arrays.asList("Palmice", "Gualtieri"),
				Arrays.asList("Bavilaqua", "Soprano"),
				Arrays.asList("Bavilaqua", "Bompensiero"),
				Arrays.asList("Moltisanti", "Soprano"),
				Arrays.asList("Buscettaa", "Gualtieri"),
				Arrays.asList("Spatafore", "Leotardo")
		);

		initRelations(personsDiMeo, familyDiMeo, null);
		initRelations(personsBuscetta, familyBuscetta, null);
		initRelations(personsLupertazzi, familyLupertazzi, familyDiMeo);
		initRelations(personsVittorio, familyVittorio, familyDiMeo);

		killedPersonsList.forEach(list -> {
			Person personKilled = personRepository.findByLastName(list.get(0));
			Person killer = personRepository.findByLastName(list.get(1));
			if (killer != null && personKilled != null) {
				personKilledByRepository.save(new PersonKilledByRelation(personKilled, killer));
			}
		});
	}

	private void initRelations(List<Person> personList, Family family, Family allianceFamily) {
		personList.forEach(person -> {
			personFamilyRepository.save(new PersonFamilyRelation(person, family));
		});

		if (allianceFamily != null) {
			familyPartOfFamilyRepository.save(new FamilyAllianceFamilyRelation(family, allianceFamily));
		}
	}
}
