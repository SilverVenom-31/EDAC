//Created by @AkhilD on 17/12/2020.
package com.app.utils;

import com.app.exception.CustomerHandlingException;
import com.app.org.Customer;


public class CustomerValidations {
	
	public static final int MIN_SIZE ;
	 public static final int MAX_SIZE ;
	 public static final int PASS_MIN_SIZE ;
	 public static final int PASS_MAX_SIZE ;
	 
	 
	 static {
		 MIN_SIZE =8;
		 MAX_SIZE=15;
		 PASS_MIN_SIZE=6;
		 PASS_MAX_SIZE=20;
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

	public static String chckDup(Customer[] cfg, String email) throws CustomerHandlingException {

		for (Customer i : cfg) {
			if (i != null) {
				if (i.getEmail().equals(email)) {
					throw new CustomerHandlingException(" email must not be duplicate");
				}
			}
		}

		return email;
	}
	
	
	public static String passChck(String pass) throws CustomerHandlingException{
		
		if(!pass.matches("((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})")) {
			throw new CustomerHandlingException(" Password minimum length 6 to 20 & must contain atleast one of the special characters ");
		}
	/*	if(pass.length() <=PASS_MIN_SIZE && pass.length() >= PASS_MAX_SIZE ) {
			throw new CustomerHandlingException(" Password minimum length 6 to maximum 20 ");
		}
		
		if(!pass.contains("!@#$%&*()'+,-./:;<=>?[]^_`{|}")) {
			throw new CustomerHandlingException(" Password must contain a special character ");
		}
		
		if(!pass.matches("[A-Za-z0-9]+")) {
			throw new CustomerHandlingException(" Password must be Alpha numeric ");
		}*/
		return pass;
	}
	
	public static double regAmtChck(double reg)  throws CustomerHandlingException{
		
		if(reg%500 != 0) {
			throw new CustomerHandlingException(" Registration amount must be in the multiples of 500");
		}
		
		return reg;
	}
	

}
