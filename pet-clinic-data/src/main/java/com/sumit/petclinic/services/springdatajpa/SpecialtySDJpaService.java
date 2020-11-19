package com.sumit.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Specialty;
import com.sumit.petclinic.repositories.SpecialtyRepo;
import com.sumit.petclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

	private final SpecialtyRepo specialtyRepo;

	public SpecialtySDJpaService(SpecialtyRepo specialtyRepo) {
		super();
		this.specialtyRepo = specialtyRepo;
	}

	@Override
	public Set<Specialty> findAll() {

		Set<Specialty> specialties = new HashSet<Specialty>();
		specialtyRepo.findAll().forEach(specialties::add);
		;
		return specialties;
	}

	@Override
	public Specialty findById(Long id) {
		Optional<Specialty> optionalSpecialty = specialtyRepo.findById(id);
		return optionalSpecialty.orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {

		return specialtyRepo.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepo.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		specialtyRepo.deleteById(id);

	}

}
