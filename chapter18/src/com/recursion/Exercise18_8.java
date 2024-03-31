package com.recursion;

public class Exercise18_8 {
    public static int reverseDisplay(int value){
        String str = String.valueOf(value);
        int length = str.length();
        if(value >= 0 & value <= 9){
            return  value;
        }else{
            int quotient = (value / 10);
            return  (int)(value % 10 * Math.pow(10,length -1)) + reverseDisplay(quotient );
        }

    }
    private static int reverseNum;
    public static void reversalDisplay(int value){
        int temp = 0;
        String str = String.valueOf(value);
        int length = str.length();
        if(value >= 0 & value <= 9){
            temp = value;
        }else{
            temp = (int)(value % 10 * Math.pow(10,length -1));
        }
        int quotient = (value / 10);
        reverseNum += temp;
        if(quotient == 0){
            System.out.println(reverseNum);
        }else {
            reversalDisplay(quotient);
        }
    }
    // standard answer
    public static void reverse(int value){
        if(value != 0){
            System.out.print(value % 10);
            value = value / 10;
            reverse(value);
        }
    }

    public static void main(String[] args) {
        System.out.println("the reverse num is: " + reverseDisplay(12345));
        System.out.print("the reversal display is: ");
        reversalDisplay(12345);
    }
}
