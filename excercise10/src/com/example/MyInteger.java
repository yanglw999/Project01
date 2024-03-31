package com.example;

public class MyInteger {
    private int value;
    public MyInteger(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public boolean isEven(){
        //return  (getValue() % 2 == 0) ? true : false;
        return getValue() % 2 == 0;
    }
    public boolean isPrime(){
        boolean isPrime = true;
        if(value == 1){
            System.out.println("1 neither prime number nor composite number");
            isPrime = false;
        }else {
            for (int i = 2; i <= value / 2; i++) {
                if (value % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
    public static boolean isOdd(int num){
        return num % 2 != 0;
    }

    public boolean equals(MyInteger num){
        return getValue() == num.getValue(); // return this.value = num.value;
    }
    public static int parseInt(String str){
       // return Integer.parseInt(str);  OR
        return Integer.valueOf(str);
    }
    public  static int parseInt(char[] digitalArray){
        return Integer.valueOf(String.valueOf(digitalArray)); // or return Integer.valueOf(new String(digitalArray));
    }
}
