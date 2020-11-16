package com.sumit.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sumit.petclinic.model.Owner;
import com.sumit.petclinic.model.PetType;
import com.sumit.petclinic.model.Vet;
import com.sumit.petclinic.services.OwnerService;
import com.sumit.petclinic.services.PetTypeService;
import com.sumit.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService =  vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType saveCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Owner1FirstName");
		owner1.setLastName("Owner1LastName");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Owner2FirstName");
		owner2.setLastName("Owner2LastName");

		ownerService.save(owner2);
		
		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Vet1FirstName");
		vet1.setLastName("Vet1LastName");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Vet2FirstName");
		vet2.setLastName("Vet2LastName");

		vetService.save(vet2);		 
		
		System.out.println("Loaded Vets....");

	}

}
