package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LaunchCourse {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			CourseDaoImpl cDao = new CourseDaoImpl();
			System.out.println("Enter course title, startDate, endDate, fees, capacity");
			Course course = new Course(sc.next(), sdf.parse(sc.next()), sdf.parse(sc.next()), sc.nextDouble(),
					sc.nextInt());
			System.out.println(cDao.launchCourse(course));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
