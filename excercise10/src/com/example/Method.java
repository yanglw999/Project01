package com.example;

public class Method {
    public static void main(String[] args) {
        int[]num = arrayRandom(20);
        System.out.println(java.util.Arrays.toString(num));
        bubbleSort(num);
        System.out.println(java.util.Arrays.toString(num));
    }
    public static int[] arrayRandom(int n){
        int[]array = new int[n];
        int i = 0;
        while( i < array.length ){
            boolean diff = true;
            int r = (int) (Math.random() * 100);
            for(int j = 0; j < i; j++){
                if(r == array[j])
                    diff = false;
            }
            if(diff){
                array[i] = r;
                i++;
            }
        }
        return array;
    }
    public static void bubbleSort(int[]array){
        for(int j = 0; j < array.length; j++){
            for(int i = j + 1; i < array.length; i++ ){
                if(array[j] > array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
