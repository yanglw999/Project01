package com.obj.exercise;

public class lineXPointTest {
    public static void main(String[] args) {
        Line line1 = new Line(0,0,2,2);
        Line line2 = new Line(0,3,-1.5,0);
        System.out.println(" the intersection point between line1 and line2:");
        line1.xPoint(line2);
        System.out.print("line1 k = " + line1.getK() + ", line1 b = " + line1.getB() + " \n");
        System.out.print("line2 k = " + line2.getK() + ", line2 b = " + line2.getB() + " \n");
    }

}
