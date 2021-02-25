package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Location;
import com.app.pojos.UserRole;
import com.app.pojos.Vendors;

@Repository // tell SC about DAO layer bean+ enables exception translation mechanism(catches
			// DB related Exc and rethrows them as Spring related excp(unchecked)
public class VendorDaoImpl implements IVendorDao {
	// dependecy: session factory i/f
	@Autowired
	private EntityManager mgr;

	@Override
	public Vendors authenticateUser(String email, String password) {
		String jpql = "select v from Vendors v where v.email=:em and v.password=:ps";
		return mgr.createQuery(jpql, Vendors.class).setParameter("em", email).setParameter("ps", password)
				.getSingleResult();
	}

	@Override
	public List<Vendors> getVendorList() {
		// TODO Auto-generated method stub
		String jpql = "select v from Vendors v where v.role=:rl";

		return mgr.createQuery(jpql, Vendors.class).setParameter("rl", UserRole.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(Vendors persistentVendor) {
		// Since there exist one to one unidirectional association between Vendors and
		// Location and PK of location table is FK
		// which references PK of vendors table , we cannot directly parent record
		// without first deleting the child record i.e.location record
		// otherwise throws constraintVoilation exception
		Location l = mgr.find(Location.class, persistentVendor.getId());
		if (l != null) {
			mgr.remove(l);
		}
		mgr.remove(persistentVendor);

		return "Vendor details deleted for ID: " + persistentVendor.getId();
	}

	@Override
	public Vendors getVendorDets(int vId) {
		// TODO Auto-generated method stub
		return mgr.find(Vendors.class, vId);
	}

	@Override
	public String registerVendor(Vendors v) {
		// TODO Auto-generated method stub
		mgr.persist(v);
		return "Vendors dets registered successfully with ID: " + v.getId();
	}

	@Override
	public String updateVendor(Vendors v) {
		Vendors vt = mgr.merge(v);
		if (v != null) {
			return "Successfully updated vendor";
		}
		return "Updatation of vendor failed";
	}

	@Override
	public String registerVendorLocation(Location l, Vendors v) {
		// TODO Auto-generated method stub
		l.setCurrentVendor(v);
		System.out.println("in dao: " + v.getId());
		mgr.persist(l.getCurrentVendor());

		System.out.println("after registering Vendor: " + l.getCurrentVendor().getId());
		mgr.persist(l);
		return "Vendors location dets registered successfully with ID: " + l.getId();
	}

}
