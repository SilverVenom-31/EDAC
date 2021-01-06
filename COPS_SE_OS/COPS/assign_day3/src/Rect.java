//Created by Akhil Darge on 3/10/20.

import java.util.Scanner;

public class Rect {
    public static void main(String args[]) {
        Rectangle rect = new Rectangle();   //assigning object to class Rectangle
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter width: ");
        rect.width = scan.nextDouble(); //populating width
        System.out.print("Enter height: ");
        rect.height = scan.nextDouble();  //populating height

        System.out.print("Area of Rectangle: " + rect.area());
        scan.close();

    }
}
