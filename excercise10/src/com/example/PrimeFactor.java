package com.example;

public class PrimeFactor {
    int num;
    int size;
    public PrimeFactor(int num){
        this.num = num;
    }

    public int[] find(){
        int[] primeFactors = new int[1];
        while (num > 1){
            int primeFactor = -1;
            for(int i = 2; i <= num; i++){
                if(num % i == 0){
                    num /= i;
                    primeFactor = i;
                    break;
                }
            }
            if(size >= primeFactors.length){
                int[] temp = new int[primeFactors.length + 1];
                System.arraycopy(primeFactors,0,temp,0,primeFactors.length);
                primeFactors = temp;
            }
            primeFactors[size] = primeFactor;
            size ++;
        }

        return primeFactors;
    }
}
