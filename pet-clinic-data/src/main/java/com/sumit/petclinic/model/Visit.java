package com.sumit.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object representing a visit.

 */
@Entity
@Table(name = "scheduled_visits")
public class Visit extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2512908735945716444L;

	private LocalDate date;

	private String description;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	/**
	 * Creates a new instance of Visit for the current date
	 */
	public Visit() {
		this.date = LocalDate.now();
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

}
