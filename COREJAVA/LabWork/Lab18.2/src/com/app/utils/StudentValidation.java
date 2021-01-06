//Created by @AkhilD on 28/12/2021.
package com.app.utils;

import java.util.HashMap;

import com.app.core.Students;
import com.app.exception.StudentsException;

public class StudentValidation {

	public static String checkDup(HashMap<String, Students> hMap, String prn) throws StudentsException {

		if (hMap.containsKey(prn)) {
			throw new StudentsException("Student already registered");

		}
		
		return prn;

	}

}
