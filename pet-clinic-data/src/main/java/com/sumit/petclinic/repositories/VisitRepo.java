package com.sumit.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sumit.petclinic.model.Visit;

public interface VisitRepo extends CrudRepository<Visit, Long> {

}
