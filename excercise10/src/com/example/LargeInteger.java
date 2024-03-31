package com.example;

import java.math.BigInteger;

public class LargeInteger {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("100000000000000000000000000000000000000000000000000000000");
        int n = 0;
            do{
                if(isPicked(num)){
                    n++;
                    System.out.println(num);
                }
                num = num.add(new BigInteger("1"));
            }while(n < 10);

    }
    public static boolean isPicked(BigInteger i){ //divided by 2 or 3
        return (i.mod(new BigInteger("2")).equals(BigInteger.ZERO) )||
                (i.mod(new BigInteger("3")).equals(BigInteger.ZERO)) ;
    }
}
