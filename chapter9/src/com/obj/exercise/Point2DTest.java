package com.obj.exercise;
import javafx.geometry.Point2D;
import java.util.Scanner;
public class Point2DTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter point1's x-, y-coordinates: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.println("Enter point2's x-, y-coordinates: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        Point2D p1 = new Point2D(x1,y1);
        Point2D p2 = new Point2D(x2, y2);
        System.out.println("point1" + p1.toString());
        System.out.println("point2" + p2.toString());
        System.out.printf("the distance from point1 to points: %.2f", p1.distance(p2));
    }
}
