package com.Exercise14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Exercise14_02 extends Application {
    @Override
    public void start(Stage primary){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        for(int i = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                gridPane.add(FillingBlank(),j,i);
            }
        }

        Scene scene = new Scene(gridPane);
        primary.setScene(scene);
        primary.setTitle("chess panel");
        primary.show();
    }

    public static ImageView FillingBlank(){
        Random random = new Random();
        int r = random.nextInt(3);
        javafx.scene.image.ImageView view;
        if(r == 1){
            view = new javafx.scene.image.ImageView("image/x.gif");
        }else if(r == 0){
            view = new javafx.scene.image.ImageView("image/o.gif");
        }else{
            view = new javafx.scene.image.ImageView();
        }
        return view;
    }
}
