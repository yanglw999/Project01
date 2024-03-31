package com.inheritance;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> city = new ArrayList<>();
        city.add("Toronto");city.add("London"); city.add("New York"); city.add("Shanghai");
        System.out.println("city list 1: " + city.toString());
        System.out.println("the size : " + city.size());
        if (!city.contains("Paris")) {
            city.add("Paris");
        } else {
            city.add("Sydney");
        }
        System.out.print("is city list empty ? " + city.isEmpty());
        city.add(2,"Beijing");
        System.out.println("\ncity list 2: " + city.toString());
        city.set(4,"Ottawa");// .set(,) differs from .add(,)
        System.out.println("city list 3: " + city.toString());
        System.out.println("length of " + city.get(3) + " : " + city.get(3).length());
    }
}
