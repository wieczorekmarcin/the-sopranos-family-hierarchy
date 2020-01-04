package com.wieczorekmarcin.sopranoFamilyHierarchy.repository;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.PersonFamilyRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PersonFamilyRepository extends Neo4jRepository<PersonFamilyRelation, Long> {
	List<PersonFamilyRelation> findAll();
}