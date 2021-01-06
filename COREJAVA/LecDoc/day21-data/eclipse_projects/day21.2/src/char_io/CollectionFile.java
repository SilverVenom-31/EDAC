//Created by @AkhilD on 31/12/2021.
package char_io;

import static utils.CollectionUtils.populateData;
import static utils.CollectionUtils.populateMap;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Product;

public class CollectionFile {

	public static void main(String[] args) {
		System.out.println("Enter File Name: ");
		try (Scanner sc = new Scanner(System.in); PrintWriter pr = new PrintWriter(new FileWriter(sc.nextLine()))) {

			Map<Integer, Product> aMap = populateMap(populateData());

			aMap.values().stream().sorted((i1, i2) -> {

				if (i1.getManufactureDate().compareTo(i2.getManufactureDate()) == 0) {
					return ((Double) i1.getPrice()).compareTo(i2.getPrice());
				}

				return i1.getManufactureDate().compareTo(i2.getManufactureDate());
			}).forEach(i -> pr.println(i));

			System.out.println("File Writing Completed...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
