package com.obj.exercise;

public class Rectangle {
    double width;
    double height;
    Rectangle (){
        width = 1;
        height = 1;
    }
    Rectangle (double w, double h){
        width = w;
        height = h;
    }
    public double getArea(){
        return width * height;
    }
    double getPerimeter(){
        return 2 *(width + height);
    }
}
