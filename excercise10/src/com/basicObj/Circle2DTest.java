package com.basicObj;

import com.example.Circle2D;

public class Circle2DTest {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(0,0,2);
        Circle2D c2 = new Circle2D(1,0,1);
        Circle2D c3 = new Circle2D(4,0,2);
        System.out.println("c1 contains c2: " + c1.contains(c2));
        System.out.println("c1 overlaps c3: " + c1.overlaps(c3));
    }


}
