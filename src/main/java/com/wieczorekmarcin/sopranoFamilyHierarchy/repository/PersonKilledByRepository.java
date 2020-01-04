package com.wieczorekmarcin.sopranoFamilyHierarchy.repository;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.Person;
import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.PersonKilledByRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PersonKilledByRepository extends Neo4jRepository<PersonKilledByRelation, Long> {
	List<PersonKilledByRelation> findAll();
}