package com.example;

public class Factorial {
    int [] primeFactors = new int[1];
    int size;
    int num;
    public Factorial(){

    }
    public Factorial(int num){
        this.num = num;
    }
    public int[] getPrimes(){
        int capacity = 0;
        int[] primes = new int[1];
        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;
            for(int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }

            }
            if(capacity >= primes.length){
                int [] temp = new int[primes.length + 1];
                System.arraycopy(primes,0,temp,0,primes.length);
                primes = temp;
            }

            if(isPrime){
                primes[capacity] = i;
                capacity++;
            }
        }
        return primes;

    }
    public boolean isPrime(int num){
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {

            if (num % i == 0) {
                isPrime = false;
                break;
                }

            }

        return isPrime;
    }


    public int[] getPrimeFactors(){
        int[] primeNum = getPrimes();
        int[] primeFactors = new int[1];
        while (num > 1){
            for (int prime : primeNum) {
                boolean isPrimeFactor = false;
                if(prime != 0 && num % prime == 0){
                    num /= prime;
                    isPrimeFactor = true;
                }
                if(size >= primeFactors.length){
                    int[] temp = new int[primeFactors.length + 1]; // roll to expand []
                    System.arraycopy(primeFactors,0,temp,0,primeFactors.length);
                    primeFactors = temp;
                }
               if(isPrimeFactor){
                   primeFactors[size] = prime;
                   size++;
               }

            }

        }
        return primeFactors;
            }

}
