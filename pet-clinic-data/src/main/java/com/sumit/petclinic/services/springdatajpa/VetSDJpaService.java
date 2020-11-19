package com.sumit.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Vet;
import com.sumit.petclinic.repositories.VetRepo;
import com.sumit.petclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

	private final VetRepo vetRepo;

	public VetSDJpaService(VetRepo vetRepo) {
		this.vetRepo = vetRepo;
	}

	@Override
	public Set<Vet> findAll() {

		Set<Vet> vets = new HashSet<Vet>();
		vetRepo.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {

		return vetRepo.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {

		return vetRepo.save(object);
	}

	@Override
	public void delete(Vet object) {
		
		vetRepo.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		
		vetRepo.deleteById(id);

	}

}
