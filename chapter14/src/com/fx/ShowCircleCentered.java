package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircleCentered extends Application {
    public void start(Stage primary){
        Pane pane = new Pane();
        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(70);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane,200,150);
        primary.setScene(scene);
        primary.setTitle("Show Circle in Center");
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
