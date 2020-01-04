package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

public enum FamilyPosition {
	FOUNDER("Founder"),
	BOSS("Boss"),
	UNDERBOSS("Underboss"),
	CONSIGLIERE("Consigliere"),
	CAPOREGIME("Caporegime"),
	SOLDIER("Soldier"),
	ASSOCIATE("Associate");

	private String positon;

	FamilyPosition(String positon) {
		this.positon = positon;
	}

	public String getPositon() {
		return positon;
	}

	public void setPositon(String positon) {
		this.positon = positon;
	}
}
