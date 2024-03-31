package com.Exercise14;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise14_27 extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        ClockTemplate clockTemplate = new ClockTemplate();
        EventHandler<ActionEvent> eventHandler = e ->
                clockTemplate.setCurrentTime();


        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        pane.getChildren().add(clockTemplate);

        Scene scene = new Scene(pane, 1500,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_27");
        primaryStage.show();
    }
}
