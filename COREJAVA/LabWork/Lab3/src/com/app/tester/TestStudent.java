package com.app.tester;

import com.app.core.Student;

import java.util.Scanner;

public class TestStudent {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Details of student:id,name,email,age: ");
        Student s1 = new Student(sc.nextInt(),sc.next(),sc.next(),sc.nextInt());

        sc.nextLine();
        System.out.println("Enter Details of student:id,name,email,age: ");
        Student s2 = new Student(sc.nextInt(),sc.next(),sc.next(),sc.nextInt());


        s1.computeGPA(30,40,50);
        s2.computeGPA(40,50,60);

        if(s1.isGreater(s2)){
            System.out.print(s1.fetchDetails()+" is greater");
        }else{
            System.out.print(s2.fetchDetails()+" is greater");

        }


    }
}
