package dao;

import pojos.User;
import static utils.HibernateUtils.getSf;

import org.hibernate.*;

public class UserDaoImpl implements IUserDao {
	String msg = "User registration failed";

	@Override
	public String registerUser(User user) {
		// get session from session factory
		Session session = getSf().openSession(); // L1 cache is opened: EMPTY
		// Begin Transaction
		Transaction tx = session.beginTransaction(); // DB cn is pooled out and attached to hib session
		System.out.println("Is open: " + session.isOpen() + " is connected: " + session.isConnected());
		try {
			// user registration
			Integer id = (Integer) session.save(user);
			tx.commit(); // in case of success, commit the tx
			msg = "user registered successfully with ID: " + id;
		} catch (RuntimeException e) {
			// rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			// close the session
			if (session != null) {
				System.out.println("Closing the session");
				session.close();
			}
		}
		System.out.println("Is open: " + session.isOpen() + " is connected: " + session.isConnected());
		return msg;
	}

}
