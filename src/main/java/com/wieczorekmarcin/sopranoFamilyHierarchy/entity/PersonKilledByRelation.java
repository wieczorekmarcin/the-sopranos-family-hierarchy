package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "KILLED_BY")
public class PersonKilledByRelation {

	@Id
	@GeneratedValue
	private Long id;

	@StartNode
	private Person person;

	@EndNode
	private Person killedByPerson;

	public PersonKilledByRelation(Person person, Person killedByPerson) {
		this.person = person;
		this.killedByPerson = killedByPerson;
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

	public Person getKilledByPerson() {
		return killedByPerson;
	}

	public void setKilledByPerson(Person killedByPerson) {
		this.killedByPerson = killedByPerson;
	}
}
