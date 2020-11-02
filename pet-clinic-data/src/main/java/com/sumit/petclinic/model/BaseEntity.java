package com.sumit.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4798098062596011401L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
