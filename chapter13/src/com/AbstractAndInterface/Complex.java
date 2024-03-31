package com.AbstractAndInterface;

public class Complex implements Cloneable {
    // a + b * i
    private double a;
    private double b;
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }
    public Complex(){
        a = 0;
        b = 0;
    }
    public Complex(double a){
        this.a = a;
        this.b = 0;
    }
    public double getRealPart() {
        return a;
    }
    public double getImaginaryPart(){
        return b;
    }
    public Complex add(Complex c){
        double m = getRealPart() + c.getRealPart();
        double n = getImaginaryPart() + c.getImaginaryPart();
        return new Complex(m,n);
    }
    public Complex subtract(Complex c){
        double m = getRealPart() - c.getRealPart();
        double n = getImaginaryPart() - c.getImaginaryPart();
        return new Complex(m,n);
    }
    public Complex multiply(Complex c){
       double m = getRealPart() * c.getRealPart() - getImaginaryPart() * c.getImaginaryPart();
       double n = getImaginaryPart() * c.getRealPart() + getRealPart() * c.getImaginaryPart();
       return new Complex(m,n);
    }
    public double ComplexAbs() {
        double m = a * a + b * b;
        double n = Math.pow(m, 0.5);
        return n;
    }
    @Override
    public boolean equals(Object c){
       return (subtract((Complex)c)).getRealPart() == 0 &&  subtract((Complex)c).getImaginaryPart() == 0;
    }
    @Override
    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }
   /* @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    } */
}
