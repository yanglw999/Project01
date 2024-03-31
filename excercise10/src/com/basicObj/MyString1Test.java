package com.basicObj;

public class MyString1Test {
    public static void main(String[] args) {
        MyString1 str = new MyString1(new char[] {'a', 'b', 'c'});
        System.out.println(str.length());
        System.out.println(str.charAt(1));
        System.out.println(str.equals(new MyString1(new char[]{'a','c','b'})));
        System.out.println(str.substring(0,2).toChars());

        char[] chars = MyString1.valueOf(34567).toChars();
        for(int i = 0; i < chars.length; i++){
            System.out.print(chars[i]);
        }
    }
}
