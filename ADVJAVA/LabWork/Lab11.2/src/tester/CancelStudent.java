package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Student;

public class CancelStudent {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {

			StudentDaoImpl sDao = new StudentDaoImpl();
			System.out.println("Enter course name, student id");

			System.out.println(sDao.cancelAdmission(sc.next(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
