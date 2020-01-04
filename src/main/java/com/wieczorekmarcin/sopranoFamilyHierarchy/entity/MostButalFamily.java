package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class MostButalFamily {
	private Family family;
	private Long familyMmbers;
	private Long numberOfKillings;
	private Double killPerMembers;

	public MostButalFamily(Family family, Long familyMmbers, Long numberOfKillings, Double killPerMembers) {
		this.family = family;
		this.familyMmbers = familyMmbers;
		this.numberOfKillings = numberOfKillings;
		this.killPerMembers = killPerMembers;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Long getFamilyMmbers() {
		return familyMmbers;
	}

	public void setFamilyMmbers(Long familyMmbers) {
		this.familyMmbers = familyMmbers;
	}

	public Long getNumberOfKillings() {
		return numberOfKillings;
	}

	public void setNumberOfKillings(Long numberOfKillings) {
		this.numberOfKillings = numberOfKillings;
	}

	public Double getKillPerMembers() {
		return killPerMembers;
	}

	public void setKillPerMembers(Double killPerMembers) {
		this.killPerMembers = killPerMembers;
	}
}
