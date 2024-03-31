package com.ui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class FanZoom extends Pane {
    private double w = 600;
    private double h = 400;
    private double r = Math.min(w, h) * 0.4;
    double startAngle = 60;
    double arcLength = 30;
    double speedUnit = 3;
    boolean on = false;
    Circle circle = new Circle( );
    Arc[] arc = new Arc[4];

    public FanZoom(){
        circle.setCenterX(w/2);
        circle.setCenterY(h/2);
        circle.setRadius(r);
        circle.setFill(new Color(1,1,1,0));
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        for(int i = 0; i < 4; i++){ // loop cannot be put outside method
            arc[i] = new Arc(
                    circle.getCenterX(),circle.getCenterY(),
                      circle.getRadius() * .9,circle.getRadius() * .9, startAngle + (arcLength + 60) * i, arcLength);
            arc[i].setType(ArcType.ROUND);
            arc[i].centerXProperty().bind(circle.centerXProperty());
            arc[i].centerYProperty().bind(circle.centerYProperty());
            arc[i].radiusXProperty().bind(circle.radiusProperty().multiply(0.9));
            arc[i].radiusYProperty().bind(circle.radiusProperty().multiply(.9));
            arc[i].setFill(Color.color(Math.random(),Math.random(),Math.random()));
            getChildren().add(arc[i]);
        }

    }
    public void reverse(){
        speedUnit = - speedUnit;
        setValues();
    }
    public void setSpeedUnit(double speed){
        speedUnit = speed;
    }
    public void spin(){
        setStartAngle();
        setValues();
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
        setValues();
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
        setValues();
    }

    public double getR() {
        return r;
    }

    public void setR() {
        this.r = r = Math.min(w, h) * 0.4;
    }
    public void setStartAngle(){
        startAngle = startAngle + speedUnit;
    }

    public void setValues() {

        setR();
        circle.setCenterX(w / 2);
        circle.setCenterY(h / 2);
        circle.setRadius(r);
        circle.setFill(new Color(1, 1, 1, 0));

        for (int i = 0; i < 4; i++) { // loop cannot be put outside method
           /* arc[i].setCenterX(circle.getCenterX());
            arc[i].setCenterY(circle.getCenterY());
            arc[i].setRadiusX(circle.getRadius() * .9);
            arc[i].setRadiusY(circle.getRadius() * .9);
        } */
           arc[i].setFill(Color.color(Math.random(), Math.random(), Math.random()));
           arc[i].setStartAngle(startAngle + 90 * i);

        }

    }
}
