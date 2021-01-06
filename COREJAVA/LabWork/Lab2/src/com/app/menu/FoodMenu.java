//Created by @Akhild on 8/12/20.

package com.app.menu;
import java.util.*;


class FoodMenu{

public static void main(String [] args){

//Initializing data array
String [] foodItems = {"Dosa","Samosa","Rice","Vadapav","Franky"};
double [] price = {50,20,70,20,90};



//Creating instance of class
MenuBackEnd config = new MenuBackEnd(foodItems,price);






Scanner sc = new Scanner(System.in);


//Performing operations
config.performOperation(sc);

sc.close();
	


}

}


