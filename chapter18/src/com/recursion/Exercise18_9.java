package com.recursion;

public class Exercise18_9 {
    // standard answer
    public static void reverse(int value){
        if(value != 0){
            System.out.print(value % 10);
            value = value / 10;
            reverse(value);
        }
    }
    public static void reverseDisplay(String value){
        if(value.length() != 0){
            System.out.print(value.charAt(value.length() - 1));
            value = value.substring(0, value.length() - 1);
            reverseDisplay(value);
        }
    }
    // Exercise18.11
    public static int sumDigits(long n){
        int sum = 0;
        if(n != 0){
            sum = (int)(n % 10) + sumDigits(n / 10);
        }
        return sum;
    }
    public static int sumDigits(int n){
        if(n == 0){
            return 0;
        }else{
            return n % 10 + sumDigits(n / 10);
        }
    }

    public static void main(String[] args) {
        System.out.print("1. the reverse of ABCDEF: ");
        reverseDisplay("ABCDEF");
        System.out.println();
        System.out.println("2. sumDigits: " + sumDigits(1234));
        System.out.println("3. sumDigits " + sumDigits(2034));
    }
}
