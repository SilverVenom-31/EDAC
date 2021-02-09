package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CourseWithStudents {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			CourseDaoImpl cDao = new CourseDaoImpl();
			System.out.println("Enter course title, startDate, endDate, fees, capacity");
			Course course = new Course(sc.next(), sdf.parse(sc.next()), sdf.parse(sc.next()), sc.nextDouble(),
					sc.nextInt());
			boolean exit = false;
			while (!exit) {
				System.out.println("1.Add new Student\n2.quit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter student name, email");
					course.addStudent(new Student(sc.next(), sc.next()));
					break;
				case 2:
					System.out.println("goodbye");
					exit = true;
					break;
				default:
					System.out.println("try again");
					break;
				}

			}

			System.out.println(cDao.launchCourse(course));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
