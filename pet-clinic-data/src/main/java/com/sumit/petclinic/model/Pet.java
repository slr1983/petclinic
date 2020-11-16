package com.sumit.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -416244833728028894L;
	private String petName;
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;
	
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public PetType getPetType() {
		return petType;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
