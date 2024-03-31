package com.inheritance;

public class CircleRectangleTest {
    public static void main(String[] args) {
        Circle c = new Circle(1,"red",false);
        System.out.println("the circle: " + c.toString()); // invoke toString of its own
        System.out.println("the circle was created on " + c.getDateCreated());
        Circle c2 = new Circle(2,"blue",true);
        System.out.println("c and c1 comparison: " + c.compareTo(c2));
        // String.format()
        System.out.println(String.format("the Perimeter: %.2f",c.getPerimeter()));
        System.out.println("the color: " + c.getColor());
        System.out.println();
        Rectangle rec = new Rectangle(2,4,"black",true);
        System.out.println("A rectangle " + rec.toString());// toString() is from SuperClass
    }
}
