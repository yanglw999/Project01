package com.example;

import java.math.BigInteger;

public class LargeFactorial {
    public static void main(String[] args) {
    BigInteger result = LargeFactorial.Factorial(100);
        System.out.println(result);
    }
    public static BigInteger Factorial(int n){
        BigInteger p = new BigInteger(String.valueOf(1));
        System.out.println(p);
        for(int i = n; i > 0; i--){
            p = p.multiply (new BigInteger(i + ""));// * does not work here
        }
        return p;
    }
}
