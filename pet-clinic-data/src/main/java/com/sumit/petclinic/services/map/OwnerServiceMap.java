package com.sumit.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Owner;
import com.sumit.petclinic.model.Pet;
import com.sumit.petclinic.services.OwnerService;
import com.sumit.petclinic.services.PetService;
import com.sumit.petclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner object) {

		if (object != null) {

			if (object.getPets() != null) {

				object.getPets().forEach(pet -> {

					if (pet.getPetType() != null) {

						if (pet.getPetType().getId() != null) {

							petTypeService.save(pet.getPetType());

						}

					} else {
						throw new RuntimeException("PetType is Required.");
					}

					if (pet.getId() == null) {

						Pet savedPet = petService.save(pet);
						savedPet.setId(savedPet.getId());
					}

				});

			}

			return super.save(object);
		} else {
			return null;
		}

	}

	@Override
	public Set<Owner> findAll() {

		return super.findAll();
	}

	@Override

	public Owner findById(Long id) {

		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {

		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {

		super.delete(object);
	}

	@Override
	public Owner findByLastName(String lastName) {

		return null;
	}

}
