package com.sumit.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Visit;
import com.sumit.petclinic.repositories.VisitRepo;
import com.sumit.petclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

	private final VisitRepo visitRepo;

	public VisitSDJpaService(VisitRepo visitRepo) {
		super();
		this.visitRepo = visitRepo;
	}

	@Override
	public Set<Visit> findAll() {

		Set<Visit> visits = new HashSet<Visit>();
		visitRepo.findAll().forEach(visits::add);

		return visits;
	}

	@Override
	public Visit findById(Long id) {
		Optional<Visit> optionaVisit = visitRepo.findById(id);
		return optionaVisit.orElse(null);
	}

	@Override
	public Visit save(Visit object) {

		return visitRepo.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepo.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		visitRepo.deleteById(id);

	}

}