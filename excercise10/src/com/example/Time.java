package com.example;

public class Time {
    private Long hour;
    static int minute;
    int second;
    private static long millis;
    public Time(){
        this.hour = (System.currentTimeMillis() / 1000 / 60 / 60 % 24);
        minute = (int)(System.currentTimeMillis() / 1000 / 60 % 60);
        second = (int)(System.currentTimeMillis() / 1000 % 60);
    }
    public Time(long millis){
        this.hour = (millis / 1000 / 60 / 60 % 24);
        minute = (int) (millis / 1000 / 60 % 60);
        second =(int) (millis / 1000 % 60);
    }
    public Long getHour(){
        return this.hour;
    }
    public static long getMinute(){
        return minute;
    }
    public long getSecond(){
        return second;
    }
    public static void setTimeMillIs(long elapseTime){
        millis = elapseTime;
    }
}
