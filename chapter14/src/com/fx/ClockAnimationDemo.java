package com.fx.Image;

import com.fx.ClockPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockAnimationDemo extends Application {
    @Override
    public void start(Stage primary){
        StackPane stackPane = new StackPane();
        ClockPane clock = new ClockPane();
        stackPane.getChildren().add(clock);
        //
        EventHandler<ActionEvent> eventEventHandler = e ->
            clock.setCurrentTime();///$$$$

        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), eventEventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(stackPane);
        primary.setScene(scene);
        primary.setTitle("ClockAnimation Demo");
        primary.show();

        stackPane.widthProperty().addListener(o -> clock.setW(stackPane.getWidth()) );
        stackPane.heightProperty().addListener(o -> clock.setH(stackPane.getHeight()));
    }
}
