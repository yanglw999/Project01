package com.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_01 extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(15);

        ImageView view1 = new ImageView("image/china.gif");
        ImageView view2 = new ImageView("image/ca.gif");
        ImageView view3 = new ImageView("image/uk.gif");
        ImageView view4 = new ImageView("image/us.gif");

        gridPane.add(view1,0,0);
        gridPane.add(view2,1,0);
        gridPane.add(view3,0,1);
        gridPane.add(view4,1,1);

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("flags show");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
