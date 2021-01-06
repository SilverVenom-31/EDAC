//Created by @Akhild on 8/12/20.
package com.app.menu;
import java.util.*;

public class MenuBackEnd{

private double sum;
private String[] foodItems;
private double[] price;

public MenuBackEnd(String[] foodItems,double[] price){

this.foodItems = foodItems;
this.price = price;

}

public void performOperation( Scanner sc ){

//Scanner sc = new Scanner(System.in);

while (true){

//Displaying the menu: 
for (int i =0 ; i< foodItems.length ; i++){
System.out.println(i+"."+foodItems[i]+" == "+"  Rs."+price[i]);
}

//Taking the input from the customer:
System.out.println("\nChoose your item: ");
int item = sc.nextInt();

//Taking the quantity for computation: 
 System.out.println("Please enter the quantity: ");
 int quantity = sc.nextInt();

//Asking customer if they are still hungry:
 System.out.println("Do you want to order more or generate bill:\n1.Yes\n2.Generate Bill\n\nChoose option:  ");
int  option = sc.nextInt();
	
if (option == 1){
	sum = (quantity*price[item])+sum;
	continue;
}else{

//Total bill of previous orders and current orders: 
	sum = (quantity*price[item])+sum;
	
	//Requesting customer to pay the bill and leave:
	System.out.println("Generated Bill: Rs."+sum);
	System.exit(0);  //Initializing termination
     }	

   }

 }

}
