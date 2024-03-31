package com.AbstractAndInterface;

public class GeoRectangle extends GeomObject {
    private double length;
    private double width;
    protected GeoRectangle(){
        super();
    }
    protected GeoRectangle(String color, boolean filled, double length, double width) {
        super(color, filled);
        setLength(length);
        this.width = width;
    }

    @Override
    public String toString() {
        return "GeoRectangle is Created on " + getDateCreated() + "color: " + getColor();
    }
    @Override // must override abstract methods
    public double getArea(){
        return length * width;
    }
    public double getPerimeter(){
        return 2 * (length + width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
