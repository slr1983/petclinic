package com.sumit.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sumit.petclinic.model.Owner;
import com.sumit.petclinic.model.Vet;
import com.sumit.petclinic.services.OwnerService;
import com.sumit.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService =  vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Owner1FirstName");
		owner1.setLastName("Owner1LastName");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Owner2FirstName");
		owner2.setLastName("Owner2LastName");

		ownerService.save(owner2);
		
		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Vet1FirstName");
		vet1.setLastName("Vet1LastName");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(1L);
		vet2.setFirstName("Vet2FirstName");
		vet2.setLastName("Vet2LastName");

		vetService.save(vet2);
		
		System.out.println("Loaded Vets....");

	}

}
