package com.inheritance;

public class Person {
   private String name;
   private String address;
   private String ceil;
   private String email;
    public Person(){

    }
    public Person(String name, String address, String ceil, String email){
        this.name = name;
        this.address = address;
        this.ceil = ceil;
        this.email = email;
    }
    String getName(){
        return name;
    }
    String getAddress(){
        return address;
    }
    String getCeil(){
        return ceil;
    }
    String getEmail(){
        return email;
    }
    public String toString(){
        return "name: " + getName() + " address: " + getAddress() + " phone num: " + this.ceil + " email: " + getEmail();
    }
}
