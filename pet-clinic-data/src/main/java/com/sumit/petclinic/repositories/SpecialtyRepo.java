package com.sumit.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sumit.petclinic.model.Specialty;

public interface SpecialtyRepo extends CrudRepository<Specialty, Long> {

}
