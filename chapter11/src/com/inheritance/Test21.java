package com.inheritance;

public class Test21 {
    private int age;
    private String name;
    public Test21(){
        this(25, "dog");
    }
    public Test21(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString(){
        return "name: " + name + "; age: " + age + ";";
    }

    public static void main(String[]args){
        new People().printPeople();
        new Student().printPeople();

        Test21 test21 = new Test21();
        System.out.println(test21.toString());


    }
}
class Student extends People{
    @Override
    public String getInfo(){
        return "Student";
    }
}
class People{
    public String getInfo(){
        return "Person";
    }

    public void printPeople(){
        System.out.println(getInfo());
    }
}