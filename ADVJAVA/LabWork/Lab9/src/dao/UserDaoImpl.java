package dao;

import pojos.Role;
import pojos.User;
import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.*;

public class UserDaoImpl implements IUserDao {
	private String msg = "User registration failed";

	@Override
	public String registerUser(User user) {
		// get session from session factory
		Session session = getSf().openSession(); // L1 cache is opened: EMPTY
		Session session2 = getSf().openSession(); // L1 will have different address

		// Begin Transaction
		Transaction tx = session.beginTransaction(); // DB cn is pooled out and attached to hib session
		System.out.println("Is open: " + session.isOpen() + " is connected: " + session.isConnected());// t t
		try {
			// user registration
			Integer id = (Integer) session.save(user);
			tx.commit(); // in case of success, commit the tx //DML: insert query
			msg = "user registered successfully with ID: " + id;
			System.out.println("Is open: " + session.isOpen() + " is connected: " + session.isConnected()); // t t
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
		System.out.println("Is open: " + session.isOpen() + " is connected: " + session.isConnected());// f f
		return msg;
	}

	@Override
	public String registerUserWGetCurrSess(User user) {
		// get session from SF: getCurrentSession
		Session session = getSf().getCurrentSession();
		Session session2 = getSf().getCurrentSession(); // will have same address
		// begin tx
		Transaction tx = session.beginTransaction();

		System.out.println("Is open: " + session.isOpen() + " is connected: " + session.isConnected());// t t

		try {
			// user registration
			session.persist(user);
			tx.commit(); // in case of success, commit the tx //DML: insert query , l1 is cache is
							// destroyed,closing the session
			msg = "user registered successfully with ID: " + user.getUserId();
			System.out.println("Is open: " + session.isOpen() + " is connected: " + session.isConnected());// f f

		} catch (RuntimeException e) {
			// rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session
				System.out.println(
						"Is open after rollback: " + session.isOpen() + " is connected: " + session.isConnected());// f
																													// f
			}
			throw e;
		}

		return msg;
	}

	@Override
	public User getUserDetails(int userId) {
		User u = null;
		// get session from SF: with current session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get method for retrieval
			u = session.get(User.class, userId);// int to Integer to Serializable (autoboxing)
			u = session.get(User.class, userId);// int to Integer to Serializable (autoboxing)
			u = session.get(User.class, userId);// int to Integer to Serializable (autoboxing)
			// select query will be fired exactly once due to L1 cache if have valid id
			// if id is not valid then it will fire 3 times;

			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;
		}

		return u;
	}

	@Override
	public List<User> fetchAllUsers() {
		String jpql = "select u from User u";

		List<User> userList = null;
		// get session from SF: with current session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {

			userList = session.createQuery(jpql, User.class).getResultList();
			// the result of resultList are not cached auto
			// you will have to explicitly enable query level cache to experience it
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;
		}
		return userList;
	}

	@Override
	public List<User> fetchSelectedUsers(LocalDate strDate, LocalDate enDate, Role userRole) {
		String jpql = "select u from User u where u.regDate between :strt and :end and u.userRole=:role";

		List<User> userList = null;

		// get session from SF: with current session
		Session session = getSf().getCurrentSession(); // begin tx
		Transaction tx = session.beginTransaction();
		try {
			userList = session.createQuery(jpql, User.class).setParameter("strt", strDate).setParameter("end", enDate)
					.setParameter("role", userRole).getResultList();
			// userList: list of peristance of pojos
			tx.commit(); // if not given then, ERROR: Connection leak detected: there are 1 unclosed
							// connections upon
							// shutting down pool
							// jdbc:mysql://localhost:3306/acts?useSSL=false&allowPublicKeyRetrieval=true
		} catch (RuntimeException e) { // rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;
		}
		return userList;
	}

	@Override
	public User userLogin(String email, String password) {
		String jpql = "select u from User u where u.email=:e and u.password=:p";

		User u = null;
		// get session from SF: with current session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {

			u = session.createQuery(jpql, User.class).setParameter("e", email).setParameter("p", password)
					.getSingleResult();
			// the result of resultList are not cached auto
			// you will have to explicitly enable query level cache to experience it
			tx.commit();
		} catch (NoResultException e) {
			System.out.println("Invalid Login");
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;

		} catch (RuntimeException e) {
			// rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}

			throw e;
		}
		return u;
	}

	@Override
	public List<String> fetchSelectedUserName(LocalDate strDate, LocalDate enDate, Role userRole) {
		String jpql = "select u.name from User u where u.regDate between :strt and :end and u.userRole=:role";

		List<String> userList = null;

		// get session from SF: with current session
		Session session = getSf().getCurrentSession(); // begin tx
		Transaction tx = session.beginTransaction();
		try {
			userList = session.createQuery(jpql, String.class).setParameter("strt", strDate).setParameter("end", enDate)
					.setParameter("role", userRole).getResultList();
			// userList: list of peristance of pojos
			tx.commit(); // if not given then, ERROR: Connection leak detected: there are 1 unclosed
							// connections upon
							// shutting down pool
							// jdbc:mysql://localhost:3306/acts?useSSL=false&allowPublicKeyRetrieval=true
		} catch (RuntimeException e) { // rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;
		}
		return userList;

	}

	@Override
	public List<User> fetchSpecificUser(LocalDate strDate, LocalDate enDate, Role userRole) {
		String jpql = "select new pojos.User(name,regAmount,regDate) from User u where u.regDate between :strt and :end and u.userRole=:role";

		List<User> userList = null;

		// get session from SF: with current session
		Session session = getSf().getCurrentSession(); // begin tx
		Transaction tx = session.beginTransaction();
		try {
			userList = session.createQuery(jpql, User.class).setParameter("strt", strDate).setParameter("end", enDate)
					.setParameter("role", userRole).getResultList();
			// userList: list of peristance of pojos
			tx.commit(); // if not given then, ERROR: Connection leak detected: there are 1 unclosed
							// connections upon
							// shutting down pool
							// jdbc:mysql://localhost:3306/acts?useSSL=false&allowPublicKeyRetrieval=true
		} catch (RuntimeException e) { // rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;
		}
		return userList;
	}

	@Override
	public String changePass(int userId, String newPass) {
		String message = "Password updation failed!!!";
		User u = null;
		// get session from SF: with current session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			/// get user details by id
			u = session.get(User.class, userId);
			if (u != null) {
				// valid id u: persistant (exists in L1 cache and DB )
				u.setPassword(newPass); // updating state of persistant pojo
				message = "Password updated successfully";
			}

			tx.commit(); // hib automatically performs automatic dirty checking: update query,l1 cache is
							// closed,DB connection is returned to pool
		} catch (RuntimeException e) {
			// rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;
		}
		if (u != null) {
			u.setPassword("9999"); // updating state of detached pojo state, so no updation in DB,no auto dirty
									// checking by HB and not responsible to update in DB
		}
		return message;
	}

	@Override
	public String deleteUser(int userId) {
		String message = "Deletion of user failed!!!";
		String jpql = "delete from User u where u.userId=:id";
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {

			int check = session.createQuery(jpql).setParameter("id", userId).executeUpdate();
			if (check > 0) {
				message = "User Deletion successfull";
			}

			tx.commit(); // hib automatically performs automatic dirty checking: update query,l1 cache is
							// closed,DB connection is returned to pool
		} catch (RuntimeException e) {
			// rollback tx and rethrow the exception to the caller
			if (tx != null) {
				tx.rollback(); // l1 cache is destroyed and closing the session

			}
			throw e;
		}
		return message;
	}

}

/*
 * Hibernate template until spring // get session from SF: with current session
 * Session session = getSf().getCurrentSession(); // begin tx Transaction tx =
 * session.beginTransaction(); try {
 * 
 * 
 * tx.commit(); } catch (RuntimeException e) { // rollback tx and rethrow the
 * exception to the caller if (tx != null) { tx.rollback(); // l1 cache is
 * destroyed and closing the session
 * 
 * } throw e; }
 */
