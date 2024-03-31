package com.otherClass;

// Generics on class
public class Generics0 <T,N> {
    private N age;
    private T name;
    public void setAge (N age){
        this.age = age;
    }
    public N getAge(){
        return this.age;
    }
    public T getName(){
        return this.name;
    }
}
class test0{
    public static void main(String[] args) {
        Generics0 <String,Number> g0 = new Generics0<>(); // when new instance, need to specify the type T,N
        String name = g0.getName();
        Generics0 g1 = new Generics0(); // if not specify the type, take off <>, default Object class
        g1.setAge(25);
    }

}
