package com.example;

public class MyPoint {
    private double x, y;

    public MyPoint(){
        x = 0;
        y = 0;
    }
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(double a, double b){
        double dis = Math.sqrt((x - a) * (x - a) + (y - b) * (y - b));
        return dis;
    }
    public double distance(MyPoint point){
        double dis = Math.sqrt((point.x - this.x) * (point.x - this.x) + (point.y - this.y) * (point.y - this.y));
        return dis;
    }
}
