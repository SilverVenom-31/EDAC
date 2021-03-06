package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getSf;

import java.util.List;

import pojos.Course;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchCourse(Course c) {
		String msg = "Launching of new Course failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(c);
			tx.commit();
			msg = "New Course Launched successfully";
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return msg;
	}

	@Override
	public String cancelCourse(int cId) {
		String msg = "Course Cancellation failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Course c = session.get(Course.class, cId);

			if (c != null) {
				session.delete(c); // marked for removal
				msg = "Course cancelled successfully" + c.getTitle();
			}

			tx.commit();// auto DC : deletes all assoc child rec and then parent rec

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return msg;
	}

	@Override
	public Course fetchCourseDetails(String courseName) {
		//3. join fetch c.students
		String jpql = "select c from Course c join fetch c.students where c.title=:name";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Course c = null;

		try {
			c = session.createQuery(jpql, Course.class).setParameter("name", courseName).getSingleResult();
//till now course details are fetched
			//access the size of collection
		//	c.getStudents().size(); //select query on students table
			tx.commit();// auto DC : deletes all assoc child rec and then parent rec

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return c; //detached
	}

}
