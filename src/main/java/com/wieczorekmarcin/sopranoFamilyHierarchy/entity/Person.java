package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String pseudonym;
	private String sex;

	@Relationship(value = "IS", direction = Relationship.OUTGOING)
	private Status status;

	@Relationship(value = "HAS_POSITION", direction = Relationship.OUTGOING)
	private Position position;

	@Relationship(value = "KILLED_BY", direction = Relationship.OUTGOING)
	private PersonKilledByRelation killedBy;

	public Person(String firstName, String lastName, String sex, String pseudonym, Position position, Status status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.pseudonym = pseudonym;
		this.position = position;
		this.status = status;
	}

	public Person(String firstName, String lastName, String sex, Position position, Status status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.position = position;
		this.status = status;
	}

	public Person() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public PersonKilledByRelation getKilledBy() {
		return killedBy;
	}

	public void setKilledBy(PersonKilledByRelation killedBy) {
		this.killedBy = killedBy;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}