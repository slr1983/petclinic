package com.sumit.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sumit.petclinic.model.Pet;

public interface PetRepo extends CrudRepository<Pet, Long> {

}
