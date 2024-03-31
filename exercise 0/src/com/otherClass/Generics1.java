package com.otherClass;


// Generics on interface
public interface Generics1 <T, N> { // interface only contains abstract method and constants
     T getName();
     N getAge(); // modifier public/abstract is redundant for interface method
}
class Generics1Sub implements Generics1 <String, Integer> {  // T, N must be specified
    String name;
    Integer age;
    @Override
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
}
class test1 {
    public static void main(String[] args) {
        Generics1Sub g1S1 = new Generics1Sub(); //implemented subClass as class type
        Integer age = g1S1.getAge();
        Generics1 <String, Integer> g1S2 = new Generics1Sub(); // use interface as class type

    }
}