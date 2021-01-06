//Created by @AkhilD on 30/12/2021.
package p2;

import static utils.CollectionUtils.populateData;

import java.util.List;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Product;

public class Test3 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Product> list = populateData();
			System.out.println("Enter category");
			Category category = Category.valueOf(sc.next().toUpperCase());
			
			double sumPrice = list.stream().filter(i-> i.getProductCatgeory()==category).mapToDouble(p->p.getPrice()).sum();
			System.out.println(sumPrice);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
