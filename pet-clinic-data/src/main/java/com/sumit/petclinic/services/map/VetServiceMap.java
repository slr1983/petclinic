package com.sumit.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Specialty;
import com.sumit.petclinic.model.Vet;
import com.sumit.petclinic.services.SpecialtyService;
import com.sumit.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialtyService specialtyService;

	public VetServiceMap(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save(Vet object) {

		if (object != null) {

			if (object.getSpecialties() != null) {

				object.getSpecialties().forEach(speciality -> {

					if (speciality != null && speciality.getId() == null) {

						Specialty savedSpecialty = specialtyService.save(speciality);

						savedSpecialty.setId(speciality.getId());

					}

				});

			}

		}

		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}
