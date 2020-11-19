package com.sumit.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sumit.petclinic.model.Vet;

public interface VetRepo extends CrudRepository<Vet, Long> {

}
