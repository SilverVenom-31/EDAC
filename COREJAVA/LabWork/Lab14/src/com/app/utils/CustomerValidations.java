//Created by @AkhilD on 22/12/2020.
package com.app.utils;

/* Modification:
1. Changed the functionality of chckDup method
 
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import static com.app.tester.CustomerRegistration.sdf;
import com.app.exception.CustomerHandlingException;
import com.app.org.Customer;
import com.app.org.CustomerType;

public class CustomerValidations {

	public static final int MIN_SIZE;
	public static final int MAX_SIZE;
	public static final int PASS_MIN_SIZE;
	public static final int PASS_MAX_SIZE;
	public static final int PHONE;

	static {
		MIN_SIZE = 8;
		MAX_SIZE = 15;
		PASS_MIN_SIZE = 6;
		PASS_MAX_SIZE = 20;
		PHONE = 10;

	}

	public static String validateEmail(String email) throws CustomerHandlingException {

		if (email.length() <= MIN_SIZE && email.length() >= MAX_SIZE) {
			throw new CustomerHandlingException("email must be minimum 8 chars or maximum 15 chars long");
		}
		if (!email.endsWith(".com")) {
			throw new CustomerHandlingException("email must end with .com");
		}
		if (!email.matches(
				"^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$")) {
			throw new CustomerHandlingException(" email must content @");
		}

		return email;
	}

	public static void chckDup(ArrayList<Customer> serv, Customer cfg) throws CustomerHandlingException {

		if (serv.contains(cfg)) {

			throw new CustomerHandlingException("Customer is already registered");
		}
	}

	public static String passChck(String pass) throws CustomerHandlingException {

		if (!pass.matches("((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})")) {
			throw new CustomerHandlingException(
					" Password minimum length 6 to 20 & must contain atleast one of the special characters ");
		}
		/*
		 * if(pass.length() <=PASS_MIN_SIZE && pass.length() >= PASS_MAX_SIZE ) { throw
		 * new CustomerHandlingException(" Password minimum length 6 to maximum 20 "); }
		 * 
		 * if(!pass.contains("!@#$%&*()'+,-./:;<=>?[]^_`{|}")) { throw new
		 * CustomerHandlingException(" Password must contain a special character "); }
		 * 
		 * if(!pass.matches("[A-Za-z0-9]+")) { throw new
		 * CustomerHandlingException(" Password must be Alpha numeric "); }
		 */
		return pass;
	}

	public static double regAmtChck(double reg) throws CustomerHandlingException {

		if (reg % 500 != 0) {
			throw new CustomerHandlingException(" Registration amount must be in the multiples of 500");
		}

		return reg;
	}

	public static Date dobValidate(Date dob) throws CustomerHandlingException, ParseException {

		if (dob.before(sdf.parse("2020-01-01"))) {
			throw new CustomerHandlingException(" Customer dob must be before 1st Jan 2020.");
		}

		return dob;
	}

	public static CustomerType typeValidate(CustomerType cd) throws CustomerHandlingException {
		int count = 0;
		for (CustomerType c : CustomerType.values()) {
			if (c.equals(cd)) {
				count++;
			}
		}
		if (count == 0) {
			throw new CustomerHandlingException(" Customer type must be either : SILVER OR GOLD OR PLATINUM");
		}

		return cd;
	}

	public static String counValidate(String coun) throws CustomerHandlingException {

		if (!coun.equals("INDIA")) {
			throw new CustomerHandlingException(
					" Currently we are supporting , customer registration from within India");
		}

		return coun;
	}

	public static String numValidate(String num) throws CustomerHandlingException {

		if (num.length() != 10) {
			throw new CustomerHandlingException(" Customer Phone number should be 10 digits");
		}

		return num;
	}

}
