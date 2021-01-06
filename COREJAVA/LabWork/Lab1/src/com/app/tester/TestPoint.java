//tester class for UI

package com.app.tester;
import java.util.Scanner;
import java.lang.*;
import com.app.geometry.Point2D;

class TestPoint {


public static void main(String args[] ){


//Created Scanner class instance to wrap std i/p stream (console i/p stream)

Scanner sc = new Scanner (System.in);

System.out.println("Enter 1st point in x and y");

//Create first instance of Point class , with  user i/ps

Point2D firstPoints = new Point2D(sc.nextInt(),sc.nextInt());


System.out.println("Enter 2nd point in x and y");
//Create second instance of Point class , with  user i/ps

Point2D secondPoints = new Point2D(sc.nextInt(),sc.nextInt());


//display details of both points;
 System.out.println(firstPoints.getDetails());
 System.out.println(secondPoints.getDetails());
 
 
 
 //Invoking equal method for checking points lying on same co-ordinates
 
 System.out.println("p1 & p2 are located at the same position: "+firstPoints.isEqual(secondPoints));
 
 
 //Creating new instance with offset of previous points
 
	
 
 System.out.println("Enter offset for x and y: ");
  Point2D thirdPoints = firstPoints.createNewPoint(sc.nextInt(),sc.nextInt());
  System.out.println("Points after offset: "+thirdPoints.getDetails());
 
//Calculating distance of co-ordinates: 


System.out.println("Distance between 2 points: "+ firstPoints.calculateDistance(secondPoints)); 
 

//close scanner before terminating app
sc.close();
}

}
