package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "ALLIANCE_WITH")
public class FamilyAllianceFamilyRelation {

	@Id
	@GeneratedValue
	private Long id;

	@StartNode
	private Family familyPartOf;

	@EndNode
	private Family family;

	public FamilyAllianceFamilyRelation(Family familyPartOf, Family family) {
		this.familyPartOf = familyPartOf;
		this.family = family;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Family getFamilyPartOf() {
		return familyPartOf;
	}

	public void setFamilyPartOf(Family familyPartOf) {
		this.familyPartOf = familyPartOf;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
}
