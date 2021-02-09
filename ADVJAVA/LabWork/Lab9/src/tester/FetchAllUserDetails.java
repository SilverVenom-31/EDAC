package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class FetchAllUserDetails {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf()) {
			UserDaoImpl dao = new UserDaoImpl();
			dao.fetchAllUsers().forEach(System.out::println);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
