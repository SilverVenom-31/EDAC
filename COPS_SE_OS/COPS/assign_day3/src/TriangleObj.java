//Created by Akhil Darge on 3/10/20.

import java.util.Scanner;

public class TriangleObj {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Triangle trian = new Triangle();
        System.out.print("Enter side 1 of triangle: ");
         trian.s1 = scan.nextDouble();
        System.out.print("Enter side 2 of triangle: ");
        trian.s2 = scan.nextDouble();
        System.out.print("Enter side 3 of triangle: ");
        trian.s3 = scan.nextDouble();
        System.out.println("\nPerimeter of triangle: " + trian.perimeter());
        System.out.println("Area of triangle: " + trian.area());
        scan.close();

    }
}

