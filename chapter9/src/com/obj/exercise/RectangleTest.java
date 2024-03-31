package com.obj.exercise;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(4,40);
        System.out.println("width: " + rec.width + "; height: " + rec.height +
                "; perimeter: " + rec.getPerimeter() + "; area: " + rec.getArea() + ";");
        Rectangle rec2 = new Rectangle(3.5,35.9);
        System.out.println("width: " + rec2.width + "; height: " + rec2.height +
                "; perimeter: " + rec2.getPerimeter() + "; area: " + rec2.getArea() + ";");
    }
}
