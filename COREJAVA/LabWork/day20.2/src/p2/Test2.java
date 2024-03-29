//Created by @AkhilD on 30/12/2021.
package p2;

import java.util.List;
import java.util.Scanner;
import static utils.CollectionUtils.*;
import com.app.core.Category;
import com.app.core.Product;

public class Test2 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			List<Product> list = populateData();
			System.out.println("Enter category and price");

			Category category = Category.valueOf(sc.next().toUpperCase());
			double price = sc.nextDouble();

			list.stream().filter(i -> i.getProductCatgeory() == category && i.getPrice() > price)
					.forEach(i -> System.out.println(i));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
