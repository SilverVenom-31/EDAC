//Created by @AkhilD on 31/12/2021.
package strms;

import static utils.CollectionUtils.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Product;

public class Tester {

	public static void main(String[] args) {
		Map<Integer, Product> populData = populateMap(populateData());
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Category: ");
			Category cat = Category.valueOf(sc.next().toUpperCase());

			String pString = populData.values().stream().filter(i -> i.getProductCatgeory() == cat)
					.min(Comparator.comparing(Product::getPrice))
					.orElseThrow(() -> new ProductNotFoundExecption("ProductNotFound")).getName();
			System.out.println("Category: " + cat + "\nName: " + pString);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	// Optional<Product> op =populData.stream().filter(i-> i.getProductCatgeory() ==
	// cat).min((i1,i2)->((Double)i1.getPrice()).compareTo(i2.getPrice()));
}
