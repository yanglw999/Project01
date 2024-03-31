package com.inheritance;

public class DynamicBindingTest {
    public static void main(String[] args) {
        new Pers().printPerson();
        new Stud().printPerson();
    }
}
class Stud extends Pers{
    @Override
    public String getInfo(){
        return "Student";
    }
}
class Pers{
    public String getInfo(){
        return "Person";
    }
    public void printPerson(){
        System.out.println(getInfo());
    }
}
