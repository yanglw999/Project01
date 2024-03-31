package com.inheritance;

public class PerStudent extends Person{
    private String grade;
    public PerStudent(){
    }
    public PerStudent(String name, String address, String ceil, String email, String grade){
        super(name, address, ceil,email);
        this.grade = grade;
    }
}
