package com.otherClass;

import java.util.Random;

public enum  Season {
    SPRING, SUMMER, FALL, WINTER
}
class EnumTest{
    public static void main(String[] args) {
        int i = -1;
        int rand = new Random().nextInt(4);
        switch (Season.values()[rand]){ //Season.values()[] ~ list[]
            case SPRING:
                i = 0; break;
            case SUMMER:
                i = 1; break;
            case FALL:
                i = 2; break;
            case WINTER:
                i = 3; break;
        }
        System.out.println(i);
    }
}
