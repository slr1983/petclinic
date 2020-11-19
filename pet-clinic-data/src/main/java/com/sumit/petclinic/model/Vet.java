package com.sumit.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8736692213999909419L;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"),
	inverseJoinColumns = @JoinColumn(name  = "speciality_id"))
	private Set<Specialty> specialties = new HashSet<Specialty>();

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
	
	

}
