package com.basicObj;

public class MyStringBuilderTest {
    public static void main(String[] args) {
        MyStringBuilder1 my = new MyStringBuilder1("Tomorrow");
        my.append(new MyStringBuilder1(" is Sunday" ));
        System.out.println(my);
        System.out.println(my.length());
        System.out.println(my.substring(3,12));
        System.out.println(my.toLowerCase());
        System.out.println(my.toString());
    }
}
