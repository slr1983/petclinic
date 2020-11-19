package com.sumit.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Pet;
import com.sumit.petclinic.repositories.PetRepo;
import com.sumit.petclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

	private final PetRepo petRepo;

	public PetSDJpaService(PetRepo petRepo) {
		super();
		this.petRepo = petRepo;
	}

	@Override
	public Set<Pet> findAll() {

		Set<Pet> pets = new HashSet<Pet>();
		petRepo.findAll().forEach(pets::add);

		return pets;
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> pet = petRepo.findById(id);
		return pet.orElse(null);
	}

	@Override
	public Pet save(Pet object) {

		return petRepo.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepo.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		petRepo.deleteById(id);

	}

}
