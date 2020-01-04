package com.wieczorekmarcin.sopranoFamilyHierarchy.repository;

import org.neo4j.ogm.model.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends Neo4jRepository<Node, Long> {

	@Query("MATCH (n) DETACH DELETE n")
	void deleteAll();
}
