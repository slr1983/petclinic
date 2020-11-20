package com.sumit.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sumit.petclinic.model.Visit;
import com.sumit.petclinic.services.VisitService;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {

		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return null;
	}

	@Override
	public Visit save(Visit object) {

		if (object == null || object.getPet() == null || object.getPet().getId() == null) {

			throw new RuntimeException("Invalid Data. Pet not saved or Pet doesnt have any Owner attached...");
		}

		return super.save(object);
	}

	@Override
	public void delete(Visit object) {
		super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}