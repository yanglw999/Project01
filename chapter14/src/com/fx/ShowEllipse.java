package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class ShowEllipse extends Application {
    @Override
    public void start(Stage primary){
        Pane pane = new Pane();
        for(int i = 0 ; i < 20; i++){
            Ellipse ellipse = new Ellipse(100,100,200,100);
            ellipse.setRotate(i * 360 / 20);
            ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
            ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
            ellipse.setStroke(Color.color(Math.random(),Math.random(),Math.random()));
            ellipse.setStrokeWidth(1);
            //ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.WHITE);

            pane.getChildren().add(ellipse);
        }

        Scene scene = new Scene(pane);
        primary.setTitle("Show Ellipse");
        primary.setScene(scene);
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
