//user defined package meant for functional separation
package com.app.geometry;

//class representing a point x-y co-ordinate system
public class Point2D {
    //state: x,y
    private int x, y;


//parameterized constructor

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;

    }


    //Business Logic: Return co-ordinates in string format
    public String getDetails() {

        return "Points: " + x + " " + y;

    }

//Return true if co-ordinates are equal

    public boolean isEqual(Point2D anotherPoint) {


        return (this.x == anotherPoint.x) && (this.y == anotherPoint.y);

    }
    

    
    //Point2D p3 = new Point2D(s,r);
    
   // Point2D p3 = p1.createNewPoint(2,3);
   
   
   

//Prevent method to compute the offset of points
    public Point2D createNewPoint(int xOff, int yOff) {
  
 
        return new Point2D((x + xOff), (y + yOff));

    }

    // based on formula for calculating distance of coordinates
    public double calculateDistance(Point2D anotherPoint) {

        return Math.sqrt((Math.pow(((x - anotherPoint.x)), 2)) + (Math.pow(((y - anotherPoint.y)), 2)));

    }


}
