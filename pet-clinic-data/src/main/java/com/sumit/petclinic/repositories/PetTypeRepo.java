package com.sumit.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sumit.petclinic.model.PetType;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {

}
