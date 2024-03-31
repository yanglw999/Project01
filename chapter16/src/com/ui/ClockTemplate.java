package com.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockTemplate extends Pane {
   private double w = 800;
   private double h = 600;
   private double r = Math.min(w, h) / 2.0 * 0.7;

    Circle circle;
    Line hourHand;
    Line minHand;
    Line secondHand;
    double degreeOfHour;
    double degreeOfMin;
    double degreeOfSecond;

    int hour;
    int min;
    int second;
    Line longMark;
    Line shortMark;
    Label numMark;

    public ClockTemplate (){
        circle = new Circle( w / 2.0, h / 2.0, r);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        getChildren().add(circle);
       for(int i = 1; i <=  60; i ++){
            if(i % 5 == 0){
                 longMark = new Line();
                longMark.setStrokeWidth(3);
                longMark.setStroke(Color.RED);
                longMark.setStartX(circle.getCenterX() + (r - 10) * Math.cos(i * (2 * Math.PI / 60.0)));
                longMark.setStartY(circle.getCenterY() - (r - 10) * Math.sin(i * (2 * Math.PI / 60.0)));
                longMark.setEndX(circle.getCenterX() + (r - 0) * Math.cos(i * (2 * Math.PI / 60.0)));
                longMark.setEndY(circle.getCenterY() - (r - 0) * Math.sin(i * (2 * Math.PI / 60.0)));
                getChildren().add(longMark);
            }else{
                 shortMark = new Line();
                shortMark.setStartX(circle.getCenterX() + (r - 5) * Math.cos(i * (2 * Math.PI / 60.0)));
                shortMark.setStartY(circle.getCenterY() - (r - 5) * Math.sin(i * (2 * Math.PI / 60.0)));
                shortMark.setEndX(circle.getCenterX() + (r - 0) * Math.cos(i * (2 * Math.PI / 60.0)));
                shortMark.setEndY(circle.getCenterY() - (r - 0) * Math.sin(i * (2 * Math.PI / 60.0)));
                getChildren().add(shortMark);
            }

        }
        for(int i = 1; i <= 12; i++){
            numMark = new Label();
            numMark.setPadding(new Insets(0,3,3,0));
            numMark.setText(String.valueOf(i));
            numMark.setLayoutX(circle.getCenterX() + (r - 15) * Math.cos(-i * Math.PI / 6.0 + (Math.PI / 2.0)));
            numMark.setLayoutY(circle.getCenterY() - (r - 20) * Math.sin(-i * Math.PI / 6.0 + (Math.PI / 2.0)));
            getChildren().add(numMark);
        }

        hourHand = new Line();
        hourHand.setStartX(circle.getCenterX());
        hourHand.setStartY(circle.getCenterY());
        hourHand.setEndX(circle.getCenterX() + (r * 0.6) * Math.cos(- degreeOfHour + Math.PI / 2));
        hourHand.setEndY(circle.getCenterY() - (r * 0.6) * Math.sin(- degreeOfHour + Math.PI / 2));

        minHand = new Line();
        minHand.setStrokeWidth(3);
        minHand.setStroke(Color.BLUE);
        minHand.setStartX(circle.getCenterX());
        minHand.setStartY(circle.getCenterY());
        minHand.setEndX(circle.getCenterX() + (r * 0.75) * Math.cos(- degreeOfMin + Math.PI / 2));
        minHand.setEndY(circle.getCenterY() - (r * 0.75) * Math.sin(- degreeOfMin + Math.PI / 2));

        secondHand = new Line();
        secondHand.setStroke(Color.RED);
        secondHand.setStartX(circle.getCenterX());
        secondHand.setStartY(circle.getCenterY());
        secondHand.setEndX(circle.getCenterX() + (r * 0.85) * Math.cos(- degreeOfSecond + Math.PI / 2));
        secondHand.setEndY(circle.getCenterY() - (r * 0.85) * Math.sin(- degreeOfSecond + Math.PI / 2));
        getChildren().addAll(hourHand, minHand, secondHand);
    }
    public void setCurrentTime(){
        Calendar calendar = new GregorianCalendar();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
    }
    public void setAngles(){
        setCurrentTime();
        degreeOfSecond = (second / 60.0) * (2 * Math.PI);
        degreeOfMin = (second / 60.0 + min) / 60.0 * (2 * Math.PI);
        degreeOfHour = (second / 3600.0 + min / 60.0 + hour) / 12.0 * (2 * Math.PI);
    }
    public void setValues(){

        getChildren().clear();

        setAngles();

        circle = new Circle();
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);

        circle.setCenterX(getW() / 2.0);
        circle.setCenterY(getH() / 2.0);
        r = Math.min(getW(), getH()) / 2.0 * 0.7;
        circle.setRadius(r);
        getChildren().add(circle);

        for(int i = 1; i <=  60; i ++){
            if(i % 5 == 0){
               longMark = new Line();
               longMark.setStrokeWidth(3);
               longMark.setStroke(Color.RED);
                longMark.setStartX(circle.getCenterX() + (r - 10) * Math.cos(i * (2 * Math.PI / 60.0)));
                longMark.setStartY(circle.getCenterY() - (r - 10) * Math.sin(i * (2 * Math.PI / 60.0)));
                longMark.setEndX(circle.getCenterX() + (r - 0) * Math.cos(i * (2 * Math.PI / 60.0)));
                longMark.setEndY(circle.getCenterY() - (r - 0) * Math.sin(i * (2 * Math.PI / 60.0)));
                getChildren().add(longMark);
            }else{
                 shortMark = new Line();
                shortMark.setStartX(circle.getCenterX() + (r - 5) * Math.cos(i * (2 * Math.PI / 60.0)));
                shortMark.setStartY(circle.getCenterY() - (r - 5) * Math.sin(i * (2 * Math.PI / 60.0)));
                shortMark.setEndX(circle.getCenterX() + (r - 0) * Math.cos(i * (2 * Math.PI / 60.0)));
                shortMark.setEndY(circle.getCenterY() - (r - 0) * Math.sin(i * (2 * Math.PI / 60.0)));
                getChildren().add(shortMark);
            }

        }
        for(int i = 1; i <= 12; i++){
             numMark = new Label();
            numMark.setPadding(new Insets(0,3,3,0));
            numMark.setText(String.valueOf(i));
            numMark.setLayoutX(circle.getCenterX() + (r - 15) * Math.cos(-i * Math.PI / 6.0 + (Math.PI / 2.0)));
            numMark.setLayoutY(circle.getCenterY() - (r - 20) * Math.sin(-i * Math.PI / 6.0 + (Math.PI / 2.0)));
            getChildren().add(numMark);
        }

        hourHand = new Line();
        hourHand.setStartX(circle.getCenterX());
        hourHand.setStartY(circle.getCenterY());
        hourHand.setEndX(circle.getCenterX() + (r * 0.6) * Math.cos(- degreeOfHour + Math.PI / 2));
        hourHand.setEndY(circle.getCenterY() - (r * 0.6) * Math.sin(- degreeOfHour + Math.PI / 2));

        minHand = new Line();
        minHand.setStroke(Color.BLUE);
        minHand.setStrokeWidth(2);
        minHand.setStartX(circle.getCenterX());
        minHand.setStartY(circle.getCenterY());
        minHand.setEndX(circle.getCenterX() + (r * 0.75) * Math.cos(- degreeOfMin + Math.PI / 2));
        minHand.setEndY(circle.getCenterY() - (r * 0.75) * Math.sin(- degreeOfMin + Math.PI / 2));

        secondHand = new Line();
        secondHand.setStroke(Color.RED);
        secondHand.setStartX(circle.getCenterX());
        secondHand.setStartY(circle.getCenterY());
        secondHand.setEndX(circle.getCenterX() + (r * 0.85) * Math.cos(- degreeOfSecond + Math.PI / 2));
        secondHand.setEndY(circle.getCenterY() - (r * 0.85) * Math.sin(- degreeOfSecond + Math.PI / 2));

        getChildren().addAll(hourHand,minHand,secondHand);

    }

    public void setW(double w) {
        this.w = w;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }
}
