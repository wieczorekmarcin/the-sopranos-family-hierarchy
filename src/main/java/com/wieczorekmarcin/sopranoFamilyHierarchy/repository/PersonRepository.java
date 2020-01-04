package com.wieczorekmarcin.sopranoFamilyHierarchy.repository;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.BestKiller;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.BestVictim;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.Person;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
	@Query("MATCH (n:Person) RETURN n")
	List<Person> findAll();

	@Query("MATCH (n:Person) where ID(n) = {0} RETURN n LIMIT 1")
	Optional<Person> findById(Long id);

	@Query("MATCH (n:Person) WHERE n.lastName = {0} RETURN n LIMIT 1")
	Person findByLastName(String lastName);

	default List<BestKiller> getBestKillers(Session session, String limit, String sort) {
		String query = "MATCH (n:Person)-[:KILLED_BY]->(m)\n" +
				"RETURN m.firstName + ' ' +  m.lastName AS killer, \n" +
				"COUNT(*)  AS number_of_killings ORDER BY number_of_killings " + sort + " " + limit;
		Result result = session.run(query);
		List<BestKiller> objectResponse = new ArrayList<>();
		result.stream().forEach(record -> {
			objectResponse.add(new BestKiller(record.get("killer").asString(), record.get("number_of_killings").asLong()));
		});
		session.close();
		return objectResponse;
	}

	default List<BestVictim> getBestVictims(Session session, String limit, String sort) {
		String query = "MATCH (n:Person)-[:KILLED_BY]->(m)\n" +
				"RETURN n.firstName + ' ' +  n.lastName AS victim, \n" +
				"COUNT(*)  AS number_of_killers ORDER BY number_of_killers " + sort + " " + limit;
		Result result = session.run(query);
		List<BestVictim> objectResponse = new ArrayList<>();
		result.stream().forEach(record -> {
			objectResponse.add(new BestVictim(record.get("victim").asString(), record.get("number_of_killers").asLong()));
		});
		session.close();
		return objectResponse;
	}
}
