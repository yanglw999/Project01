package com.Exercise14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise14_19 extends Application {
    @Override
    public void start(Stage primaryStage){
        SinConFunction sinConFunction = new SinConFunction();

        Scene scene = new Scene(sinConFunction, 800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_19");
        primaryStage.show();
    }
}
