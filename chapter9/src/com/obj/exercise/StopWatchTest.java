package com.obj.exercise;

//9.6 exercise
public class StopWatchTest {
    public static void main(String[] args) {
        StopWatch wa = new StopWatch();
        wa.start();
        int[] num = new int[20];
        int n = 0;
        while( n < num.length){
            boolean diff = true;
            int m = (int)(Math.random() * 2000);
            for(int j =0; j < n; j++ ) {
                if (m == num[j]) {
                    diff = false;
                    break;
                }
            }
                if(true){
                    num[n] = m;
                    n++;
                }
        }
        System.out.println(java.util.Arrays.toString(num));
        bubbleSort(num);
        System.out.println(java.util.Arrays.toString(num));
        wa.stop();
        System.out.println("times: " + wa.getElapseTime() + " ms.");
    }
    public static void bubbleSort(int[]num){
        // bubble sort
        for(int i = 0; i < num.length; i++){
            for(int j = i +1 ; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }
}
