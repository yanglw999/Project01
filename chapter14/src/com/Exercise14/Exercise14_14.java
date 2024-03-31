package com.Exercise14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Exercise14_14 extends Application {
    @Override
    public void start(Stage primaryStage){
      Cube cube = new Cube();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(cube);

        Scene scene = new Scene(borderPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_14");
        primaryStage.show();

    }
}
