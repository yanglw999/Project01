package com.event;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
    @Override
    public void start(Stage primary) {
        Pane pane = new Pane();
        Line line = new Line(100, 20, 100, 500);
       /** line.setStartX(pane.getWidth() / 3);
        line.setEndY(pane.getHeight());
        line.setEndX(pane.getWidth() / 3); */
       line.startXProperty().bind(pane.widthProperty().divide(2));
       line.endXProperty().bind(pane.widthProperty().divide(2));
       pane.heightProperty().addListener(ov ->line.setEndY(pane.getHeight()));

        line.setStroke(Color.BLACK);
        line.setStrokeWidth(5);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{20., 20., 40., 40., 20., 40.});
        polygon.setStyle("-fx-fill: red;");
        pane.getChildren().addAll(line, polygon);
        // .setLayoutX()
        pane.widthProperty().addListener(ov -> {polygon.setLayoutX(pane.getWidth()/2);});

        PathTransition pt = new PathTransition();
        pt.setPath(line);
        pt.setNode(polygon);
        pt.setDuration(Duration.seconds(10));
        pt.setOrientation(PathTransition.OrientationType.NONE);
        pt.setAutoReverse(true);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();


        Scene scene = new Scene(pane);
        primary.setScene(scene);
        primary.setTitle("Flag Rising");
        primary.show();
    }
}
