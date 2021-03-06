package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CourseDets {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			
			CourseDaoImpl cDao = new CourseDaoImpl();
			StudentDaoImpl sDao = new StudentDaoImpl();
			System.out.println("Enter course title");
			String courseName=sc.next();
					//	System.out.println(cDao.fetchCourseDetails(courseName));
					//	cDao.fetchCourseDetails(courseName).getStudents().forEach(System.out::println);
		
		System.out.println(sDao.getStudDetByCourse(courseName));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
