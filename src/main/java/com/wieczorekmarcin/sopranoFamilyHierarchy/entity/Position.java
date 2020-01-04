package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Position {

	@Id
	@GeneratedValue
	private Long id;

	private FamilyPosition familyPosition;

	public Position(FamilyPosition familyPosition) {
		this.familyPosition = familyPosition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FamilyPosition getFamilyPosition() {
		return familyPosition;
	}

	public void setFamilyPosition(FamilyPosition familyPosition) {
		this.familyPosition = familyPosition;
	}
}
