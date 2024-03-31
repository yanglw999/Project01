package com.recursion;

import java.math.BigInteger;

public class Exercise18_1 {
    public static void main(String[] args) {
        System.out.println("the factorial of 10: " + bigFactorial(10));
        System.out.println("the fib num of index 10: " + fib(10));

    }
    public static BigInteger bigFactorial(int n){
        BigInteger result; // = new BigInteger("0");
        if(n == 0){
           result = new BigInteger("1");
        }else{
            result = new BigInteger(n + "").multiply(bigFactorial(n - 1) );
        }
        return result;
    }
    public static long fib(int index){
        if(index == 0){
            return 0;
        }else if(index == 1){
            return 1;
        }else {
            return fib(index - 1) + fib(index -2);
        }
    }
}
