package com.collect;

public abstract class Person {

    public Person(){}
    public abstract int getAge();
    public abstract double getHeight();
    public abstract int getCode();
}
class Teacher extends Person{
    private int age;
    private double height;
    private int code;
   
    public Teacher(int age, double height, int code){
        this.age = age;
        this.height = height;
        this.code = code;
    }
    @Override
    public int getAge(){
        return age;
    }
    @Override
    public double getHeight(){
        return height;
    }
    @Override
    public int getCode() {
        return code;
    }
}
class Student extends Person{
    private int age;
    private double height;
    private int code;
    public Student(int age, double height, int code){
        this.age = age;
        this.height = height;
        this.code = code;
    }
    @Override
    public int getAge(){
        return age;
    }
    @Override
    public double getHeight(){
        return height;
    }
    @Override
    public int getCode() {
        return code;
    }
}