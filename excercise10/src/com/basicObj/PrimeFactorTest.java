package com.basicObj;

import com.example.PrimeFactor;

public class PrimeFactorTest {
    public static void main(String[] args) {
        PrimeFactor n = new PrimeFactor(840);
       int[] primes =  n.find();
        System.out.println(java.util.Arrays.toString(primes));
    }




}
