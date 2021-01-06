//Created by @AkhilD on 02/01/2021.
package com.app.tester;

import java.util.Map;

import com.app.core.Student;
import com.app.threads.DobSortedTask;
import com.app.threads.GpaSortedTask;

import static com.app.utils.CollectionUtils.*;

public class SaveStudentDet {

	public static void main(String[] args) {

		try {

			Map<String, Student> populateMap = populateMap(populateList());

			Thread t1 = new Thread(new GpaSortedTask(populateMap), "GpaSorted");
			Thread t2 = new Thread(new DobSortedTask(populateMap), "DobSorted");
			t1.start();
			t2.start();

			System.out.println("Charlie Mike");
			t1.join();
			t2.join();

			System.out.println("JackPot");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
