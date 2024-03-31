package com.example;

public class MyPointTest {
    public static void main(String[] args) {
        MyPoint p = new MyPoint();
        System.out.print("the coordinates: [" + p.getX() + ", " + p.getY() + "]\n");
        System.out.println("the distance with point (3, 4): " + p.distance(3,4));
        p.setX(6);
        p.setY(8);
        System.out.print("the coordinates: [" + p.getX() + ", " + p.getY() + "]\n");
        System.out.println("the distance with point (3, 4): " + p.distance(3,4));

        MyPoint p2 = new MyPoint( 3,4);
        System.out.println("the distance between p1 & p2: " + p.distance(p2));
    }
}
