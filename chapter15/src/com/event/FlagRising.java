package com.event;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class FlagRising extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        File file = new File("E:\\Study_coding\\IDEA_workspace\\Image","canada.jpg");
        String url = file.toURI().toString();
        Image image = new Image(url);
        double width = image.getWidth();
        double height = image.getHeight();

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width * 0.02);
        imageView.setFitHeight(height * 0.02);
        pane.widthProperty().addListener(ov ->{imageView.setLayoutX(pane.getWidth() / 2 + 31);});

        Line line = new Line(100,20,100,700);
        line.setStroke(Color.color(0.3,.4,.5,.8));
        line.setStrokeWidth(4);
        line.startXProperty().bind(pane.widthProperty().divide(2));
        line.endXProperty().bind(pane.widthProperty().divide(2));

        pane.heightProperty().addListener(ov -> {line.setEndY(pane.getHeight() - 20);});

        pane.getChildren().addAll(imageView, line);

        PathTransition pt = new PathTransition(Duration.millis(10000), line,imageView);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.setOrientation(PathTransition.OrientationType.NONE);
        pt.play();
        // need to click on line
        line.setOnMousePressed( e -> pt.pause());
        line.setOnMouseReleased(e -> pt.play());

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(" Canada Flag Rising");
        primaryStage.show();


    }
}
