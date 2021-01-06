//Created by @AkhilD on 01/01/2021.
package com.app.tester;

import static com.app.core.Category.FRUITS;
import static java.time.LocalDate.parse;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import com.app.core.Product;

public class ProductInfo {

	public static void main(String[] args) {
		Product p1 = new Product(1020, "mango", FRUITS, parse("2021-01-01"), 100);
		try (Scanner sc = new Scanner(System.in);DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("product.data")))){
			
			//id,name,category,date,price;
			
			out.writeInt(p1.getId());
			out.writeUTF(p1.getName());
			out.writeUTF(p1.getProductCatgeory().name());
			out.writeUTF(p1.getManufactureDate().toString());
			out.writeDouble(p1.getPrice());

			
			System.out.println("Writing over...");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
