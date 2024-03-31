package com.example;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print("enter a string: ");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println("\nis \"" + s + "\" a palindrome ? ");
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s){
        String s1 = filter(s);
        String s2 = reverse(s1);
        return s1.equals(s2)? true : false;
    }
    public static String filter(String s){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(isLetterOrDigital(s.charAt(i))){
               str.append(s.charAt(i)) ;
            }
        }
        return str.toString(); // produce a new string only including digital and letters
    }
    public static boolean isLetterOrDigital(char a){
        if (a >= 'a' && a <= 'z' || a >= '0' && a <= '9' || a >= 'A' && a <= 'Z'){
            return true;
        }else {
            return false;
        }
    }
    public static String reverse(String str){
        StringBuilder strRev = new StringBuilder(str);
        strRev.reverse();
        return strRev.toString();
    }
}
