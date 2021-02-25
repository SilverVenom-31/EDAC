package com.app.service;

import java.util.List;

import com.app.pojos.Location;
import com.app.pojos.Vendors;

public interface IVendorService {
	Vendors authenticateUser(String email, String password);
	List<Vendors> getVendorList();
	String deleteVendorDetails(int vId);
	Vendors getVendorDets(int vId);
	String registerVendor(Vendors v);
	String updateVendor(Vendors v);
	String registerVendorLocation(Location l,Vendors v);
}
