package com.sumit.petclinic.services;

import com.sumit.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	
	Owner findByLastName(String lastName);
	

}
