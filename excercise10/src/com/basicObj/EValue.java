package com.basicObj;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EValue {
    public static void main(String[] args) {
        BigDecimal eBase = new BigDecimal(1);

        for(BigInteger  i = BigInteger.ONE; i.compareTo(new BigInteger("1001" )) == -1; // i < 1000
            i = i.add(BigInteger.ONE)){

            BigInteger factorial = new BigInteger(String.valueOf(BigInteger.ONE));

            for(BigInteger n = i; n.compareTo(BigInteger.ZERO) == 1; n = n.subtract(BigInteger.ONE)){
                factorial = factorial.multiply(new BigInteger(String.valueOf(n)));
            }
            //new BigInteger("1").devide(new BigInteger("10")) return integer 0
            // new BigDecimal(1).devide(new BigInteger("10")) return decimal 0.1
            eBase = eBase.add(new BigDecimal(String.valueOf(
                    new BigDecimal("1").divide(new BigDecimal(String.valueOf(factorial)),10,BigDecimal.ROUND_UP))));
        }
        System.out.println("e = " + eBase);
    }
}
