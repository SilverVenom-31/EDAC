//Created by @AkhilD on 01/01/2021.
package com.app.tester;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import static java.time.LocalDate.parse;

import com.app.core.Category;
import com.app.core.Product;

public class RestoreProductDet {

	public static void main(String[] args) {
		
		try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("product.data")))) {
				
			Product p = new Product(in.readInt(), in.readUTF(), Category.valueOf(in.readUTF()), parse(in.readUTF()), in.readDouble());
			
			System.out.println(p);
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

}
