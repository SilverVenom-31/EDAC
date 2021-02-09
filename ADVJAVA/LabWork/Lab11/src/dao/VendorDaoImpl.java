package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Location;

import pojos.Vendors;
import static utils.HibernateUtils.getSf;

public class VendorDaoImpl implements IVendorDao {

	@Override
	public String registerVendor(Vendors v) {
		String msg = "Vendor reg failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(v);
			tx.commit();
			 msg = "Vendor reg successfull";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return msg;
	}

	@Override
	public String assignVendorLocation(int vId, Location location) {
		String mesg = "Location assigned failed..";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			Vendors v = session.get(Vendors.class, vId);
			if (v != null) {
				location.setCurrentVendor(v);
				session.persist(location);
				mesg = "Locations Assigned successfully";

			}

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	@Override
	public Vendors fetchVendorDetails(String email) {
		Vendors v=null;
		String jpql = "select v from Vendors v where v.email=:em";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			v=session.createQuery(jpql, Vendors.class).setParameter("em", email).getSingleResult();
			
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return v;
	}

	@Override
	public String registerVendorWithLoc(Location location) {
		
		String msg = "Vendor reg failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			 session.persist(location.getCurrentVendor());
			session.persist(location);
			tx.commit();
			 msg = "Vendor reg successfull";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return msg;
	}

	@Override
	public Vendors getVendorDetByPhone(String phoneNo) {
		Vendors v = null;
		String sql = "select * from vendors_tbl v,vendor_phones p where v.id=p.vendor_id and p.phone_no=:ph";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			v = session.createNativeQuery(sql, Vendors.class).setParameter("ph", phoneNo).getSingleResult();
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return v;
	}

}
