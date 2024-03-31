package com.inheritance;

public class PersonTest {
    public static void main(String[] args) {
        Person faculty = new PerFaculty("Maddy","Ontario","647719","maddy@gmail.com",1,10000,8,"Associate");
        System.out.println(faculty.toString());
        System.out.println("name: " + faculty.getName());

        //Person --> PerEmployee (explicit casting & downcasting)
        PerEmployee employee =(PerEmployee) faculty;// explicit casting & downcasting
        System.out.println("salary:" + employee.getSalary());

        if(faculty instanceof PerFaculty)
        System.out.println("rank: " + ((PerFaculty)faculty).getRank());

        System.out.println(faculty.equals(employee));
    }
}
