package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

public class MostEffectiveFamily {
	private Family family;
	private Long familyMembers;
	private Long peronsAtLarge;
	private Double personsAtLargePerMembers;

	public MostEffectiveFamily(Family family, Long familyMembers, Long peronsAtLarge, Double personsAtLargePerMembers) {
		this.family = family;
		this.familyMembers = familyMembers;
		this.peronsAtLarge = peronsAtLarge;
		this.personsAtLargePerMembers = personsAtLargePerMembers;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Long getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Long familyMembers) {
		this.familyMembers = familyMembers;
	}

	public Long getPeronsAtLarge() {
		return peronsAtLarge;
	}

	public void setPeronsAtLarge(Long peronsAtLarge) {
		this.peronsAtLarge = peronsAtLarge;
	}

	public Double getPersonsAtLargePerMembers() {
		return personsAtLargePerMembers;
	}

	public void setPersonsAtLargePerMembers(Double personsAtLargePerMembers) {
		this.personsAtLargePerMembers = personsAtLargePerMembers;
	}
}
