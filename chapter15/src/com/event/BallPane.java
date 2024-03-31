package com.event;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1; // directionX, directionY
    private Circle circle = new Circle(x,y,radius);
    private Timeline animation;  // Timeline extends Animation

    public BallPane(){
        circle.setFill(Color.GREEN);
        getChildren().add(circle);

        EventHandler<ActionEvent> moveBall = e -> moveBall();
        // Timeline extends Animation
        animation = new Timeline(// for now, the speed of ball was decided by duration instead of speedUp or slowDown
                new KeyFrame(Duration.millis(100), moveBall ));// Timeline is like a loop, which repeatedly carrys out moveBall()
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    public void play(){
        animation.play();  // Timeline extends Animation
    }
    public void pause(){
        animation.pause();  // Timeline extends Animation
    }
    public void speedUp(){  // Timeline extends Animation
        animation.setRate(animation.getRate() + 9);
    }
    public void slowDown(){
        animation.setRate(animation.getRate() > 0? animation.getRate() - 9: 0);
    }
    public DoubleProperty rateProperty(){
        return animation.rateProperty();
    }
    protected void moveBall(){
        if(x < radius || x > getWidth() - radius){
            dx *= -1;
        }else if(y < radius || y > getHeight() - radius){
            dy *= -1;
        }
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}
