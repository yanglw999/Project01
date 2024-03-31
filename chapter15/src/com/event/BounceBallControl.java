package com.event;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BounceBallControl extends Application {
    @Override
    public void start(Stage primary){
        BallPane ballPane = new BallPane();
        Slider sliderSpeed = new Slider();
        sliderSpeed.setMax(100);
        sliderSpeed.setShowTickLabels(true);
        sliderSpeed.setShowTickMarks(true);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(ballPane);
        borderPane.setBottom(sliderSpeed);

        ballPane.rateProperty().bind(sliderSpeed.valueProperty());

        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());
        ballPane.setOnKeyTyped(e -> {
            if(e.getCode() == KeyCode.UP){
                ballPane.speedUp();
            }else if(e.getCode() == KeyCode.DOWN){
                ballPane.slowDown();
            }
        });
        Scene scene = new Scene(borderPane);
        primary.setTitle("BounceBall Control Demo");
        primary.setScene(scene);
        primary.show();
        ballPane.requestFocus();

    }
}
