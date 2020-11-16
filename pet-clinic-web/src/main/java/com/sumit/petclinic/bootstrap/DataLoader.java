package com.sumit.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sumit.petclinic.model.Owner;
import com.sumit.petclinic.model.Pet;
import com.sumit.petclinic.model.PetType;
import com.sumit.petclinic.model.Specialty;
import com.sumit.petclinic.model.Vet;
import com.sumit.petclinic.services.OwnerService;
import com.sumit.petclinic.services.PetTypeService;
import com.sumit.petclinic.services.SpecialtyService;
import com.sumit.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0) {
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType saveCatPetType = petTypeService.save(cat);

		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty saveRadiology = specialtyService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty saveSurgery = specialtyService.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty saveDentistry = specialtyService.save(dentistry);

		Owner owner1 = new Owner();
		Pet sumitsPet = new Pet();
		owner1.setFirstName("Sumit");
		owner1.setLastName("Ram");
		owner1.setAddress("Dahisar East");
		sumitsPet.setBirthDate(LocalDate.now());
		sumitsPet.setPetType(saveDogPetType);
		sumitsPet.setPetName("Lucy");
		owner1.getPets().add(sumitsPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		Pet amitsPet = new Pet();
		owner2.setFirstName("Amit");
		owner2.setLastName("Laxman");
		owner2.setAddress("Borivli East");
		amitsPet.setBirthDate(LocalDate.now());
		amitsPet.setPetType(saveCatPetType);
		amitsPet.setPetName("Katie");
		owner2.getPets().add(amitsPet);

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sohit");
		vet1.setLastName("Mishra");
		vet1.getSpecialties().add(saveDentistry);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Arnab");
		vet2.setLastName("Goswami");
		vet2.getSpecialties().add(radiology);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
