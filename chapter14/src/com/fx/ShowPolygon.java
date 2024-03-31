package com.fx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class ShowPolygon extends Application {
    @Override
    public void start(Stage primary){
        Pane pane = new Pane();
        Polygon polygon = new Polygon();
        polygon.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        polygon.setStroke(Color.GREEN);
        pane.getChildren().add(polygon);
        final double WIDTH =1000, HEIGHT =900;
        double centerX = WIDTH/2, centerY = HEIGHT/2;
        double radius = Math.min(centerX, centerY) * .4;
        ObservableList<Double>list = polygon.getPoints();
        for(int i = 0; i < 6; i++){
            list.add(centerX + radius * Math.cos(Math.PI * 2 * i  /6));
            list.add(centerY - radius * Math.sin(Math.PI * 2 * i / 6));
        }
        Scene scene = new Scene(pane);
        primary.setScene(scene);
        primary.setTitle("Show Polygon");
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
