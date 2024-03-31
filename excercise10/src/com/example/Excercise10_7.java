package com.example;

public class Excercise10_7 {
    public static void main(String[] args) {
        Integer i = new Double(12.4).intValue();
        System.out.println("i: " + i);
        Double j = new Integer(12).doubleValue();
        System.out.println("j: " + j);
        Double a = Double.valueOf("12.4");
        System.out.println("a: " + a);
        Integer b  = Integer.valueOf("9" );
        System.out.println("b: " + b);
        int c = Integer.parseInt("10");
        System.out.println("c: " + c);
       /** Int d = Integer.parseInt("11",10);// wrong
        System.out.println("d: " + d); */
        Integer d = Integer.parseInt("15",8);//八进制 15 转换成十进制
        System.out.println("d: " + d);
        Integer e = (Double.valueOf("32.1")).intValue();// using .intValue()but without new
        System.out.println("e: " + e);
        String f = new Integer(23).toString();
        System.out.println("f: " + f);
        String g = (Double.valueOf("42.1")).toString();
        System.out.println("g: " + g);
        String h = String.format("%o",13);//十进制的13 转换为八进制
        System.out.println("h: " + h);
        Integer k = new Integer("30");
        System.out.println("k: " + k);
    }
}
