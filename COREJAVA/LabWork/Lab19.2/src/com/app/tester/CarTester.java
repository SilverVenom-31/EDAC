//Created by @AkhilD on 29/12/2021.
package com.app.tester;

import java.util.HashMap;
import java.util.Scanner;
import static java.time.LocalDate.parse;
import com.app.core.Car;

public class CarTester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			HashMap<Car, Car> hMap = new HashMap<>();
			Car c1 = new Car(101, "ASSDFAD", parse("2020-03-20"), 200000, "S", "Tesla");
			hMap.put(c1, c1);
			Car c2 = new Car(102, "ASSDFAD", parse("2020-03-20"), 200000, "K", "Tesla");
			hMap.put(c2, c2);
			Car c3 = new Car(101, "ASSDFAD", parse("2020-03-20"), 200000, "M", "Tesla");
			hMap.put(c3, c3);

			System.out.println(hMap.values());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
