package com.Exercise14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise14_15 extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();
        StopSign stopSign = new StopSign();
        borderPane.setCenter(stopSign);

        Scene scene = new Scene(borderPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_15");
        primaryStage.show();

    }
}
