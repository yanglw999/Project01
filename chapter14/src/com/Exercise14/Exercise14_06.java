package com.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise14_06 extends Application  {
    @Override
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(0);
        gridPane.setHgap(0);
       /* Rectangle r1 = new javafx.scene.shape.Rectangle(2,2);
        r1.setFill(Color.BLACK);
        Rectangle r2 = new javafx.scene.shape.Rectangle(2,2);
        r2.setFill(Color.WHITE); */
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Rectangle r1 = new javafx.scene.shape.Rectangle(30,30);
                r1.setFill(Color.BLACK);
                Rectangle r2 = new javafx.scene.shape.Rectangle(30,30);
                r2.setFill(Color.WHITE);
                if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        gridPane.add(r1,j,i);
                    }  else {
                        gridPane.add(r2,j,i);
                    }
                }else{
                    if (j % 2 != 0) {
                        gridPane.add(r1,j,i);
                    }  else {
                        gridPane.add(r2,j,i);
                    }
                }
                }
            }

        Scene scene = new Scene(gridPane,240,240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("show Chess pane");
        primaryStage.show();
    }
}
