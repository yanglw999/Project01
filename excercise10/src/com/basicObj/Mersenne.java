package com.basicObj;

import java.math.BigInteger;

public class Mersenne {
    public static void main(String[] args) {
        BigInteger baseNum = new BigInteger("2");
        System.out.print("p" + "\t\t");
        System.out.println("2^p - 1");
        for(int p = 2; p <=100; p++){
           /* BigInteger merNum = new BigInteger("2");
            for(int i = 1; i < p; i++){
                merNum = merNum.multiply(new BigInteger("2"));
            }
            */
           BigInteger merNum = baseNum.pow(p);
            if(isPrime( merNum.subtract(new BigInteger("1")))){
                System.out.print(p + "\t\t");
                System.out.println(merNum.subtract(new BigInteger("1")));

            }
        }

    }
    public static boolean isPrime(BigInteger n){
        boolean isPrime = true; //
        for( BigInteger i = new BigInteger("2");
             i.compareTo(new BigInteger(String.valueOf(n.divide(new BigInteger("2"))))) == -1;
             i = i.add(BigInteger.ONE) ){
            if(n.remainder(i) == BigInteger.ZERO){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
