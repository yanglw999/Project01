package com.Exercise14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Exercise14_07 extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // each node is an independent object,it put the object out of the for loop, it means only have one object rather than 100
     /*
        TextField textField = new TextField();
        textField.setPrefColumnCount(1);
        textField.setAlignment(Pos.CENTER);
     */
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                TextField textField = new TextField();
                textField.setPrefColumnCount(1);
                textField.setAlignment(Pos.CENTER);
                textField.setText(new Random().nextInt(2) + "");
                gridPane.add(textField,j,i);
            }
        }
        Scene scene = new Scene(gridPane,240,240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_07");
        primaryStage.show();
    }
}
