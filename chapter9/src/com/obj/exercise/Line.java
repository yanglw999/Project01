package com.obj.exercise;

public class Line{
    double x1, x2;
    double y1, y2;
    public Line(){

    }
    public Line(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }



    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getK(){
        return  (getY2() - getY1()) /(getX2() - getX1());
    }
    public double getB(){
        return getY1() - getX1() * getK();
    }


    public  void xPoint(Line line){
        String point;
        if(getK() != line.getK()) {
          //  point =  "(" + (line.getB() - getB())/(getK() - line.getK()) + ", " +
                   // (getK() * line.getB() - getB() * line.getK()) / (getK() - line.getK()) + ")";
            point = String.format("(%.2f, " +
                    "%.2f)",(line.getB() - getB())/(getK() - line.getK()), (getK() * line.getB() - getB() * line.getK()) / (getK() - line.getK()) );

        }else{
            point = "not intersected";;
        }
        System.out.println(point);
    }
}
