package com.sumit.petclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumit.petclinic.model.Owner;
import com.sumit.petclinic.services.OwnerService;

@Controller
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;

	}

	@RequestMapping({ "/owners", "/owners/index.html", "/owners/index" })
	public String showAllOwners(Model model) {

		Set<Owner> allOwners = ownerService.findAll();

		model.addAttribute("owners", allOwners);

		return "owners/index";
	}

	@RequestMapping("/owners/find")
	public String findOwners() {

		return "unimplemented";
	}

}
