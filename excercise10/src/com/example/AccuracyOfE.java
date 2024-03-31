package com.example;

import java.math.BigDecimal;

public class AccuracyOfE {
    public static void main(String[] args) {
        BigDecimal e1 = eAccuracy(100); // BigDecimal is a dataType not a object class
        System.out.print("e1 = " + e1);
        System.out.print("\ne2 = " + eAccuracy(1000));

    }
    public static BigDecimal eAccuracy(int n){
        BigDecimal s = BigDecimal.valueOf(1);
        BigDecimal p = new BigDecimal("1");
        BigDecimal div = new BigDecimal("1");
        BigDecimal numerator = new BigDecimal("1");
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= i; j++){
                p = p.multiply(new BigDecimal(j + ""));
            }
            div = numerator.divide(p,30,BigDecimal.ROUND_UP);
            s = s.add(div);
        }
        return s;
    }
}
