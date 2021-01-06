//Created by @AkhilD on 31/12/2021.
package char_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BufferCopy {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));
				PrintWriter pr = new PrintWriter(new FileWriter(sc.nextLine()))) {

			br.lines().forEach(pr::println);

			// br.lines().forEach(l->pr.println(l) );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
