package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircle1 extends Application {
    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(new CirclePane(100));
        primaryStage.setTitle("circle in the StackPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class CirclePane extends StackPane{
    public CirclePane (double radius){
        Circle circle = new Circle(radius);
        circle.setFill(new Color(Math.random(),Math.random(),Math.random(),Math.random()));
        circle.setStrokeWidth(5);
        circle.setStroke(Color.color(0.5,.3,.6));
        getChildren().add(circle);
    }
}
