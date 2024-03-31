package com.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DisplayClock extends Application {
    @Override
    public void start(Stage primary){
        ClockPane clockPane = new ClockPane();
        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();

        String currentTime = clockPane.getHour() + ":" + clockPane.getMinute() + ":" + clockPane.getSecond();
        Label label = new Label(currentTime);

        stackPane.getChildren().add(clockPane);
        borderPane.setCenter(stackPane);
        borderPane.setBottom(label);
        BorderPane.setAlignment(label, Pos.TOP_CENTER);


        Scene scene = new Scene(borderPane,400,200);
        primary.setTitle("Display Clock");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
