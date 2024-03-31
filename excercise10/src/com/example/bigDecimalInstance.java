package com.example;

import java.math.BigDecimal;

public class bigDecimalInstance {
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal(100);
        BigDecimal t = new BigDecimal(.99);
        for(int i = 1; i <= 100; i++){
            d = d.multiply(t) ;
        }
        System.out.println("product: " + d);
    }
}
