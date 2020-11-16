package com.sumit.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.PetType;
import com.sumit.petclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
	public PetType save(PetType object) {

		return super.save(object);
	}

	@Override
	public Set<PetType> findAll() {

		return super.findAll();
	}

	@Override

	public PetType findById(Long id) {

		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {

		super.deleteById(id);
	}

	@Override
	public void delete(PetType object) {

		super.delete(object);
	}

}
