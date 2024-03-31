package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class ShowEllipseClass extends Application {
    @Override
    public void start(Stage primary){
       // Pane pane = new Pane();
        Scene scene = new Scene(getEllipse());// pane/ new object/getMethod()
        primary.setTitle("Show Ellipse");
        primary.setScene(scene);
        primary.show();
    }

    public Pane getEllipse (){
        Pane pane = new Pane();
        Ellipse ellipse = new Ellipse(100,100,200,100);
        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
        for(int i = 0 ; i < 6; i++){
            ellipse.setRotate(i * 360 / 6.0);
            ellipse.setStrokeWidth(1);
            ellipse.setStroke(Color.color(Math.random(),Math.random(),Math.random()));
            pane.getChildren().add(ellipse);// getChildren.add()
        }
        return pane;
    }
    public static void main(String[] args) {
        Application.launch();
    }
}

