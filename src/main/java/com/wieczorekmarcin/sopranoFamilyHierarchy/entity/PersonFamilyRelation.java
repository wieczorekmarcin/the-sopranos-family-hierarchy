package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "FAMILY_MEMBER")
public class PersonFamilyRelation {

	@Id
	@GeneratedValue
	private Long id;

	@StartNode
	private Person person;

	@EndNode
	private Family family;

	public PersonFamilyRelation(Person person, Family family) {
		this.person = person;
		this.family = family;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
}
