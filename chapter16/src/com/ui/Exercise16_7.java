package com.ui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_7 extends Application {
    @Override
    public void start(Stage primaryStage){
        ClockTemplate clock = new ClockTemplate();
        StackPane pane = new StackPane();
        pane.getChildren().add(clock);

        EventHandler<ActionEvent> clockTicking = e ->{
            clock.setValues();
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),clockTicking));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setAutoReverse(false);
        animation.play();

        pane.widthProperty().addListener(ov ->{
            clock.setW(pane.getWidth()); // only update the w and h, others need to be update via setValue() including r
        });
        pane.heightProperty().addListener(ov ->{
            clock.setH(pane.getHeight());
        });

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise16_7");
        primaryStage.show();


    }
}
