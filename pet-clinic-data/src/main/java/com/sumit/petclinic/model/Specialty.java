package com.sumit.petclinic.model;

import javax.persistence.Entity;

@Entity
public class Specialty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2449373334518839537L;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}