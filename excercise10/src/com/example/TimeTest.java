package com.example;

public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time();
        System.out.println("current time: " + t.getHour() + " : " + t.getMinute() + " : "
        + t.getSecond() );
        Time t1 = new Time(555550000);
        System.out.println("the time: " + t1.getHour() + " : " + t1.getMinute() + " : "
                + t1.getSecond() );
        Time t2 = new Time(1252L);
        t2.setTimeMillIs(1203183023L); //under long type, num needs to be followed with L
        System.out.println("the time: " + t2.getHour() + " : " + t2.getMinute() + " : "
                + t2.getSecond() );
    }
}
