package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class DeleteUser {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter userId");
			System.out.println(dao.deleteUser(sc.nextInt()));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
