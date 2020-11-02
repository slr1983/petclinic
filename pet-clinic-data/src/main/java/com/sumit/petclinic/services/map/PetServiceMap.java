package com.sumit.petclinic.services.map;

import java.util.Set;

import com.sumit.petclinic.model.Pet;
import com.sumit.petclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet object) {
		
		return super.save(object.getId(), object);
	}

	@Override
	public Set<Pet> findAll() {
		
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public Pet save(Long id, Pet object) {
		
		return super.save(id, object);
	}

	@Override
	public void deleteById(Long id) {
		
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		
		super.delete(object);
	}

}
