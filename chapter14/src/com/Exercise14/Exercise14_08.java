package com.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_08 extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 9; j++){
                gridPane.add(new ImageView("card/" + (9 * i + j + 1) + ".png"),j,i);
            }
        }
        Scene scene = new Scene(gridPane,240,240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_08");
        primaryStage.show();
    }
}
