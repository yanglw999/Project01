package com.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontDemo extends Application {
    @Override
    public void start(Stage primary){
        Pane pane = new StackPane();
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setStroke(new Color(0,1,1,1));
        circle.setFill(Color.YELLOW);
        pane.getChildren().add(circle);
        //
        // invoke Label Class from javafx.scene.control.Label
        Label label = new Label("JavaFX");
        //label.setFont(Font.font("Times",FontWeight.BOLD, FontPosture.ITALIC,20));
        label.setFont(Font.font("Times",FontWeight.BOLD,FontPosture.ITALIC,20));
        pane.getChildren().add(label);
        //
        Scene scene = new Scene(pane,200,250);
        primary.setScene(scene);
        primary.setTitle("Font Demo");
        primary.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
