package com.inheritance;

import java.util.Date;

public class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;
    public Circle(){

    }
    public Circle(double radius){
        setRadius(radius);

    }
    public Circle(double radius, String color, boolean filled){
        this(radius);
        setColor(color); // invoke the setColor() to reset the private variable  in superClass
        setFilled(filled);// 'this.color, this.filled' can't be used since private
        setDateCreated(new Date());
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius)throws IllegalArgumentException{
        if(radius <= 0)
            throw new IllegalArgumentException("Radium cannot be negative or 0.");
        else
            this.radius = radius;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    public void printCircle(){
        System.out.println("the circle of " + getRadius() + " and area is " + getArea());
    }
    public String toString(){
        return super.toString() + "\nradius is " + getRadius();
    }

    @Override
    public int compareTo(Circle c){
        if(getArea() > c.getArea()){
            return 1;
        }else if(getArea() < c.getArea()){
            return -1;
        }else{
            return 0;
        }
    }
}
