package com.example;

public class StackOfPrime {
    public static void main(String[] args) {
        StackOfIntegers prime = new StackOfIntegers();
        for(int i = 2; i < 120; i++){
           if(isPrimeNum(i)){
               prime.push(i);
           }
        }
        while (!prime.empty()){
            System.out.print(prime.pop() + " ");
        }
    }

    public static boolean isPrimeNum(int num){
        boolean isPrime = true;
        for(int j = 2; j < num / 2; j++){
            if(num % j == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
