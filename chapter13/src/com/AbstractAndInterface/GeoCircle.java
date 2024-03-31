package com.AbstractAndInterface;

public class GeoCircle extends GeomObject {
    private double radius;
    private final double PI = Math.PI;
    public GeoCircle(){
        super();
    }
    public GeoCircle(String color, boolean filled,double radius){
        super(color,filled);
        setRadius(radius);
    }

    @Override
    public double getArea(){
        return radius*radius*PI;
    }
    public double getPerimeter(){
        return 2*PI*radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
}
