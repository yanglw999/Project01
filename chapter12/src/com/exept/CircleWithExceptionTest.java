package com.exept;

import javafx.scene.shape.Circle;
// have some unsolved problems on how to invoke the class in other package
public class CircleWithExceptionTest {
    public static void main(String[] args) {
        try {
            Circle c1 = new Circle(5);
            Circle c2 = new Circle(-2);
           // System.out.println(Circle.getAre);
        }
        catch (IllegalArgumentException ex){
            System.out.println("\n" + ex);
            System.out.println("radius");
        }
        System.out.println("the num of object: " );
    }
}
