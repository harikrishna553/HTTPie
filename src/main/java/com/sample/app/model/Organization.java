package com.sample.app.model;

public class Organization {
	private String name;
	private int establishedYear;
	private OrganizationAddress address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}

	public OrganizationAddress getAddress() {
		return address;
	}

	public void setAddress(OrganizationAddress address) {
		this.address = address;
	}

}
