package com.obj.exercise;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random ran1 = new Random();// current time as seed when using Random()
        System.out.println("Produce a random integer @ current time: " + ran1.nextInt());

        Random ran2 = new Random(10L);//.nextInt() has boundary
        System.out.println("random integer ran2 within 1000: " + ran2.nextInt(1000));

        Random ran3 = new Random();
        System.out.println("random decimal ran3 within 1: " + ran3.nextDouble());

        Random ran4 = new Random(5);
        System.out.println("random Long ran4: " + ran4.nextLong());

        Random ran5 = new Random(100);//.nextFloat() within [0,1)
        System.out.println("random float ran5 within 1: " + ran3.nextFloat());

        Random ran6 = new Random(0);
        System.out.println("random true or false: " + ran6.nextBoolean());
    }
}
