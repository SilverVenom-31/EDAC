package tester;

import java.util.Scanner;

public class TestCustomerCRUD {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			//create a dao instance
			boolean exit=false;
			while(!exit)
			{
				try {
					System.out.println("Menu 1: User Login 5 :Exit");
					switch (sc.nextInt()) {
					case 1: //user login
						
						break;

					case 5 :exit=true;
					//clean up dao (to release DB resources)
						break;
					}
				}catch (Exception e) {
					System.out.println("Error : "+e);
					System.out.println("Pls retry .....");
				}
				sc.nextLine();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
