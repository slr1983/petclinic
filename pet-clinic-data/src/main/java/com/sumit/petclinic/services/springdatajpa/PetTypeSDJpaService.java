package com.sumit.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.PetType;
import com.sumit.petclinic.repositories.PetTypeRepo;
import com.sumit.petclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepo pettypeRepo;

	public PetTypeSDJpaService(PetTypeRepo pettypeRepo) {
		super();
		this.pettypeRepo = pettypeRepo;
	}

	@Override
	public Set<PetType> findAll() {

		Set<PetType> petType = new HashSet<PetType>();
		pettypeRepo.findAll().forEach(petType::add);
		return petType;
	}

	@Override
	public PetType findById(Long id) {
		Optional<PetType> optionalPetType = pettypeRepo.findById(id);
		return optionalPetType.orElse(null);
	}

	@Override
	public PetType save(PetType object) {

		return pettypeRepo.save(object);
	}

	@Override
	public void delete(PetType object) {
		pettypeRepo.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		pettypeRepo.deleteById(id);
	}

}
