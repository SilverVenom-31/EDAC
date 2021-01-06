//Created by Akhil Darge on 3/10/20.

public class Triangle {
    double s1;
    double s2;
    double s3;


    double perimeter() {

        return (s1 + s2 + s3);
    }

    double area() {
        double p = (perimeter()) / 2; //called perimeter method
        return Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));   //formula for area of 3 sides of triangle

    }

}