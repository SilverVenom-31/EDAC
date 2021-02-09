package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;

import static java.time.LocalDate.parse;

public class FetchSelectName {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter begin date, end date and role");
			dao.fetchSelectedUserName(parse(sc.next()), parse(sc.next()), Role.valueOf(sc.next().toUpperCase()))
					.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
