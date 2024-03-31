package com.otherClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        // string --> Date
        DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str1 = "2022-11-22 23:40:56";
        Date date1 = f1.parse(str1);
        System.out.print("date is: " + date1 + "\n");

        // date --> string
        Date date2 = new Date(10L*365*24*3600*1000);
        DateFormat f2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String time = f2.format(date2);
        System.out.println("date format: " + time + "\n");

        //
        Date date3 = new Date();
        DateFormat f3 = new SimpleDateFormat("D day of this year, w week of this year");
        String nowDate = f3.format(date3);
        System.out.println(nowDate);
    }
}
