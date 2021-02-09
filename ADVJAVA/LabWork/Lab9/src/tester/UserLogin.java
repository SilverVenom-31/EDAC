package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class UserLogin {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user email and password: ");
			System.out.println(dao.userLogin(sc.next(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
