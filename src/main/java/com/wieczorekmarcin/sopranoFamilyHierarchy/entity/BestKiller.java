package com.wieczorekmarcin.sopranoFamilyHierarchy.entity;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class BestKiller {
	String killer;
	Long numberOfLillings;

	public BestKiller(String killer, Long numberOfLillings) {
		this.killer = killer;
		this.numberOfLillings = numberOfLillings;
	}

	public String getKiller() {
		return killer;
	}

	public void setKiller(String killer) {
		this.killer = killer;
	}

	public Long getNumberOfLillings() {
		return numberOfLillings;
	}

	public void setNumberOfLillings(Long numberOfLillings) {
		this.numberOfLillings = numberOfLillings;
	}
}
