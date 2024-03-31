package com.recursion;

import java.util.Scanner;

public class Exercise18_10 {
    public static int count(String str, char a){
       int n = 0;
       if(str.length() > 0){
          // start from index 1 (including the char of index 1)until end of the string
           n = ((str.charAt(0) == a) ? 1: 0) + count(str.substring(1 ), a) ;
       }
        return n;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input a string: ");
        String str = input.nextLine();
        System.out.print("input a char: ");
        char ch = input.next().charAt(0);
        int count = count(str, ch);

        System.out.println(ch + " appears " + count + ((count > 1) ? " times " : " time ") + " in " + str);

    }
}
