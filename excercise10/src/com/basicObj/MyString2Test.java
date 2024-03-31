package com.basicObj;

public class MyString2Test {
    public static void main(String[] args) {
        MyString2 str2 = new MyString2("hello World");
        System.out.println(str2.subString(2).toString());
        System.out.println(str2.toUpperCase().toString());
        System.out.println(str2.toChars());
    }
}
