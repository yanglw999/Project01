package com.AbstractAndInterface;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class ClassNumberTest {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(.35);
        numbers.add(new BigDecimal(5.9823456));
        numbers.add(new BigInteger("57896245"));
        numbers.add(-3.5);
        System.out.println("display the numbers: ");
        System.out.println(numbers.toString());
        System.out.print("the smallest num: " + smallestNum(numbers));

    }
    public static Number smallestNum(ArrayList<Number> list){
       // ArrayList<Number> list = new ArrayList<>();
        if(list == null || list.size() == 0){
            return null;
        }
        Number smallest = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(smallest.doubleValue() > list.get(i).doubleValue())
                smallest = list.get(i);
        }
        return smallest;
    }
}
