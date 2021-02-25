package com.app.dao;

import java.util.List;

import com.app.pojos.Location;
import com.app.pojos.Vendors;

public interface IVendorDao {
	Vendors authenticateUser(String email, String password);
	List<Vendors> getVendorList();
	String deleteVendorDetails(Vendors persistentVendor);
	Vendors getVendorDets(int vId);
	String registerVendor(Vendors v);
	String updateVendor(Vendors v);
	String registerVendorLocation(Location l,Vendors v);
}
