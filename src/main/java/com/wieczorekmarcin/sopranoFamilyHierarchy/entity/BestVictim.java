package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class BestVictim {
	String victim;
	Long numberOfKillers;

	public BestVictim(String victim, Long numberOfKillers) {
		this.victim = victim;
		this.numberOfKillers = numberOfKillers;
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	public Long getNumberOfKillers() {
		return numberOfKillers;
	}

	public void setNumberOfKillers(Long numberOfKillers) {
		this.numberOfKillers = numberOfKillers;
	}
}
