//Created by @AkhilD on 01/01/2021.
package com.app.tester;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;

import static java.time.LocalDate.parse;

import com.app.core.Category;
import com.app.core.Product;
import static utils.IOutils.*;

public class RestoreProductDet2 {

	public static void main(String[] args) {
		// Restore product details using deserialization
		try (Scanner sc = new Scanner(System.in)) {
			//Display name and price  of all products on separate lines
			System.out.println("Enter file name: ");
			Map<Integer, Product>map = restoreProducts(sc.next());
	
			map.forEach((k,v)->System.out.println(v));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
