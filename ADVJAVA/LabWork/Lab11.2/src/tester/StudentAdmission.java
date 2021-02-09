package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Student;

public class StudentAdmission {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
		
			StudentDaoImpl sDao = new StudentDaoImpl();
			System.out.println("Enter student name,email and course title");

			System.out.println(sDao.admitStudent(new Student(sc.next(), sc.next()), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
