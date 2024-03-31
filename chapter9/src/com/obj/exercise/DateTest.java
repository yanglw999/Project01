package com.obj.exercise;
import java.util.*;
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("since Jan 01, 1970,00:00:00, it passed " + date.getTime() + " milliseconds.");
        System.out.println(date); // date ~ date.toString() 用法一样
        System.out.println(date.toString());

        Date date2 = new Date(2012,1,21);// 1970/01/01 + 2012/01/21
        System.out.println("date 2: " + date2.toString());
        date2.setTime(100000000000000L); //.getTime() & .setTime() 都是现成方法，直接可以用
        System.out.println("after setTime date 2: " + date2);

        Date date3 = new Date(100000L);
        System.out.println("before setTime date 3: " + date3.toString());
        date3.setTime(100000000000L);
        System.out.println("after setTime date 3: " + date3);
    }
}

