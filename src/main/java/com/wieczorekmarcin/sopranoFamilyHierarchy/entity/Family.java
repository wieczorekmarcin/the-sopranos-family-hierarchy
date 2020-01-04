package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity

public class Family {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String territory;

	private long soldiersAndAssociates;

	@Relationship(value = "FAMILY_MEMBER", direction = Relationship.INCOMING)
	private PersonFamilyRelation familyMember;

	@Relationship(value = "ALLIANCE_WITH", direction = Relationship.UNDIRECTED)
	private FamilyAllianceFamilyRelation allianceWith;

	public Family(String name, String territory, long soldiersAndAssociates) {
		this.name = name;
		this.territory = territory;
		this.soldiersAndAssociates = soldiersAndAssociates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSoldiersAndAssociates() {
		return soldiersAndAssociates;
	}

	public void setSoldiersAndAssociates(long soldiersAndAssociates) {
		this.soldiersAndAssociates = soldiersAndAssociates;
	}

	public PersonFamilyRelation getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(PersonFamilyRelation familyMember) {
		this.familyMember = familyMember;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public FamilyAllianceFamilyRelation getAllianceWith() {
		return allianceWith;
	}

	public void setAllianceWith(FamilyAllianceFamilyRelation allianceWith) {
		this.allianceWith = allianceWith;
	}
}
