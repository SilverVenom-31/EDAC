package beans;

import java.util.*;

import pojos.Product;

public class ProductBean {
	private List<Product> products;

	public ProductBean() {
		products = Arrays.asList(new Product(101, "Book1", 500), new Product(102, "Book2", 600),
				new Product(103, "Book3", 400), new Product(104, "Book4", 450));

	}

	public List<Product> getProducts() {
		return products;
	}

}
