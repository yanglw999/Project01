package com.otherClass;

public class StrAppend {
    public static void main(String[] args) {
        String str1 = "";
        long num0 = Runtime.getRuntime().freeMemory();
        long time0 = System.currentTimeMillis();
        for(int i = 0; i < 5000; i++){
            str1 += i;
        }
        long num1 = Runtime.getRuntime().freeMemory();
        long time1 = System.currentTimeMillis();
        System.out.print("occupied memory: " +  (num0 - num1) + "\n");
        System.out.print("consumed time: " + (time1 - time0)+ "\n");
        //
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        StringBuilder str2 = new StringBuilder("");
        for(int i = 0; i < 5000; i++){
            str2.append(i);
        }
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        System.out.print("occupied memory: " +  (num3 - num2) + "\n");
        System.out.print("consumed time: " + (time3 - time2) + "\n");
    }
}
