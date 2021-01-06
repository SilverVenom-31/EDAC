//Created by @AkhilD on 01/01/2021.
package com.app.tester;

import static com.app.core.Category.FRUITS;
import static java.time.LocalDate.parse;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import com.app.core.Product;

import utils.IOutils;
import static utils.CollectionUtils.*;
public class ProductInfo {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in);){
			
		//Store map of products in a binary file using serialization
			System.out.println("Enter fileName to save product details: ");
		
			IOutils.saveProducts(populateMap(populateData()), sc.next());
			
			System.out.println("saved product details");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
