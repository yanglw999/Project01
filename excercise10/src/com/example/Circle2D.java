package com.example;

public class Circle2D {
    private double x, y, radius;
    public Circle2D(){
        this.radius = 1;
        this.x = 0;
        this.y = 0;
    }
    public Circle2D(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public boolean contains(Circle2D circle) {
        return (radius >= circle.radius)&&((Math.abs(x - circle.x) <= Math.abs(radius - circle.radius))) && ((Math.abs(y - circle.y) <= Math.abs(radius - circle.radius)));
    }
    public boolean overlaps(Circle2D circle){
        double a = Math.abs(x - circle.x);
        double b = Math.abs(radius - circle.radius);
        double c = Math.abs(radius + circle.radius);
        double d = Math.abs(y - circle.y);
        return ((a > b)&&(a < c)) ||((d > b) && ( d < c) );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }
}
