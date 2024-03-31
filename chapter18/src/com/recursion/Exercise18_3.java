package com.recursion;

public class Exercise18_3 {
    // calculate greatest common divisor
    public static int gcd(int m, int n){
        if(m < n){
            int temp = m;
            m = n;
            n = temp;
        }
        if(m % n == 0){
            return n;
        }else {
            return gcd(n, m % n);
        }
    }
    //m(i) = 1/3 + 1/2 + 1/3 .... 1/i
    public static double m(int n){
        if(n == 1){
            return 1.0;
        }else{
            return  (1.0 / n) + m(n - 1);
        }
    }
    // m(i) = 1/3 + 2/5 + 3/7 ....i/(2i + 1)
    public static double m2(int i){
        if(i == 1){
            return i/(2.0*i + 1.0);
            //return 1.0/3;
        }else {
            return i/(2.0*i + 1.0) + m2(i - 1);
        }

    }
    public static void main(String[] args) {
        System.out.println("the gcd of m & n: " + gcd(36,45));
        System.out.println("the m: " + m(3));
        for(int i = 1; i < 6; i++){
            System.out.printf("%.4f ", m2(i));
        }
    }
}
