package com.example;

import java.math.BigInteger;

public class LargeSqrtNum {
    public static void main(String[] args) {
        BigInteger num = new BigInteger(String.valueOf(Long.MAX_VALUE));
        System.out.println("Long.MAX_VALUE: " + num);
        BigInteger start = new BigInteger("3000000000");
        System.out.println("start: " + start);
        System.out.println("num sqrt:  \t\t" + "num:");
        int n = 0;
        while(n < 10){
            BigInteger startSquare = start.multiply(new BigInteger(String.valueOf(start)));
            if(startSquare.compareTo(num) == 1){// compareTo() : -1, 0, 1
                n++;
                System.out.print(start +"\t\t");
                System.out.println(startSquare);
            }
            start = start.add(new BigInteger(String.valueOf(1)));
        }
    }

    public static boolean isSqrtNum(BigInteger i) {
        // Math.sqrt() is not applied to BigInteger
        // String.valueOf(Math.sqrt(new BigInteger("i").doubleValue()))  String.valueOf(Math.sqrt(i.doubleValue())
        return i.mod(new BigInteger(" ")).equals(new BigInteger("0"));
    }
}
