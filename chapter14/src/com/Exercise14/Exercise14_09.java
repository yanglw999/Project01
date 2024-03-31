package com.Exercise14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_09 extends Application {
    @Override
    public void start(Stage primaryStage){

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
       for(int i = 0; i < 2; i++){
           for(int j = 0; j < 2; j++){
               FanPane fanPane = new FanPane();
               gridPane.add(fanPane,j,i);
           }
       }
        Scene scene = new Scene(gridPane,240,240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_09");
        primaryStage.show();
    }
}
