package com.Exercise14;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockTemplate extends Pane {
    double w = 1500;
    double h = 800;

    int hour;
    int minute;
    int second;
    int date ;
    public ClockTemplate(){
        ClockDraw();
    }
 public void setCurrentTime(){
     Calendar calendar = new GregorianCalendar();
     hour = calendar.get(Calendar.HOUR_OF_DAY);
     minute = calendar.get(Calendar.MINUTE);
     second = calendar.get(Calendar.SECOND);
     date = calendar.get(Calendar.DAY_OF_MONTH);
     ClockDraw();
 }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getDate() {
        return date;
    }

    public void ClockDraw(){
        double r = Math.min(w,h) * 0.5 * .5;
        Circle circle = new Circle(700,400,r);
        circle.setFill(Color.WHITE);
        circle.setStyle("-fx-stroke-width: 2;-fx-stroke: BLACK");
        //circle.centerXProperty().bind(widthProperty().divide(2));
       // circle.centerYProperty().bind(heightProperty().divide(2));
        getChildren().add(circle);
        double layoutX = circle.getCenterX();
        double layoutY = circle.getCenterY();
        Line line1;
        for(int i = 1; i <= 60; i ++){
            double percent = 1;
            if(i % 5 == 0){
                percent = .95;
            }
            line1 = new Line(1,1,1,1);
            line1.setStyle("-fx-stroke-width: 2");
            line1.setStartX(layoutX + percent * (r - 5) * Math.cos(2 * Math.PI / 60 * i) );
            line1.setStartY(layoutY - percent *(r - 5) * Math.sin(2 * Math.PI / 60 * i) );
            line1.setEndX(layoutX + (r) * Math.cos((2 * Math.PI / 60 * i)));
            line1.setEndY(layoutY - (r) * Math.sin((2 * Math.PI / 60 * i)));
            getChildren().add(line1);
        }
        for(int i = 12; i >= 1; i--){
            Text text = new Text();
            if(i == 12){
                 javafx.scene.image.ImageView imageView = new ImageView("image/rolex1.png");
                 imageView.setFitHeight(35);
                 imageView.setFitWidth(50);
                 imageView.setLayoutX(675);
                 imageView.setLayoutY(220);
                 getChildren().add(imageView);
            }else if(i == 3){
                // date
                TextField textField = new TextField();

                textField.setStyle("-fx-font-size: 30");
                textField.setText(String.valueOf(getDate()));
                textField.setEditable(false);
                textField.setStyle("-fx-border-color: black;-fx-font-weight: bold");
                textField.setAlignment(Pos.CENTER);
                textField.setPrefColumnCount(1);
                textField.setPrefHeight(30);
                textField.setPrefWidth(35);
                textField.setLayoutX(830);
                textField.setLayoutY(380);
                getChildren().add(textField);
            } else {
                 text = new Text(i +" " );
            }

            text.setFont(Font.font("Carrier", FontWeight.BOLD, FontPosture.ITALIC,20));
            text.setFill(Color.BLUE);
            text.setX(layoutX + (r-20) * Math.cos(2 * Math.PI / 12 * 3  + 2 * Math.PI /12 * (12 - i)) - 4 );
            text.setY(layoutY - (r - 25) * Math.sin(2 * Math.PI / 12 * 3 + 2 * Math.PI /12*(12 -i )) + 4 );
            getChildren().add(text);
        }
        Label label2 = new Label("ROLEX DATEJUST");
        label2.setFont(Font.font("Carrier",FontWeight.BOLD,FontPosture.REGULAR,20));
        label2.setTextFill(Color.BLACK);
        label2.setLayoutX(625);
        label2.setLayoutY(300);

        Label label3 = new Label("Men are born for Rolex");
        label3.setFont(Font.font("Carrier",FontWeight.NORMAL,FontPosture.REGULAR,25));
        label3.setTextFill(Color.BLUE);
        label3.setLayoutX(582);
        label3.setLayoutY(340);

        Label label4 = new Label("ROLEX");
        label4.setTextFill(Color.color(0.2,0.5,.9,.95));
        label4.setFont(Font.font("Carrier",FontWeight.BOLD,FontPosture.ITALIC,30));
        label4.setLayoutX(654);
        label4.setLayoutY(250);
        getChildren().addAll( label2,label3,label4);

        double hEndX =  layoutX + 0.5 * r * Math.cos(-(2*Math.PI/12 * (getHour() + getMinute()/60.0 + getSecond()/3600.0)) + (Math.PI/2));
        double hEndY = layoutY - 0.5 * r * Math.sin(-(2*Math.PI/12 * (getHour() + getMinute()/60.0 + getSecond()/3600.0)) + (Math.PI/2));
        Line handHour = new Line(layoutX,layoutY,100,100);
        handHour.setFill(Color.BLACK);
        handHour.setStrokeWidth(5);
        handHour.setEndX(hEndX);
        handHour.setEndY(hEndY);

        double mEndX =  layoutX + 0.7 * r * Math.cos(-(2*Math.PI/60.0 * (getMinute() + getSecond()/60.0)) + (Math.PI/2));
        double mEndY = layoutY - 0.7 * r * Math.sin(-(2*Math.PI/60.0 * (getMinute() + getSecond()/60.0)) + (Math.PI/2));
        Line handMinute = new Line(layoutX,layoutY,100,100);
        handMinute.setStroke(Color.GREEN);
        handMinute.setStrokeWidth(3);
        handMinute.setEndX(mEndX);
        handMinute.setEndY(mEndY);

        double sEndX =  layoutX + 0.8 * r * Math.cos(-(2*Math.PI/60.0 * getSecond()) + (Math.PI/2));
        double sEndY = layoutY - 0.8 * r * Math.sin(-(2*Math.PI/60.0 * getSecond()) + (Math.PI/2));
        Line handSecond = new Line(layoutX,layoutY,100,100);
        handSecond.setStroke(Color.RED);
        handSecond.setStrokeWidth(1);
        handSecond.setEndX(sEndX);
        handSecond.setEndY(sEndY);
       getChildren().addAll(handHour,handMinute,handSecond);


    }
}
