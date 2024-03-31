package com.exercise11;

import com.inheritance.AbstractObj;

public class Square extends AbstractObj implements Colorable {
    private double side;
    public Square(){}
    public Square(double side, boolean fill){
        super(fill);
        setSide(side);
    }
    public void setSide(double side){
        this.side = side;
    }
    @Override
    public double getArea(){
        return side * side;
    }
    @Override
    public String toString(){
        return super.toString() + "Area: " + getArea();
    }
    @Override
    public void howToColor(){
        System.out.println("Color all four sides");
    }
    @Override
    public boolean equals(Object s){  //public boolean equals(Object obj) { return (this== obj); }
        return this.equals(s) ;
    }
}
