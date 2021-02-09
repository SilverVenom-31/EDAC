package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;

public class CancelCourse {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			
			CourseDaoImpl cDao = new CourseDaoImpl();
			System.out.println("Enter course id");
			
			System.out.println(cDao.cancelCourse(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
