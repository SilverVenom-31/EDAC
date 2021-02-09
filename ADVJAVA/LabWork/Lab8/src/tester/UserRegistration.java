package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

import static java.time.LocalDate.parse;
import pojos.Role;
import pojos.User;

public class UserRegistration {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter User details : name, email, password, userRole, confirmPassword,\n"
					+ "			regAmount, regDate");
			UserDaoImpl dao = new UserDaoImpl();
			User u= new User(sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()), sc.next(),sc.nextDouble(), parse(sc.next()));
	
		//invoke dao's method
		System.out.println("Registration status: " + dao.registerUser(u));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
