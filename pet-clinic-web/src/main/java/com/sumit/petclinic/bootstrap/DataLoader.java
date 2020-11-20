package com.sumit.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sumit.petclinic.model.Owner;
import com.sumit.petclinic.model.Pet;
import com.sumit.petclinic.model.PetType;
import com.sumit.petclinic.model.Specialty;
import com.sumit.petclinic.model.Vet;
import com.sumit.petclinic.model.Visit;
import com.sumit.petclinic.services.OwnerService;
import com.sumit.petclinic.services.PetService;
import com.sumit.petclinic.services.PetTypeService;
import com.sumit.petclinic.services.SpecialtyService;
import com.sumit.petclinic.services.VetService;
import com.sumit.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	private final PetService petService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService, PetService petService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
		this.petService = petService;
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
		Visit sumitsPetVisit = new Visit();
		owner1.setFirstName("Sumit");
		owner1.setLastName("Ram");
		owner1.setAddress("Dahisar East");
		owner1.setTelephone("111111");
		owner1.setCity("Mumbai");

		sumitsPet.setBirthDate(LocalDate.now());
		sumitsPet.setPetType(saveDogPetType);
		sumitsPet.setPetName("Lucy");
		sumitsPet.setOwner(owner1);
		//petService.save(sumitsPet);
		sumitsPetVisit.setPet(sumitsPet);
		sumitsPetVisit.setDescription("Sumits Pet Dogs 1st Visit...");
		
		//visitService.save(sumitsPetVisit);
		
		sumitsPet.getVisits().add(sumitsPetVisit);

		owner1.getPets().add(sumitsPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		Pet amitsPet = new Pet();
		Pet amitsPetDog = new Pet();
		Visit amitsPetVisit = new Visit();
		Visit amitsPets2ndVisit = new Visit();
		Visit amitsPetDogsVisit = new Visit();

		owner2.setFirstName("Amit");
		owner2.setLastName("Laxman");
		owner2.setAddress("Borivli East");
		owner1.setTelephone("222222");
		owner1.setCity("Pune");

		amitsPet.setBirthDate(LocalDate.now());
		amitsPet.setPetType(saveCatPetType);
		amitsPet.setPetName("Katie");
		amitsPet.setOwner(owner2);
		//petService.save(amitsPet);

		amitsPetVisit.setPet(amitsPet);
		amitsPetVisit.setDescription("Amits Pet Cats 1st Visit...");
		//visitService.save(amitsPetVisit);
		amitsPet.getVisits().add(amitsPetVisit);

		amitsPets2ndVisit.setPet(amitsPet);
		amitsPets2ndVisit.setDescription("Amits Pet Cats 2nd Visit...");
		//visitService.save(amitsPets2ndVisit);
		amitsPet.getVisits().add(amitsPets2ndVisit);
		owner2.getPets().add(amitsPet);

		amitsPetDog.setBirthDate(LocalDate.now());
		amitsPetDog.setPetType(saveDogPetType);
		amitsPetDog.setPetName("Bruno");
		amitsPetDog.setOwner(owner2);
		//petService.save(amitsPetDog);
		amitsPetDogsVisit.setPet(amitsPetDog);
		amitsPetDogsVisit.setDescription("Amits Pet Dogs 1st Visit...");
		//visitService.save(amitsPetDogsVisit);
		amitsPetDog.getVisits().add(amitsPetDogsVisit);
		owner2.getPets().add(amitsPetDog);

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