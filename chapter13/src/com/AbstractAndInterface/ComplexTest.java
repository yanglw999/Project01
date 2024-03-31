package com.AbstractAndInterface;

public class ComplexTest {
    public static void main(String[] args) {
        Complex c1 = new Complex(3.5,5.5);
        Complex c2 = new Complex(-3.5,1);
        System.out.println("the multiplication of c1 and c2: " + c1.multiply(c2).getRealPart() + " + " + c1.multiply(c2).getImaginaryPart() + "i");
        System.out.println(c1.equals(c2));
        System.out.println(c1.ComplexAbs());
    }
}
