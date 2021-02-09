package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitStudent(Student student, String courseTitle) {
		String msg = "Admission of Student failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "select c from Course c where c.title=:title";
		try {
			// get course details by course title
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseTitle).getSingleResult();
			// c: persistant
			// this approach will work but along with cascading
			// can this work without cascading: yes,
			// for bidirect assoc
			// c.getStudents().add(student);
			// useCase: unidirectional assoc: many-to-one
			// establish the link from student to course
			// establish the link from course to student
			// c.getStudents().add(student);
			// student.setSelectedCourse(c); //reverse assoc from child to parent
			// System.out.println("course: "+student.getSelectedCourse());
			// session.persist(student);

			c.addStudent(student);

			tx.commit();

			msg = "Student Admission successfully";
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return msg;
	}

	@Override
	public String cancelAdmission(String courseName, int studId) {
		String msg = "Student Admission Cancellation failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Student s = session.get(Student.class, studId);

			if (s != null) {
				s.getSelectedCourse().removeStudent(s);
				//session.delete(s); // marked for removal
				msg = "Student Admission cancelled successfully";
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

}
