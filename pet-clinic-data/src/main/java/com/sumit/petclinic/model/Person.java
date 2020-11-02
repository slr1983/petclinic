package com.sumit.petclinic.model;

public class Person extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1594731065960727169L;
	private String firstName;
	private String lastName;

	public Person() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
