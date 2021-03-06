package dao;

import static utils.HibernateUtils.getSf;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.org.apache.bcel.internal.generic.Select;

import pojos.Course;
import pojos.EducationalQual;
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
				// session.delete(s); // marked for removal
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

	@Override
	public String admitStudentWithAC(Student student, int courseId) {
		String msg = "Admission of Student failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			Course c = session.get(Course.class, courseId);
			c.addStudent(student);
			// session.persist(student); not required
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
	public List<Student> getStudDetByCourse(String courseName) {
		String jpql = "select s from Student s where s.selectedCourse.title = :title";
		List<Student> lst = new ArrayList<>();
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			lst = session.createQuery(jpql, Student.class).setParameter("title", courseName).getResultList();

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return lst;
	}

	@Override
	public List<EducationalQual> getEducationalQuals(String email) {
		String jpql = "select s from Student s join fetch s.educationalQuals where s.email=:em";
		Student s = null;
		List<EducationalQual> lst = new ArrayList<EducationalQual>();

		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {

			s = session.createQuery(jpql, Student.class).setParameter("em", email).getSingleResult();
			lst = s.getEducationalQuals();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return lst;

	}

	@Override
	public String cancelAdmission(String courseName, String email) {
		String msg = "Student Admission Cancellation failed";
		String jpql = "select s from Student s where s.email=:em";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
		Student	s = session.createQuery(jpql, Student.class).setParameter("em", email).getSingleResult();

			if (s != null) {
				s.getSelectedCourse().removeStudent(s);
				// session.delete(s); // marked for removal
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
