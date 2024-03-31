package com.Exercise14;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class FanPane extends Pane { // StackPane did not work well here
    Circle circle = new Circle(100,100,110);

    public FanPane(){

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        for(int i = 0; i < 4; i++){
            Arc arc = new Arc(100,100,90,90,30 + 90 * i,35);
            arc.setType(ArcType.ROUND);
            arc.setFill(Color.color(Math.random(),Math.random(),Math.random()));
           /* arc.setRotate(30 + 90 * i); */ // setRotate() is not proper to be used here
            getChildren().add(arc);
        }
    }
}
