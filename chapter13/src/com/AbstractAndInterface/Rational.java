package com.AbstractAndInterface;

public class Rational extends Number implements Comparable<Rational> {
    private long numerator;
    private long denominator;
    public Rational(){}
    public Rational(long numerator, long denominator){
        this.numerator = ((denominator > 0)? 1 : -1) * numerator / gcd(numerator, denominator);
        this.denominator = Math.abs(denominator) /gcd(numerator,denominator);
    }
    public static long gcd(long m, long n){
        long a = Math.abs(m);
        long b = Math.abs(n);
        long gcd = 1;
        for(int i = 1; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0)
                gcd = i;
        }
        return gcd;
    }
    public long getNumerator(){
        return numerator;
    }
    public long getDenominator(){
        return denominator;
    }
    public Rational add(Rational num){
        long a = getNumerator() * num.getDenominator() + getDenominator() * num.getNumerator();
        long b = getDenominator() * num.getDenominator();
        return new Rational(a,b);
    }
    public Rational subtract(Rational num){
        long a = getNumerator() * num.getDenominator() - getDenominator() * num.getNumerator();
        long b = getDenominator() * num.getDenominator();
        return new Rational(a,b);
    }
    public Rational multiply( Rational num){
        long a = getNumerator() * num.getNumerator();
        long b = getDenominator() * num.getDenominator();
        return new Rational(a,b);
    }
    public Rational divide(Rational num) {
        long a = getNumerator() * num.getDenominator();
        long b = getDenominator() * num.getNumerator();
        return new Rational(a, b);
    }
    // Object class
    @Override
    public String toString(){
        if(getDenominator() == 1){
            return String.valueOf(numerator);
        }else {
            return numerator + "/" + denominator;
        }
    }
    @Override
    public boolean equals(Object obj){ // equals is defined in Object
        if(subtract((Rational)obj).getNumerator() == 0){
            return true;
        }else{
            return false;
        }
    }
    // Comparable interface
    @Override
    public int compareTo(Rational num){
        if(this.subtract(num).getNumerator() > 0){
            return 1;
        }else if(this.subtract(num).getNumerator() < 0){
            return -1;
        }else{
            return 0;
        }
    }
    // Number class
    @Override
    public double doubleValue(){
        return numerator * 1.0 / denominator;
    }
    @Override
    public int intValue(){
        return (int)doubleValue();
    }
    @Override
    public float floatValue(){
        return (float)doubleValue();
    }
    @Override
    public long longValue(){
        return (long)doubleValue();
    }
}
