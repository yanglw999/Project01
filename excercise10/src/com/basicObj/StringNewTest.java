package com.basicObj;

public class StringNewTest {
    public static void main(String[] args) {
        StringNew s1 = new StringNew("ab#12#453");
       String[] strings =  s1.split("#");
        for(String e : strings){
            System.out.print(e + " ");
        }
    }
}
