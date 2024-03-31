package com.example;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal big1 = new BigDecimal(9.3);
        BigDecimal big2 = new BigDecimal(4.5);
        BigDecimal v1 = big1.multiply(big2);
        System.out.printf("%.5f", v1);
        BigInteger n1 = new BigInteger("2");
        BigInteger v2 = n1.multiply(new BigInteger("5"));
        System.out.println(String.format("\n%d",v2));
    }
}
