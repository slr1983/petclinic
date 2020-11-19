package com.sumit.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Specialty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2449373334518839537L;

	@ManyToOne
	@JoinColumn(name = "speciality_description")
	private String description;

	@ManyToMany(mappedBy = "specialties")
	private Vet vet;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Vet getVet() {
		return vet;
	}

	public void setVet(Vet vet) {
		this.vet = vet;
	}

}