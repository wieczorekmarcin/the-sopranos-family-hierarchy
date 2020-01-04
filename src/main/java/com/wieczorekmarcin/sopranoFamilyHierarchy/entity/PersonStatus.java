package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

public enum PersonStatus {
	AT_LARGE("At large"),
	IN_PRISON("In prison"),
	DEAD("Dead"),;

	private String personStatus;

	PersonStatus(String personStatus) {
		this.personStatus = personStatus;
	}

	public String getPersonStatus() {
		return personStatus;
	}

	public void setPersonStatus(String personStatus) {
		this.personStatus = personStatus;
	}
}
