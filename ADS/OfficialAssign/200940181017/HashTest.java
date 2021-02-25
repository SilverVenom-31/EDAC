package phoneDirectory;

import java.util.Scanner;


//Hash table is a data structure that is directly accessed based on the key value. 
//The hash table is to quickly locate a location in the table for access based on the key code value to speed up the search.

public class HashTest {
		public static void main(String[] args) {
			try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter the size of hashtable : ");
			Hashtable ht=new Hashtable(sc.nextInt()); 
			boolean flag=false;
			System.out.println("Welcome to the telephone directory !!");
			while(!flag) {
			System.out.println("Enter 1 : Add information about a user");
			System.out.println("Input 2 : Find/Search a user");
			System.out.println("Input 3 : Delete User information");
			System.out.println("Input 4 : Display list of User along with the information");
			System.out.println("Input 5 : Exit the system.");
			try {
				System.out.println("Enter your option---");
				switch(sc.nextInt())
				{
				case 1:
					ht.in();
					break;
				case 2:
					ht.find(); 
					break;
				case 3:
					ht.delete();
					break;
				case 4:
					ht.list();
					break;
				case 5:
					flag=true;
					System.out.println("Thank you !! Exited Successfully...");
					break;
				default:
					System.out.println("WRONG Option !! Please choose a correct one...");
				   break;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
			
		}
	}
}
 //  Hash table provide index based searching
//   Time complexity for add: o(1) (using hash function)
//   Time complexity for search based on phone number : best O(1)...worst O(n)
//   Time complexity for search based on name  : best O(1)..average O(n)...worst O(n2)

 