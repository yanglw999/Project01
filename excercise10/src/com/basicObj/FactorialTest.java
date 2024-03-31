package com.basicObj;

import com.example.Factorial;

public class FactorialTest {
    public static void main(String[] args) {
        Factorial factorial = new Factorial(120);
        int[] primes = factorial.getPrimes();
        System.out.println(java.util.Arrays.toString(primes));
        int[] primeFactor = factorial.getPrimeFactors();
        System.out.println(java.util.Arrays.toString(primeFactor));
    }
}
