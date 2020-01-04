package com.wieczorekmarcin.sopranoFamilyHierarchy.repository;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.*;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyRepository extends Neo4jRepository<Family, Long> {
	@Query("MATCH (n:Family) RETURN n")
	List<Family> findAll();

	@Query("MATCH (n:Family) where ID(n) = {0} RETURN n LIMIT 1")
	Optional<Family> findById(Long id);

	@Query("MATCH (n:Family) WHERE n.name = {0} RETURN n LIMIT 1")
	Family findByName(String name);

	default List<FamilyWar> getFamilyWars(Session session, PersonRepository personRepository) {
		String query = "MATCH (p1:Person)-[:KILLED_BY]->(p2), (p1)-[:FAMILY_MEMBER]->(f1), (p2)-[:FAMILY_MEMBER]->(f2)\n" +
				"WHERE f1.name <> f2.name\n" +
				"WITH p1 AS victim, p2 AS killer\n" +
				"RETURN killer, victim";
		Result result = session.run(query);
		List<FamilyWar> objectResponse = new ArrayList<>();
		result.stream().forEach(record -> {
			String killerLastName = record.get("killer").get("lastName").asString();
			String victimLastName = record.get("victim").get("lastName").asString();

			Person killer = personRepository.findByLastName(killerLastName);
			Person victim = personRepository.findByLastName(victimLastName);

			objectResponse.add(new FamilyWar(killer, victim));
		});
		session.close();
		return objectResponse;
	}

	default List<MostButalFamily> getMostButalFamilies(Session session, FamilyRepository familyRepository) {
		String query = "MATCH (p1:Person)-[:KILLED_BY]->(p2), (p2:Person)-[:FAMILY_MEMBER]->(f1)\n" +
				"WITH COUNT(p2) AS numberOfKillings, f1 AS family\n" +
				"MATCH (p3:Person)-[r:FAMILY_MEMBER]->(family)\n" +
				"WITH numberOfKillings AS number_of_killings, numberOfKillings * 1.0 / COUNT(r) * 1.0 AS kill_per_members, family as family, count(r) as family_members\n" +
				"RETURN family, family_members, number_of_killings , kill_per_members\n" +
				"ORDER BY kill_per_members DESC";
		Result result = session.run(query);
		List<MostButalFamily> objectResponse = new ArrayList<>();
		result.stream().forEach(record -> {
			String familyName = record.get("family").get("name").asString();
			Long familyMembers = record.get("family_members").asLong();
			Long number_of_killings = record.get("number_of_killings").asLong();
			Double kill_per_members = record.get("kill_per_members").asDouble();

			Family family = familyRepository.findByName(familyName);

			objectResponse.add(new MostButalFamily(family, familyMembers, number_of_killings, kill_per_members));
		});
		session.close();
		return objectResponse;
	}

	default List<MostEffectiveFamily> getMostEffectiveFamilies(Session session, FamilyRepository familyRepository) {
		String query = "MATCH (p1:Person)-[:IS]->(is), (p1:Person)-[:FAMILY_MEMBER]->(f1)\n" +
				"WITH COUNT(p1) AS persons_with_status, f1 AS family, is.status as status\n" +
				"MATCH (p3:Person)-[r:FAMILY_MEMBER]->(family)\n" +
				"WITH persons_with_status AS perons_at_large, persons_with_status * 1.0 / COUNT(r) * 1.0 AS persons_at_large_per_members, family as family, status as status, count(r) as family_members\n" +
				"WHERE status = 'AT_LARGE'\n" +
				"RETURN family, family_members, perons_at_large , persons_at_large_per_members\n" +
				"ORDER BY persons_at_large_per_members DESC";
		Result result = session.run(query);
		List<MostEffectiveFamily> objectResponse = new ArrayList<>();
		result.stream().forEach(record -> {
			String familyName = record.get("family").get("name").asString();
			Long familyMembers = record.get("family_members").asLong();
			Long peronsAtLarge = record.get("perons_at_large").asLong();
			Double personsAtLargePerMembers = record.get("persons_at_large_per_members").asDouble();

			Family family = familyRepository.findByName(familyName);

			objectResponse.add(new MostEffectiveFamily(family, familyMembers, peronsAtLarge, personsAtLargePerMembers));
		});
		session.close();
		return objectResponse;
	}
}
