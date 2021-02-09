package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class UserDetails {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user id: ");
			System.out.println(dao.getUserDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
