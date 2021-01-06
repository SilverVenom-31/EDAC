package com.app.core;

public class Student {

    // --- id(int) --, name (String), email(String), age(int),gpa(double)
    private int id;
    private String name;
    private String email;
    private int age;
    private double gpa;

    public Student(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;

    }

    public String fetchDetails(){
        return ("StudentId: "+id+" StudentName: "+name+" StudentEmail: "+email+" StudentAge: "+age+" StudentGPA: "+gpa);
    }


    public void computeGPA(int quiz , int test , int assignment)
    {
        this.gpa = ((((quiz*20)/100)+((test*50)/100)+((assignment*30)/100))*10)/100;

    }

    public boolean isGreater(Student anotherStudent){

        return (this.gpa>anotherStudent.gpa)?true:false;
    }


}
