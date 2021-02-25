package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Location;
import com.app.pojos.UserRole;
import com.app.pojos.Vendors;

@Service // tell SC that class is a spring bean containing BL
@Transactional // tell SC to automate TX mgmt //by spring supplied HB
public class VendorServiceImpl implements IVendorService {
//dependency: DAO layer i/f
	@Autowired
	private IVendorDao vDao;

	@Override
	public Vendors authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		return vDao.authenticateUser(email, password);
	}

	@Override
	public List<Vendors> getVendorList() {
		// TODO Auto-generated method stub
		return vDao.getVendorList();
	}

	@Override
	public String deleteVendorDetails(int vId) {
		// TODO Auto-generated method stub
		Vendors v = vDao.getVendorDets(vId);
		if(v!=null)
		return vDao.deleteVendorDetails(v);
		
		return "Vendor deletion failed";
	}

	@Override
	public String registerVendor(Vendors v) {
		// TODO Auto-generated method stub
		
		v.setRole(UserRole.VENDOR);
		
		return vDao.registerVendor(v);
	}

	@Override
	public String updateVendor(Vendors v) {
		// TODO Auto-generated method stub
		return vDao.updateVendor(v);
	}

	@Override
	public Vendors getVendorDets(int vId) {
		// TODO Auto-generated method stub
		return vDao.getVendorDets(vId);
	}

	@Override
	public String registerVendorLocation(Location l,Vendors v) {
		// TODO Auto-generated method stub
		return vDao.registerVendorLocation(l,v);
	}

	

}
