package com.sumit.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Owner;
import com.sumit.petclinic.repositories.OwnerRepo;
import com.sumit.petclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepo ownerRepo;

	public OwnerSDJpaService(OwnerRepo ownerRepo) {
		super();
		this.ownerRepo = ownerRepo;
	}

	@Override
	public Set<Owner> findAll() {

		Set<Owner> owners = new HashSet<Owner>();
		ownerRepo.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {

		Optional<Owner> owner = ownerRepo.findById(id);

		return owner.orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		ownerRepo.save(object);
		return object;
	}

	@Override
	public void delete(Owner object) {

		ownerRepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepo.deleteById(id);

	}

	@Override
	public Owner findByLastName(String lastName) {
		ownerRepo.findByLastName(lastName);
		return null;
	}

}
