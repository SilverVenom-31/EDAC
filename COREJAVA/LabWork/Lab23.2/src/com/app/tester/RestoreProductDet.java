//Created by @AkhilD on 01/01/2021.
package com.app.tester;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

import static java.time.LocalDate.parse;

import com.app.core.Category;
import com.app.core.Product;
import static utils.IOutils.*;

public class RestoreProductDet {

	public static void main(String[] args) {
		// Restore product details using deserialization
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name: ");

			System.out.println(restoreProducts(sc.next()));
			System.out.println("Data restored");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
