package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class FamilyWar {
	private Person killer;
	private Person victim;

	public FamilyWar(Person killer, Person victim) {
		this.killer = killer;
		this.victim = victim;
	}

	public Person getKiller() {
		return killer;
	}

	public void setKiller(Person killer) {
		this.killer = killer;
	}

	public Person getVictim() {
		return victim;
	}

	public void setVictim(Person victim) {
		this.victim = victim;
	}
}
