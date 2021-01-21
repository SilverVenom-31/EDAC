//Created by @AkhilD on 17/01/2021.
package com.app.validation;

import java.util.HashMap;

import com.app.core.MyBuddies;
import com.app.exception.BuddyExceptionHandling;

public class BuddyValidation {

	public static void chckDup(HashMap<String, MyBuddies> hashMap, String email) throws BuddyExceptionHandling {

		if (hashMap.containsKey(email)) {    //if contains then throw error
			throw new BuddyExceptionHandling("Buddy is already registered");
		}
	}

	public static String valEmail(String email) throws BuddyExceptionHandling {

		if (!email.contains("@")) { //if does not contain @ then throw error
			throw new BuddyExceptionHandling("Email should contain @");
		}
		if (!email.endsWith(".com")) {  //if does not ends with .com then throw error
			throw new BuddyExceptionHandling("Email should end with .com");
		}

		return email;
	}

	public static String valPhone(String num) throws BuddyExceptionHandling {

		if (num.length() > 10) {    //number is greater then 10 then throw error
			throw new BuddyExceptionHandling("Phone number should not be greater than 10");
		}

		return num;

	}
	public static void emailChck(HashMap<String, MyBuddies> hashMap, String email)throws BuddyExceptionHandling {
		
		if (!hashMap.containsKey(email)) {
			throw new BuddyExceptionHandling("No such email id exists");
		}
		
		
		
	}

}
