package com.sumit.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sumit.petclinic.model.Owner;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);

}
