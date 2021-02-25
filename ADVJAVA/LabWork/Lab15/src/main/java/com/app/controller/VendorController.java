package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//mandatory
@RequestMapping("/vendor")
public class VendorController {

	
	public VendorController() {
		// TODO Auto-generated constructor stub
		System.out.println("in vc contr : "+ getClass().getName());
	}
	
	@GetMapping("/details")
	public String showVendorDetails() {
		
		System.out.println("in showvendorDet");
		
		
		return "/vendor/details";
	}
	
}
