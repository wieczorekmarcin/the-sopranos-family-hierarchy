package com.wieczorekmarcin.sopranoFamilyHierarchy.repository;

import com.wieczorekmarcin.sopranoFamilyHierarchy.entity.FamilyAllianceFamilyRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface FamilyPartOfFamilyRepository extends Neo4jRepository<FamilyAllianceFamilyRelation, Long> {
	List<FamilyAllianceFamilyRelation> findAll();
}