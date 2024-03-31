package com.event;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionDemo extends Application {
    @Override
    public void start(Stage primary){
        Pane pane = new Pane();
        Circle circle = new Circle(125,100,50);
        circle.setStrokeWidth(3);
        circle.setStroke(Color.GREEN);
        circle.setFill(Color.WHITE);

        Polygon polygon = new Polygon();
        //polygon.getPoints().addAll(new Double[]{125.,100.,100.,200.,200.,200.});
        polygon.getPoints().addAll(0.0,0.,100.,50.,50.,100.);// must be double
        polygon.setStyle("-fx-border-color: RED;");
        polygon.setStroke(Color.RED);

        Rectangle rectangle = new Rectangle(0,0,25,50);
        rectangle.setFill(Color.GREEN);


        pane.getChildren().add(circle);
        pane.getChildren().add(rectangle);
        pane.getChildren().add(polygon);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(5));
        pathTransition.setPath(circle);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);//
        pathTransition.setNode(rectangle);
        pathTransition.setNode(polygon);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        circle.setOnMousePressed(e -> pathTransition.pause());
        circle.setOnMouseReleased(e -> pathTransition.play());

        Scene scene = new Scene(pane,250,200);
        primary.setScene(scene);
        primary.setTitle("PathTransition Demo");
        primary.show();
    }
}
