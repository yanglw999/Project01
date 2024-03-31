package com.basicObj;

public class MyCharacterTest {
    public static void main(String[] args) {
        MyCharacter ch1 = new MyCharacter('a');
        System.out.println(ch1.compareTo(new MyCharacter('e')));
        System.out.println(ch1.isDigit());
        System.out.println(ch1.toUpperCase());
        System.out.println(MyCharacter.toLowerCase('M'));
    }
}
