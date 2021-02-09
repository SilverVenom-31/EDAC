package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class ChangePassword {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter user ID and new password ");
			System.out.println(dao.changePass(sc.nextInt(), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
