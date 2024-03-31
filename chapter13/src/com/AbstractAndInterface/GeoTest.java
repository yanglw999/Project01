package com.AbstractAndInterface;

public class GeoTest {
    public static void main(String[] args) {
        GeomObject obj1 = new GeoCircle("while",true,2);
        GeomObject obj2 = new GeoRectangle("red",false,3,2);
        System.out.println("is the area of two objects equal: " + isAreaEqual(obj1,obj2));
        System.out.println("display the rectangle:");
        displayGeomObject(obj2);

    }
    public static boolean isAreaEqual(GeomObject obj1, GeomObject obj2){ // must be static, or cannot be invoked
        return obj1.getArea() == obj2.getArea();
    }
    public static void displayGeomObject(GeomObject obj){
        System.out.println(String.format(" created on %s, area is %.2f, perimeter is %.1f",obj.getDateCreated(),obj.getArea(),obj.getPerimeter()));
    }
}
