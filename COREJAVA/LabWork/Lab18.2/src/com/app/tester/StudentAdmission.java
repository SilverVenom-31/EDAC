//Created by @AkhilD on 28/12/2021.
package com.app.tester;

import static com.app.utils.StudentValidation.checkDup;
import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Course;
import com.app.core.Students;
import com.app.exception.StudentsException;

public class StudentAdmission {
	/* Note: Application is not user friendly, strictly binded with protocols. */
	/* Warning: Do not try to run this application in absence of its creator. */
	/* Help: Incase stuck immediately contact its creator. */

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			HashMap<String, Students> hMap = new HashMap<>();

			while (true) {

				System.out.println(
						"\n1.Enroll Student\n2.Fetch Student\n3.Display all Student details\n4.Update Marks of Student\n5.Cancel admission of Student\n6.Sort Student details\n7.Exit\n\nChoose any one option: ");

				switch (sc.nextInt()) {
				case 1:
//101 SPRING Alpha 40 2020-03-21
//103 DBT Bravo 50 2020-04-21
//102 DEVOPS Charlie 60 2020-05-21

					try {
						System.out.println(
								"Please enter details of Students:  prnString,  course,  nameString, marks, bDate(yyyy-MM-dd)");
						String prn = checkDup(hMap, sc.next());

						hMap.put(prn, new Students(prn, Course.valueOf(sc.next().toUpperCase()), sc.next(),
								sc.nextDouble(), parse(sc.next())));
						System.out.println("Student registered successfully.....");

					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;
				case 2:
//101
					try {

						System.out.println("Enter Student PRN number: ");
						String prnString = sc.next();
						if (!hMap.containsKey(prnString)) {
							throw new StudentsException("Student details not found");
						}
						System.out.println(hMap.get(prnString));

					} catch (Exception e) {
						e.printStackTrace();
					}

					continue;

				case 3:

					Collection<Students> stud = hMap.values();

					System.out.println(stud);

					continue;

				case 4:
//101 80
					try {
						System.out.println("Enter Prn numbers and New marks");

						String prnString = sc.next();
						double marks = sc.nextDouble();

						if (!hMap.containsKey(prnString)) {
							throw new StudentsException("Student details not found");
						}

						hMap.get(prnString).setMarks(marks);

						System.out.println("New marks updated successfully...");
						System.out.println(hMap.get(prnString));
					} catch (Exception e) {
						e.printStackTrace();
					}

					continue;

				case 5:

//102
					try {
						System.out.println("Enter Prn number of student: ");
						String prnString = sc.next();
						if (!hMap.containsKey(prnString)) {
							throw new StudentsException("Student details not found");
						}

						hMap.remove(prnString);

						System.out.println("Student removed successfully...");

					} catch (Exception e) {
						e.printStackTrace();
					}
					continue;

				case 6:
					// Sort student details as per the course & marks obtained.
					ArrayList<Students> arrlist = new ArrayList<>(hMap.values());
					Collections.sort(arrlist, new Comparator<Students>() {

						public int compare(Students s1, Students s2) {

							if (((Double) s1.getMarks()).compareTo(s2.getMarks()) == 0) {
								return s1.getCourse().compareTo(s2.getCourse());
							}

							return ((Double) s1.getMarks()).compareTo(s2.getMarks());

						}

					});

					for (Students s : arrlist) {
						System.out.println(s);
					}

					break;

				case 7:
					System.out.println("GoodBye!!!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid option: Please choose again");
					continue;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
