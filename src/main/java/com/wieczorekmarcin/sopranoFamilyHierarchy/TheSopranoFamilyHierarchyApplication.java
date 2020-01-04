package com.wieczorekmarcin.sopranoFamilyHierarchy;

import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.FamilyPartOfFamilyRepository;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonFamilyRepository;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonKilledByRepository;
import com.wieczorekmarcin.sopranoFamilyHierarchy.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
public class TheSopranoFamilyHierarchyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheSopranoFamilyHierarchyApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PersonFamilyRepository personFamilyRepository,
						   PersonKilledByRepository personKilledByRepository,
						   FamilyPartOfFamilyRepository familyPartOfFamilyRepository,
						   PersonRepository personRepository) {

		InitialData initialData = new InitialData(personFamilyRepository,
				personKilledByRepository,
				familyPartOfFamilyRepository,
				personRepository);

		return args -> {
			initialData.init();
		};
	}
}
