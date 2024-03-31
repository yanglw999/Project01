package com.Exercise14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise14_18 extends Application {
    @Override
    public void start(Stage primaryStage){
        XSquareFunction xSquareFunction = new XSquareFunction();

        Scene scene = new Scene(xSquareFunction, 800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_18");
        primaryStage.show();


    }
}
