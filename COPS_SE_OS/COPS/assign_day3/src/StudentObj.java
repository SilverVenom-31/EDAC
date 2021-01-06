//Created by Akhil Darge on 3/10/20.

import java.util.Scanner;

public class StudentObj {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Student stud = new Student();
        System.out.print("Enter name of student: ");
        stud.name = scan.nextLine();    //populating name
        System.out.print("Enter roll number of student: ");
        stud.rollNumber = scan.nextInt();   //populating rollNumber

        System.out.print("Student Name: " + stud.name + "\nStudent roll no.: " + stud.rollNumber);
        scan.close();

    }
}
