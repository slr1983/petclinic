package com.sumit.petclinic.model;

import java.util.Set;

public class Owner extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8844833556503648393L;

	private Set<Pet> pets;

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
